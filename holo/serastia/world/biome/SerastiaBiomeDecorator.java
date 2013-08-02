package holo.serastia.world.biome;

import holo.serastia.world.feature.MapGenKelp;
import holo.serastia.world.feature.MapGenWaterTree;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

public class SerastiaBiomeDecorator extends BiomeDecorator
{
    private WorldGenerator waterTrees = new MapGenWaterTree(false);
    private WorldGenerator kelp = new MapGenKelp();

	public SerastiaBiomeDecorator(BiomeGenBase par1BiomeGenBase) 
	{
		super(par1BiomeGenBase);
	}

    
    /**
     * The method that does the work of actually decorating chunks
     */
    protected void decorate()
    {
        super.decorate();
        MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(currentWorld, randomGenerator, chunk_X, chunk_Z));
        

    	int i;
    	int j;
    	int k;
        if (randomGenerator.nextInt(3) == 0)
        {
        	i = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
        	k = this.chunk_Z + randomGenerator.nextInt(16) + 8;
        	j = 35;
        	while(this.currentWorld.getBlockId(i, j, k) != Block.waterStill.blockID)
        	{
        		++j;
        	}
        	this.waterTrees.generate(this.currentWorld, randomGenerator, i, j, k);
        }
        
        for(int n = 0; n < 3; ++n)
        {
        	i = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
        	k = this.chunk_Z + randomGenerator.nextInt(16) + 8;
        	j = 35;
        	while(this.currentWorld.getBlockMaterial(i, j, k) != Material.water)
        	{
        		++j;
        	}
        	this.kelp.generate(this.currentWorld, randomGenerator, i, j, k);
        }
        
        MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(currentWorld, randomGenerator, chunk_X, chunk_Z));
    }

}
