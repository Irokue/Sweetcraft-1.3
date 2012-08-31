package net.minecraft.src;

import java.util.Random;

public class BlockLeavesPommier extends BlockLeavesBase
{
    /**
     * The base index in terrain.png corresponding to the fancy version of the leaf texture. This is stored so we can
     * switch the displayed version between fancy and fast graphics (fast is this index + 1).
     */
    private int baseIndexInPNG;
    int adjacentTreeBlocks[];

    protected BlockLeavesPommier(int par1, int par2)
    {
        super(par1, par2, Material.leaves, false);
        baseIndexInPNG = par2;
        setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabDeco);

    }

    
    /**
     * ejects contained items into the world, and notifies neighbours of an update, as appropriate
     */
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        byte var7 = 1;
        int var8 = var7 + 1;

        if (par1World.checkChunksExist(par2 - var8, par3 - var8, par4 - var8, par2 + var8, par3 + var8, par4 + var8))
        {
            for (int var9 = -var7; var9 <= var7; ++var9)
            {
                for (int var10 = -var7; var10 <= var7; ++var10)
                {
                    for (int var11 = -var7; var11 <= var7; ++var11)
                    {
                        int var12 = par1World.getBlockId(par2 + var9, par3 + var10, par4 + var11);

                        if (var12 == Block.leavesPommier.blockID)
                        {
                            int var13 = par1World.getBlockMetadata(par2 + var9, par3 + var10, par4 + var11);
                        }
                    }
                }
            }
        }
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (par1World.isRemote)
        {
            return;
        }

        int i = par1World.getBlockMetadata(par2, par3, par4);

        if ((i & 8) != 0 && (i & 4) == 0)
        {
            byte byte0 = 4;
            int j = byte0 + 1;
            byte byte1 = 32;
            int k = byte1 * byte1;
            int l = byte1 / 2;

            if (adjacentTreeBlocks == null)
            {
                adjacentTreeBlocks = new int[byte1 * byte1 * byte1];
            }

            if (par1World.checkChunksExist(par2 - j, par3 - j, par4 - j, par2 + j, par3 + j, par4 + j))
            {
                for (int i1 = -byte0; i1 <= byte0; i1++)
                {
                    for (int l1 = -byte0; l1 <= byte0; l1++)
                    {
                        for (int j2 = -byte0; j2 <= byte0; j2++)
                        {
                            int l2 = par1World.getBlockId(par2 + i1, par3 + l1, par4 + j2);

                            if (l2 == Block.wood.blockID)
                            {
                                adjacentTreeBlocks[(i1 + l) * k + (l1 + l) * byte1 + (j2 + l)] = 0;
                                continue;
                            }

                            if (l2 == Block.leavesPommier.blockID)
                            {
                                adjacentTreeBlocks[(i1 + l) * k + (l1 + l) * byte1 + (j2 + l)] = -2;
                            }
                            else
                            {
                                adjacentTreeBlocks[(i1 + l) * k + (l1 + l) * byte1 + (j2 + l)] = -1;
                            }
                        }
                    }
                }

                for (int j1 = 1; j1 <= 4; j1++)
                {
                    for (int i2 = -byte0; i2 <= byte0; i2++)
                    {
                        for (int k2 = -byte0; k2 <= byte0; k2++)
                        {
                            for (int i3 = -byte0; i3 <= byte0; i3++)
                            {
                                if (adjacentTreeBlocks[(i2 + l) * k + (k2 + l) * byte1 + (i3 + l)] != j1 - 1)
                                {
                                    continue;
                                }

                                if (adjacentTreeBlocks[((i2 + l) - 1) * k + (k2 + l) * byte1 + (i3 + l)] == -2)
                                {
                                    adjacentTreeBlocks[((i2 + l) - 1) * k + (k2 + l) * byte1 + (i3 + l)] = j1;
                                }

                                if (adjacentTreeBlocks[(i2 + l + 1) * k + (k2 + l) * byte1 + (i3 + l)] == -2)
                                {
                                    adjacentTreeBlocks[(i2 + l + 1) * k + (k2 + l) * byte1 + (i3 + l)] = j1;
                                }

                                if (adjacentTreeBlocks[(i2 + l) * k + ((k2 + l) - 1) * byte1 + (i3 + l)] == -2)
                                {
                                    adjacentTreeBlocks[(i2 + l) * k + ((k2 + l) - 1) * byte1 + (i3 + l)] = j1;
                                }

                                if (adjacentTreeBlocks[(i2 + l) * k + (k2 + l + 1) * byte1 + (i3 + l)] == -2)
                                {
                                    adjacentTreeBlocks[(i2 + l) * k + (k2 + l + 1) * byte1 + (i3 + l)] = j1;
                                }

                                if (adjacentTreeBlocks[(i2 + l) * k + (k2 + l) * byte1 + ((i3 + l) - 1)] == -2)
                                {
                                    adjacentTreeBlocks[(i2 + l) * k + (k2 + l) * byte1 + ((i3 + l) - 1)] = j1;
                                }

                                if (adjacentTreeBlocks[(i2 + l) * k + (k2 + l) * byte1 + (i3 + l + 1)] == -2)
                                {
                                    adjacentTreeBlocks[(i2 + l) * k + (k2 + l) * byte1 + (i3 + l + 1)] = j1;
                                }
                            }
                        }
                    }
                }
            }

            int k1 = adjacentTreeBlocks[l * k + l * byte1 + l];

            if (k1 >= 0)
            {
                par1World.setBlockMetadata(par2, par3, par4, i & -9);
            }
            else
            {
                removeLeaves(par1World, par2, par3, par4);
            }
        }
    }

    private void removeLeaves(World par1World, int par2, int par3, int par4)
    {
        dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
        par1World.setBlockWithNotify(par2, par3, par4, 0);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return par1Random.nextInt(20) != 0 ? 0 : 1;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
		if ((par1 & 3) == 1)
		{
			return Item.appleRed.shiftedIndex;
		}else
		{
			return Block.sapling.blockID;
		}
	}

    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        if (!par1World.isRemote)
        {
            byte byte0 = 20;

            if ((par5 & 3) == 0 && par1World.rand.nextInt(200) == 0)
            {
                dropBlockAsItem_do(par1World, par2, par3, par4, new ItemStack(Item.appleRed, 1, 0));
            }


        		if ((par5 & 3) == 1)
        		{
        			dropBlockAsItem_do(par1World, par2, par3, par4, new ItemStack(Item.appleRed, 1));
        		}else
        		{
                    if (par1World.rand.nextInt(byte0) == 0)
                    {
                    	dropBlockAsItem_do(par1World, par2, par3, par4, new ItemStack(Block.sapling, 1,4));
                    }
        		}


        }
    }

    /**
     * Called when the player destroys a block with an item that can harvest it. (i, j, k) are the coordinates of the
     * block and l is the block's subtype/damage.
     */
    public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6)
    {
        if (!par1World.isRemote && par2EntityPlayer.getCurrentEquippedItem() != null && par2EntityPlayer.getCurrentEquippedItem().itemID == Item.shears.shiftedIndex)
        {
            par2EntityPlayer.addStat(StatList.mineBlockStatArray[blockID], 1);
            dropBlockAsItem_do(par1World, par3, par4, par5, new ItemStack(Block.leavesPommier.blockID, 1, par6 & 3));
        }
        else
        {
            super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
        }
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    protected int damageDropped(int par1)
    {
        return par1 & 3;
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
	switch(par2)
	{
        	case 1:
        	    if(par1 == 1) return 216;
        	    return 217;
		default:
		    return 216;
	}
    }

    /**
     * Pass true to draw this block using fancy graphics, or false for fast graphics.
     */
    public void setGraphicsLevel(boolean par1)
    {
       graphicsLevel = par1;
       // blockIndexInTexture = baseIndexInPNG + (par1 ? 0 : 1);
    }
}
