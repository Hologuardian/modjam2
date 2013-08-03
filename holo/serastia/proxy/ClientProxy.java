package holo.serastia.proxy;

import holo.serastia.client.model.ModelBaracuda;
import holo.serastia.client.render.RenderBaracuda;
import holo.serastia.entity.mob.EntityBaracuda;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	public void initClient()
	{
		System.out.println("Redering registered");
		RenderingRegistry.registerEntityRenderingHandler(EntityBaracuda.class, new RenderBaracuda(new ModelBaracuda(), 0.25F));
	}
}
