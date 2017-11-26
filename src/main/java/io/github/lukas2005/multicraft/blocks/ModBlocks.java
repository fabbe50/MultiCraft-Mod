package io.github.lukas2005.multicraft.blocks;

import io.github.lukas2005.multicraft.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;

import java.util.HashMap;

public class ModBlocks {

    public static final HashMap<String, Block> ModBlocks = new HashMap<>();

    public static BlockAncientStone blockAncientStone = new BlockAncientStone();

    public static void init() {
        // Building Blocks

        registerBlock(new ColoredPlanks().setCreativeTab(CreativeTabs.BUILDING_BLOCKS), "colored_planks");
        registerBlock(new BlockPath(Material.ROCK).setResistance(30).setHardness(3).setCreativeTab(CreativeTabs.BUILDING_BLOCKS), "rock_path");
        registerBlock(blockAncientStone, "ancient_stone");
        registerBlock(new BlockVolcanicStone().setCreativeTab(CreativeTabs.BUILDING_BLOCKS), "volcanic_stone");

        registerBlock(new BlockAncientStoneStairs(blockAncientStone.getDefaultState()).setCreativeTab(CreativeTabs.BUILDING_BLOCKS), "ancient_stone_stairs");
    }

    private static void registerBlock(Block block, String name) {
        block.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
        block.setUnlocalizedName(Reference.MOD_ID+"."+name);
        ModBlocks.put(block.getUnlocalizedName(), block);
    }

    public static Block getBlock(String itemName) {
        return ModBlocks.get("tile."+Reference.MOD_ID+"."+itemName);
    }
}
