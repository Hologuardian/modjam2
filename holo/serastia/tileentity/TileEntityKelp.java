package holo.serastia.tileentity;

import net.minecraft.tileentity.TileEntity;

public class TileEntityKelp extends TileEntity
{
	/**
     * Determines if this TileEntity requires update calls.
     * @return True if you want updateEntity() to be called, false if not
     */
    public boolean canUpdate()
    {
        return false;
    }
}
