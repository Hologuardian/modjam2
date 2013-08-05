package holo.serastia.item;

import holo.serastia.util.Utils;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import org.bouncycastle.util.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBoneSword extends ItemSword
{
	public ItemBoneSword(int par1, EnumToolMaterial par2EnumToolMaterial) 
	{
		super(par1, par2EnumToolMaterial);
	}

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack stack, EntityLivingBase entityHit, EntityLivingBase holdingEntity)
    {
        entityHit.addPotionEffect(new PotionEffect(Potion.poison.id, 120));
        return super.hitEntity(stack, entityHit, holdingEntity);
    }

    @SideOnly(Side.CLIENT)
    protected String func_111208_A()
    {
        return Strings.toLowerCase(Utils.MAIN_MOD_ID) + ":BoneSword";
    }
    
    @Override
    @SideOnly(Side.CLIENT)

    /**
     * allows items to add custom lines of information to the mouseover description
     */
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
    	list.add("On hit: poison I for 6 seconds");
    	list.add(this.getMaxDamage() - stack.getItemDamage() + " uses left");
    }
}
