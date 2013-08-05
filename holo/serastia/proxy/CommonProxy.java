package holo.serastia.proxy;

import holo.serastia.helper.ConfigHelper;
import holo.serastia.helper.DimensionHelper;
import holo.serastia.helper.EntityHelper;
import holo.serastia.helper.ItemHelper;
import holo.serastia.helper.RecipeHelper;
import holo.serastia.util.Utils;

import java.io.File;

import org.bouncycastle.util.Strings;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy 
{
	public void init()
	{
		ItemHelper.init();
		DimensionHelper.init();
		EntityHelper.init();
		RecipeHelper.init();
	}
	
	public void initClient(){}
	
    public void configRegistry(FMLPreInitializationEvent event) 
    {
        File file = new File(event.getModConfigurationDirectory(), "Serastia.cfg");
        Configuration config = new Configuration(file);
        config.load();
        ConfigHelper.init(config);
        config.save();
    }
}
