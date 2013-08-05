package holo.serastia.item;

import java.util.List;

import holo.serastia.util.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;

import org.bouncycastle.util.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBoneArmor extends ItemSerastiaArmor
{
    public ItemBoneArmor(int id, EnumArmorMaterial material, int renderIndex,
			int armorType, double reductionAmount, int uses, String iconName) 
    {
		super(id, material, renderIndex, armorType, reductionAmount, uses, iconName);
	}

	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) 
	{
		if (source instanceof EntityDamageSource)
		{
			((EntityDamageSource)source).getSourceOfDamage().attackEntityFrom(DamageSource.cactus, 1);
		}
		super.damageArmor(entity, stack, source, damage, slot);
	}
    
	/**
     * Called by RenderBiped and RenderPlayer to determine the armor texture that 
     * should be use for the currently equiped item.
     * This will only be called on instances of ItemArmor. 
     * 
     * Returning null from this function will use the default value.
     * 
     * @param stack ItemStack for the equpt armor
     * @param entity The entity wearing the armor
     * @param slot The slot the armor is in
     * @param type The subtype, can be null or "overlay"
     * @return Path of texture to bind, or null to use default
     */
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        return slot == 2 ? Strings.toLowerCase(Utils.MAIN_MOD_ID) + ":textures/armor/BoneArmor_2.png" : Strings.toLowerCase(Utils.MAIN_MOD_ID) + ":textures/armor/BoneArmor_1.png";
    }
    
    @SideOnly(Side.CLIENT)

    /**
     * allows items to add custom lines of information to the mouseover description
     */
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        super.addInformation(stack, player, list, par4);
        list.add("On hit: Deal 1 damage to attacker (per piece)");
    }
}
