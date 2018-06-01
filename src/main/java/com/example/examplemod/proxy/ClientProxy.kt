package com.example.examplemod.proxy

import com.example.examplemod.modId
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraft.util.text.translation.I18n
import net.minecraftforge.client.model.ModelLoader

//ClientProxy inherits from CommonProxy
class ClientProxy : CommonProxy()
{
    override fun registerItemRenderer(item: Item, meta: Int, id: String)
    {
        ModelLoader.setCustomModelResourceLocation(item, meta, ModelResourceLocation(modId + ":" + id, "inventory"))
    }
    override fun localize(unlocalized: String, vararg args: Any): String {
        return I18n.translateToLocalFormatted(unlocalized,args)
    }
}