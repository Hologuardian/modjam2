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
	public EntityLivingBase thrower = null;
	public boolean hasCollided = false;
	public EntityHook(World par1World) 
	{
		super(par1World);
	}

	public EntityHook(World par1World, EntityPlayer player)
	{
		super(par1World, player);
		thrower = player;
	}

	public void onUpdate()
	{
		super.onUpdate();
		EntityPlayer player = this.worldObj.getClosestPlayerToEntity(this, 64.0D);

		if (player == null || player.getDistanceToEntity(this) > 64 || player.isSneaking())
		{
			this.setDead();
		}
		thrower = player;

		if (this.hasCollided)
		{
			if (player == null || this.getDistanceToEntity(player) > 64 || player.isSneaking() || this.posY < 5)
			{
				this.setDead();
				return;
			}
			double xDif = this.posX - player.posX;
			double yDif = this.posY - player.posY + 1.8;
			double zDif = this.posZ - player.posZ;

			if (Math.abs(xDif) < 0.3)
				xDif = 0;
			if (Math.abs(yDif) < 0.3)
				yDif = 0;
			if (Math.abs(zDif) < 0.3)
				zDif = 0;

			double xV = Math.signum(xDif) * 0.10;
			double yV = Math.signum(yDif) * 0.15;
			double zV = Math.signum(zDif) * 0.10;

			player.fallDistance = 0;
			player.addVelocity(xV, yV, zV);
		}
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

				this.motionX = 0;
				this.motionY = 0;
				this.motionZ = 0;
			}
		}
	}

	 /**
	  * Gets the amount of gravity to apply to the thrown entity with each tick.
	  */
	 protected float getGravityVelocity()
	 {
		 return this.hasCollided ? 0 : 0.03F;
	 }

}
