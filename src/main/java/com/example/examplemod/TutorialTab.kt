package com.example.examplemod

import com.example.examplemod.item.ModItems
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.ItemStack


class TutorialTab : CreativeTabs(modId)
{
    //Sets background image
    init
    {
        backgroundImageName = "tutorialmod.png"
    }
    //Overrides the default function to change the icon to whatever icon is after ModItems.
    override fun getTabIconItem(): ItemStack
    {
        return ItemStack(ModItems.ingotCopper)
    }
    override fun hasSearchBar():Boolean
    {
        return true
    }
}
