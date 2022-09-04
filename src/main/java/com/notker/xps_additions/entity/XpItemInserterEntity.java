package com.notker.xps_additions.entity;

import com.notker.xp_storage.XpStorage;
import com.notker.xp_storage.blocks.StorageBlockEntity;
import com.notker.xp_storage.regestry.ModBlocks;
import com.notker.xp_storage.regestry.ModFluids;
import com.notker.xp_storage.regestry.ModItems;
import com.notker.xps_additions.XpsAdditions;
import com.notker.xps_additions.regestry.AdditionBlocks;
import com.notker.xps_additions.screen.BoxScreenHandler;
import com.notker.xps_additions.screen.ImplementedInventory;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

@SuppressWarnings("UnstableApiUsage")
public class XpItemInserterEntity extends BlockEntity implements ImplementedInventory, ExtendedScreenHandlerFactory{


    private int syncedInt;

    //PropertyDelegate is an interface which we will implement inline here.
    //It can normally contain multiple integers as data identified by the index, but in this example we only have one.
    private final PropertyDelegate propertyDelegate = new PropertyDelegate() {
        @Override
        public int get(int index) {
            return syncedInt;
        }

        @Override
        public void set(int index, int value) {
            syncedInt = value;
        }

        //this is supposed to return the amount of integers you have in your delegate, in our example only one
        @Override
        public int size() {
            return 1;
        }
    };



    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(size(), ItemStack.EMPTY);
    public XpItemInserterEntity(BlockPos pos, BlockState state) {
        super(AdditionBlocks.XP_ITEM_INSERTER_ENTITY, pos, state);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, items);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, items);
        super.writeNbt(nbt);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    @Override
    public int size() {
        return XpsAdditions.ITEM_SLOTS;
    }


    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(pos);
    }

    public static void tick(World world, BlockPos blockPos, BlockState blockState, XpItemInserterEntity entity) {

        Direction facing = blockState.get(Properties.HORIZONTAL_FACING);
        BlockPos pos = blockPos.offset(facing, 1);
        Optional<StorageBlockEntity> storage = world.getBlockEntity(pos, ModBlocks.STORAGE_BLOCK_ENTITY);

        if (storage.isPresent()) {
            entity.syncedInt = storage.get().getContainerExperience();
            if (!world.isReceivingRedstonePower(blockPos)) {
                int mbToInsert = 0;
                for (int i = 0; i < XpsAdditions.ITEM_SLOTS; i++) {
                    ItemStack itemStackToInsert = entity.getItems().get(i);
                    if (!itemStackToInsert.isEmpty()) {
                        if (itemStackToInsert.isOf(ModItems.XP_BERRIES)) {
                            mbToInsert += XpStorage.MB_PER_BERRIE * itemStackToInsert.getCount();
                            entity.getItems().set(i, ItemStack.EMPTY);
                            break;

                        }
                        if (itemStackToInsert.getItem().equals(ModFluids.XP_BUCKET)) {
                            mbToInsert += FluidConstants.BUCKET;
                            entity.getItems().set(i, new ItemStack(Items.BUCKET, 1));
                            break;

                        }
                        if (itemStackToInsert.isOf(Items.EXPERIENCE_BOTTLE)) {
                            mbToInsert += FluidConstants.BOTTLE * itemStackToInsert.getCount();
                            entity.getItems().set(i, new ItemStack(Items.GLASS_BOTTLE, itemStackToInsert.getCount()));
                            break;

                        }
                        if (itemStackToInsert.getItem().equals(Items.SCULK)) {
                            mbToInsert += XpStorage.MB_PER_XP * itemStackToInsert.getCount();
                            entity.getItems().set(i, ItemStack.EMPTY);
                            break;

                        }
                    }
                }
                if (mbToInsert <= 0) {
                    return;
                }

                try (Transaction transaction = Transaction.openOuter()) {
                    storage.get().liquidXp.insert(FluidVariant.of(ModFluids.LIQUID_XP), mbToInsert, transaction);
                    transaction.commit();
                }
            }

        } else {
            entity.syncedInt = 0;
        }
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.xps_additions.xp_item_inserter");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new BoxScreenHandler(syncId, inv, this, propertyDelegate);
    }

}
