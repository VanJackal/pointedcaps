package com.njackal.pointedcaps.screen;

import com.njackal.pointedcaps.PointedCaps;
import com.njackal.pointedcaps.block.entity.SpellPaperBlockEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.Nullable;

public class SpellPaperMenu extends AbstractContainerMenu {
    public final SpellPaperBlockEntity blockEntity;
    private final ContainerLevelAccess access;

    public SpellPaperMenu(int i, Inventory inventory, FriendlyByteBuf extraData) {
        this(i, inventory, inventory.player.level().getBlockEntity(extraData.readBlockPos()));

    }

    public SpellPaperMenu(int containerId, Inventory playerInventory, BlockEntity blockEntity) {
        super(ModMenuTypes.SPELL_PAPER_MENU.get(), containerId);
        this.blockEntity = (SpellPaperBlockEntity) blockEntity;
        this.access = ContainerLevelAccess.NULL;

        //Player Inventory
        for(int k = 0; k < 3; ++k) {
            for(int i1 = 0; i1 < 9; ++i1) {
                this.addSlot(new Slot(playerInventory, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18));
            }
        }

        for(int l = 0; l < 9; ++l) {
            this.addSlot(new Slot(playerInventory, l, 8 + l * 18, 142));
        }
    }


    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return ItemStack.EMPTY;//todo?
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(access, player, PointedCaps.SPELL_PAPER.get());
    }
}
