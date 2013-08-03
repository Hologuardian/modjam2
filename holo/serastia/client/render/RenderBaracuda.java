package holo.serastia.client.render;

import holo.serastia.entity.mob.EntityBaracuda;
import holo.serastia.util.Utils;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.bouncycastle.util.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBaracuda extends RenderLiving
{
    private static final ResourceLocation field_110833_a = new ResourceLocation(Strings.toLowerCase(Utils.MAIN_MOD_ID) + ":textures/mob/Baracuda.png");

    public RenderBaracuda(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }

    protected ResourceLocation func_110832_a(EntityBaracuda par1)
    {
        return field_110833_a;
    }

    protected ResourceLocation func_110775_a(Entity par1Entity)
    {
        return this.func_110832_a((EntityBaracuda)par1Entity);
    }
}