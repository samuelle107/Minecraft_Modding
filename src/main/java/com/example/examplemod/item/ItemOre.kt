package com.example.examplemod.item

import net.minecraftforge.oredict.OreDictionary


class ItemOre(name:String, private var oreName:String): ItemBase(name)
{
    fun initOreDict()
    {
        OreDictionary.registerOre(oreName, this)
    }


}