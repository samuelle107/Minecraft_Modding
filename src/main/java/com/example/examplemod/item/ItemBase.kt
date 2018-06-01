package com.example.examplemod.item

import com.example.examplemod.TutorialMod
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item

open class ItemBase( var name: String) : Item()
{
    init
    {
        unlocalizedName = name
        setRegistryName(name)
        setCreativeTab(TutorialMod.creativeTab)
    }
    fun registerItemModel()
    {
        TutorialMod.proxy!!.registerItemRenderer(this, 0, name)
    }
    override fun setCreativeTab(tab: CreativeTabs): ItemBase
    {
        super.setCreativeTab(tab)
        return this
    }
}