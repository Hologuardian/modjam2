package holo.serastia.helper;

import holo.serastia.item.ItemDimensionTraveler;
import holo.serastia.item.ItemGrappleHook;
import net.minecraft.item.Item;

public class ItemHelper 
{
	public static Item dimensionTraveler;
	public static Item grappleHook;
	
	public static void init()
	{
		dimensionTraveler = new ItemDimensionTraveler(ConfigHelper.dimensionTravelerID);
		grappleHook = new ItemGrappleHook(ConfigHelper.grappleHookID);
	}
}
