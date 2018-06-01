package com.example.examplemod.armor

import com.example.examplemod.TutorialMod
import net.minecraft.inventory.EntityEquipmentSlot
import net.minecraft.item.ItemArmor

class ItemArmor(material:ItemArmor.ArmorMaterial,slot:EntityEquipmentSlot, private val name:String):net.minecraft.item.ItemArmor(material,0, slot)
{
    init
    {
        setRegistryName(name)
        setUnlocalizedName(name)
        setCreativeTab(TutorialMod.creativeTab)
    }
    fun registerItemModel()
    {
        TutorialMod.proxy!!.registerItemRenderer(this,0,name)
    }
}