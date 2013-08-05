package holo.serastia.block;

import holo.serastia.helper.BlockHelper;
import holo.serastia.util.Utils;

import org.bouncycastle.util.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockGlowPowder extends Block
{

	public BlockGlowPowder(int par1, Material par2Material)
	{
		super(par1, par2Material);
	}

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        if (par1World.getBlockId(par2, par3 - 1, par4) != Block.wood.blockID || !BlockHelper.blockSerastiaPortal.tryToCreatePortal(par1World, par2, par3, par4))
        {
        	par1World.setBlockToAir(par2, par3, par4);
        }
    }

    @SideOnly(Side.CLIENT)
    protected String func_111023_E()
    {
        return Strings.toLowerCase(Utils.MAIN_MOD_ID) + ":BlockGlowPowder";
    }

}
