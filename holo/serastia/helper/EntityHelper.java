package holo.serastia.helper;

import holo.serastia.SerastiaMain;
import holo.serastia.entity.EntityHook;
import holo.serastia.util.Strings;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityHelper 
{
	public static void init()
	{
		EntityRegistry.registerModEntity(EntityHook.class, "GrappleHook", 0, SerastiaMain.instance, 64, 40, true);
	}
}
