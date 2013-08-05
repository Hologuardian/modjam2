package holo.serastia.item;

import java.util.List;

import holo.serastia.util.Utils;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.ISpecialArmor;

import org.bouncycastle.util.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSerastiaArmor extends ItemArmor implements ISpecialArmor
{
	public double reduction = 0;
	public boolean unbreakable = false;
	public String icon;
	public ItemSerastiaArmor(int id, EnumArmorMaterial material, int renderIndex, int armorType, double reductionAmount, int uses, String iconName) 
	{
		super(id, material, renderIndex, armorType);
		reduction = reductionAmount;
		if (uses < 0)
		{
			unbreakable = true;
			this.setMaxDamage(Integer.MAX_VALUE);
		}
		else
			this.setMaxDamage(uses);
		icon = iconName;
		this.setCreativeTab(CreativeTabs.tabCombat);
	}

	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) 
	{
		return new ISpecialArmor.ArmorProperties(0, this.getResistanceFromSlot(slot), Integer.MAX_VALUE);
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) 
	{
		return (int)(25 * this.getResistanceFromSlot(3 - slot));
	}

	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) 
	{
		if (!unbreakable)
			stack.damageItem(1, entity);
	}
	
	public double getResistanceFromSlot(int slot)
	{
		double resistance = slot == 0 ? 0.15D : slot == 1? 0.4D : slot == 2 ? 0.3D : 0.15D;
		return resistance * reduction;
	}

    @SideOnly(Side.CLIENT)
    protected String func_111208_A()
    {
        return Strings.toLowerCase(Utils.MAIN_MOD_ID) + ":" + icon;
    }
    
    @SideOnly(Side.CLIENT)

    /**
     * allows items to add custom lines of information to the mouseover description
     */
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
    	list.add((int)(this.getResistanceFromSlot(this.armorType) * 100) + "% damage reduction");
        if (this.unbreakable)
            list.add("Infinite uses");
        else
            list.add(this.getMaxDamage() - this.getDamage(stack) + " uses remaining");
    }
}
