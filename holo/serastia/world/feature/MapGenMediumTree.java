package holo.serastia.world.feature;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityList;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.DungeonHooks;

public class MapGenMediumTree extends WorldGenerator
{

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) 
	{
		int top = genTrunk(world, random, x, y, z);
		genCanopy(world, random, x, top, z);
		return true;
	}
	
	public int genTrunk(World world, Random random, int x, int y, int z)
	{
		int height = random.nextInt(25) + 60;
		int radius = 1;
		int j;
		for(j = y; j <= y + height; j++)
		{
			for(int i = x - radius; i <= x + radius; i++)
			{
				for(int k = z - radius; k <= z + radius; k++)
				{
					int xDist = i - x;
					int zDist = k - z;
					if (xDist * xDist + zDist * zDist <= radius * radius + random.nextInt(4))
					{
						world.setBlock(i, j, k, Block.wood.blockID, 3, 2);
					}
				}
			}
		}
		
		return j;
	}
	
	public void genCanopy(World world, Random random, int x, int y, int z)
	{
		for (int i = 0; i < 20; ++i)
		{
			genLargeBranches(world, random, x, y - random.nextInt(25), z);
		}
	}
	
	public void genLargeBranches(World world, Random rand, int x, int y, int z)
	{
		float[] dir = {rand.nextFloat() * 2 - 1, rand.nextFloat() * 0.5F, rand.nextFloat() * 2 - 1};
		double norm = Math.abs(Math.sqrt(dir[0] * dir[0] + dir[1] * dir[1] + dir[2] * dir[2]));
		dir[0] /= norm;
		dir[1] /= norm;
		dir[1] = dir[1] * 0.9F + 0.1F;
		dir[2] /= norm;
		genBranch(world, rand, x, y, z, dir, 15 + rand.nextInt(5), 1);
	}
	
	public void genBranch(World world, Random rand, int x, int y, int z, float[] dir, int length, int size)
	{
		for (int i = 0; i < length; ++i)
		{
			float xd = dir[0] * i;
			float yd = dir[1] * i;
			float zd = dir[2] * i;
			genSphere(world, rand, x + (int)xd, y + (int)yd, z + (int)zd, size);
			genLeafSphere(world, rand, x + (int)xd, y + (int)yd, z + (int)zd, size * 3);
		}
	}

	public void genSphere(World world, Random rand, int x, int y, int z, int size)
	{
		for (int i = x - size; i <= x + size; ++i)
		{
			for (int j = y - size; j <= y + size; ++j)
			{
				for (int k = z - size; k <= z + size; ++k)
				{
					int xd = i - x;
					int yd = j - y;
					int zd = k - z;
					if (xd * xd + zd * zd + yd * yd <= size * size)
					{
						world.setBlock(i, j, k, Block.wood.blockID, 3, 2);
					}
				}
			}
		}
	}
	
	public void genLeafSphere(World world, Random rand, int x, int y, int z, int size)
	{
		for (int i = x - size; i < x + size; ++i)
		{
			for (int j = y - size; j < y + size; ++j)
			{
				for (int k = z - size; k < z + size; ++k)
				{
					int xd = i - x;
					int yd = j - y;
					int zd = k - z;
					if (xd * xd + zd * zd + yd * yd <= size * size - 1)
					{
						if (world.getBlockId(i, j, k) != Block.wood.blockID)
						{
							world.setBlock(i, j, k, Block.leaves.blockID, 4, 2);
						}
					}
				}
			}
		}
	}
}
