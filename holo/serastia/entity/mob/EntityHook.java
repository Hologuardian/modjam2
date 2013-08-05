package holo.serastia.entity.mob;

import java.util.List;

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
	public Entity entityHit = null;
	public boolean hasCollided;
	private boolean hasEntityCollided;
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
			this.moveEntities(this, player, 1.0F);
		}
		else if (this.hasEntityCollided)
		{
			entityHit = this.getClosestEntity(this.worldObj);

			this.moveEntities(player, entityHit, 1.0F);
			this.moveEntities(entityHit, this, 1.0F);

			if (entityHit.getDistanceToEntity(player) < 2)
			{
				this.setDead();
				return;
			}
		}
	}

	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	protected void onImpact(MovingObjectPosition pos)
	{
		if (pos.entityHit == null && !this.hasEntityCollided)
		{
			if (this.worldObj.getBlockId(pos.blockX, pos.blockY, pos.blockZ) != 0)
			{
				this.hasCollided = true;

				this.motionX = 0;
				this.motionY = 0;
				this.motionZ = 0;
			}
		}
		else if(pos.entityHit != this.getThrower())
		{
			this.entityHit = pos.entityHit;
			this.hasCollided = false;
			this.hasEntityCollided = true;
			this.motionX = 0;
			this.motionY = 0;
			this.motionZ = 0;
		}
	}

	/**
	 * Gets the amount of gravity to apply to the thrown entity with each tick.
	 */
	protected float getGravityVelocity()
	{
		return this.hasCollided || this.hasEntityCollided   ? 0 : 0.03F;
	}

	public Entity getClosestEntity(World world)
	{
		Entity retEnt = null;
		float entDist = Float.MAX_VALUE;
		List<Entity> entityList = world.loadedEntityList;
		for(Entity entity : entityList)
		{
			if(this.getDistanceToEntity(entity) < entDist && !(entity instanceof EntityHook) && entity != this.getThrower() && !(entity instanceof EntityPlayer))
			{
				retEnt = entity;
				entDist = this.getDistanceToEntity(entity);
			}
		}

		return retEnt;
	}

	public void moveEntities(Entity target, Entity moving, float speed)
	{
		if (target == null || moving == null)
		{
			this.setDead();
			return;
		}
		double xDif = target.posX - moving.posX;
		double yDif = target.posY - moving.posY + moving.height;
		double zDif = target.posZ - moving.posZ;

		if (Math.abs(xDif) < (moving.width) * speed)
			xDif = 0;
		if (Math.abs(yDif) < 0.1 * speed)
			yDif = 0;
		if (Math.abs(zDif) < (moving.width) * speed)
			zDif = 0;

		double xV = Math.signum(xDif) * 0.10 * speed;
		double yV = Math.signum(yDif) * 0.15 * speed;
		double zV = Math.signum(zDif) * 0.10 * speed;

		moving.fallDistance = 0;
		moving.addVelocity(xV, yV, zV);
	}
}
