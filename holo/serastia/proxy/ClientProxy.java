package holo.serastia.proxy;

import holo.serastia.client.model.ModelBaracuda;
import holo.serastia.client.render.*;
import holo.serastia.entity.mob.*;
import holo.serastia.tileentity.TileEntityKelp;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	public void initClient()
	{
		System.out.println("Redering registered");
		RenderingRegistry.registerEntityRenderingHandler(EntityBaracuda.class, new RenderBaracuda(new ModelBaracuda(), 0.25F));
		RenderingRegistry.registerEntityRenderingHandler(EntityHook.class, new RenderGrappleHook());
		ClientRegistry.registerTileEntity(TileEntityKelp.class, "TileEntityKelp", new RenderBlockKelp());
	}
}
