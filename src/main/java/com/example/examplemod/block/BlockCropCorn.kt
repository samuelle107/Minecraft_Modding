package com.example.examplemod.block

import com.example.examplemod.item.ModItems
import com.example.examplemod.TutorialMod
import net.minecraft.block.BlockCrops
import net.minecraft.item.Item

class BlockCropCorn: BlockCrops()
{
    init
    {
        unlocalizedName = "crop_corn"
        setRegistryName("crop_corn")
        setCreativeTab(TutorialMod.creativeTab)
    }
    override fun getSeed():Item
    {
        return ModItems.cornSeed
    }
    override fun getCrop():Item
    {
        return ModItems.corn
    }
}
