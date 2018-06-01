package com.example.examplemod.item

import com.example.examplemod.TutorialMod
import com.example.examplemod.block.ModBlocks
import net.minecraft.init.Blocks
import net.minecraft.item.ItemSeeds


class ItemCornSeed : ItemSeeds(ModBlocks.cropCorn, Blocks.FARMLAND)
{
    init
    {
        unlocalizedName = "corn_seed"
        setRegistryName("corn_seed")
        setCreativeTab(TutorialMod.creativeTab)
    }
    fun registerItemModel()
    {
        TutorialMod.proxy!!.registerItemRenderer(this, 0, "corn_seed")
    }

}