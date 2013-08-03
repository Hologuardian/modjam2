package holo.serastia;

import holo.serastia.proxy.CommonProxy;
import holo.serastia.util.Utils;
import net.minecraft.command.CommandHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Utils.MAIN_MOD_ID, version = Utils.VERSION, name = Utils.MAIN_MOD_ID)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class SerastiaMain
{   
    @Instance(Utils.MAIN_MOD_ID)
    public static SerastiaMain instance;
    
    @SidedProxy
    (clientSide = Utils.clientProxy, 
        serverSide = Utils.commonProxy)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        instance = this;
        this.proxy.configRegistry(event);
        this.proxy.init();
    	this.proxy.initClient();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
    }
}