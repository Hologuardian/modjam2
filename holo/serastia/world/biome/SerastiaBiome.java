package holo.serastia.world.biome;

import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

public class SerastiaBiome extends BiomeGenBase
{
	public SerastiaBiome(int par1) 
	{
		super(par1);
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.setMinMaxHeight(-2.5F, 0.5F);
		this.rainfall = 0.0F;
	}
}
