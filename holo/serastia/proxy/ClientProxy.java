package holo.serastia.proxy;

import holo.serastia.client.model.ModelBaracuda;
import holo.serastia.client.render.RenderBaracuda;
import holo.serastia.client.render.RenderGrappleHook;
import holo.serastia.entity.mob.EntityBaracuda;
import holo.serastia.entity.mob.EntityHook;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	public void initClient()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityBaracuda.class, new RenderBaracuda(new ModelBaracuda(), 0.25F));
		RenderingRegistry.registerEntityRenderingHandler(EntityHook.class, new RenderGrappleHook());
	}
}
