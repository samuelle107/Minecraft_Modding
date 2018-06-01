package com.example.examplemod.block

import com.example.examplemod.TutorialMod
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.ItemFood
import net.minecraftforge.oredict.OreDictionary

class ItemCorn : ItemFood(3, 0.6F, false)
{
    init
    {
        unlocalizedName = "corn"
        setRegistryName("corn")
        creativeTab = TutorialMod.creativeTab
    }
    fun registerItemModel()
    {
        TutorialMod.proxy!!.registerItemRenderer(this, 0, "corn");
    }
    fun initOreDict()
    {
        OreDictionary.registerOre("cropCorn",this)
    }
}