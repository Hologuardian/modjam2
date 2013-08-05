package holo.serastia.proxy;

import org.bouncycastle.util.Strings;

import holo.serastia.client.model.ModelBaracuda;
import holo.serastia.client.render.*;
import holo.serastia.entity.mob.*;
import holo.serastia.tileentity.TileEntityKelp;
import holo.serastia.util.Utils;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	public void initClient()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityBaracuda.class, new RenderBaracuda(new ModelBaracuda(), 0.25F));
		RenderingRegistry.registerEntityRenderingHandler(EntityHook.class, new RenderGrappleHook());
		ClientRegistry.registerTileEntity(TileEntityKelp.class, "TileEntityKelp", new RenderBlockKelp());
	}
}
