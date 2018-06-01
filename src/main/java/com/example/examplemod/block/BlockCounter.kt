package com.example.examplemod.block

import com.example.examplemod.TutorialMod
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumHand
import net.minecraft.util.math.BlockPos
import net.minecraft.util.text.TextComponentString
import net.minecraft.world.World


class BlockCounter : BlockTileEntity<TileEntityCounter>(Material.ROCK, "counter")
{
    init
    {
        setCreativeTab(TutorialMod.creativeTab)
    }
    override val tileEntityClass: Class<TileEntityCounter>
        get() = TileEntityCounter::class.java

    override fun onBlockActivated(world: World?, pos: BlockPos?, state: IBlockState?, player: EntityPlayer?, hand: EnumHand?, side: EnumFacing?, hitX: Float, hitY: Float, hitZ: Float): Boolean
    {
        if (!world!!.isRemote)
        {
            val tile : TileEntityCounter = getTileEntity(world, pos!!)
            if (side == EnumFacing.DOWN)
            {
                tile.decrementCount()
            }
            else if (side == EnumFacing.UP)
            {
                tile.incrementCount()
            }
            player!!.sendMessage(TextComponentString("Count: " + tile.count))
        }
        return true
    }
    override fun createTileEntity(world: World, state: IBlockState): TileEntityCounter
    {
        return TileEntityCounter()
    }

}