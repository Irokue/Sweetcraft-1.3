package net.minecraft.src;
 
import java.util.List;
import java.util.Random;
 
public class BlockTapis extends Block
{
    protected BlockTapis(int par1, int par2)
    {
        super(par1, par2, Material.cloth);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.1F, 1.0F);
        this.setCreativeTab(CreativeTabs.tabDeco);
    }
    
    
    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int var4 = 0; var4 < 16; ++var4)
        {
            par3List.add(new ItemStack(par1, 1, var4));
        }
    }
 
    //Ceci est pour passer à travers le bloc. Enlevez-le si vous ne vous les pas avoir un effet "noclip".
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
    	return null;
    }
    
    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        if (par2 == 0)
        {
            return blockIndexInTexture;
        }
        else
        {
            par2 = ~(par2 & 0xf);
            return 113 + ((par2 & 8) >> 3) + (par2 & 7) * 16;
        }
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    protected int damageDropped(int par1)
    {
        return par1;
    }

 
    public boolean isOpaqueCube()
    {
        return false;
    }
 
    public boolean renderAsNormalBlock()
    {
        return false;
    }
}