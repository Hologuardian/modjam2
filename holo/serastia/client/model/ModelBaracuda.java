package holo.serastia.client.model;

import holo.serastia.entity.mob.EntityBaracuda;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBaracuda extends ModelBase
{
	//fields
	ModelRenderer Body;
	ModelRenderer Head;
	ModelRenderer Jaw;
	ModelRenderer Tail;
	ModelRenderer Spine1;
	ModelRenderer Spine2;
	ModelRenderer Spine3;
	ModelRenderer Spine4;
	ModelRenderer Spine5;
	ModelRenderer Spine6;
	ModelRenderer Spine7;
	ModelRenderer Spine8;
	ModelRenderer Shape1;

	public ModelBaracuda()
	{
		textureWidth = 64;
		textureHeight = 64;

		Body = new ModelRenderer(this, 0, 0);
		Body.addBox(-2F, -3F, -5F, 4, 4, 17);
		Body.setRotationPoint(0F, 20F, 0F);
		Body.setTextureSize(64, 64);
		Body.mirror = true;
		setRotation(Body, 0F, 0F, 0F);
		Head = new ModelRenderer(this, 44, 0);
		Head.addBox(-2F, -1F, -5F, 4, 3, 6);
		Head.setRotationPoint(0F, 18F, -6F);
		Head.setTextureSize(64, 64);
		Head.mirror = true;
		setRotation(Head, 0F, 0F, 0F);
		Jaw = new ModelRenderer(this, 45, 9);
		Jaw.addBox(-2F, 0F, -5F, 4, 1, 6);
		Jaw.setRotationPoint(0F, 20F, -6F);
		Jaw.setTextureSize(64, 64);
		Jaw.mirror = true;
		setRotation(Jaw, 0.3490659F, 0F, 0F);
		Tail = new ModelRenderer(this, 0, 21);
		Tail.addBox(-1F, -2F, 0F, 2, 4, 6);
		Tail.setRotationPoint(0F, 19F, 12F);
		Tail.setTextureSize(64, 64);
		Tail.mirror = true;
		setRotation(Tail, 0F, 0F, 0F);
		Spine1 = new ModelRenderer(this, 45, 18);
		Spine1.addBox(-1F, -2F, 0F, 2, 2, 1);
		Spine1.setRotationPoint(0F, 17F, -5F);
		Spine1.setTextureSize(64, 64);
		Spine1.mirror = true;
		setRotation(Spine1, -0.5235988F, 0F, 0F);
		Spine2 = new ModelRenderer(this, 45, 18);
		Spine2.addBox(-1F, -2F, 0F, 2, 2, 1);
		Spine2.setRotationPoint(0F, 17F, -3F);
		Spine2.setTextureSize(64, 64);
		Spine2.mirror = true;
		setRotation(Spine2, -0.5235988F, 0F, 0F);
		Spine3 = new ModelRenderer(this, 45, 18);
		Spine3.addBox(-1F, -2F, 0F, 2, 2, 1);
		Spine3.setRotationPoint(0F, 17F, -1F);
		Spine3.setTextureSize(64, 64);
		Spine3.mirror = true;
		setRotation(Spine3, -0.5235988F, 0F, 0F);
		Spine4 = new ModelRenderer(this, 45, 18);
		Spine4.addBox(-1F, -2F, 0F, 2, 2, 1);
		Spine4.setRotationPoint(0F, 17F, 1F);
		Spine4.setTextureSize(64, 64);
		Spine4.mirror = true;
		setRotation(Spine4, -0.5235988F, 0F, 0F);
		Spine5 = new ModelRenderer(this, 45, 18);
		Spine5.addBox(-1F, -2F, 0F, 2, 2, 1);
		Spine5.setRotationPoint(0F, 17F, 3F);
		Spine5.setTextureSize(64, 64);
		Spine5.mirror = true;
		setRotation(Spine5, -0.5235988F, 0F, 0F);
		Spine6 = new ModelRenderer(this, 45, 18);
		Spine6.addBox(-1F, -2F, 0F, 2, 2, 1);
		Spine6.setRotationPoint(0F, 17F, 5F);
		Spine6.setTextureSize(64, 64);
		Spine6.mirror = true;
		setRotation(Spine6, -0.5235988F, 0F, 0F);
		Spine7 = new ModelRenderer(this, 45, 18);
		Spine7.addBox(-1F, -2F, 0F, 2, 2, 1);
		Spine7.setRotationPoint(0F, 17F, 7F);
		Spine7.setTextureSize(64, 64);
		Spine7.mirror = true;
		setRotation(Spine7, -0.5235988F, 0F, 0F);
		Spine8 = new ModelRenderer(this, 45, 18);
		Spine8.addBox(-1F, -2F, 0F, 2, 2, 1);
		Spine8.setRotationPoint(0F, 17F, 9F);
		Spine8.setTextureSize(64, 64);
		Spine8.mirror = true;
		setRotation(Spine8, -0.5235988F, 0F, 0F);
		Shape1 = new ModelRenderer(this, 16, 21);
		Shape1.addBox(0F, -5F, 6F, 0, 10, 3);
		Shape1.setRotationPoint(0F, 19F, 12F);
		Shape1.setTextureSize(64, 64);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, (EntityBaracuda) entity);
		Body.render(f5);
		Head.render(f5);
		Jaw.render(f5);
		Tail.render(f5);
		Spine1.render(f5);
		Spine2.render(f5);
		Spine3.render(f5);
		Spine4.render(f5);
		Spine5.render(f5);
		Spine6.render(f5);
		Spine7.render(f5);
		Spine8.render(f5);
		Shape1.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, EntityBaracuda entity)
	{
		if (entity.openJaw)
			setRotation(Jaw, 0.35F, 0F, 0F);
		else
			setRotation(Jaw, 0.0F, 0F, 0F);
		

        this.Tail.rotateAngleY = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
        this.Shape1.rotateAngleY = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
	}

}
