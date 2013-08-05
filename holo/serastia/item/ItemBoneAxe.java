package holo.serastia.item;

import holo.serastia.util.Utils;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;

import org.bouncycastle.util.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBoneAxe extends ItemAxe
{
	String icon;
	public ItemBoneAxe(int par1, EnumToolMaterial par2EnumToolMaterial, String name) 
	{
		super(par1, par2EnumToolMaterial);
		icon = name;
	}

    @SideOnly(Side.CLIENT)
    protected String func_111208_A()
    {
        return Strings.toLowerCase(Utils.MAIN_MOD_ID) + ":" + icon;
    }

}
