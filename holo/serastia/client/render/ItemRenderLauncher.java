package holo.serastia.client.render;

import holo.serastia.client.model.ModelGrappleLauncher;
import holo.serastia.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.bouncycastle.util.Strings;
import org.lwjgl.opengl.GL11;

public class ItemRenderLauncher implements IItemRenderer 
{
	protected ModelGrappleLauncher launcherModel;
	
	public ItemRenderLauncher()
	{
		launcherModel = new ModelGrappleLauncher();
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) 
	{
		switch(type)
		{
		case EQUIPPED: return true;
		case EQUIPPED_FIRST_PERSON: return true;
		default: return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) 
	{
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) 
	{
		switch(type)
		{
		case EQUIPPED:
		{
			GL11.glPushMatrix();
			Minecraft.getMinecraft().renderEngine.func_110577_a(new ResourceLocation(Strings.toLowerCase(Utils.MAIN_MOD_ID) + ":textures/model/GrappleLauncher.png"));

			GL11.glRotatef(150F, 90F, 25F, -90F);
			
			GL11.glTranslatef(0.0F, -0.15F, -0.6F);
			
			
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			
			launcherModel.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			
			
			GL11.glPopMatrix();
		}
		case EQUIPPED_FIRST_PERSON:
		{
			GL11.glPushMatrix();
			Minecraft.getMinecraft().renderEngine.func_110577_a(new ResourceLocation(Strings.toLowerCase(Utils.MAIN_MOD_ID) + ":textures/model/GrappleLauncher.png"));

			GL11.glRotatef(150F, 90F, 25F, -90F);
			
			GL11.glTranslatef(0.0F, -0.15F, -0.6F);
			
			
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			
			launcherModel.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			
			
			GL11.glPopMatrix();
		}
		default:
			break;
		}
	}

}
