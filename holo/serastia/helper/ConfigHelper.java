package holo.serastia.helper;

import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;

public class ConfigHelper 
{
	public static int serastiaDimensionID;
	public static int serastiaBiomeID;
	public static boolean keepLoadedSerastia;
	
	public static int dimensionTravelerID;
	public static int grappleHookID;
	
	public static int boneSwordID;
	public static int bonePickaxeID;
	public static int boneShovelID;
	public static int boneAxeID;

	public static int chitinousSwordID;
	public static int chitinousPickaxeID;
	public static int chitinousShovelID;
	public static int chitinousAxeID;
	
	public static int boneHelmID;
	public static int boneChestID;
	public static int boneLegsID;
	public static int boneBootsID;
	
	public static int chitinousHelmID;
	public static int chitinousChestID;
	public static int chitinousLegsID;
	public static int chitinousBootsID;
	
	public static int chitinFragmentID;
	public static int boneFragmentID;
	
	public static int kelpBlockID;
	public static int airFlowerBlockID;
	
	public static void init(Configuration config)
	{
		serastiaDimensionID = config.get("Dimension", "Dimension ID", 5).getInt();
		serastiaBiomeID = config.get("Dimension", "Biome ID", 50).getInt();
		keepLoadedSerastia = config.get("Dimension", "Keep Loaded", false).getBoolean(false);
		
		initItems(config);
		initBlocks(config);
		initEntities(config);
	}
	
	public static void initItems(Configuration config)
	{
		int itemID = 5500;
		dimensionTravelerID = config.getItem("Dimension Traveler", ++itemID).getInt();
		grappleHookID = config.getItem("Grapple Hook", ++itemID).getInt();
		
		boneHelmID = config.getItem("Bone Helmet", ++itemID).getInt();
		boneChestID = config.getItem("Bone Chestplate", ++itemID).getInt();
		boneLegsID = config.getItem("Bone Leggings", ++itemID).getInt();
		boneBootsID = config.getItem("Bone Boots", ++itemID).getInt();
		
		chitinousHelmID = config.getItem("Chitinous Helmet", ++itemID).getInt();
		chitinousChestID = config.getItem("Chitinous Chestplate", ++itemID).getInt();
		chitinousLegsID = config.getItem("Chitinous Leggings", ++itemID).getInt();
		chitinousBootsID = config.getItem("Chitinous Boots", ++itemID).getInt();
		
		bonePickaxeID = config.getItem("Bone Pickaxe", ++itemID).getInt();
		boneSwordID = config.getItem("Bone Sword", ++itemID).getInt();
		boneShovelID = config.getItem("Bone Shovel", ++itemID).getInt();
		boneAxeID = config.getItem("Bone Axe", ++itemID).getInt();
		
		chitinousPickaxeID = config.getItem("Chitinous Pickaxe", ++itemID).getInt();
		chitinousSwordID = config.getItem("Chitinous Sword", ++itemID).getInt();
		chitinousShovelID = config.getItem("Chitinous Shovel", ++itemID).getInt();
		chitinousAxeID = config.getItem("Chitinous Axe", ++itemID).getInt();
		
		chitinFragmentID = config.getItem("Chitin Fragment", ++itemID).getInt();
		boneFragmentID = config.getItem("Bone Fragment", ++itemID).getInt();
		System.out.println("Frag: " + boneFragmentID + " Frag2: " + chitinFragmentID + " BoneSword: " + boneSwordID + " BonePick: " + bonePickaxeID);
	}
	
	public static void initBlocks(Configuration config)
	{
		int blockID = 3200;
		kelpBlockID = config.getBlock("Kelp", ++blockID).getInt();
		airFlowerBlockID = config.getBlock("Air Flower", ++blockID).getInt();
	}
	
	public static void initEntities(Configuration config)
	{
		
	}
}
