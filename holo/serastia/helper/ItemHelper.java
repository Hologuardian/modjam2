package holo.serastia.helper;

import holo.serastia.item.ItemBoneArmor;
import holo.serastia.item.ItemBoneAxe;
import holo.serastia.item.ItemBonePick;
import holo.serastia.item.ItemBoneShovel;
import holo.serastia.item.ItemBoneSword;
import holo.serastia.item.ItemChitinAxe;
import holo.serastia.item.ItemChitinPick;
import holo.serastia.item.ItemChitinShovel;
import holo.serastia.item.ItemChitinousArmor;
import holo.serastia.item.ItemChitinousSword;
import holo.serastia.item.ItemDimensionTraveler;
import holo.serastia.item.ItemGrappleHook;
import holo.serastia.item.SerastiaItemMisc;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;

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
		grappleHook = new ItemGrappleHook(ConfigHelper.grappleHookID).setFull3D();
		
		boneHelm = new ItemBoneArmor(ConfigHelper.boneHelmID, EnumArmorMaterial.IRON, 0, 0, 0.85D, 500, "BoneHelm");
		boneChest = new ItemBoneArmor(ConfigHelper.boneChestID, EnumArmorMaterial.IRON, 0, 1, 0.85D, 500, "BoneChest");
		boneLegs = new ItemBoneArmor(ConfigHelper.boneLegsID, EnumArmorMaterial.IRON, 0, 2, 0.85D, 500, "BoneLegs");
		boneBoots = new ItemBoneArmor(ConfigHelper.boneBootsID, EnumArmorMaterial.IRON, 0, 3, 0.85D, 500, "BoneBoots");
		
		EnumToolMaterial bone = EnumHelper.addToolMaterial("Bone", 3, 364, 4, 13, 22);
		EnumToolMaterial chitin = EnumHelper.addToolMaterial("Chitin", 4, 896, 7, 19, 42);
		
		boneSword = new ItemBoneSword(ConfigHelper.boneSwordID, bone);
		boneShovel = new ItemBoneShovel(ConfigHelper.boneShovelID, bone, "BoneShovel");
		bonePickaxe = new ItemBonePick(ConfigHelper.bonePickaxeID, bone, "BonePick");
		boneAxe = new ItemBoneAxe(ConfigHelper.boneAxeID, bone, "BoneAxe");
		
		chitinousSword = new ItemChitinousSword(ConfigHelper.chitinousSwordID, chitin);
		chitinousShovel = new ItemChitinShovel(ConfigHelper.chitinousShovelID, chitin, "ChitinousShovel");
		chitinousPickaxe = new ItemChitinPick(ConfigHelper.chitinousPickaxeID, chitin, "ChitinousPick");
		chitinousAxe = new ItemChitinAxe(ConfigHelper.chitinousAxeID, chitin, "ChitinousAxe");
		
		chitinousHelm = new ItemChitinousArmor(ConfigHelper.chitinousHelmID, EnumArmorMaterial.IRON, 0, 0, 0.95D, -1, "ChitinousHelm");
		chitinousChest = new ItemChitinousArmor(ConfigHelper.chitinousChestID, EnumArmorMaterial.IRON, 0, 1, 0.95D, -1, "ChitinousChest");
		chitinousLegs = new ItemChitinousArmor(ConfigHelper.chitinousLegsID, EnumArmorMaterial.IRON, 0, 2, 0.95D, -1, "ChitinousLegs");
		chitinousBoots = new ItemChitinousArmor(ConfigHelper.chitinousBootsID, EnumArmorMaterial.IRON, 0, 3, 0.95D, -1, "ChitinousBoots");

		chitinFragment = new SerastiaItemMisc(ConfigHelper.chitinFragmentID, "ChitinFragment");
		boneFragment = new SerastiaItemMisc(ConfigHelper.boneFragmentID, "BoneFragment");
	}
}
