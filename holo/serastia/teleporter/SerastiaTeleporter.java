package holo.serastia.teleporter;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class SerastiaTeleporter extends Teleporter
{
    private final WorldServer worldServerInstance;
    private final Random random;

	public SerastiaTeleporter(WorldServer par1WorldServer) 
	{
		super(par1WorldServer);
        this.worldServerInstance = par1WorldServer;
        this.random = new Random(par1WorldServer.getSeed());
	}

    /**
     * Place an entity in a nearby portal, creating one if necessary.
     */
    public void placeInPortal(Entity par1Entity, double par2, double par4, double par6, float par8)
    {
        if (this.worldServerInstance.provider.dimensionId != 1)
        {
            if (!this.placeInExistingPortal(par1Entity, par2, par4, par6, par8))
            {
                this.makePortal(par1Entity);
                this.placeInExistingPortal(par1Entity, par2, par4, par6, par8);
            }
        }
        else
        {
            int i = MathHelper.floor_double(par1Entity.posX);
            int j = MathHelper.floor_double(par1Entity.posY) - 1;
            int k = MathHelper.floor_double(par1Entity.posZ);
            byte b0 = 1;
            byte b1 = 0;

//            for (int l = -2; l <= 2; ++l)
//            {
//                for (int i1 = -2; i1 <= 2; ++i1)
//                {
//                    for (int j1 = -1; j1 < 3; ++j1)
//                    {
//                        int k1 = i + i1 * b0 + l * b1;
//                        int l1 = j + j1;
//                        int i2 = k + i1 * b1 - l * b0;
//                        boolean flag = j1 < 0;
//                        this.worldServerInstance.setBlock(k1, l1, i2, flag ? Block.obsidian.blockID : 0);
//                    }
//                }
//            }

            par1Entity.setLocationAndAngles((double)i, (double)j, (double)k, par1Entity.rotationYaw, 0.0F);
            par1Entity.motionX = par1Entity.motionY = par1Entity.motionZ = 0.0D;
        }
    }

    public boolean makePortal(Entity par1Entity)
    {
//        byte b0 = 16;
//        double d0 = -1.0D;
//        int i = MathHelper.floor_double(par1Entity.posX);
//        int j = MathHelper.floor_double(par1Entity.posY);
//        int k = MathHelper.floor_double(par1Entity.posZ);
//        int l = i;
//        int i1 = j;
//        int j1 = k;
//        int k1 = 0;
//        int l1 = this.random.nextInt(4);
//        int i2;
//        double d1;
//        double d2;
//        int j2;
//        int k2;
//        int l2;
//        int i3;
//        int j3;
//        int k3;
//        int l3;
//        int i4;
//        int j4;
//        int k4;
//        double d3;
//        double d4;
//
//        for (i2 = i - b0; i2 <= i + b0; ++i2)
//        {
//            d1 = (double)i2 + 0.5D - par1Entity.posX;
//
//            for (j2 = k - b0; j2 <= k + b0; ++j2)
//            {
//                d2 = (double)j2 + 0.5D - par1Entity.posZ;
//                label274:
//
//                for (k2 = this.worldServerInstance.getActualHeight() - 1; k2 >= 0; --k2)
//                {
//                    if (this.worldServerInstance.isAirBlock(i2, k2, j2))
//                    {
//                        while (k2 > 0 && this.worldServerInstance.isAirBlock(i2, k2 - 1, j2))
//                        {
//                            --k2;
//                        }
//
//                        for (i3 = l1; i3 < l1 + 4; ++i3)
//                        {
//                            l2 = i3 % 2;
//                            k3 = 1 - l2;
//
//                            if (i3 % 4 >= 2)
//                            {
//                                l2 = -l2;
//                                k3 = -k3;
//                            }
//
//                            for (j3 = 0; j3 < 3; ++j3)
//                            {
//                                for (i4 = 0; i4 < 4; ++i4)
//                                {
//                                    for (l3 = -1; l3 < 4; ++l3)
//                                    {
//                                        k4 = i2 + (i4 - 1) * l2 + j3 * k3;
//                                        j4 = k2 + l3;
//                                        int l4 = j2 + (i4 - 1) * k3 - j3 * l2;
//
//                                        if (l3 < 0 && !this.worldServerInstance.getBlockMaterial(k4, j4, l4).isSolid() || l3 >= 0 && !this.worldServerInstance.isAirBlock(k4, j4, l4))
//                                        {
//                                            continue label274;
//                                        }
//                                    }
//                                }
//                            }
//
//                            d4 = (double)k2 + 0.5D - par1Entity.posY;
//                            d3 = d1 * d1 + d4 * d4 + d2 * d2;
//
//                            if (d0 < 0.0D || d3 < d0)
//                            {
//                                d0 = d3;
//                                l = i2;
//                                i1 = k2;
//                                j1 = j2;
//                                k1 = i3 % 4;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        if (d0 < 0.0D)
//        {
//            for (i2 = i - b0; i2 <= i + b0; ++i2)
//            {
//                d1 = (double)i2 + 0.5D - par1Entity.posX;
//
//                for (j2 = k - b0; j2 <= k + b0; ++j2)
//                {
//                    d2 = (double)j2 + 0.5D - par1Entity.posZ;
//                    label222:
//
//                    for (k2 = this.worldServerInstance.getActualHeight() - 1; k2 >= 0; --k2)
//                    {
//                        if (this.worldServerInstance.isAirBlock(i2, k2, j2))
//                        {
//                            while (k2 > 0 && this.worldServerInstance.isAirBlock(i2, k2 - 1, j2))
//                            {
//                                --k2;
//                            }
//
//                            for (i3 = l1; i3 < l1 + 2; ++i3)
//                            {
//                                l2 = i3 % 2;
//                                k3 = 1 - l2;
//
//                                for (j3 = 0; j3 < 4; ++j3)
//                                {
//                                    for (i4 = -1; i4 < 4; ++i4)
//                                    {
//                                        l3 = i2 + (j3 - 1) * l2;
//                                        k4 = k2 + i4;
//                                        j4 = j2 + (j3 - 1) * k3;
//
//                                        if (i4 < 0 && !this.worldServerInstance.getBlockMaterial(l3, k4, j4).isSolid() || i4 >= 0 && !this.worldServerInstance.isAirBlock(l3, k4, j4))
//                                        {
//                                            continue label222;
//                                        }
//                                    }
//                                }
//
//                                d4 = (double)k2 + 0.5D - par1Entity.posY;
//                                d3 = d1 * d1 + d4 * d4 + d2 * d2;
//
//                                if (d0 < 0.0D || d3 < d0)
//                                {
//                                    d0 = d3;
//                                    l = i2;
//                                    i1 = k2;
//                                    j1 = j2;
//                                    k1 = i3 % 2;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        int i5 = l;
//        int j5 = i1;
//        j2 = j1;
//        int k5 = k1 % 2;
//        int l5 = 1 - k5;
//
//        if (k1 % 4 >= 2)
//        {
//            k5 = -k5;
//            l5 = -l5;
//        }
//
//        boolean flag;
//
//        if (d0 < 0.0D)
//        {
//            if (i1 < 70)
//            {
//                i1 = 70;
//            }
//
//            if (i1 > this.worldServerInstance.getActualHeight() - 10)
//            {
//                i1 = this.worldServerInstance.getActualHeight() - 10;
//            }
//
//            j5 = i1;
//
//            for (k2 = -1; k2 <= 1; ++k2)
//            {
//                for (i3 = 1; i3 < 3; ++i3)
//                {
//                    for (l2 = -1; l2 < 3; ++l2)
//                    {
//                        k3 = i5 + (i3 - 1) * k5 + k2 * l5;
//                        j3 = j5 + l2;
//                        i4 = j2 + (i3 - 1) * l5 - k2 * k5;
//                        flag = l2 < 0;
//                        this.worldServerInstance.setBlock(k3, j3, i4, flag ? Block.obsidian.blockID : 0);
//                    }
//                }
//            }
//        }
//
//        for (k2 = 0; k2 < 4; ++k2)
//        {
//            for (i3 = 0; i3 < 4; ++i3)
//            {
//                for (l2 = -1; l2 < 4; ++l2)
//                {
//                    k3 = i5 + (i3 - 1) * k5;
//                    j3 = j5 + l2;
//                    i4 = j2 + (i3 - 1) * l5;
//                    flag = i3 == 0 || i3 == 3 || l2 == -1 || l2 == 3;
//                    this.worldServerInstance.setBlock(k3, j3, i4, flag ? Block.obsidian.blockID : Block.portal.blockID, 0, 2);
//                }
//            }
//
//            for (i3 = 0; i3 < 4; ++i3)
//            {
//                for (l2 = -1; l2 < 4; ++l2)
//                {
//                    k3 = i5 + (i3 - 1) * k5;
//                    j3 = j5 + l2;
//                    i4 = j2 + (i3 - 1) * l5;
//                    this.worldServerInstance.notifyBlocksOfNeighborChange(k3, j3, i4, this.worldServerInstance.getBlockId(k3, j3, i4));
//                }
//            }
//        }

        return true;
    }

}
