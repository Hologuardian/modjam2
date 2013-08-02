package holo.serastia.item;

import holo.serastia.helper.ConfigHelper;
import holo.serastia.teleporter.SerastiaTeleporter;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class ItemDimensionTraveler extends Item
{

	public ItemDimensionTraveler(int par1) 
	{
		super(par1);
		this.setCreativeTab(CreativeTabs.tabRedstone);
	}

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (player.ridingEntity == null && player.riddenByEntity == null && player instanceof EntityPlayerMP)
		{
			int dimID = ConfigHelper.serastiaDimensionID;
			int currentDimID = player.dimension;

			EntityPlayerMP playerMP = (EntityPlayerMP) player;
			if(player.timeUntilPortal == 0)
			{
				player.timeUntilPortal = 100;

				MinecraftServer minecraftServer = MinecraftServer.getServer();
				WorldServer currentWorldServer = minecraftServer.worldServerForDimension(currentDimID);
				WorldServer worldServer = minecraftServer.worldServerForDimension(dimID);

				if(dimID == currentDimID)
				{
					minecraftServer.getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) player, 0, new SerastiaTeleporter(worldServer));
				} 
				else 
				{
					minecraftServer.getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) player, dimID, new SerastiaTeleporter(currentWorldServer));
				}
			}
		}
		return stack;
	}
}
