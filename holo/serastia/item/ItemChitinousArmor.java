package holo.serastia.item;

import holo.serastia.util.Utils;

import java.util.List;

import org.bouncycastle.util.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.ISpecialArmor.ArmorProperties;

public class ItemChitinousArmor extends ItemSerastiaArmor
{

	public ItemChitinousArmor(int id, EnumArmorMaterial material,
			int renderIndex, int armorType, double reductionAmount, int uses,
			String iconName) {
		super(id, material, renderIndex, armorType, reductionAmount, uses, iconName);
	}

	@Override
	public ArmorProperties getProperties(EntityLivingBase entity, ItemStack armor, DamageSource source, double damage, int slot) 
	{
		if (entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)entity;
			if (source.equals(DamageSource.fall) && this.wearingFullSet(player))
			{
				return new ISpecialArmor.ArmorProperties(0, 1.0, Integer.MAX_VALUE);
			}
		}
		return super.getProperties(entity, armor, source, damage, slot);
	}
	
	public boolean wearingFullSet(EntityPlayer player)
	{
		if (player.inventory.armorItemInSlot(0).getItem() instanceof ItemChitinousArmor
				&& player.inventory.armorItemInSlot(1).getItem() instanceof ItemChitinousArmor
				&& player.inventory.armorItemInSlot(2).getItem() instanceof ItemChitinousArmor
				&& player.inventory.armorItemInSlot(3).getItem() instanceof ItemChitinousArmor)
		{
			return true;
		}
		return false;
	}

	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) 
	{
		if (entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)entity;
			if (source.equals(DamageSource.fall) && this.wearingFullSet(player))
			{
				return;
			}
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
        return slot == 2 ? Strings.toLowerCase(Utils.MAIN_MOD_ID) + ":textures/armor/ChitinousArmor_2.png" : Strings.toLowerCase(Utils.MAIN_MOD_ID) + ":textures/armor/ChitinousArmor_1.png";
    }
    
    @SideOnly(Side.CLIENT)

    /**
     * allows items to add custom lines of information to the mouseover description
     */
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        super.addInformation(stack, player, list, par4);
        list.add("Full set: No fall damage");
    }

}
