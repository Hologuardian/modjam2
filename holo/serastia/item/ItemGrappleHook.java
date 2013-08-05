package holo.serastia.item;

import org.bouncycastle.util.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import holo.serastia.entity.mob.EntityHook;
import holo.serastia.util.Utils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGrappleHook extends Item
{
    public ItemGrappleHook(int par1)
    {
        super(par1);
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
    	
        world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!world.isRemote && world.getEntitiesWithinAABB(EntityHook.class, player.boundingBox.expand(128.0F, 128.0F, 128.0F)).isEmpty())
        {
        	EntityHook entity = new EntityHook(world, player);
            world.spawnEntityInWorld(entity);
        }

        return stack;
    }

    @SideOnly(Side.CLIENT)
    protected String func_111208_A()
    {
        return Strings.toLowerCase(Utils.MAIN_MOD_ID) + ":HookLauncher";
    }
}
