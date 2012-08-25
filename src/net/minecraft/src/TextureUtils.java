package net.minecraft.src;

import java.util.HashSet;
import java.util.Set;

public class TextureUtils
{
    private static Set atlasNames = makeAtlasNames();
    private static Set atlasIds = new HashSet();

    private static Set makeAtlasNames()
    {
        HashSet var0 = new HashSet();
        var0.add("/terrain.png");
        var0.add("/gui/items.png");
        var0.add("/ctm.png");
        return var0;
    }

    public static void textureCreated(String var0, int var1)
    {
        if (atlasNames.contains(var0))
        {
            atlasIds.add(Integer.valueOf(var1));
        }
    }

    public static void addAtlasName(String var0)
    {
        if (var0 != null)
        {
            atlasNames.add(var0);
            Config.dbg("TextureAtlas: " + var0);
        }
    }

    public static boolean isAtlasId(int var0)
    {
        return atlasIds.contains(Integer.valueOf(var0));
    }

    public static boolean isAtlasName(String var0)
    {
        return atlasNames.contains(var0);
    }
}
