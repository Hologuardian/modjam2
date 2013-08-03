package holo.serastia.block;

import holo.serastia.tileentity.TileEntityKelp;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockKelp extends Block
{

	public BlockKelp(int par1, Material par2Material) 
	{
		super(par1, par2Material);
	}

    /**
     * Called throughout the code as a replacement for ITileEntityProvider.createNewTileEntity
     * Return the same thing you would from that function.
     * This will fall back to ITileEntityProvider.createNewTileEntity(World) if this block is a ITileEntityProvider
     *
     * @param metadata The Metadata of the current block
     * @return A instance of a class extending TileEntity
     */
    public TileEntity createTileEntity(World world, int metadata)
    {
        return new TileEntityKelp();
    }

}
