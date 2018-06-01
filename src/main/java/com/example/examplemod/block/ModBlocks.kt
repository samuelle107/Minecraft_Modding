package com.example.examplemod.block

import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraftforge.fml.common.registry.GameRegistry
import net.minecraftforge.registries.IForgeRegistry
//Same process as ModItems except there is now a registerItemBlocks, which converts the item to a block

object ModBlocks
{
    //Create block variables here
    var oreCopper = BlockOre("ore_copper", "oreCopper")//.setCreativeTab(CreativeTabs.MATERIALS)
    var cropCorn: BlockCropCorn = BlockCropCorn()
    var counter : BlockCounter = BlockCounter()
    var pedestal:BlockPedestal = BlockPedestal()

    fun register(registry: IForgeRegistry<Block>)
    {
        //registerAll has infinite parameters, so register all blocks here
        registry.registerAll(oreCopper, cropCorn, counter, pedestal)
        GameRegistry.registerTileEntity(counter.tileEntityClass, counter.registryName.toString())
    }
    fun registerItemBlocks(registry: IForgeRegistry<Item>)
    {
        registry.registerAll(oreCopper.createItemBlock(), pedestal.createItemBlock(), counter.createItemBlock())
    }
    fun registerModels()
    {
        oreCopper.registerItemModel(Item.getItemFromBlock(oreCopper))
        counter.registerItemModel(Item.getItemFromBlock(counter))
        pedestal.registerItemModel(Item.getItemFromBlock(pedestal))
    }

}