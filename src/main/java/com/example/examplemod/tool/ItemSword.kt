package com.example.examplemod.tool

import com.example.examplemod.TutorialMod
import net.minecraft.item.Item

class ItemSword(material: Item.ToolMaterial, private val name: String) : net.minecraft.item.ItemSword(material)
{
    init
    {
        setRegistryName(name)
        unlocalizedName = name
        //Adds swords to the mod tab
        setCreativeTab(TutorialMod.creativeTab)
    }
    fun registerItemModel()
    {
        TutorialMod.proxy!!.registerItemRenderer(this, 0, name)
    }
}