package holo.serastia.helper;

import holo.serastia.world.SerastiaWorldProvider;
import holo.serastia.world.biome.SerastiaBiome;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;

public class DimensionHelper 
{
	public static BiomeGenBase serastiaBiome;
	
	public static void init()
	{
		serastiaBiome = new SerastiaBiome(ConfigHelper.serastiaBiomeID);

        DimensionManager.registerProviderType(ConfigHelper.serastiaDimensionID, SerastiaWorldProvider.class, ConfigHelper.keepLoadedSerastia);
        DimensionManager.registerDimension(ConfigHelper.serastiaDimensionID, ConfigHelper.serastiaDimensionID);
	}
}
