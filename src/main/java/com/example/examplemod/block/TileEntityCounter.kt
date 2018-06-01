package com.example.examplemod.block

import net.minecraftforge.common.util.BlockSnapshot.readFromNBT
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.tileentity.TileEntity


class TileEntityCounter : TileEntity() {

    var count: Int = 0
        private set

    override fun writeToNBT(compound: NBTTagCompound): NBTTagCompound {
        compound.setInteger("count", count)
        return super.writeToNBT(compound)
    }

    override fun readFromNBT(compound: NBTTagCompound) {
        count = compound.getInteger("count")
        super.readFromNBT(compound)
    }

    fun incrementCount() {
        count++
        markDirty()
    }

    fun decrementCount() {
        count--
        markDirty()
    }

}