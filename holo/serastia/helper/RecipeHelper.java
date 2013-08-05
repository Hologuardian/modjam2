package holo.serastia.helper;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeHelper 
{
	public static void init()
	{
		 GameRegistry.addRecipe(new ItemStack(ItemHelper.boneSword, 1), new Object[] {" y ", " y ", " x ", 'y',  ItemHelper.boneFragment, 'x', Item.stick});
		 GameRegistry.addRecipe(new ItemStack(ItemHelper.boneAxe, 1), new Object[] {"yy ", "yx ", " x ", 'y',  ItemHelper.boneFragment, 'x', Item.stick});
		 GameRegistry.addRecipe(new ItemStack(ItemHelper.bonePickaxe, 1), new Object[] {"yyy", " x ", " x ", 'y',  ItemHelper.boneFragment, 'x', Item.stick});
		 GameRegistry.addRecipe(new ItemStack(ItemHelper.boneShovel, 1), new Object[] {" y ", " x ", " x ", 'y',  ItemHelper.boneFragment, 'x', Item.stick});
		 
		 GameRegistry.addRecipe(new ItemStack(ItemHelper.boneHelm, 1), new Object[] {"yyy", "y y", 'y',  ItemHelper.boneFragment});
		 GameRegistry.addRecipe(new ItemStack(ItemHelper.boneChest, 1), new Object[] {"y y", "yyy", "yyy", 'y',  ItemHelper.boneFragment});
		 GameRegistry.addRecipe(new ItemStack(ItemHelper.boneLegs, 1), new Object[] {"yyy", "y y", "y y", 'y',  ItemHelper.boneFragment});
		 GameRegistry.addRecipe(new ItemStack(ItemHelper.boneBoots, 1), new Object[] { "y y", "y y", 'y',  ItemHelper.boneFragment});

		 GameRegistry.addRecipe(new ItemStack(ItemHelper.chitinousSword, 1), new Object[] {" y ", " y ", " x ", 'y',  ItemHelper.chitinFragment, 'x', Item.stick});
		 GameRegistry.addRecipe(new ItemStack(ItemHelper.chitinousAxe, 1), new Object[] {"yy ", "yx ", " x ", 'y',  ItemHelper.chitinFragment, 'x', Item.stick});
		 GameRegistry.addRecipe(new ItemStack(ItemHelper.chitinousPickaxe, 1), new Object[] {"yyy", " x ", " x ", 'y',  ItemHelper.chitinFragment, 'x', Item.stick});
		 GameRegistry.addRecipe(new ItemStack(ItemHelper.chitinousShovel, 1), new Object[] {" y ", " x ", " x ", 'y',  ItemHelper.chitinFragment, 'x', Item.stick});
		 
		 GameRegistry.addRecipe(new ItemStack(ItemHelper.chitinousHelm, 1), new Object[] {"yyy", "y y", 'y',  ItemHelper.chitinFragment});
		 GameRegistry.addRecipe(new ItemStack(ItemHelper.chitinousChest, 1), new Object[] {"y y", "yyy", "yyy", 'y',  ItemHelper.chitinFragment});
		 GameRegistry.addRecipe(new ItemStack(ItemHelper.chitinousLegs, 1), new Object[] {"yyy", "y y", "y y", 'y',  ItemHelper.chitinFragment});
		 GameRegistry.addRecipe(new ItemStack(ItemHelper.chitinousBoots, 1), new Object[] { "y y", "y y", 'y',  ItemHelper.chitinFragment});

		 GameRegistry.addRecipe(new ItemStack(BlockHelper.blockGlowPowder, 1), new Object[] { "yxy", "xyx", "yxy", 'y',  Item.redstone, 'x', Item.glowstone});
	}
}
