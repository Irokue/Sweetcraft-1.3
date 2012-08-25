package net.minecraft.src;

public enum EnumOptions
{
    MUSIC("options.music", true, false),
    SOUND("options.sound", true, false),
    INVERT_MOUSE("options.invertMouse", false, true),
    SENSITIVITY("options.sensitivity", true, false),
    FOV("options.fov", true, false),
    GAMMA("options.gamma", true, false),
    RENDER_DISTANCE("options.renderDistance", false, false),
    VIEW_BOBBING("options.viewBobbing", false, true),
    ANAGLYPH("options.anaglyph", false, true),
    ADVANCED_OPENGL("options.advancedOpengl", false, true),
    FRAMERATE_LIMIT("options.framerateLimit", false, false),
    DIFFICULTY("options.difficulty", false, false),
    GRAPHICS("options.graphics", false, false),
    AMBIENT_OCCLUSION("options.ao", false, true),
    GUI_SCALE("options.guiScale", false, false),
    RENDER_CLOUDS("options.renderClouds", false, true),
    PARTICLES("options.particles", false, false),
    CHAT_VISIBILITY("options.chat.visibility", false, false),
    CHAT_COLOR("options.chat.color", false, true),
    CHAT_LINKS("options.chat.links", false, true),
    CHAT_OPACITY("options.chat.opacity", true, false),
    CHAT_LINKS_PROMPT("options.chat.links.prompt", false, true),
    USE_SERVER_TEXTURES("options.serverTextures", false, true),
    SNOOPER_ENABLED("options.snooper", false, true),
    USE_FULLSCREEN("options.fullscreen", false, true),
    SEE_GLOBAL("options.seeglobal", false, true),
    SEE_COMMERCE("options.seecommerce", false, true),
    SEE_LOCAL("options.seelocal", false, true),
    TALK_GLOBAL("options.talkglobal", false, true),
    TALK_COMMERCE("options.talkcommerce", false, true),
    TALK_LOCAL("options.talklocal", false, true),
    HD_SKINS("options.hdSkins", false, true),
    ENABLE_VSYNC("options.vsync", false, true),
    FOG_FANCY("Fog", false, false),
    FOG_START("Fog Start", false, false),
    MIPMAP_LEVEL("Mipmap Level", false, false),
    MIPMAP_TYPE("Mipmap Type", false, false),
    LOAD_FAR("Load Far", false, false),
    PRELOADED_CHUNKS("Preloaded Chunks", false, false),
    SMOOTH_FPS("Smooth FPS", false, false),
    CLOUDS("Clouds", false, false),
    CLOUD_HEIGHT("Cloud Height", true, false),
    TREES("Trees", false, false),
    GRASS("Grass", false, false),
    RAIN("Rain & Snow", false, false),
    WATER("Water", false, false),
    ANIMATED_WATER("Water Animated", false, false),
    ANIMATED_LAVA("Lava Animated", false, false),
    ANIMATED_FIRE("Fire Animated", false, false),
    ANIMATED_PORTAL("Portal Animated", false, false),
    AO_LEVEL("Smooth Lighting", true, false),
    FAST_DEBUG_INFO("Fast Debug Info", false, false),
    AUTOSAVE_TICKS("Autosave", false, false),
    BETTER_GRASS("Better Grass", false, false),
    ANIMATED_REDSTONE("Redstone Animated", false, false),
    ANIMATED_EXPLOSION("Explosion Animated", false, false),
    ANIMATED_FLAME("Flame Animated", false, false),
    ANIMATED_SMOKE("Smoke Animated", false, false),
    WEATHER("Weather", false, false),
    SKY("Sky", false, false),
    STARS("Stars", false, false),
    SUN_MOON("Sun & Moon", false, false),
    CHUNK_UPDATES("Chunk Updates per Frame", false, false),
    CHUNK_UPDATES_DYNAMIC("Dynamic Updates", false, false),
    TIME("Time", false, false),
    CLEAR_WATER("Clear Water", false, false),
    SMOOTH_INPUT("Smooth Input", false, false),
    DEPTH_FOG("Depth Fog", false, false),
    VOID_PARTICLES("Void Particles", false, false),
    WATER_PARTICLES("Water Particles", false, false),
    RAIN_SPLASH("Rain Splash", false, false),
    PORTAL_PARTICLES("Portal Particles", false, false),
    PROFILER("Debug Profiler", false, false),
    DRIPPING_WATER_LAVA("Dripping Water/Lava", false, false),
    BETTER_SNOW("Better Snow", false, false),
    FULLSCREEN_MODE("Fullscreen", false, false),
    ANIMATED_TERRAIN("Terrain Animated", false, false),
    ANIMATED_ITEMS("Items Animated", false, false),
    SWAMP_COLORS("Swamp Colors", false, false),
    RANDOM_MOBS("Random Mobs", false, false),
    SMOOTH_BIOMES("Smooth Biomes", false, false),
    CUSTOM_FONTS("Custom Fonts", false, false),
    CUSTOM_COLORS("Custom Colors", false, false),
    SHOW_CAPES("Show Capes", false, false),
    CONNECTED_TEXTURES("Connected Textures", false, false),
    RENDER_DISTANCE_FINE("Render Distance", true, false),
    ANIMATED_TEXTURES("Textures Animated", false, false),
    NATURAL_TEXTURES("Natural Textures", false, false);
    private final boolean enumFloat;
    private final boolean enumBoolean;
    private final String enumString;

    public static EnumOptions getEnumOptions(int par0)
    {
        EnumOptions[] var1 = values();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3)
        {
            EnumOptions var4 = var1[var3];

            if (var4.returnEnumOrdinal() == par0)
            {
                return var4;
            }
        }

        return null;
    }

    private EnumOptions(String par3Str, boolean par4, boolean par5)
    {
        this.enumString = par3Str;
        this.enumFloat = par4;
        this.enumBoolean = par5;
    }

    public boolean getEnumFloat()
    {
        return this.enumFloat;
    }

    public boolean getEnumBoolean()
    {
        return this.enumBoolean;
    }

    public int returnEnumOrdinal()
    {
        return this.ordinal();
    }

    public String getEnumString()
    {
        return this.enumString;
    }
}