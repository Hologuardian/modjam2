package holo.serastia.helper;

import cpw.mods.fml.common.registry.GameRegistry;
import holo.serastia.block.BlockKelp;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockHelper 
{
	public static Block blockKelp;
	
	public static void init()
	{
		blockKelp = new BlockKelp(ConfigHelper.kelpBlockID, Material.wood);
		GameRegistry.registerBlock(blockKelp, "Kelp Block");
	}
}
