package holo.serastia.client.model;

import holo.serastia.entity.mob.EntityBaracuda;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBaracuda extends ModelBase
{
  //fields
    ModelRenderer Body;
    ModelRenderer Head;
    ModelRenderer Spine2;
    ModelRenderer Spine3;
    ModelRenderer Spine4;
    ModelRenderer Spine5;
    ModelRenderer Spine6;
    ModelRenderer Spine7;
    ModelRenderer Spine8;
    ModelRenderer Spine9;
    ModelRenderer Spine10;
    ModelRenderer Jaw;
    ModelRenderer TailFin;
    ModelRenderer LeftFin;
    ModelRenderer RightFin;
    ModelRenderer Spine1;
    ModelRenderer Tail;
  
  public ModelBaracuda()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Body = new ModelRenderer(this, 0, 18);
      Body.addBox(-2F, -3F, -12F, 4, 4, 10);
      Body.setRotationPoint(0F, 7F, 6F);
      Body.setTextureSize(64, 32);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      Head = new ModelRenderer(this, 0, 0);
      Head.addBox(-2F, -2F, -2F, 4, 3, 6);
      Head.setRotationPoint(0F, 6F, 6F);
      Head.setTextureSize(64, 32);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      Spine2 = new ModelRenderer(this, 58, 0);
      Spine2.addBox(-1F, -2F, 0F, 2, 3, 1);
      Spine2.setRotationPoint(0F, 4F, 2F);
      Spine2.setTextureSize(64, 32);
      Spine2.mirror = true;
      setRotation(Spine2, 0.6981317F, 0F, 0F);
      Spine3 = new ModelRenderer(this, 58, 0);
      Spine3.addBox(-1F, -2F, 0F, 2, 3, 1);
      Spine3.setRotationPoint(0F, 4F, 0F);
      Spine3.setTextureSize(64, 32);
      Spine3.mirror = true;
      setRotation(Spine3, 0.6981317F, 0F, 0F);
      Spine4 = new ModelRenderer(this, 58, 0);
      Spine4.addBox(-1F, -2F, 0F, 2, 3, 1);
      Spine4.setRotationPoint(0F, 4F, -2F);
      Spine4.setTextureSize(64, 32);
      Spine4.mirror = true;
      setRotation(Spine4, 0.6981317F, 0F, 0F);
      Spine5 = new ModelRenderer(this, 58, 0);
      Spine5.addBox(-1F, -2F, 0F, 2, 3, 1);
      Spine5.setRotationPoint(0F, 4F, -4F);
      Spine5.setTextureSize(64, 32);
      Spine5.mirror = true;
      setRotation(Spine5, 0.6981317F, 0F, 0F);
      Spine6 = new ModelRenderer(this, 58, 0);
      Spine6.addBox(-1F, -2F, 0F, 2, 3, 1);
      Spine6.setRotationPoint(0F, 4F, -6F);
      Spine6.setTextureSize(64, 32);
      Spine6.mirror = true;
      setRotation(Spine6, 0.6981317F, 0F, 0F);
      Spine7 = new ModelRenderer(this, 58, 0);
      Spine7.addBox(-1F, -2F, 0F, 2, 3, 1);
      Spine7.setRotationPoint(0F, 4F, -8F);
      Spine7.setTextureSize(64, 32);
      Spine7.mirror = true;
      setRotation(Spine7, 0.6981317F, 0F, 0F);
      Spine8 = new ModelRenderer(this, 58, 0);
      Spine8.addBox(-1F, -2F, 0F, 2, 3, 1);
      Spine8.setRotationPoint(0F, 4F, -10F);
      Spine8.setTextureSize(64, 32);
      Spine8.mirror = true;
      setRotation(Spine8, 0.6981317F, 0F, 0F);
      Spine9 = new ModelRenderer(this, 58, 0);
      Spine9.addBox(-1F, -2F, 0F, 2, 3, 1);
      Spine9.setRotationPoint(0F, 4F, -12F);
      Spine9.setTextureSize(64, 32);
      Spine9.mirror = true;
      setRotation(Spine9, 0.6981317F, 0F, 0F);
      Spine10 = new ModelRenderer(this, 58, 0);
      Spine10.addBox(-1F, -2F, 0F, 2, 3, 1);
      Spine10.setRotationPoint(0F, 4F, -14F);
      Spine10.setTextureSize(64, 32);
      Spine10.mirror = true;
      setRotation(Spine10, 0.6981317F, 0F, 0F);
      Jaw = new ModelRenderer(this, 0, 9);
      Jaw.addBox(-2F, 0F, 0F, 4, 1, 6);
      Jaw.setRotationPoint(0F, 7F, 4F);
      Jaw.setTextureSize(64, 32);
      Jaw.mirror = true;
      setRotation(Jaw, 0F, 0F, 0F);
      TailFin = new ModelRenderer(this, 28, 18);
      TailFin.addBox(0F, -5F, -4F, 0, 10, 4);
      TailFin.setRotationPoint(0F, 6F, -16F);
      TailFin.setTextureSize(64, 32);
      TailFin.mirror = true;
      setRotation(TailFin, 0F, 0F, 0F);
      LeftFin = new ModelRenderer(this, 20, 0);
      LeftFin.addBox(-1F, -2F, -4F, 0, 4, 4);
      LeftFin.setRotationPoint(-1F, 6F, 1F);
      LeftFin.setTextureSize(64, 32);
      LeftFin.mirror = true;
      setRotation(LeftFin, 0F, 0.4089647F, 0F);
      RightFin = new ModelRenderer(this, 20, 0);
      RightFin.addBox(1F, -2F, -4F, 0, 4, 4);
      RightFin.setRotationPoint(1F, 6F, 1F);
      RightFin.setTextureSize(64, 32);
      RightFin.mirror = true;
      setRotation(RightFin, 0F, -0.3066203F, 0F);
      Spine1 = new ModelRenderer(this, 58, 0);
      Spine1.addBox(-1F, -2F, 0F, 2, 3, 1);
      Spine1.setRotationPoint(0F, 4F, 4F);
      Spine1.setTextureSize(64, 32);
      Spine1.mirror = true;
      setRotation(Spine1, 0.6981317F, 0F, 0F);
      Tail = new ModelRenderer(this, 34, 0);
      Tail.addBox(-1F, -2F, 0F, 2, 4, 10);
      Tail.setRotationPoint(0F, 6F, -16F);
      Tail.setTextureSize(64, 32);
      Tail.mirror = true;
      setRotation(Tail, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Body.render(f5);
    Head.render(f5);
    Spine2.render(f5);
    Spine3.render(f5);
    Spine4.render(f5);
    Spine5.render(f5);
    Spine6.render(f5);
    Spine7.render(f5);
    Spine8.render(f5);
    Spine9.render(f5);
    Spine10.render(f5);
    Jaw.render(f5);
    TailFin.render(f5);
    LeftFin.render(f5);
    RightFin.render(f5);
    Spine1.render(f5);
    Tail.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
	  if (entity instanceof EntityBaracuda)
	  {
		  EntityBaracuda ent = (EntityBaracuda)entity;
		  if (ent.target != null)
		  {
		      setRotation(Jaw, -0.30F, 0F, 0F);
		  }
		  else
		  {
		      setRotation(Jaw, 0F, 0F, 0F);
		  }
	  }
  }

}
