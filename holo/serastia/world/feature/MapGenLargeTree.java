package holo.serastia.world.feature;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityList;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.DungeonHooks;

public class MapGenLargeTree extends WorldGenerator
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
		int height = random.nextInt(35) + 120;
		int radius = random.nextInt(2) + 7;
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
		for (int i = 0; i < 25; ++i)
		{
			genLargeBranches(world, random, x, y - random.nextInt(65), z);
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
		genBranch(world, rand, x, y, z, dir, 35 + rand.nextInt(20), 3);
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
			if (rand.nextInt(50) == 0 && length - i <= 5)
			{
				this.generateNest(world, rand, x + (int)xd, y + (int)yd - size * 3, z + (int)zd);
			}
		}
	}
	
	public void generateNest(World world, Random rand, int x, int y, int z) 
	{
		int size = 6 + rand.nextInt(3);
		
		int n;
		
		for (n = y; n >= y - 4; --n)
		{
			world.setBlock(x, n, z, Block.planks.blockID, 3, 2);
		}
		n -= size;
		++n;
		
		for (int i = x - size; i <= x + size; ++i)
		{
			for (int j = n - size; j <= n + size; ++j)
			{
				for (int k = z - size; k <= z + size; ++k)
				{
					int xd = i - x;
					int yd = j - n;
					int zd = k - z;
					if (xd * xd + yd * yd + zd * zd <= size * size && xd * xd + yd * yd + zd * zd >= (size - 1) * (size - 1) )
					{
						world.setBlock(i, j, k, Block.planks.blockID, 3, 2);
					}
					else if (xd * xd + yd * yd + zd * zd < (size - 1) * (size - 1))
					{
						if (i == x && j == n && k ==z)
						{
							world.setBlock(i, j, k, Block.mobSpawner.blockID);
				            TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getBlockTileEntity(i, j, k);

				            if (tileentitymobspawner != null)
				            {
				                tileentitymobspawner.getSpawnerLogic().setMobID("Skeratik");
				            }
				            else
				            {
				                System.err.println("Failed to fetch mob spawner entity at (" + i + ", " + j + ", " + k + ")");
				            }
						}
						else if (i == x && j <= n && k ==z)
						{
							world.setBlock(i, j, k, Block.planks.blockID, 3, 2);
						}
						else
						{
							world.setBlockToAir(i, j, k);
						}
					}
				}
			}
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
					if (xd * xd + zd * zd + yd * yd <= size * size)
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
