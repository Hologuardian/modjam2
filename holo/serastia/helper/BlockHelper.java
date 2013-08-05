package holo.serastia.helper;

import holo.serastia.block.BlockAirFlower;
import holo.serastia.block.BlockGlowPowder;
import holo.serastia.block.BlockKelp;
import holo.serastia.block.BlockSerastiaPortal;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BlockHelper 
{
	public static Block blockKelp;
	public static Block blockAirFlower;
	public static BlockSerastiaPortal blockSerastiaPortal;
	public static Block blockGlowPowder;
	
	public static void init()
	{
		blockKelp = new BlockKelp(ConfigHelper.kelpBlockID, Material.wood).setUnlocalizedName("Kelp").setHardness(0.5F);
		blockAirFlower = new BlockAirFlower(ConfigHelper.airFlowerBlockID, Material.wood).setUnlocalizedName("Air Flower");
		blockSerastiaPortal = (BlockSerastiaPortal) new BlockSerastiaPortal(ConfigHelper.serastiaPortalBlockID).setUnlocalizedName("Serastia Portal").setBlockUnbreakable().setResistance(999999F).setCreativeTab(CreativeTabs.tabBlock);
		blockGlowPowder = new BlockGlowPowder(ConfigHelper.blockGlowPowderID, Material.glass).setUnlocalizedName("Glow Powder");
		
		GameRegistry.registerBlock(blockKelp, "Kelp Block");
		GameRegistry.registerBlock(blockAirFlower, "Air Flower");
		GameRegistry.registerBlock(blockSerastiaPortal, "Serastia Portal");
		GameRegistry.registerBlock(blockGlowPowder, "Glow Powder");
		
		initNames();
	}
	
	public static void initNames()
	{
		LanguageRegistry.addName(blockKelp, "Kelp");
		LanguageRegistry.addName(blockAirFlower, "Air Flower");
		LanguageRegistry.addName(blockSerastiaPortal, "Serastia Portal");
		LanguageRegistry.addName(blockGlowPowder, "Glow Powder");
	}
}
