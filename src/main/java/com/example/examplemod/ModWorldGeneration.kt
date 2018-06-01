package com.example.examplemod

import com.example.examplemod.block.ModBlocks
import net.minecraftforge.fml.common.IWorldGenerator
import java.util.Random
import net.minecraft.world.chunk.IChunkProvider
import net.minecraft.world.gen.IChunkGenerator
import net.minecraft.world.World
import net.minecraft.world.gen.feature.WorldGenMinable
import net.minecraft.util.math.BlockPos
import net.minecraft.block.state.IBlockState

class ModWorldGeneration : IWorldGenerator
{
    override fun generate(random: Random, chunkX: Int, chunkZ: Int, world: World, chunkGenerator: IChunkGenerator, chunkProvider: IChunkProvider)
    {
        if (world.provider.getDimension() == 0)
        { // the overworld
            generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider)
        }
    }

    private fun generateOverworld(random: Random, chunkX: Int, chunkZ: Int, world: World, chunkGenerator: IChunkGenerator, chunkProvider: IChunkProvider)
    {
        generateOre(ModBlocks.oreCopper.defaultState, world, random, chunkX * 16, chunkZ * 16, 16, 64, 4 + random.nextInt(4), 6)
    }

    private fun generateOre(ore: IBlockState, world: World, random: Random, x: Int, z: Int, minY: Int, maxY: Int, size: Int, chances: Int) {
        val deltaY = maxY - minY

        for (i in 0 until chances)
        {
            val pos = BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16))
            val generator = WorldGenMinable(ore, size)
            generator.generate(world, random, pos)
        }
    }
}