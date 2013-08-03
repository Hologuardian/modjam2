package holo.serastia.entity.mob;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityBaracuda extends EntityMob
{
	public Entity target = null;

	public EntityBaracuda(World par1World) 
	{
		super(par1World);
		this.getNavigator().setCanSwim(false);
	}

	public boolean canBreatheUnderwater()
	{
		return true;
	}

	/**
	 * Checks if the entity's current position is a valid location to spawn this entity.
	 */
	public boolean getCanSpawnHere()
	{
		return this.worldObj.checkNoEntityCollision(this.boundingBox);
	}

	/**
	 * Takes a coordinate in and returns a weight to determine how likely this creature will try to path to the block.
	 * Args: x, y, z
	 */
	public float getBlockPathWeight(int par1, int par2, int par3)
	{
		return this.worldObj.getBlockMaterial(par1, par2, par3) != Material.water ? 0 : 0.5F - this.worldObj.getLightBrightness(par1, par2, par3);
	}

	public void onLivingUpdate()
	{
		super.onLivingUpdate();
		this.target = this.findPlayerToAttack();

		if (this.target != null)
		{
			this.getNavigator().tryMoveToEntityLiving(target, 0.5F);
		}
	}

    /**
     * Takes in the distance the entity has fallen this tick and whether its on the ground to update the fall distance
     * and deal fall damage if landing on the ground.  Args: distanceFallenThisTick, onGround
     */
    protected void updateFallState(double par1, boolean par3)
    {}

    /**
     * Called when the mob is falling. Calculates and applies fall damage.
     */
    protected void fall(float par1)
    {}

	/**
	 * Moves the entity based on the specified heading.  Args: strafe, forward
	 */
	public void moveEntityWithHeading(float par1, float par2)
	{
		double d0;
		float f2 = 0.91F;

		if (this.onGround)
		{
			f2 = 0.54600006F;
			int i = this.worldObj.getBlockId(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.boundingBox.minY) - 1, MathHelper.floor_double(this.posZ));

			if (i > 0)
			{
				f2 = Block.blocksList[i].slipperiness * 0.91F;
			}
		}

		float f3 = 0.16277136F / (f2 * f2 * f2);
		float f4;

		if (this.onGround)
		{
			f4 = this.getAIMoveSpeed() * f3;
		}
		else
		{
			f4 = this.jumpMovementFactor;
		}

		this.moveFlying(par1, par2, f4);
		f2 = 0.91F;

		if (this.onGround)
		{
			f2 = 0.54600006F;
			int j = this.worldObj.getBlockId(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.boundingBox.minY) - 1, MathHelper.floor_double(this.posZ));

			if (j > 0)
			{
				f2 = Block.blocksList[j].slipperiness * 0.91F;
			}
		}

		if (this.isOnLadder())
		{
			float f5 = 0.15F;

			if (this.motionX < (double)(-f5))
			{
				this.motionX = (double)(-f5);
			}

			if (this.motionX > (double)f5)
			{
				this.motionX = (double)f5;
			}

			if (this.motionZ < (double)(-f5))
			{
				this.motionZ = (double)(-f5);
			}

			if (this.motionZ > (double)f5)
			{
				this.motionZ = (double)f5;
			}

			this.fallDistance = 0.0F;

			if (this.motionY < -0.15D)
			{
				this.motionY = -0.15D;
			}

			boolean flag = this.isSneaking();

			if (flag && this.motionY < 0.0D)
			{
				this.motionY = 0.0D;
			}
		}

		this.moveEntity(this.motionX, this.motionY, this.motionZ);

		if (this.isCollidedHorizontally && this.isOnLadder())
		{
			this.motionY = 0.2D;
		}

		if (this.worldObj.isRemote && (!this.worldObj.blockExists((int)this.posX, 0, (int)this.posZ) || !this.worldObj.getChunkFromBlockCoords((int)this.posX, (int)this.posZ).isChunkLoaded))
		{
			if (this.posY > 0.0D)
			{
				this.motionY = -0.1D;
			}
			else
			{
				this.motionY = 0.0D;
			}
		}
		else
		{
			this.motionY -= 0.08D;
		}

		this.motionY *= 0.9800000190734863D;
		this.motionX *= (double)f2;
		this.motionZ *= (double)f2;

		this.prevLimbYaw = this.limbYaw;
		d0 = this.posX - this.prevPosX;
		double d1 = this.posZ - this.prevPosZ;
		float f6 = MathHelper.sqrt_double(d0 * d0 + d1 * d1) * 4.0F;

		if (f6 > 1.0F)
		{
			f6 = 1.0F;
		}

		this.limbYaw += (f6 - this.limbYaw) * 0.4F;
		this.limbSwing += this.limbYaw;
	}
}
