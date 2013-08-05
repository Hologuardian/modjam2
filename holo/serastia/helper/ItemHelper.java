package holo.serastia.helper;

import holo.serastia.item.ItemBoneArmor;
import holo.serastia.item.ItemChitinousArmor;
import holo.serastia.item.ItemDimensionTraveler;
import holo.serastia.item.ItemGrappleHook;
import holo.serastia.item.SerastiaItemMisc;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;

public class ItemHelper 
{
	public static Item dimensionTraveler;
	public static Item grappleHook;
	
	public static Item boneHelm;
	public static Item boneChest;
	public static Item boneLegs;
	public static Item boneBoots;
	
	public static Item boneSword;
	public static Item bonePickaxe;
	public static Item boneShovel;
	public static Item boneAxe;

	public static Item chitinousHelm;
	public static Item chitinousChest;
	public static Item chitinousLegs;
	public static Item chitinousBoots;

	public static Item chitinousSword;
	public static Item chitinousPickaxe;
	public static Item chitinousShovel;
	public static Item chitinousAxe;
	
	public static Item chitinFragment;
	public static Item boneFragment;
	
	public static void init()
	{
		dimensionTraveler = new ItemDimensionTraveler(ConfigHelper.dimensionTravelerID);
		grappleHook = new ItemGrappleHook(ConfigHelper.grappleHookID);
		
		boneHelm = new ItemBoneArmor(ConfigHelper.boneHelmID, EnumArmorMaterial.IRON, 0, 0, 0.85D, 500, "BoneHelm");
		boneChest = new ItemBoneArmor(ConfigHelper.boneChestID, EnumArmorMaterial.IRON, 0, 1, 0.85D, 500, "BoneChest");
		boneLegs = new ItemBoneArmor(ConfigHelper.boneLegsID, EnumArmorMaterial.IRON, 0, 2, 0.85D, 500, "BoneLegs");
		boneBoots = new ItemBoneArmor(ConfigHelper.boneBootsID, EnumArmorMaterial.IRON, 0, 3, 0.85D, 500, "BoneBoots");

		chitinousHelm = new ItemChitinousArmor(ConfigHelper.chitinousHelmID, EnumArmorMaterial.IRON, 0, 0, 0.95D, -1, "ChitinousHelm");
		chitinousChest = new ItemChitinousArmor(ConfigHelper.chitinousChestID, EnumArmorMaterial.IRON, 0, 1, 0.95D, -1, "ChitinousChest");
		chitinousLegs = new ItemChitinousArmor(ConfigHelper.chitinousLegsID, EnumArmorMaterial.IRON, 0, 2, 0.95D, -1, "ChitinousLegs");
		chitinousBoots = new ItemChitinousArmor(ConfigHelper.chitinousBootsID, EnumArmorMaterial.IRON, 0, 3, 0.95D, -1, "ChitinousBoots");

		chitinFragment = new SerastiaItemMisc(ConfigHelper.chitinFragmentID, "ChitinFragment");
		boneFragment = new SerastiaItemMisc(ConfigHelper.boneFragmentID, "BoneFragment");
	}
}
