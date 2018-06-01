package com.example.examplemod.block

import net.minecraft.block.material.Material
import net.minecraft.creativetab.CreativeTabs
import net.minecraftforge.oredict.OreDictionary

//This is used to give the block ore characteristics (hardness and resitance to explosions)

class BlockOre(name: String, private val oreName: String) : BlockBase(Material.ROCK, name) {

    init {

        setHardness(3f)
        setResistance(5f)
    }

    fun initOreDict() {
        OreDictionary.registerOre(oreName, this)
    }

    override fun setCreativeTab(tab: CreativeTabs): BlockOre {
        super.setCreativeTab(tab)
        return this
    }

}