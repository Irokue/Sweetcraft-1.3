package net.minecraft.src;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.ImageObserver;

public class ImageBufferDownload implements ImageBuffer
{
    private int[] imageData;
    private int imageWidth;
    private int imageHeight;

    public BufferedImage parseUserSkin(BufferedImage par1BufferedImage)
    {
        if (par1BufferedImage == null)
        {
            return null;
        }
        else
        {
            this.imageWidth = 64;
            this.imageHeight = 32;

            for (BufferedImage var2 = par1BufferedImage; this.imageWidth < var2.getWidth() || this.imageHeight < var2.getHeight(); this.imageHeight *= 2)
            {
                this.imageWidth *= 2;
            }

            BufferedImage var3 = new BufferedImage(this.imageWidth, this.imageHeight, 2);
            Graphics var4 = var3.getGraphics();
            var4.drawImage(par1BufferedImage, 0, 0, (ImageObserver)null);
            var4.dispose();
            this.imageData = ((DataBufferInt)var3.getRaster().getDataBuffer()).getData();
            int var5 = this.imageWidth;
            int var6 = this.imageHeight;
            this.func_78433_b(0, 0, var5 / 2, var6 / 2);
            this.func_78434_a(var5 / 2, 0, var5, var6);
            this.func_78433_b(0, var6 / 2, var5, var6);
            boolean var7 = false;
            int var8;
            int var9;
            int var10;

            for (var8 = var5 / 2; var8 < var5; ++var8)
            {
                for (var9 = 0; var9 < var6 / 2; ++var9)
                {
                    var10 = this.imageData[var8 + var9 * var5];

                    if ((var10 >> 24 & 255) < 128)
                    {
                        var7 = true;
                    }
                }
            }

            if (!var7)
            {
                for (var8 = var5 / 2; var8 < var5; ++var8)
                {
                    for (var9 = 0; var9 < var6 / 2; ++var9)
                    {
                        var10 = this.imageData[var8 + var9 * var5];

                        if ((var10 >> 24 & 255) < 128)
                        {
                            boolean var11 = true;
                        }
                    }
                }
            }

            return var3;
        }
    }

    private void func_78434_a(int par1, int par2, int par3, int par4)
    {
        if (!this.func_78435_c(par1, par2, par3, par4))
        {
            for (int var5 = par1; var5 < par3; ++var5)
            {
                for (int var6 = par2; var6 < par4; ++var6)
                {
                    this.imageData[var5 + var6 * this.imageWidth] &= 16777215;
                }
            }
        }
    }

    private void func_78433_b(int par1, int par2, int par3, int par4)
    {
        for (int var5 = par1; var5 < par3; ++var5)
        {
            for (int var6 = par2; var6 < par4; ++var6)
            {
                this.imageData[var5 + var6 * this.imageWidth] |= -16777216;
            }
        }
    }

    private boolean func_78435_c(int par1, int par2, int par3, int par4)
    {
        for (int var5 = par1; var5 < par3; ++var5)
        {
            for (int var6 = par2; var6 < par4; ++var6)
            {
                int var7 = this.imageData[var5 + var6 * this.imageWidth];

                if ((var7 >> 24 & 255) < 128)
                {
                    return true;
                }
            }
        }

        return false;
    }
}
