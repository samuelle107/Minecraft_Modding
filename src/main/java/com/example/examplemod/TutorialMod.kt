package com.example.examplemod

import com.example.examplemod.block.ModBlocks
import com.example.examplemod.item.ModItems
import com.example.examplemod.proxy.CommonProxy
import com.example.examplemod.recipe.ModRecipes
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.common.util.EnumHelper
import net.minecraft.init.SoundEvents
import net.minecraftforge.fml.common.registry.GameRegistry
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

const val modId = "tutorial"
const val name = "Tutorial Mod"
const val version = "1.0.0"
//Creates a new tool material that is made of copper
val copperToolMaterial = EnumHelper.addToolMaterial("COPPER", 2, 500, 6f, 2f, 14)
//Create a new armor material that is made of copper
//"COPPER": The name of the new enum value, this is completely capitalized, following the enum naming convention.
//modId:copper": This is the texture that will be used for our armor. We prefix it with our mod ID to use our mod’s domain instead of the default minecraft domain.
//15: The maximum damage factor.
//new int[]{2, 5, 6, 2}: The damage reduction factors for each armor piece.
//9: The enchantibility of the armor.
//SoundEvents.ITEM_ARMOR_EQUIP_IRON: The sound event that is played when the armor is equipped.
//0.0F: The toughness of the armor.
val copperArmorMaterial = EnumHelper.addArmorMaterial("COPPER","$modId:copper" , 15, intArrayOf(2, 5, 6, 2), 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f)

//This makes this class as a main mod so that forge will load it
@Mod(modid = modId, name = name, version = version)
class TutorialMod
{
    companion object
    {
        //@Mod.Instance marks this field so that Forge will inject the instance of our mod that is used into it
        //Use @JvmStatic when using a static method
        @JvmStatic
        //@Mod.Instance annotation marks this field so that Forge will inject the instance of our mod that is used into it.
        @Mod.Instance(modId)
        var instance: TutorialMod? = null
        @JvmStatic
        //This is so that Forge will detect which side our mod is running on and inject into correct proxy
        @SidedProxy(serverSide = "com.example.examplemod.proxy.CommonProxy", clientSide = "com.example.examplemod.proxy.ClientProxy")
        var proxy: CommonProxy? = null
        var creativeTab = TutorialTab()

    }
    //EventBusSubscriber signals forge that it needs to be subscribed to the main event bus
    @Mod.EventBusSubscriber
    object RegistrationHandler
    {
        //SubscribeEvent is used to indicate to Forge that this method handles an event
        @JvmStatic
        @SubscribeEvent
        fun registerItems(event: RegistryEvent.Register<Item>)
        {
            ModItems.register(event.registry)
            ModBlocks.registerItemBlocks(event.registry)
        }
        @JvmStatic
        @SubscribeEvent
        fun registerItems(event:ModelRegistryEvent)
        {
            ModItems.registerModels()
            ModBlocks.registerModels()
        }
        @JvmStatic
        @SubscribeEvent
        fun registerBlocks(event: RegistryEvent.Register<Block>)
        {
            ModBlocks.register(event.registry)
        }
    }
    @Mod.EventHandler
    fun preInit(event: FMLPreInitializationEvent)
    {
        GameRegistry.registerWorldGenerator(ModWorldGeneration(), 3)
    }
    //It needs to be called during the initialization phase, so we want to register at the pre-init or post-init phase sp the mods will be registered by then
    @Mod.EventHandler
    fun init(event: FMLInitializationEvent)
    {
        ModRecipes.init()
    }
}