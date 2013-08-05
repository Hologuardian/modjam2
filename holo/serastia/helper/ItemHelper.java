package holo.serastia.helper;

import cpw.mods.fml.common.registry.LanguageRegistry;
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
		dimensionTraveler = new ItemDimensionTraveler(ConfigHelper.dimensionTravelerID).setUnlocalizedName("Dimension Traveler");
		grappleHook = new ItemGrappleHook(ConfigHelper.grappleHookID).setFull3D().setUnlocalizedName("Grapple Hook");
		
		boneHelm = new ItemBoneArmor(ConfigHelper.boneHelmID, EnumArmorMaterial.IRON, 0, 0, 0.85D, 500, "BoneHelm").setUnlocalizedName("Bone Helmet");
		boneChest = new ItemBoneArmor(ConfigHelper.boneChestID, EnumArmorMaterial.IRON, 0, 1, 0.85D, 500, "BoneChest").setUnlocalizedName("Bone Chestplate");
		boneLegs = new ItemBoneArmor(ConfigHelper.boneLegsID, EnumArmorMaterial.IRON, 0, 2, 0.85D, 500, "BoneLegs").setUnlocalizedName("Bone Leggings");
		boneBoots = new ItemBoneArmor(ConfigHelper.boneBootsID, EnumArmorMaterial.IRON, 0, 3, 0.85D, 500, "BoneBoots").setUnlocalizedName("Bone Boots");
		
		EnumToolMaterial bone = EnumHelper.addToolMaterial("Bone", 3, 364, 4, 13, 22);
		EnumToolMaterial chitin = EnumHelper.addToolMaterial("Chitin", 4, 896, 7, 19, 42);
		
		boneSword = new ItemBoneSword(ConfigHelper.boneSwordID, bone).setUnlocalizedName("Bone Sword");
		boneShovel = new ItemBoneShovel(ConfigHelper.boneShovelID, bone, "BoneShovel").setUnlocalizedName("Bone Shovel");
		bonePickaxe = new ItemBonePick(ConfigHelper.bonePickaxeID, bone, "BonePick").setUnlocalizedName("Bone Pickaxe");
		boneAxe = new ItemBoneAxe(ConfigHelper.boneAxeID, bone, "BoneAxe").setUnlocalizedName("Bone Axe");
		
		chitinousSword = new ItemChitinousSword(ConfigHelper.chitinousSwordID, chitin).setUnlocalizedName("Chitinous Sword");
		chitinousShovel = new ItemChitinShovel(ConfigHelper.chitinousShovelID, chitin, "ChitinousShovel").setUnlocalizedName("Chitinous Shovel");
		chitinousPickaxe = new ItemChitinPick(ConfigHelper.chitinousPickaxeID, chitin, "ChitinousPick").setUnlocalizedName("Chitinous Pickaxe");
		chitinousAxe = new ItemChitinAxe(ConfigHelper.chitinousAxeID, chitin, "ChitinousAxe").setUnlocalizedName("Chitinous Axe");
		
		chitinousHelm = new ItemChitinousArmor(ConfigHelper.chitinousHelmID, EnumArmorMaterial.IRON, 0, 0, 0.95D, -1, "ChitinousHelm").setUnlocalizedName("Chitinous Helmet");
		chitinousChest = new ItemChitinousArmor(ConfigHelper.chitinousChestID, EnumArmorMaterial.IRON, 0, 1, 0.95D, -1, "ChitinousChest").setUnlocalizedName("Chitinous Chestplate");
		chitinousLegs = new ItemChitinousArmor(ConfigHelper.chitinousLegsID, EnumArmorMaterial.IRON, 0, 2, 0.95D, -1, "ChitinousLegs").setUnlocalizedName("Chitinous Leggings");
		chitinousBoots = new ItemChitinousArmor(ConfigHelper.chitinousBootsID, EnumArmorMaterial.IRON, 0, 3, 0.95D, -1, "ChitinousBoots").setUnlocalizedName("Chitinous Boots");

		chitinFragment = new SerastiaItemMisc(ConfigHelper.chitinFragmentID, "ChitinFragment").setUnlocalizedName("Chitin Fragment");
		boneFragment = new SerastiaItemMisc(ConfigHelper.boneFragmentID, "BoneFragment").setUnlocalizedName("Bone Fragment");
		
		initNames();
	}

	
	public static void initNames()
	{
		LanguageRegistry.addName(dimensionTraveler, "Dimension Traveler");
		LanguageRegistry.addName(grappleHook, "Grapple Hook Launcher");
		
		LanguageRegistry.addName(boneHelm, "Bone Helmet");
		LanguageRegistry.addName(boneChest, "Bone Chestplate");
		LanguageRegistry.addName(boneLegs, "Bone Leggings");
		LanguageRegistry.addName(boneBoots, "Bone Boots");

		LanguageRegistry.addName(boneSword, "Bone Sword");
		LanguageRegistry.addName(boneShovel, "Bone Shovel");
		LanguageRegistry.addName(bonePickaxe, "Bone Pickaxe");
		LanguageRegistry.addName(boneAxe, "Bone Axe");

		LanguageRegistry.addName(chitinousHelm, "Chitinous Helmet");
		LanguageRegistry.addName(chitinousChest, "Chitinous Chestplate");
		LanguageRegistry.addName(chitinousLegs, "Chitinous Leggings");
		LanguageRegistry.addName(chitinousBoots, "Chitinous Boots");
		
		LanguageRegistry.addName(chitinousSword, "Chitinous Sword");
		LanguageRegistry.addName(chitinousShovel, "Chitinous Shovel");
		LanguageRegistry.addName(chitinousPickaxe, "Chitinous Pickaxe");
		LanguageRegistry.addName(chitinousAxe, "Chitinous Axe");

		LanguageRegistry.addName(chitinFragment, "Chitin Fragment");
		LanguageRegistry.addName(boneFragment, "Bone Fragment");
	}
}
