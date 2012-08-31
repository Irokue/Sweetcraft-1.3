package net.minecraft.src;

class EnumOptionsHelper
{
    static final int[] enumOptionsMappingHelperArray = new int[EnumOptions.values().length];

    static
    {
        try
        {
            enumOptionsMappingHelperArray[EnumOptions.INVERT_MOUSE.ordinal()] = 1;
        }
        catch (NoSuchFieldError var13)
        {
            ;
        }

        try
        {
            enumOptionsMappingHelperArray[EnumOptions.VIEW_BOBBING.ordinal()] = 2;
        }
        catch (NoSuchFieldError var12)
        {
            ;
        }

        try
        {
            enumOptionsMappingHelperArray[EnumOptions.ANAGLYPH.ordinal()] = 3;
        }
        catch (NoSuchFieldError var11)
        {
            ;
        }

        try
        {
            enumOptionsMappingHelperArray[EnumOptions.ADVANCED_OPENGL.ordinal()] = 4;
        }
        catch (NoSuchFieldError var10)
        {
            ;
        }

        try
        {
            enumOptionsMappingHelperArray[EnumOptions.AMBIENT_OCCLUSION.ordinal()] = 5;
        }
        catch (NoSuchFieldError var9)
        {
            ;
        }

        try
        {
            enumOptionsMappingHelperArray[EnumOptions.RENDER_CLOUDS.ordinal()] = 6;
        }
        catch (NoSuchFieldError var8)
        {
            ;
        }

        try
        {
            enumOptionsMappingHelperArray[EnumOptions.CHAT_COLOR.ordinal()] = 7;
        }
        catch (NoSuchFieldError var7)
        {
            ;
        }

        try
        {
            enumOptionsMappingHelperArray[EnumOptions.CHAT_LINKS.ordinal()] = 8;
        }
        catch (NoSuchFieldError var6)
        {
            ;
        }

        try
        {
            enumOptionsMappingHelperArray[EnumOptions.CHAT_LINKS_PROMPT.ordinal()] = 9;
        }
        catch (NoSuchFieldError var5)
        {
            ;
        }

        try
        {
            enumOptionsMappingHelperArray[EnumOptions.USE_SERVER_TEXTURES.ordinal()] = 10;
        }
        catch (NoSuchFieldError var4)
        {
            ;
        }

        try
        {
            enumOptionsMappingHelperArray[EnumOptions.SNOOPER_ENABLED.ordinal()] = 11;
        }
        catch (NoSuchFieldError var3)
        {
            ;
        }

        try
        {
            enumOptionsMappingHelperArray[EnumOptions.USE_FULLSCREEN.ordinal()] = 12;
        }
        catch (NoSuchFieldError var2)
        {
            ;
        }

        try
        {
            enumOptionsMappingHelperArray[EnumOptions.ENABLE_VSYNC.ordinal()] = 13;
        }
        catch (NoSuchFieldError var1)
        {
            ;
        }
        
        try
        {
            enumOptionsMappingHelperArray[EnumOptions.SEE_GLOBAL.ordinal()] = 14;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        
        try
        {
            enumOptionsMappingHelperArray[EnumOptions.SEE_COMMERCE.ordinal()] = 15;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        
        try
        {
            enumOptionsMappingHelperArray[EnumOptions.SEE_LOCAL.ordinal()] = 16;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        
        try
        {
            enumOptionsMappingHelperArray[EnumOptions.TALK_GLOBAL.ordinal()] = 17;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        
        try
        {
            enumOptionsMappingHelperArray[EnumOptions.TALK_COMMERCE.ordinal()] = 18;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        
        try
        {
            enumOptionsMappingHelperArray[EnumOptions.TALK_LOCAL.ordinal()] = 19;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        
        try
        {
            enumOptionsMappingHelperArray[EnumOptions.HD_SKINS.ordinal()] = 20;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
    }
}
