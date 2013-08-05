package holo.serastia.item;

import holo.serastia.util.Utils;

import org.bouncycastle.util.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SerastiaItemMisc extends Item
{
	String icon;
	public SerastiaItemMisc(int par1, String name) 
	{
		super(par1);
		this.setCreativeTab(CreativeTabs.tabMisc);
		icon = name;
	}

    @SideOnly(Side.CLIENT)
    protected String func_111208_A()
    {
        return Strings.toLowerCase(Utils.MAIN_MOD_ID) + ":" + icon;
    }

}
