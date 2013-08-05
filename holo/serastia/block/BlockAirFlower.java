package holo.serastia.block;

import java.util.Random;

import holo.serastia.util.Utils;

import org.bouncycastle.util.Strings;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EntityBubbleFX;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockAirFlower extends Block
{
	public BlockAirFlower(int par1, Material par2Material) 
	{
		super(par1, par2Material);
		this.setCreativeTab(CreativeTabs.tabMisc);
	}

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 1;
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
    	world.setBlockToAir(x, y, z);
    	this.breakBlock(world, x, y, z, 3, world.getBlockMetadata(x, y, z));
    	player.setAir(300);
        for (int var3 = 0; var3 < 30; ++var3)
        {
            EntityBubbleFX FX = new EntityBubbleFX(world, x + player.getRNG().nextFloat() * 3 - 1, y + player.getRNG().nextFloat() * 2, z + player.getRNG().nextFloat() * 3 - 1, player.getRNG().nextFloat() * 0.25, player.getRNG().nextFloat() * 0.25, player.getRNG().nextFloat() * 0.25);
            FMLClientHandler.instance().getClient().effectRenderer.addEffect(FX);
        }
    	return true;
    }
    
    @SideOnly(Side.CLIENT)

    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World world, int x, int y, int z, Random rand) 
    {
        for (int var3 = 0; var3 < 8; ++var3)
        {
            EntityBubbleFX FX = new EntityBubbleFX(world, x + rand.nextFloat(), y + rand.nextFloat(), z + rand.nextFloat(), rand.nextFloat() * 0.25, rand.nextFloat() * 0.25, rand.nextFloat() * 0.25);
            FMLClientHandler.instance().getClient().effectRenderer.addEffect(FX);
        }
    }

    @SideOnly(Side.CLIENT)
    protected String func_111023_E()
    {
        return Strings.toLowerCase(Utils.MAIN_MOD_ID) + ":AirFlower";
    }

}
