package holo.serastia.entity.mob;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityHook extends EntityThrowable
{

	public boolean hasCollided = false;
	public EntityHook(World par1World) 
	{
		super(par1World);
	}

	public EntityHook(World par1World, EntityPlayer player)
	{
		super(par1World, player);
	}

	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	protected void onImpact(MovingObjectPosition pos)
	{
		if (pos.entityHit == null)
		{
			if (this.worldObj.getBlockId(pos.blockX, pos.blockY, pos.blockZ) != 0)
			{
				this.hasCollided = true;

				for (int i = 0; i < 8; ++i)
				{
					this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
				}
				
				EntityPlayer var1 = this.worldObj.getClosestVulnerablePlayerToEntity(this, 64.0D);

		        if (var1 == null || var1.getDistanceToEntity(this) > 64)
		        {
		        	this.setDead();
		        }
		        else if (this.getDistanceToEntity(var1) < 1 || var1.isSneaking())
		        {
		        	this.setDead();
		        }
		        else
		        {
		        	double xDif =this.posX - var1.posX;
		        	double yDif = this.posY - var1.posY + 1.8;
		        	double zDif = this.posZ - var1.posZ;
		        	
		        	if (Math.abs(xDif) < 0.3)
		        		xDif = 0;
		        	if (Math.abs(yDif) < 0.3)
		        		yDif = 0;
		        	if (Math.abs(zDif) < 0.3)
		        		zDif = 0;
		        	
		        	double xV = Math.signum(xDif) * 0.10;
		        	double yV = Math.signum(yDif) * 0.15;
		        	double zV = Math.signum(zDif) * 0.10;
		        	
		        	var1.fallDistance = 0;
		            var1.addVelocity(xV, yV, zV);
		        }

				this.motionX = 0;
				this.motionY = 0;
				this.motionZ = 0;
			}
		}
	}

}
