package com.example.examplemod.block

import net.minecraftforge.items.CapabilityItemHandler
import net.minecraft.util.EnumFacing
import net.minecraftforge.common.util.BlockSnapshot.readFromNBT
import net.minecraft.nbt.NBTTagCompound
import net.minecraftforge.items.ItemStackHandler
import net.minecraft.tileentity.TileEntity
import net.minecraftforge.common.capabilities.Capability
import javax.annotation.Nullable


class TileEntityPedestal : TileEntity()
{
    private val inventory = ItemStackHandler(1)

    override fun writeToNBT(compound: NBTTagCompound): NBTTagCompound
    {
        compound.setTag("inventory", inventory.serializeNBT())
        return super.writeToNBT(compound)
    }
    override fun readFromNBT(compound: NBTTagCompound)
    {
        inventory.deserializeNBT(compound.getCompoundTag("inventory"))
        super.readFromNBT(compound)
    }
    override fun hasCapability(capability: Capability<*>, @Nullable facing: EnumFacing?): Boolean
    {
        return capability === CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || super.hasCapability(capability, facing)
    }
    override fun <T : Any?> getCapability(capability: Capability<T>, @Nullable facing: EnumFacing?): T?
    {
        return if (capability === CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) inventory as T else super.getCapability<T>(capability, facing)
    }
}