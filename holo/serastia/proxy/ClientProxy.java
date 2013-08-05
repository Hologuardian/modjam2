package holo.serastia.proxy;

import holo.serastia.client.model.ModelBaracuda;
import holo.serastia.client.model.ModelSkeratik;
import holo.serastia.client.render.ItemRenderLauncher;
import holo.serastia.client.render.RenderBaracuda;
import holo.serastia.client.render.RenderGrappleHook;
import holo.serastia.client.render.RenderSkeratik;
import holo.serastia.client.render.RenderSpitBall;
import holo.serastia.entity.mob.EntityBaracuda;
import holo.serastia.entity.mob.EntityHook;
import holo.serastia.entity.mob.EntitySkeratik;
import holo.serastia.entity.mob.EntitySpitBall;
import holo.serastia.helper.ItemHelper;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	public void initClient()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityBaracuda.class, new RenderBaracuda(new ModelBaracuda(), 0.25F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySkeratik.class, new RenderSkeratik(new ModelSkeratik(), 0.25F));
		RenderingRegistry.registerEntityRenderingHandler(EntityHook.class, new RenderGrappleHook());
		RenderingRegistry.registerEntityRenderingHandler(EntitySpitBall.class, new RenderSpitBall());
		MinecraftForgeClient.registerItemRenderer(ItemHelper.grappleHook.itemID, new ItemRenderLauncher());
	}
}
