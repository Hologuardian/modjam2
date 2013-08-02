package holo.serastia.helper;

import holo.serastia.item.ItemDimensionTraveler;
import net.minecraft.item.Item;

public class ItemHelper 
{
	public static Item dimensionTraveler;
	
	public static void init()
	{
		dimensionTraveler = new ItemDimensionTraveler(ConfigHelper.dimensionTravelerID);
	}
}
