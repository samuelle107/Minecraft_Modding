package com.example.examplemod.block

import net.minecraft.block.state.IBlockState
import net.minecraft.world.World
import javax.annotation.Nullable
import net.minecraft.util.text.TextComponentString
import com.example.examplemod.TutorialMod
import net.minecraft.block.material.Material
import net.minecraftforge.items.CapabilityItemHandler
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumHand
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.math.BlockPos
import net.minecraft.entity.item.EntityItem

class BlockPedestal : BlockTileEntity<TileEntityPedestal>(Material.ROCK, "pedestal")
{
    @Deprecated("")
    override fun isOpaqueCube(state: IBlockState?): Boolean
    {
        return false
    }
    @Deprecated("")
    override fun isFullCube(state: IBlockState?): Boolean
    {
        return false
    }
    override val tileEntityClass: Class<TileEntityPedestal>
        get() = TileEntityPedestal::class.java
    override fun onBlockActivated(world: World?, pos: BlockPos?, state: IBlockState?, player: EntityPlayer?, hand: EnumHand?, side: EnumFacing?, hitX: Float, hitY: Float, hitZ: Float): Boolean
    {
        if (!world!!.isRemote)
        {
            val heldItem = player!!.getHeldItem(hand)
            val tile = getTileEntity(world, pos!!)
            val itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, side!!)
            if (!player!!.isSneaking)
            {
                if (heldItem.isEmpty())
                {
                    player.setHeldItem(hand, itemHandler!!.extractItem(0, 64, false))
                } else {
                    player.setHeldItem(hand, itemHandler!!.insertItem(0, heldItem, false))
                }
                tile.markDirty()
            }
            else
            {
                val stack = itemHandler!!.getStackInSlot(0)
                if (!stack.isEmpty())
                {
                    val localized = TutorialMod.proxy!!.localize(stack.getUnlocalizedName() + ".name")
                     player.sendMessage(TextComponentString( "${stack.count} x $localized"))
                } else
                {
                    player.sendMessage(TextComponentString("Empty"))
                }
            }
        }
        return true
    }
    override fun breakBlock(world: World, pos: BlockPos, state: IBlockState) {
        val tile = getTileEntity(world, pos)
        val itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH)
        val stack = itemHandler!!.getStackInSlot(0)
        if (!stack.isEmpty()) {
            val item = EntityItem(world, pos.x.toDouble(), pos.y.toDouble(), pos.z.toDouble(), stack)
            world.spawnEntity(item)
        }
        super.breakBlock(world, pos, state)
    }
    @Nullable
    override fun createTileEntity(world: World, state: IBlockState): TileEntityPedestal
    {
        return TileEntityPedestal()
    }
}