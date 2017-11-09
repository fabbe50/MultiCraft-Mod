package io.github.lukas2005.multicraft.items;

import io.github.lukas2005.multicraft.Reference;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class Hammer extends ItemSword {

    public static ToolMaterial mat = EnumHelper.addToolMaterial(Reference.MOD_ID+":hammer", 1, 270,1,9,10);

    public Hammer() {
        super(mat);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (worldIn.getBlockState(pos).getBlock() == Blocks.CONCRETE) {
            IBlockState state = worldIn.getBlockState(pos);

            worldIn.setBlockState(pos, Blocks.CONCRETE_POWDER.getStateFromMeta(Blocks.CONCRETE.getMetaFromState(state)));
            ItemStack is = player.getHeldItem(hand);
            is.damageItem(1, player);

            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.PASS;
    }
}
