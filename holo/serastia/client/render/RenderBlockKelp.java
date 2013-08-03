package holo.serastia.client.render;

import holo.serastia.tileentity.TileEntityKelp;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityPiston;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBlockKelp extends TileEntitySpecialRenderer
{
    /** instance of RenderBlocks used to draw the piston base and extension. */
    private RenderBlocks blockRenderer;

    public void renderKelp(TileEntityKelp tileEntity, double x, double y, double z, float par8)
    {
        Block block = Block.blocksList[tileEntity.worldObj.getBlockId(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord)];
        Block block1 = Block.blocksList[Block.waterStill.blockID];

        if (block != null)
        {
            Tessellator tessellator = Tessellator.instance;
            this.func_110628_a(TextureMap.field_110575_b);
            RenderHelper.disableStandardItemLighting();
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDisable(GL11.GL_CULL_FACE);

            if (Minecraft.isAmbientOcclusionEnabled())
            {
                GL11.glShadeModel(GL11.GL_SMOOTH);
            }
            else
            {
                GL11.glShadeModel(GL11.GL_FLAT);
            }

            tessellator.startDrawingQuads();
            tessellator.setTranslation((double)((float)x - (float)tileEntity.xCoord), (double)((float)y - (float)tileEntity.yCoord), (double)((float)z - (float)tileEntity.zCoord));
            tessellator.setColorOpaque(1, 1, 1);

            this.blockRenderer.renderCrossedSquares(block, tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord);
            this.blockRenderer.renderBlockFluids(block1, tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord);

            tessellator.setTranslation(0.0D, 0.0D, 0.0D);
            tessellator.draw();
            RenderHelper.enableStandardItemLighting();
        }
    }

    /**
     * Called when the ingame world being rendered changes (e.g. on world -> nether travel) due to using one renderer
     * per tile entity type, rather than instance
     */
    public void onWorldChange(World par1World)
    {
        this.blockRenderer = new RenderBlocks(par1World);
    }

    public void renderTileEntityAt(TileEntity par1TileEntity, double x, double y, double z, float par8)
    {
        this.renderKelp((TileEntityKelp)par1TileEntity, x, y, z, par8);
    }
}
