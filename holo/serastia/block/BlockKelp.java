package holo.serastia.block;

import holo.serastia.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import org.bouncycastle.util.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockKelp extends Block
{

	public BlockKelp(int par1, Material par2Material) 
	{
		super(par1, par2Material);
		this.setCreativeTab(CreativeTabs.tabDecorations);
	}

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
//    public boolean renderAsNormalBlock()
//    {
//        return false;
//    }

    @SideOnly(Side.CLIENT)
    protected String func_111023_E()
    {
        return Strings.toLowerCase(Utils.MAIN_MOD_ID) + ":BlockKelp";
    }

}
