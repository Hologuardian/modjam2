package holo.serastia.helper;

import holo.serastia.SerastiaMain;
import holo.serastia.entity.mob.*;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityHelper 
{
	public static void init()
	{
		EntityRegistry.registerModEntity(EntityHook.class, "GrappleHook", 0, SerastiaMain.instance, 128, 40, true);
		EntityRegistry.registerGlobalEntityID(EntityBaracuda.class, "Baracuda", EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0xFFFFFF);
	}
}
