package holo.serastia.entity.mob;

import holo.serastia.client.fx.EntitySpitBallFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;

public class EntitySpitBall extends EntityArrow
{
    
	public EntitySpitBall(World par1World)
    {
        super(par1World);
    }

    public EntitySpitBall(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }

    public EntitySpitBall(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase, float par4, float par5)
    {
        super(par1World, par2EntityLivingBase, par3EntityLivingBase, par4, par5);
    }

    public EntitySpitBall(World par1World, EntityLivingBase par2EntityLivingBase, float par3)
    {
        super(par1World, par2EntityLivingBase, par3);
    }

	public void onUpdate()
    {
    	super.onUpdate();
//    	for (int i = 0; i < 5; ++i)
//    	{
//        	EntitySpitBallFX fx = new EntitySpitBallFX(this.worldObj, this.posX, this.posY, this.posZ, this.rand.nextFloat() * 0.25 - 0.125, this.rand.nextFloat() * 0.25 - 0.125, this.rand.nextFloat() * 0.25 - 0.125);
//        	FMLClientHandler.instance().getClient().effectRenderer.addEffect(fx);
//    	}
    }

    /**
     * Called by a player entity when they collide with an entity
     */
    public void onCollideWithPlayer(EntityPlayer player)
    {
    	player.addPotionEffect(new PotionEffect(Potion.poison.id, 120, 1));
        if (!this.worldObj.isRemote && !this.isAirBorne && this.arrowShake <= 0)
        {
            boolean flag = this.canBePickedUp == 1 || this.canBePickedUp == 2 && player.capabilities.isCreativeMode;

            if (this.canBePickedUp == 1 && !player.inventory.addItemStackToInventory(new ItemStack(Item.arrow, 1)))
            {
                flag = false;
            }

            if (flag)
            {
                this.playSound("random.pop", 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
                player.onItemPickup(this, 1);
                this.setDead();
            }
        }
    }

    public double getDamage()
    {
        return 6;
    }

}
