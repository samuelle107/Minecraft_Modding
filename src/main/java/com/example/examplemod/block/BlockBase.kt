package com.example.examplemod.block

import com.example.examplemod.TutorialMod
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock

open class BlockBase(material: Material, protected var name: String) : Block(material)
{
    init
    {
        unlocalizedName = name
        setRegistryName(name)
        setCreativeTab(TutorialMod.creativeTab)
    }
    fun registerItemModel(itemBlock: Item)
    {
        TutorialMod.proxy!!.registerItemRenderer(itemBlock, 0, name)
    }
    fun createItemBlock(): Item
    {
        return ItemBlock(this).setRegistryName(registryName)
    }
    override fun setCreativeTab(tab: CreativeTabs): BlockBase
    {
        super.setCreativeTab(tab)
        return this
    }
}