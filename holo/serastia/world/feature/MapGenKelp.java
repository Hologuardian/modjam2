package holo.serastia.world.feature;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class MapGenKelp extends WorldGenerator
{

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) 
	{
		int height = random.nextInt(5) + 5;
		for(int i = y; i < y + height && i < 70; ++i)
		{
			world.setBlock(x, i, z, Block.bedrock.blockID, 0, 2);
		}
		return false;
	}

}
