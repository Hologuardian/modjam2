package holo.serastia.helper;

import cpw.mods.fml.common.registry.GameRegistry;
import holo.serastia.block.BlockAirFlower;
import holo.serastia.block.BlockKelp;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockHelper 
{
	public static Block blockKelp;
	public static Block blockAirFlower;
	
	public static void init()
	{
		blockKelp = new BlockKelp(ConfigHelper.kelpBlockID, Material.wood);
		blockAirFlower = new BlockAirFlower(ConfigHelper.airFlowerBlockID, Material.wood);
		GameRegistry.registerBlock(blockKelp, "Kelp Block");
		GameRegistry.registerBlock(blockAirFlower, "Air Flower");
	}
}
