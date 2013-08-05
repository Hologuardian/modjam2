package holo.serastia.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSkeratik extends ModelBase
{
	//fields
	ModelRenderer Head;
	ModelRenderer RearEnd;
	ModelRenderer Neck;
	ModelRenderer LegLeft1;
	ModelRenderer LegLeft2;
	ModelRenderer LegLeft3;
	ModelRenderer LegRight3;
	ModelRenderer LegRight2;
	ModelRenderer LegRight1;

	public ModelSkeratik()
	{
		textureWidth = 64;
		textureHeight = 64;

		Head = new ModelRenderer(this, 22, 0);
		Head.addBox(-3F, -3F, -7F, 6, 5, 6);
		Head.setRotationPoint(0F, 6F, -1F);
		Head.setTextureSize(64, 64);
		Head.mirror = true;
		setRotation(Head, 0F, 0F, 0F);
		RearEnd = new ModelRenderer(this, 0, 16);
		RearEnd.addBox(-5F, -4F, -6F, 10, 8, 12);
		RearEnd.setRotationPoint(0F, 16F, 4F);
		RearEnd.setTextureSize(64, 64);
		RearEnd.mirror = true;
		setRotation(RearEnd, 0F, 0F, 0F);
		Neck = new ModelRenderer(this, 8, 0);
		Neck.addBox(-2F, -10F, -1F, 4, 12, 3);
		Neck.setRotationPoint(0F, 13F, 2F);
		Neck.setTextureSize(64, 64);
		Neck.mirror = true;
		setRotation(Neck, 0.8551081F, 0F, 0F);
		LegLeft1 = new ModelRenderer(this, 0, 0);
		LegLeft1.addBox(-1F, -1F, -1F, 2, 11, 2);
		LegLeft1.setRotationPoint(4F, 16F, -0.5F);
		LegLeft1.setTextureSize(64, 64);
		LegLeft1.mirror = true;
		setRotation(LegLeft1, 0F, 0F, -0.6981317F);
		LegLeft2 = new ModelRenderer(this, 0, 0);
		LegLeft2.addBox(-1F, -1F, -1F, 2, 11, 2);
		LegLeft2.setRotationPoint(4F, 16F, 4F);
		LegLeft2.setTextureSize(64, 64);
		LegLeft2.mirror = true;
		setRotation(LegLeft2, 0F, 0F, -0.6981317F);
		LegLeft3 = new ModelRenderer(this, 0, 0);
		LegLeft3.addBox(-1F, -1F, -1F, 2, 11, 2);
		LegLeft3.setRotationPoint(4F, 16F, 8.5F);
		LegLeft3.setTextureSize(64, 64);
		LegLeft3.mirror = true;
		setRotation(LegLeft3, 0F, 0F, -0.6981317F);
		LegRight3 = new ModelRenderer(this, 0, 0);
		LegRight3.addBox(-1F, -1F, -1F, 2, 11, 2);
		LegRight3.setRotationPoint(-4F, 16F, 8.5F);
		LegRight3.setTextureSize(64, 64);
		LegRight3.mirror = true;
		setRotation(LegRight3, 0F, 0F, 0.6981317F);
		LegRight2 = new ModelRenderer(this, 0, 0);
		LegRight2.addBox(-1F, -1F, -1F, 2, 11, 2);
		LegRight2.setRotationPoint(-4F, 16F, 4F);
		LegRight2.setTextureSize(64, 64);
		LegRight2.mirror = true;
		setRotation(LegRight2, 0F, 0F, 0.6981317F);
		LegRight1 = new ModelRenderer(this, 0, 0);
		LegRight1.addBox(-1F, -1F, -1F, 2, 11, 2);
		LegRight1.setRotationPoint(-4F, 16F, -0.5F);
		LegRight1.setTextureSize(64, 64);
		LegRight1.mirror = true;
		setRotation(LegRight1, 0F, 0F, 0.6981317F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Head.render(f5);
		RearEnd.render(f5);
		Neck.render(f5);
		LegLeft1.render(f5);
		LegLeft2.render(f5);
		LegLeft3.render(f5);
		LegRight3.render(f5);
		LegRight2.render(f5);
		LegRight1.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity entity)
	{
        this.Head.rotateAngleY = par4 / (180F / (float)Math.PI);
        this.Head.rotateAngleX = par5 / (180F / (float)Math.PI);
        float f6 = ((float)Math.PI / 4F);
        this.LegLeft1.rotateAngleZ = -f6;
        this.LegRight1.rotateAngleZ = f6;
        this.LegLeft2.rotateAngleZ = -f6;
        this.LegRight2.rotateAngleZ = f6;
        this.LegLeft3.rotateAngleZ = -f6;
        this.LegRight3.rotateAngleZ = f6;
        float f7 = -0.0F;
        float f8 = 0.3926991F;
        this.LegLeft1.rotateAngleY = f8 * 2.0F + f7;
        this.LegRight1.rotateAngleY = -f8 * 2.0F - f7;
        this.LegLeft2.rotateAngleY = f8 * 1.0F + f7;
        this.LegRight2.rotateAngleY = -f8 * 1.0F - f7;
        this.LegLeft3.rotateAngleY = -f8 * 1.0F + f7;
        this.LegRight3.rotateAngleY = f8 * 1.0F - f7;
        float f9 = -(MathHelper.cos(par1 * 0.6662F * 2.0F + 0.0F) * 0.4F) * par2;
        float f10 = -(MathHelper.cos(par1 * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * par2;
        float f11 = -(MathHelper.cos(par1 * 0.6662F * 2.0F + ((float)Math.PI / 2F)) * 0.4F) * par2;
        float f12 = -(MathHelper.cos(par1 * 0.6662F * 2.0F + ((float)Math.PI * 3F / 2F)) * 0.4F) * par2;
        float f13 = Math.abs(MathHelper.sin(par1 * 0.6662F + 0.0F) * 0.4F) * par2;
        float f14 = Math.abs(MathHelper.sin(par1 * 0.6662F + (float)Math.PI) * 0.4F) * par2;
        float f15 = Math.abs(MathHelper.sin(par1 * 0.6662F + ((float)Math.PI / 2F)) * 0.4F) * par2;
        float f16 = Math.abs(MathHelper.sin(par1 * 0.6662F + ((float)Math.PI * 3F / 2F)) * 0.4F) * par2;
        this.LegLeft1.rotateAngleY += f9;
        this.LegRight1.rotateAngleY += -f9;
        this.LegLeft2.rotateAngleY += f10;
        this.LegRight2.rotateAngleY += -f10;
        this.LegLeft3.rotateAngleY += f11;
        this.LegRight3.rotateAngleY += -f11;
        
        this.LegLeft1.rotateAngleZ += f13;
        this.LegRight1.rotateAngleZ += -f13;
        this.LegLeft2.rotateAngleZ += f14;
        this.LegRight2.rotateAngleZ += -f14;
        this.LegLeft3.rotateAngleZ += f15;
        this.LegRight3.rotateAngleZ += -f15;
	}

}
