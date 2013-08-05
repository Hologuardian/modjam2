package holo.serastia.helper;

import holo.serastia.SerastiaMain;
import holo.serastia.entity.mob.*;
import net.minecraft.entity.EnumCreatureType;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class EntityHelper 
{
	public static void init()
	{
		EntityRegistry.registerModEntity(EntityHook.class, "GrappleHook", 0, SerastiaMain.instance, 128, 40, true);
		EntityRegistry.registerModEntity(EntitySpitBall.class, "SpitBall", 1, SerastiaMain.instance, 128, 40, true);
		EntityRegistry.registerGlobalEntityID(EntityBaracuda.class, "Baracuda", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0xFFFFFF);
		EntityRegistry.registerGlobalEntityID(EntitySkeratik.class, "Skeratik", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0xFFFFFF);
		
		EntityRegistry.addSpawn(EntityBaracuda.class, 4, 1, 4, EnumCreatureType.waterCreature, DimensionHelper.serastiaBiome);
		initNames();
	}
	
	public static void initNames()
	{
		LanguageRegistry.instance().addStringLocalization("entity.Baracuda.name", "Baracuda");
		LanguageRegistry.instance().addStringLocalization("entity.Skeratik.name", "Skeratik");
		LanguageRegistry.instance().addStringLocalization("entity.serastia.SpitBall.name", "Poisonous Spit");
		LanguageRegistry.instance().addStringLocalization("entity.serastia.GrappleHook.name", "Grapple Hook");
	}
}
