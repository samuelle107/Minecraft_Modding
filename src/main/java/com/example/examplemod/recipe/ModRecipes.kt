package com.example.examplemod.recipe

import com.example.examplemod.item.ModItems
import net.minecraft.item.ItemStack
import com.example.examplemod.block.ModBlocks
import net.minecraftforge.fml.common.registry.GameRegistry

object ModRecipes
{
    fun init()
    {
        ModBlocks.oreCopper.initOreDict()
        ModItems.ingotCopper.initOreDict()
        ModItems.corn.initOreDict()
        //Parameters are input, output, how much experience is gained
        GameRegistry.addSmelting(ModBlocks.oreCopper, ItemStack(ModItems.ingotCopper), 10000f)
    }
}