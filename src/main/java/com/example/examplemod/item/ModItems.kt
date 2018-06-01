package com.example.examplemod.item

import com.example.examplemod.armor.ItemArmor
import com.example.examplemod.block.ItemCorn
import com.example.examplemod.copperArmorMaterial
import com.example.examplemod.copperToolMaterial
import com.example.examplemod.tool.ItemSword
import net.minecraft.inventory.EntityEquipmentSlot
import net.minecraft.item.Item
import net.minecraftforge.registries.IForgeRegistry

//Go to this object to add your own items.  Make sure to create your item with var......, then register in both functions
object ModItems
{
    var ingotCopper = ItemOre("ingot_copper", "ingotCopper")//.setCreativeTab(CreativeTabs.MATERIALS)
    var corn : ItemCorn = ItemCorn()//.setCreativeTab(CreativeTabs.FOOD)
    var cornSeed = ItemCornSeed()
    //Swords
    //the !! is to fix the type? error
    var copperSword = ItemSword(copperToolMaterial!!, "copper_sword")
    var mySword = ItemSword(copperToolMaterial!!, "my_sword")
    //Helmet
    var copperHelmet = ItemArmor(copperArmorMaterial!!, EntityEquipmentSlot.HEAD,"copper_helmet")

    fun register(registry: IForgeRegistry<Item>)
    {
        //Same reason as ModBlocks
        registry.registerAll(ingotCopper, corn, cornSeed, copperSword, mySword, copperHelmet)
    }
    fun registerModels()
    {
        ingotCopper.registerItemModel()
        corn.registerItemModel()
        cornSeed.registerItemModel()
        copperSword.registerItemModel()
        mySword.registerItemModel()
        copperHelmet.registerItemModel()
    }
}