package net.minecraft.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class GameSettings
{
    private static final String[] RENDER_DISTANCES = new String[] {"options.renderDistance.far", "options.renderDistance.normal", "options.renderDistance.short", "options.renderDistance.tiny"};
    private static final String[] DIFFICULTIES = new String[] {"options.difficulty.peaceful", "options.difficulty.easy", "options.difficulty.normal", "options.difficulty.hard"};

    /** GUI scale values */
    private static final String[] GUISCALES = new String[] {"options.guiScale.auto", "options.guiScale.small", "options.guiScale.normal", "options.guiScale.large"};
    private static final String[] field_74369_af = new String[] {"options.chat.visibility.full", "options.chat.visibility.system", "options.chat.visibility.hidden"};
    private static final String[] PARTICLES = new String[] {"options.particles.all", "options.particles.decreased", "options.particles.minimal"};

    /** Limit framerate labels */
    private static final String[] LIMIT_FRAMERATES = new String[] {"performance.max", "performance.balanced", "performance.powersaver"};
    public float musicVolume = 1.0F;
    public float soundVolume = 1.0F;
    public float mouseSensitivity = 0.5F;
    public boolean invertMouse = false;
    public int renderDistance = 0;
    public boolean viewBobbing = true;
    public boolean anaglyph = false;

    /** Advanced OpenGL */
    public boolean advancedOpengl = false;
    public int limitFramerate = 1;
    public boolean fancyGraphics = true;

    /** Smooth Lighting */
    public boolean ambientOcclusion = true;

    /** Clouds flag */
    public boolean clouds = true;
    public int ofRenderDistanceFine = 128;
    public int ofFogType = 1;
    public float ofFogStart = 0.8F;
    public int ofMipmapLevel = 0;
    public boolean ofMipmapLinear = false;
    public boolean ofLoadFar = false;
    public int ofPreloadedChunks = 0;
    public boolean ofOcclusionFancy = false;
    public boolean ofSmoothFps = false;
    public boolean ofSmoothInput = true;
    public float ofAoLevel = 1.0F;
    public int ofClouds = 0;
    public float ofCloudsHeight = 0.0F;
    public int ofTrees = 0;
    public int ofGrass = 0;
    public int ofRain = 0;
    public int ofWater = 0;
    public int ofBetterGrass = 3;
    public int ofAutoSaveTicks = 4000;
    public boolean ofFastDebugInfo = false;
    public boolean ofWeather = true;
    public boolean ofSky = true;
    public boolean ofStars = true;
    public boolean ofSunMoon = true;
    public int ofChunkUpdates = 1;
    public boolean ofChunkUpdatesDynamic = false;
    public int ofTime = 0;
    public boolean ofClearWater = false;
    public boolean ofDepthFog = true;
    public boolean ofProfiler = false;
    public boolean ofBetterSnow = false;
    public String ofFullscreenMode = "Default";
    public boolean ofSwampColors = true;
    public boolean ofRandomMobs = true;
    public boolean ofSmoothBiomes = true;
    public boolean ofCustomFonts = true;
    public boolean ofCustomColors = true;
    public boolean ofShowCapes = true;
    public int ofConnectedTextures = 2;
    public boolean ofNaturalTextures = false;
    public int ofAnimatedWater = 0;
    public int ofAnimatedLava = 0;
    public boolean ofAnimatedFire = true;
    public boolean ofAnimatedPortal = true;
    public boolean ofAnimatedRedstone = true;
    public boolean ofAnimatedExplosion = true;
    public boolean ofAnimatedFlame = true;
    public boolean ofAnimatedSmoke = true;
    public boolean ofVoidParticles = true;
    public boolean ofWaterParticles = true;
    public boolean ofRainSplash = true;
    public boolean ofPortalParticles = true;
    public boolean ofDrippingWaterLava = true;
    public boolean ofAnimatedTerrain = true;
    public boolean ofAnimatedItems = true;
    public boolean ofAnimatedTextures = true;
    public boolean global = true;
    public boolean commerce = true;
    public boolean talkGlobal = true;
    public boolean talkCommerce = false;
    public boolean talkLocal = false;
    public boolean local = true;
    public boolean hdSkins = true;
    public static final int DEFAULT = 0;
    public static final int FAST = 1;
    public static final int FANCY = 2;
    public static final int OFF = 3;
    public static final int ANIM_ON = 0;
    public static final int ANIM_GENERATED = 1;
    public static final int ANIM_OFF = 2;
    public static final int CL_DEFAULT = 0;
    public static final int CL_SMOOTH = 1;
    public static final int CL_THREADED = 2;
    public static final String DEFAULT_STR = "Default";
    public KeyBinding ofKeyBindZoom;

    /** The name of the selected texture pack. */
    public String skin = "Default";
    public int chatVisibility = 0;
    public boolean chatColours = true;
    public boolean chatLinks = true;
    public boolean chatLinksPrompt = true;
    public float chatOpacity = 1.0F;
    public boolean serverTextures = true;
    public boolean snooperEnabled = true;
    public boolean fullScreen = false;
    public boolean enableVsync = false;
    public boolean field_80005_w = false;
    public KeyBinding keyBindForward = new KeyBinding("key.forward", 17);
    public KeyBinding keyBindLeft = new KeyBinding("key.left", 30);
    public KeyBinding keyBindBack = new KeyBinding("key.back", 31);
    public KeyBinding keyBindRight = new KeyBinding("key.right", 32);
    public KeyBinding keyBindJump = new KeyBinding("key.jump", 57);
    public KeyBinding keyBindInventory = new KeyBinding("key.inventory", 18);
    public KeyBinding keyBindDrop = new KeyBinding("key.drop", 16);
    public KeyBinding keyBindChat = new KeyBinding("key.chat", 20);
    public KeyBinding keyBindSneak = new KeyBinding("key.sneak", 42);
    public KeyBinding keyBindAttack = new KeyBinding("key.attack", -100);
    public KeyBinding keyBindUseItem = new KeyBinding("key.use", -99);
    public KeyBinding keyBindPlayerList = new KeyBinding("key.playerlist", 15);
    public KeyBinding keyBindPickBlock = new KeyBinding("key.pickItem", -98);
    public KeyBinding field_74323_J = new KeyBinding("key.command", 53);
    public KeyBinding keyBindSweetcraft = new KeyBinding("Caractéristiques", 46);
    public KeyBinding[] keyBindings;
    protected Minecraft mc;
    private File optionsFile;
    public int difficulty;
    public boolean hideGUI;
    public int thirdPersonView;

    /** true if debug info should be displayed instead of version */
    public boolean showDebugInfo;
    public boolean field_74329_Q;

    /** The lastServer string. */
    public String lastServer;

    /** No clipping for singleplayer */
    public boolean noclip;

    /** Smooth Camera Toggle */
    public boolean smoothCamera;
    public boolean debugCamEnable;

    /** No clipping movement rate */
    public float noclipRate;

    /** Change rate for debug camera */
    public float debugCamRate;
    public float fovSetting;
    public float gammaSetting;

    /** GUI scale */
    public int guiScale;

    /** Determines amount of particles. 0 = All, 1 = Decreased, 2 = Minimal */
    public int particleSetting;

    /** Game settings language */
    public String language;
    private File optionsFileOF;

    public GameSettings(Minecraft par1Minecraft, File par2File)
    {
        this.renderDistance = 1;
        this.limitFramerate = 0;
        this.ofKeyBindZoom = new KeyBinding("Zoom", 29);
        this.keyBindings = new KeyBinding[] {this.keyBindAttack, this.keyBindUseItem, this.keyBindForward, this.keyBindLeft, this.keyBindBack, this.keyBindRight, this.keyBindJump, this.keyBindSneak, this.keyBindDrop, this.keyBindInventory, this.keyBindChat, this.keyBindPlayerList, this.keyBindPickBlock, this.ofKeyBindZoom, this.field_74323_J, this.keyBindSweetcraft};
        this.difficulty = 2;
        this.hideGUI = false;
        this.thirdPersonView = 0;
        this.showDebugInfo = false;
        this.field_74329_Q = false;
        this.lastServer = "";
        this.noclip = false;
        this.smoothCamera = false;
        this.debugCamEnable = false;
        this.noclipRate = 1.0F;
        this.debugCamRate = 1.0F;
        this.fovSetting = 0.0F;
        this.gammaSetting = 0.0F;
        this.guiScale = 0;
        this.particleSetting = 0;
        this.language = "en_US";
        this.mc = par1Minecraft;
        this.optionsFile = new File(par2File, "options.txt");
        this.optionsFileOF = new File(par2File, "optionsof.txt");
        this.loadOptions();
        Config.setGameSettings(this);
    }

    public GameSettings()
    {
        this.renderDistance = 1;
        this.limitFramerate = 0;
        this.ofKeyBindZoom = new KeyBinding("Zoom", 29);
        this.keyBindings = new KeyBinding[] {this.keyBindAttack, this.keyBindUseItem, this.keyBindForward, this.keyBindLeft, this.keyBindBack, this.keyBindRight, this.keyBindJump, this.keyBindSneak, this.keyBindDrop, this.keyBindInventory, this.keyBindChat, this.keyBindPlayerList, this.keyBindPickBlock, this.ofKeyBindZoom, this.field_74323_J, this.keyBindSweetcraft};
        this.difficulty = 2;
        this.hideGUI = false;
        this.thirdPersonView = 0;
        this.showDebugInfo = false;
        this.field_74329_Q = false;
        this.lastServer = "";
        this.noclip = false;
        this.smoothCamera = false;
        this.debugCamEnable = false;
        this.noclipRate = 1.0F;
        this.debugCamRate = 1.0F;
        this.fovSetting = 0.0F;
        this.gammaSetting = 0.0F;
        this.guiScale = 0;
        this.particleSetting = 0;
        this.language = "en_US";
    }

    public String getKeyBindingDescription(int par1)
    {
        StringTranslate var2 = StringTranslate.getInstance();
        return var2.translateKey(this.keyBindings[par1].keyDescription);
    }

    /**
     * The string that appears inside the button/slider in the options menu.
     */
    public String getOptionDisplayString(int par1)
    {
        int var2 = this.keyBindings[par1].keyCode;
        return getKeyDisplayString(var2);
    }

    /**
     * Represents a key or mouse button as a string. Args: key
     */
    public static String getKeyDisplayString(int par0)
    {
        return par0 < 0 ? StatCollector.translateToLocalFormatted("key.mouseButton", new Object[] {Integer.valueOf(par0 + 101)}): Keyboard.getKeyName(par0);
    }

    /**
     * Sets a key binding.
     */
    public void setKeyBinding(int par1, int par2)
    {
        this.keyBindings[par1].keyCode = par2;
        this.saveOptions();
    }

    /**
     * If the specified option is controlled by a slider (float value), this will set the float value.
     */
    public void setOptionFloatValue(EnumOptions par1EnumOptions, float par2)
    {
        if (par1EnumOptions == EnumOptions.MUSIC)
        {
            this.musicVolume = par2;
            this.mc.sndManager.onSoundOptionsChanged();
        }

        if (par1EnumOptions == EnumOptions.SOUND)
        {
            this.soundVolume = par2;
            this.mc.sndManager.onSoundOptionsChanged();
        }

        if (par1EnumOptions == EnumOptions.SENSITIVITY)
        {
            this.mouseSensitivity = par2;
        }

        if (par1EnumOptions == EnumOptions.FOV)
        {
            this.fovSetting = par2;
        }

        if (par1EnumOptions == EnumOptions.GAMMA)
        {
            this.gammaSetting = par2;
        }

        if (par1EnumOptions == EnumOptions.CLOUD_HEIGHT)
        {
            this.ofCloudsHeight = par2;
        }

        if (par1EnumOptions == EnumOptions.AO_LEVEL)
        {
            this.ofAoLevel = par2;
            this.ambientOcclusion = this.ofAoLevel > 0.0F;
            this.mc.renderGlobal.loadRenderers();
        }

        if (par1EnumOptions == EnumOptions.RENDER_DISTANCE_FINE)
        {
            this.ofRenderDistanceFine = 32 + (int)(par2 * 480.0F);
            this.ofRenderDistanceFine = this.ofRenderDistanceFine >> 4 << 4;
            this.ofRenderDistanceFine = Config.limit(this.ofRenderDistanceFine, 32, 512);
            this.renderDistance = 3;

            if (this.ofRenderDistanceFine > 32)
            {
                this.renderDistance = 2;
            }

            if (this.ofRenderDistanceFine > 64)
            {
                this.renderDistance = 1;
            }

            if (this.ofRenderDistanceFine > 128)
            {
                this.renderDistance = 0;
            }

            this.mc.renderGlobal.loadRenderers();
        }

        if (par1EnumOptions == EnumOptions.CHAT_OPACITY)
        {
            this.chatOpacity = par2;
        }
    }

    private void updateWaterOpacity()
    {
        byte var1 = 3;

        if (this.ofClearWater)
        {
            var1 = 1;
        }

        Block.waterStill.setLightOpacity(var1);
        Block.waterMoving.setLightOpacity(var1);

        if (this.mc.theWorld != null)
        {
            IChunkProvider var2 = this.mc.theWorld.chunkProvider;

            if (var2 != null)
            {
                for (int var3 = -512; var3 < 512; ++var3)
                {
                    for (int var4 = -512; var4 < 512; ++var4)
                    {
                        if (var2.chunkExists(var3, var4))
                        {
                            Chunk var5 = var2.provideChunk(var3, var4);

                            if (var5 != null && !(var5 instanceof EmptyChunk))
                            {
                                ExtendedBlockStorage[] var6 = var5.getBlockStorageArray();

                                for (int var7 = 0; var7 < var6.length; ++var7)
                                {
                                    ExtendedBlockStorage var8 = var6[var7];

                                    if (var8 != null)
                                    {
                                        NibbleArray var9 = var8.getSkylightArray();

                                        if (var9 != null)
                                        {
                                            byte[] var10 = var9.data;

                                            for (int var11 = 0; var11 < var10.length; ++var11)
                                            {
                                                var10[var11] = 0;
                                            }
                                        }
                                    }
                                }

                                var5.generateSkylightMap();
                            }
                        }
                    }
                }

                this.mc.renderGlobal.loadRenderers();
            }
        }
    }

    public void setAllAnimations(boolean var1)
    {
        int var2 = var1 ? 0 : 2;
        this.ofAnimatedWater = var2;
        this.ofAnimatedLava = var2;
        this.ofAnimatedFire = var1;
        this.ofAnimatedPortal = var1;
        this.ofAnimatedRedstone = var1;
        this.ofAnimatedExplosion = var1;
        this.ofAnimatedFlame = var1;
        this.ofAnimatedSmoke = var1;
        this.ofVoidParticles = var1;
        this.ofWaterParticles = var1;
        this.ofRainSplash = var1;
        this.ofPortalParticles = var1;
        this.particleSetting = var1 ? 0 : 2;
        this.ofDrippingWaterLava = var1;
        this.ofAnimatedTerrain = var1;
        this.ofAnimatedItems = var1;
        this.ofAnimatedTextures = var1;
        this.mc.renderEngine.refreshTextures();
    }

    /**
     * For non-float options. Toggles the option on/off, or cycles through the list i.e. render distances.
     */
    public void setOptionValue(EnumOptions par1EnumOptions, int par2)
    {
        if (par1EnumOptions == EnumOptions.INVERT_MOUSE)
        {
            this.invertMouse = !this.invertMouse;
        }

        if (par1EnumOptions == EnumOptions.RENDER_DISTANCE)
        {
            this.renderDistance = this.renderDistance + par2 & 3;
            this.ofRenderDistanceFine = 32 << 3 - this.renderDistance;
        }

        if (par1EnumOptions == EnumOptions.GUI_SCALE)
        {
            this.guiScale = this.guiScale + par2 & 3;
        }

        if (par1EnumOptions == EnumOptions.PARTICLES)
        {
            this.particleSetting = (this.particleSetting + par2) % 3;
        }

        if (par1EnumOptions == EnumOptions.VIEW_BOBBING)
        {
            this.viewBobbing = !this.viewBobbing;
        }

        if (par1EnumOptions == EnumOptions.RENDER_CLOUDS)
        {
            this.clouds = !this.clouds;
        }
        
        if (par1EnumOptions == EnumOptions.SEE_GLOBAL)
        {
        	global = !global;
        }
        
        if (par1EnumOptions == EnumOptions.SEE_COMMERCE)
        {
        	commerce = !commerce;
        }
        
        if (par1EnumOptions == EnumOptions.SEE_LOCAL)
        {
        	local = !local;
        }
        
        if(par1EnumOptions == EnumOptions.TALK_GLOBAL){
        	talkGlobal = true;
        	talkCommerce = false;
        	talkLocal = false;
        }

        if(par1EnumOptions == EnumOptions.TALK_COMMERCE){
        	talkGlobal = false;
        	talkCommerce = true;
        	talkLocal = false;
        }

        if(par1EnumOptions == EnumOptions.TALK_LOCAL){
        	talkGlobal = false;
        	talkCommerce = false;
        	talkLocal = true;
        }
        if(par1EnumOptions == EnumOptions.HD_SKINS)
        {
        	hdSkins = !hdSkins;
        }

        if (par1EnumOptions == EnumOptions.ADVANCED_OPENGL)
        {
            if (!Config.isOcclusionAvailable())
            {
                this.ofOcclusionFancy = false;
                this.advancedOpengl = false;
            }
            else if (!this.advancedOpengl)
            {
                this.advancedOpengl = true;
                this.ofOcclusionFancy = false;
            }
            else if (!this.ofOcclusionFancy)
            {
                this.ofOcclusionFancy = true;
            }
            else
            {
                this.ofOcclusionFancy = false;
                this.advancedOpengl = false;
            }

            this.mc.renderGlobal.setAllRenderersVisible();
        }

        if (par1EnumOptions == EnumOptions.ANAGLYPH)
        {
            this.anaglyph = !this.anaglyph;
            this.mc.renderEngine.refreshTextures();
        }

        if (par1EnumOptions == EnumOptions.FRAMERATE_LIMIT)
        {
            this.limitFramerate = (this.limitFramerate + par2) % 4;
            Display.setVSyncEnabled(this.limitFramerate == 3);
        }

        if (par1EnumOptions == EnumOptions.DIFFICULTY)
        {
            this.difficulty = this.difficulty + par2 & 3;
        }

        if (par1EnumOptions == EnumOptions.GRAPHICS)
        {
            this.fancyGraphics = !this.fancyGraphics;
            this.mc.renderGlobal.loadRenderers();
        }

        if (par1EnumOptions == EnumOptions.AMBIENT_OCCLUSION)
        {
            this.ambientOcclusion = !this.ambientOcclusion;
            this.mc.renderGlobal.loadRenderers();
        }

        if (par1EnumOptions == EnumOptions.FOG_FANCY)
        {
            switch (this.ofFogType)
            {
                case 1:
                    this.ofFogType = 2;

                    if (!Config.isFancyFogAvailable())
                    {
                        this.ofFogType = 3;
                    }

                    break;

                case 2:
                    this.ofFogType = 3;
                    break;

                case 3:
                    this.ofFogType = 1;
                    break;

                default:
                    this.ofFogType = 1;
            }
        }

        if (par1EnumOptions == EnumOptions.FOG_START)
        {
            this.ofFogStart += 0.2F;

            if (this.ofFogStart > 0.81F)
            {
                this.ofFogStart = 0.2F;
            }
        }

        if (par1EnumOptions == EnumOptions.MIPMAP_LEVEL)
        {
            ++this.ofMipmapLevel;

            if (this.ofMipmapLevel > 4)
            {
                this.ofMipmapLevel = 0;
            }

            this.mc.renderEngine.refreshTextures();
        }

        if (par1EnumOptions == EnumOptions.MIPMAP_TYPE)
        {
            this.ofMipmapLinear = !this.ofMipmapLinear;
            this.mc.renderEngine.refreshTextures();
        }

        if (par1EnumOptions == EnumOptions.LOAD_FAR)
        {
            this.ofLoadFar = !this.ofLoadFar;
            this.mc.renderGlobal.loadRenderers();
        }

        if (par1EnumOptions == EnumOptions.PRELOADED_CHUNKS)
        {
            this.ofPreloadedChunks += 2;

            if (this.ofPreloadedChunks > 8)
            {
                this.ofPreloadedChunks = 0;
            }

            this.mc.renderGlobal.loadRenderers();
        }

        if (par1EnumOptions == EnumOptions.SMOOTH_FPS)
        {
            this.ofSmoothFps = !this.ofSmoothFps;
        }

        if (par1EnumOptions == EnumOptions.SMOOTH_INPUT)
        {
            this.ofSmoothInput = !this.ofSmoothInput;
        }

        if (par1EnumOptions == EnumOptions.CLOUDS)
        {
            ++this.ofClouds;

            if (this.ofClouds > 3)
            {
                this.ofClouds = 0;
            }
        }

        if (par1EnumOptions == EnumOptions.TREES)
        {
            ++this.ofTrees;

            if (this.ofTrees > 2)
            {
                this.ofTrees = 0;
            }

            this.mc.renderGlobal.loadRenderers();
        }

        if (par1EnumOptions == EnumOptions.GRASS)
        {
            ++this.ofGrass;

            if (this.ofGrass > 2)
            {
                this.ofGrass = 0;
            }

            RenderBlocks.fancyGrass = Config.isGrassFancy();
            this.mc.renderGlobal.loadRenderers();
        }

        if (par1EnumOptions == EnumOptions.RAIN)
        {
            ++this.ofRain;

            if (this.ofRain > 3)
            {
                this.ofRain = 0;
            }
        }

        if (par1EnumOptions == EnumOptions.WATER)
        {
            ++this.ofWater;

            if (this.ofWater > 2)
            {
                this.ofWater = 0;
            }
        }

        if (par1EnumOptions == EnumOptions.ANIMATED_WATER)
        {
            ++this.ofAnimatedWater;

            if (this.ofAnimatedWater > 2)
            {
                this.ofAnimatedWater = 0;
            }

            this.mc.renderEngine.refreshTextures();
        }

        if (par1EnumOptions == EnumOptions.ANIMATED_LAVA)
        {
            ++this.ofAnimatedLava;

            if (this.ofAnimatedLava > 2)
            {
                this.ofAnimatedLava = 0;
            }

            this.mc.renderEngine.refreshTextures();
        }

        if (par1EnumOptions == EnumOptions.ANIMATED_FIRE)
        {
            this.ofAnimatedFire = !this.ofAnimatedFire;
            this.mc.renderEngine.refreshTextures();
        }

        if (par1EnumOptions == EnumOptions.ANIMATED_PORTAL)
        {
            this.ofAnimatedPortal = !this.ofAnimatedPortal;
            this.mc.renderEngine.refreshTextures();
        }

        if (par1EnumOptions == EnumOptions.ANIMATED_REDSTONE)
        {
            this.ofAnimatedRedstone = !this.ofAnimatedRedstone;
        }

        if (par1EnumOptions == EnumOptions.ANIMATED_EXPLOSION)
        {
            this.ofAnimatedExplosion = !this.ofAnimatedExplosion;
        }

        if (par1EnumOptions == EnumOptions.ANIMATED_FLAME)
        {
            this.ofAnimatedFlame = !this.ofAnimatedFlame;
        }

        if (par1EnumOptions == EnumOptions.ANIMATED_SMOKE)
        {
            this.ofAnimatedSmoke = !this.ofAnimatedSmoke;
        }

        if (par1EnumOptions == EnumOptions.VOID_PARTICLES)
        {
            this.ofVoidParticles = !this.ofVoidParticles;
        }

        if (par1EnumOptions == EnumOptions.WATER_PARTICLES)
        {
            this.ofWaterParticles = !this.ofWaterParticles;
        }

        if (par1EnumOptions == EnumOptions.PORTAL_PARTICLES)
        {
            this.ofPortalParticles = !this.ofPortalParticles;
        }

        if (par1EnumOptions == EnumOptions.DRIPPING_WATER_LAVA)
        {
            this.ofDrippingWaterLava = !this.ofDrippingWaterLava;
        }

        if (par1EnumOptions == EnumOptions.ANIMATED_TERRAIN)
        {
            this.ofAnimatedTerrain = !this.ofAnimatedTerrain;
            this.mc.renderEngine.refreshTextures();
        }

        if (par1EnumOptions == EnumOptions.ANIMATED_TEXTURES)
        {
            this.ofAnimatedTextures = !this.ofAnimatedTextures;
        }

        if (par1EnumOptions == EnumOptions.ANIMATED_ITEMS)
        {
            this.ofAnimatedItems = !this.ofAnimatedItems;
            this.mc.renderEngine.refreshTextures();
        }

        if (par1EnumOptions == EnumOptions.RAIN_SPLASH)
        {
            this.ofRainSplash = !this.ofRainSplash;
        }

        if (par1EnumOptions == EnumOptions.FAST_DEBUG_INFO)
        {
            this.ofFastDebugInfo = !this.ofFastDebugInfo;
        }

        if (par1EnumOptions == EnumOptions.AUTOSAVE_TICKS)
        {
            this.ofAutoSaveTicks *= 10;

            if (this.ofAutoSaveTicks > 40000)
            {
                this.ofAutoSaveTicks = 40;
            }
        }

        if (par1EnumOptions == EnumOptions.BETTER_GRASS)
        {
            ++this.ofBetterGrass;

            if (this.ofBetterGrass > 3)
            {
                this.ofBetterGrass = 1;
            }

            this.mc.renderGlobal.loadRenderers();
        }

        if (par1EnumOptions == EnumOptions.CONNECTED_TEXTURES)
        {
            ++this.ofConnectedTextures;

            if (this.ofConnectedTextures > 3)
            {
                this.ofConnectedTextures = 1;
            }

            this.mc.renderGlobal.loadRenderers();
        }

        if (par1EnumOptions == EnumOptions.WEATHER)
        {
            this.ofWeather = !this.ofWeather;
        }

        if (par1EnumOptions == EnumOptions.SKY)
        {
            this.ofSky = !this.ofSky;
        }

        if (par1EnumOptions == EnumOptions.STARS)
        {
            this.ofStars = !this.ofStars;
        }

        if (par1EnumOptions == EnumOptions.SUN_MOON)
        {
            this.ofSunMoon = !this.ofSunMoon;
        }

        if (par1EnumOptions == EnumOptions.CHUNK_UPDATES)
        {
            ++this.ofChunkUpdates;

            if (this.ofChunkUpdates > 5)
            {
                this.ofChunkUpdates = 1;
            }
        }

        if (par1EnumOptions == EnumOptions.CHUNK_UPDATES_DYNAMIC)
        {
            this.ofChunkUpdatesDynamic = !this.ofChunkUpdatesDynamic;
        }

        if (par1EnumOptions == EnumOptions.TIME)
        {
            ++this.ofTime;

            if (this.ofTime > 3)
            {
                this.ofTime = 0;
            }
        }

        if (par1EnumOptions == EnumOptions.CLEAR_WATER)
        {
            this.ofClearWater = !this.ofClearWater;
            this.updateWaterOpacity();
        }

        if (par1EnumOptions == EnumOptions.DEPTH_FOG)
        {
            this.ofDepthFog = !this.ofDepthFog;
        }

        if (par1EnumOptions == EnumOptions.PROFILER)
        {
            this.ofProfiler = !this.ofProfiler;
        }

        if (par1EnumOptions == EnumOptions.BETTER_SNOW)
        {
            this.ofBetterSnow = !this.ofBetterSnow;
            this.mc.renderGlobal.loadRenderers();
        }

        if (par1EnumOptions == EnumOptions.SWAMP_COLORS)
        {
            this.ofSwampColors = !this.ofSwampColors;
            this.mc.renderGlobal.loadRenderers();
        }

        if (par1EnumOptions == EnumOptions.RANDOM_MOBS)
        {
            this.ofRandomMobs = !this.ofRandomMobs;
            this.mc.renderEngine.refreshTextures();
        }

        if (par1EnumOptions == EnumOptions.SMOOTH_BIOMES)
        {
            this.ofSmoothBiomes = !this.ofSmoothBiomes;
            this.mc.renderGlobal.loadRenderers();
        }

        if (par1EnumOptions == EnumOptions.CUSTOM_FONTS)
        {
            this.ofCustomFonts = !this.ofCustomFonts;
            this.mc.renderEngine.refreshTextures();
        }

        if (par1EnumOptions == EnumOptions.CUSTOM_COLORS)
        {
            this.ofCustomColors = !this.ofCustomColors;
            this.mc.renderEngine.refreshTextures();
            this.mc.renderGlobal.loadRenderers();
        }

        if (par1EnumOptions == EnumOptions.SHOW_CAPES)
        {
            this.ofShowCapes = !this.ofShowCapes;
            this.mc.renderGlobal.updateCapes();
        }

        if (par1EnumOptions == EnumOptions.NATURAL_TEXTURES)
        {
            this.ofNaturalTextures = !this.ofNaturalTextures;
            this.mc.renderEngine.refreshTextures();
            this.mc.renderGlobal.loadRenderers();
        }

        if (par1EnumOptions == EnumOptions.FULLSCREEN_MODE)
        {
            List var3 = Arrays.asList(Config.getFullscreenModes());

            if (this.ofFullscreenMode.equals("Default"))
            {
                this.ofFullscreenMode = (String)var3.get(0);
            }
            else
            {
                int var4 = var3.indexOf(this.ofFullscreenMode);

                if (var4 < 0)
                {
                    this.ofFullscreenMode = "Default";
                }
                else
                {
                    ++var4;

                    if (var4 >= var3.size())
                    {
                        this.ofFullscreenMode = "Default";
                    }
                    else
                    {
                        this.ofFullscreenMode = (String)var3.get(var4);
                    }
                }
            }
        }

        if (par1EnumOptions == EnumOptions.CHAT_VISIBILITY)
        {
            this.chatVisibility = (this.chatVisibility + par2) % 3;
        }

        if (par1EnumOptions == EnumOptions.CHAT_COLOR)
        {
            this.chatColours = !this.chatColours;
        }

        if (par1EnumOptions == EnumOptions.CHAT_LINKS)
        {
            this.chatLinks = !this.chatLinks;
        }

        if (par1EnumOptions == EnumOptions.CHAT_LINKS_PROMPT)
        {
            this.chatLinksPrompt = !this.chatLinksPrompt;
        }

        if (par1EnumOptions == EnumOptions.USE_SERVER_TEXTURES)
        {
            this.serverTextures = !this.serverTextures;
        }

        if (par1EnumOptions == EnumOptions.SNOOPER_ENABLED)
        {
            this.snooperEnabled = !this.snooperEnabled;
        }

        if (par1EnumOptions == EnumOptions.USE_FULLSCREEN)
        {
            this.fullScreen = !this.fullScreen;

            if (this.mc.isFullScreen() != this.fullScreen)
            {
                this.mc.toggleFullscreen();
            }
        }

        if (par1EnumOptions == EnumOptions.ENABLE_VSYNC)
        {
            this.enableVsync = !this.enableVsync;
            Display.setVSyncEnabled(this.enableVsync);
        }

        this.saveOptions();
    }

    public float getOptionFloatValue(EnumOptions par1EnumOptions)
    {
        return par1EnumOptions == EnumOptions.FOV ? this.fovSetting : (par1EnumOptions == EnumOptions.GAMMA ? this.gammaSetting : (par1EnumOptions == EnumOptions.MUSIC ? this.musicVolume : (par1EnumOptions == EnumOptions.SOUND ? this.soundVolume : (par1EnumOptions == EnumOptions.SENSITIVITY ? this.mouseSensitivity : (par1EnumOptions == EnumOptions.CLOUD_HEIGHT ? this.ofCloudsHeight : (par1EnumOptions == EnumOptions.AO_LEVEL ? this.ofAoLevel : (par1EnumOptions == EnumOptions.RENDER_DISTANCE_FINE ? (float)(this.ofRenderDistanceFine - 32) / 480.0F : (par1EnumOptions == EnumOptions.CHAT_OPACITY ? this.chatOpacity : 0.0F))))))));
    }

    public boolean getOptionOrdinalValue(EnumOptions par1EnumOptions)
    {
        switch (EnumOptionsHelper.enumOptionsMappingHelperArray[par1EnumOptions.ordinal()])
        {
            case 1:
                return this.invertMouse;

            case 2:
                return this.viewBobbing;

            case 3:
                return this.anaglyph;

            case 4:
                return this.advancedOpengl;

            case 5:
                return this.ambientOcclusion;

            case 6:
                return this.clouds;

            case 7:
                return this.chatColours;

            case 8:
                return this.chatLinks;

            case 9:
                return this.chatLinksPrompt;

            case 10:
                return this.serverTextures;

            case 11:
                return this.snooperEnabled;

            case 12:
                return this.fullScreen;

            case 13:
                return this.enableVsync;
                
            case 14:
            	return global;
            	
            case 15:
            	return commerce;
            	
            case 16:
            	return local;
            	
            case 17:
            	return talkGlobal;
            	
            case 18:
            	return talkCommerce;
            
            case 19:
            	return talkLocal;
            
            case 20:
            	return hdSkins;

            default:
                return false;
        }
    }

    private static String func_74299_a(String[] par0ArrayOfStr, int par1)
    {
        if (par1 < 0 || par1 >= par0ArrayOfStr.length)
        {
            par1 = 0;
        }

        StringTranslate var2 = StringTranslate.getInstance();
        return var2.translateKey(par0ArrayOfStr[par1]);
    }

    /**
     * Gets a key binding.
     */
    public String getKeyBinding(EnumOptions par1EnumOptions)
    {
        StringTranslate var2 = StringTranslate.getInstance();
        String var3 = var2.translateKey(par1EnumOptions.getEnumString());

        if (var3 == null)
        {
            var3 = par1EnumOptions.getEnumString();
        }

        String var4 = var3 + ": ";

        if (par1EnumOptions.getEnumFloat())
        {
            float var9 = this.getOptionFloatValue(par1EnumOptions);

            if (par1EnumOptions == EnumOptions.SENSITIVITY)
            {
                return var9 == 0.0F ? var4 + var2.translateKey("options.sensitivity.min") : (var9 == 1.0F ? var4 + var2.translateKey("options.sensitivity.max") : var4 + (int)(var9 * 200.0F) + "%");
            }
            else if (par1EnumOptions == EnumOptions.FOV)
            {
                return var9 == 0.0F ? var4 + var2.translateKey("options.fov.min") : (var9 == 1.0F ? var4 + var2.translateKey("options.fov.max") : var4 + (int)(70.0F + var9 * 40.0F));
            }
            else if (par1EnumOptions == EnumOptions.GAMMA)
            {
                return var9 == 0.0F ? var4 + var2.translateKey("options.gamma.min") : (var9 == 1.0F ? var4 + var2.translateKey("options.gamma.max") : var4 + "+" + (int)(var9 * 100.0F) + "%");
            }
            else if (par1EnumOptions == EnumOptions.RENDER_DISTANCE_FINE)
            {
                String var6 = "Tiny";
                short var7 = 32;

                if (this.ofRenderDistanceFine >= 64)
                {
                    var6 = "Short";
                    var7 = 64;
                }

                if (this.ofRenderDistanceFine >= 128)
                {
                    var6 = "Normal";
                    var7 = 128;
                }

                if (this.ofRenderDistanceFine >= 256)
                {
                    var6 = "Far";
                    var7 = 256;
                }

                if (this.ofRenderDistanceFine >= 512)
                {
                    var6 = "Extreme";
                    var7 = 512;
                }

                int var8 = this.ofRenderDistanceFine - var7;
                return var8 == 0 ? var4 + var6 : var4 + var6 + " +" + var8;
            }
            else
            {
                return par1EnumOptions == EnumOptions.CHAT_OPACITY ? var4 + (int)(var9 * 90.0F + 10.0F) + "%" : (var9 == 0.0F ? var4 + var2.translateKey("options.off") : var4 + (int)(var9 * 100.0F) + "%");
            }
        }
        else if (par1EnumOptions == EnumOptions.ADVANCED_OPENGL)
        {
            return !this.advancedOpengl ? var4 + "OFF" : (this.ofOcclusionFancy ? var4 + "Fancy" : var4 + "Fast");
        }
        else if (par1EnumOptions.getEnumBoolean())
        {
            boolean var5 = this.getOptionOrdinalValue(par1EnumOptions);
            return var5 ? var4 + var2.translateKey("options.on") : var4 + var2.translateKey("options.off");
        }
        else if (par1EnumOptions == EnumOptions.RENDER_DISTANCE)
        {
            return var4 + func_74299_a(RENDER_DISTANCES, this.renderDistance);
        }
        else if (par1EnumOptions == EnumOptions.DIFFICULTY)
        {
            return var4 + func_74299_a(DIFFICULTIES, this.difficulty);
        }
        else if (par1EnumOptions == EnumOptions.GUI_SCALE)
        {
            return var4 + func_74299_a(GUISCALES, this.guiScale);
        }
        else if (par1EnumOptions == EnumOptions.CHAT_VISIBILITY)
        {
            return var4 + func_74299_a(field_74369_af, this.chatVisibility);
        }
        else if (par1EnumOptions == EnumOptions.PARTICLES)
        {
            return var4 + func_74299_a(PARTICLES, this.particleSetting);
        }
        else if (par1EnumOptions == EnumOptions.FRAMERATE_LIMIT)
        {
            return this.limitFramerate == 3 ? var4 + "VSync" : var4 + func_74299_a(LIMIT_FRAMERATES, this.limitFramerate);
        }
        else if (par1EnumOptions == EnumOptions.FOG_FANCY)
        {
            switch (this.ofFogType)
            {
                case 1:
                    return var4 + "Fast";

                case 2:
                    return var4 + "Fancy";

                case 3:
                    return var4 + "OFF";

                default:
                    return var4 + "OFF";
            }
        }
        else if (par1EnumOptions == EnumOptions.FOG_START)
        {
            return var4 + this.ofFogStart;
        }
        else if (par1EnumOptions == EnumOptions.MIPMAP_LEVEL)
        {
            return this.ofMipmapLevel == 0 ? var4 + "OFF" : (this.ofMipmapLevel == 4 ? var4 + "Max" : var4 + this.ofMipmapLevel);
        }
        else if (par1EnumOptions == EnumOptions.MIPMAP_TYPE)
        {
            return this.ofMipmapLinear ? var4 + "Linear" : var4 + "Nearest";
        }
        else if (par1EnumOptions == EnumOptions.LOAD_FAR)
        {
            return this.ofLoadFar ? var4 + "ON" : var4 + "OFF";
        }
        else if (par1EnumOptions == EnumOptions.PRELOADED_CHUNKS)
        {
            return this.ofPreloadedChunks == 0 ? var4 + "OFF" : var4 + this.ofPreloadedChunks;
        }
        else if (par1EnumOptions == EnumOptions.SMOOTH_FPS)
        {
            return this.ofSmoothFps ? var4 + "ON" : var4 + "OFF";
        }
        else if (par1EnumOptions == EnumOptions.SMOOTH_INPUT)
        {
            return this.ofSmoothInput ? var4 + "ON" : var4 + "OFF";
        }
        else if (par1EnumOptions == EnumOptions.CLOUDS)
        {
            switch (this.ofClouds)
            {
                case 1:
                    return var4 + "Fast";

                case 2:
                    return var4 + "Fancy";

                case 3:
                    return var4 + "OFF";

                default:
                    return var4 + "Default";
            }
        }
        else if (par1EnumOptions == EnumOptions.TREES)
        {
            switch (this.ofTrees)
            {
                case 1:
                    return var4 + "Fast";

                case 2:
                    return var4 + "Fancy";

                default:
                    return var4 + "Default";
            }
        }
        else if (par1EnumOptions == EnumOptions.GRASS)
        {
            switch (this.ofGrass)
            {
                case 1:
                    return var4 + "Fast";

                case 2:
                    return var4 + "Fancy";

                default:
                    return var4 + "Default";
            }
        }
        else if (par1EnumOptions == EnumOptions.RAIN)
        {
            switch (this.ofRain)
            {
                case 1:
                    return var4 + "Fast";

                case 2:
                    return var4 + "Fancy";

                case 3:
                    return var4 + "OFF";

                default:
                    return var4 + "Default";
            }
        }
        else if (par1EnumOptions == EnumOptions.WATER)
        {
            switch (this.ofWater)
            {
                case 1:
                    return var4 + "Fast";

                case 2:
                    return var4 + "Fancy";

                case 3:
                    return var4 + "OFF";

                default:
                    return var4 + "Default";
            }
        }
        else if (par1EnumOptions == EnumOptions.ANIMATED_WATER)
        {
            switch (this.ofAnimatedWater)
            {
                case 1:
                    return var4 + "Dynamic";

                case 2:
                    return var4 + "OFF";

                default:
                    return var4 + "ON";
            }
        }
        else if (par1EnumOptions == EnumOptions.ANIMATED_LAVA)
        {
            switch (this.ofAnimatedLava)
            {
                case 1:
                    return var4 + "Dynamic";

                case 2:
                    return var4 + "OFF";

                default:
                    return var4 + "ON";
            }
        }
        else if (par1EnumOptions == EnumOptions.ANIMATED_FIRE)
        {
            return this.ofAnimatedFire ? var4 + "ON" : var4 + "OFF";
        }
        else if (par1EnumOptions == EnumOptions.ANIMATED_PORTAL)
        {
            return this.ofAnimatedPortal ? var4 + "ON" : var4 + "OFF";
        }
        else if (par1EnumOptions == EnumOptions.ANIMATED_REDSTONE)
        {
            return this.ofAnimatedRedstone ? var4 + "ON" : var4 + "OFF";
        }
        else if (par1EnumOptions == EnumOptions.ANIMATED_EXPLOSION)
        {
            return this.ofAnimatedExplosion ? var4 + "ON" : var4 + "OFF";
        }
        else if (par1EnumOptions == EnumOptions.ANIMATED_FLAME)
        {
            return this.ofAnimatedFlame ? var4 + "ON" : var4 + "OFF";
        }
        else if (par1EnumOptions == EnumOptions.ANIMATED_SMOKE)
        {
            return this.ofAnimatedSmoke ? var4 + "ON" : var4 + "OFF";
        }
        else if (par1EnumOptions == EnumOptions.VOID_PARTICLES)
        {
            return this.ofVoidParticles ? var4 + "ON" : var4 + "OFF";
        }
        else if (par1EnumOptions == EnumOptions.WATER_PARTICLES)
        {
            return this.ofWaterParticles ? var4 + "ON" : var4 + "OFF";
        }
        else if (par1EnumOptions == EnumOptions.PORTAL_PARTICLES)
        {
            return this.ofPortalParticles ? var4 + "ON" : var4 + "OFF";
        }
        else if (par1EnumOptions == EnumOptions.DRIPPING_WATER_LAVA)
        {
            return this.ofDrippingWaterLava ? var4 + "ON" : var4 + "OFF";
        }
        else if (par1EnumOptions == EnumOptions.ANIMATED_TERRAIN)
        {
            return this.ofAnimatedTerrain ? var4 + "ON" : var4 + "OFF";
        }
        else if (par1EnumOptions == EnumOptions.ANIMATED_TEXTURES)
        {
            return this.ofAnimatedTextures ? var4 + "ON" : var4 + "OFF";
        }
        else if (par1EnumOptions == EnumOptions.ANIMATED_ITEMS)
        {
            return this.ofAnimatedItems ? var4 + "ON" : var4 + "OFF";
        }
        else if (par1EnumOptions == EnumOptions.RAIN_SPLASH)
        {
            return this.ofRainSplash ? var4 + "ON" : var4 + "OFF";
        }
        else if (par1EnumOptions == EnumOptions.FAST_DEBUG_INFO)
        {
            return this.ofFastDebugInfo ? var4 + "ON" : var4 + "OFF";
        }
        else if (par1EnumOptions == EnumOptions.AUTOSAVE_TICKS)
        {
            return this.ofAutoSaveTicks <= 40 ? var4 + "Default (2s)" : (this.ofAutoSaveTicks <= 400 ? var4 + "20s" : (this.ofAutoSaveTicks <= 4000 ? var4 + "3min" : var4 + "30min"));
        }
        else if (par1EnumOptions == EnumOptions.BETTER_GRASS)
        {
            switch (this.ofBetterGrass)
            {
                case 1:
                    return var4 + "Fast";

                case 2:
                    return var4 + "Fancy";

                default:
                    return var4 + "OFF";
            }
        }
        else if (par1EnumOptions == EnumOptions.CONNECTED_TEXTURES)
        {
            switch (this.ofConnectedTextures)
            {
                case 1:
                    return var4 + "Fast";

                case 2:
                    return var4 + "Fancy";

                default:
                    return var4 + "OFF";
            }
        }
        else
        {
            return par1EnumOptions == EnumOptions.WEATHER ? (this.ofWeather ? var4 + "ON" : var4 + "OFF") : (par1EnumOptions == EnumOptions.SKY ? (this.ofSky ? var4 + "ON" : var4 + "OFF") : (par1EnumOptions == EnumOptions.STARS ? (this.ofStars ? var4 + "ON" : var4 + "OFF") : (par1EnumOptions == EnumOptions.SUN_MOON ? (this.ofSunMoon ? var4 + "ON" : var4 + "OFF") : (par1EnumOptions == EnumOptions.CHUNK_UPDATES ? var4 + this.ofChunkUpdates : (par1EnumOptions == EnumOptions.CHUNK_UPDATES_DYNAMIC ? (this.ofChunkUpdatesDynamic ? var4 + "ON" : var4 + "OFF") : (par1EnumOptions == EnumOptions.TIME ? (this.ofTime == 1 ? var4 + "Day Only" : (this.ofTime == 3 ? var4 + "Night Only" : var4 + "Default")) : (par1EnumOptions == EnumOptions.CLEAR_WATER ? (this.ofClearWater ? var4 + "ON" : var4 + "OFF") : (par1EnumOptions == EnumOptions.DEPTH_FOG ? (this.ofDepthFog ? var4 + "ON" : var4 + "OFF") : (par1EnumOptions == EnumOptions.PROFILER ? (this.ofProfiler ? var4 + "ON" : var4 + "OFF") : (par1EnumOptions == EnumOptions.BETTER_SNOW ? (this.ofBetterSnow ? var4 + "ON" : var4 + "OFF") : (par1EnumOptions == EnumOptions.SWAMP_COLORS ? (this.ofSwampColors ? var4 + "ON" : var4 + "OFF") : (par1EnumOptions == EnumOptions.RANDOM_MOBS ? (this.ofRandomMobs ? var4 + "ON" : var4 + "OFF") : (par1EnumOptions == EnumOptions.SMOOTH_BIOMES ? (this.ofSmoothBiomes ? var4 + "ON" : var4 + "OFF") : (par1EnumOptions == EnumOptions.CUSTOM_FONTS ? (this.ofCustomFonts ? var4 + "ON" : var4 + "OFF") : (par1EnumOptions == EnumOptions.CUSTOM_COLORS ? (this.ofCustomColors ? var4 + "ON" : var4 + "OFF") : (par1EnumOptions == EnumOptions.SHOW_CAPES ? (this.ofShowCapes ? var4 + "ON" : var4 + "OFF") : (par1EnumOptions == EnumOptions.NATURAL_TEXTURES ? (this.ofNaturalTextures ? var4 + "ON" : var4 + "OFF") : (par1EnumOptions == EnumOptions.FULLSCREEN_MODE ? var4 + this.ofFullscreenMode : (par1EnumOptions == EnumOptions.GRAPHICS ? (this.fancyGraphics ? var4 + var2.translateKey("options.graphics.fancy") : var4 + var2.translateKey("options.graphics.fast")) : var4)))))))))))))))))));
        }
    }

    /**
     * Loads the options from the options file. It appears that this has replaced the previous 'loadOptions'
     */
    public void loadOptions()
    {
        try
        {
            if (!this.optionsFile.exists())
            {
                return;
            }

            BufferedReader var1 = new BufferedReader(new FileReader(this.optionsFile));
            String var2 = "";

            while ((var2 = var1.readLine()) != null)
            {
                try
                {
                    String[] var3 = var2.split(":");

                    if (var3[0].equals("music"))
                    {
                        this.musicVolume = this.parseFloat(var3[1]);
                    }

                    if (var3[0].equals("sound"))
                    {
                        this.soundVolume = this.parseFloat(var3[1]);
                    }

                    if (var3[0].equals("mouseSensitivity"))
                    {
                        this.mouseSensitivity = this.parseFloat(var3[1]);
                    }

                    if (var3[0].equals("fov"))
                    {
                        this.fovSetting = this.parseFloat(var3[1]);
                    }

                    if (var3[0].equals("gamma"))
                    {
                        this.gammaSetting = this.parseFloat(var3[1]);
                    }

                    if (var3[0].equals("invertYMouse"))
                    {
                        this.invertMouse = var3[1].equals("true");
                    }

                    if (var3[0].equals("viewDistance"))
                    {
                        this.renderDistance = Integer.parseInt(var3[1]);
                        this.ofRenderDistanceFine = 32 << 3 - this.renderDistance;
                    }

                    if (var3[0].equals("guiScale"))
                    {
                        this.guiScale = Integer.parseInt(var3[1]);
                    }

                    if (var3[0].equals("particles"))
                    {
                        this.particleSetting = Integer.parseInt(var3[1]);
                    }

                    if (var3[0].equals("bobView"))
                    {
                        this.viewBobbing = var3[1].equals("true");
                    }

                    if (var3[0].equals("anaglyph3d"))
                    {
                        this.anaglyph = var3[1].equals("true");
                    }

                    if (var3[0].equals("advancedOpengl"))
                    {
                        this.advancedOpengl = var3[1].equals("true");
                    }

                    if (var3[0].equals("fpsLimit"))
                    {
                        this.limitFramerate = Integer.parseInt(var3[1]);
                        Display.setVSyncEnabled(this.limitFramerate == 3);
                    }

                    if (var3[0].equals("difficulty"))
                    {
                        this.difficulty = Integer.parseInt(var3[1]);
                    }

                    if (var3[0].equals("fancyGraphics"))
                    {
                        this.fancyGraphics = var3[1].equals("true");
                    }

                    if (var3[0].equals("ao"))
                    {
                        this.ambientOcclusion = var3[1].equals("true");

                        if (this.ambientOcclusion)
                        {
                            this.ofAoLevel = 1.0F;
                        }
                        else
                        {
                            this.ofAoLevel = 0.0F;
                        }
                    }

                    if (var3[0].equals("clouds"))
                    {
                        this.clouds = var3[1].equals("true");
                    }

                    if (var3[0].equals("skin"))
                    {
                        this.skin = var3[1];
                    }

                    if (var3[0].equals("lastServer") && var3.length >= 2)
                    {
                        this.lastServer = var3[1];
                    }

                    if (var3[0].equals("lang") && var3.length >= 2)
                    {
                        this.language = var3[1];
                    }

                    if (var3[0].equals("chatVisibility"))
                    {
                        this.chatVisibility = Integer.parseInt(var3[1]);
                    }

                    if (var3[0].equals("chatColors"))
                    {
                        this.chatColours = var3[1].equals("true");
                    }

                    if (var3[0].equals("chatLinks"))
                    {
                        this.chatLinks = var3[1].equals("true");
                    }

                    if (var3[0].equals("chatLinksPrompt"))
                    {
                        this.chatLinksPrompt = var3[1].equals("true");
                    }

                    if (var3[0].equals("chatOpacity"))
                    {
                        this.chatOpacity = this.parseFloat(var3[1]);
                    }

                    if (var3[0].equals("serverTextures"))
                    {
                        this.serverTextures = var3[1].equals("true");
                    }

                    if (var3[0].equals("snooperEnabled"))
                    {
                        this.snooperEnabled = var3[1].equals("true");
                    }

                    if (var3[0].equals("fullscreen"))
                    {
                        this.fullScreen = var3[1].equals("true");
                    }

                    if (var3[0].equals("enableVsync"))
                    {
                        this.enableVsync = var3[1].equals("true");
                    }

                    if (var3[0].equals("hideServerAddress"))
                    {
                        this.field_80005_w = var3[1].equals("true");
                    }

                    KeyBinding[] var4 = this.keyBindings;
                    int var5 = var4.length;

                    for (int var6 = 0; var6 < var5; ++var6)
                    {
                        KeyBinding var7 = var4[var6];

                        if (var3[0].equals("key_" + var7.keyDescription))
                        {
                            var7.keyCode = Integer.parseInt(var3[1]);
                        }
                    }
                }
                catch (Exception var10)
                {
                    System.out.println("Skipping bad option: " + var2);
                    var10.printStackTrace();
                }
            }

            KeyBinding.resetKeyBindingArrayAndHash();
            var1.close();
        }
        catch (Exception var11)
        {
            System.out.println("Failed to load options");
            var11.printStackTrace();
        }

        try
        {
            File var12 = this.optionsFileOF;

            if (!var12.exists())
            {
                var12 = this.optionsFile;
            }

            if (!var12.exists())
            {
                return;
            }

            BufferedReader var13 = new BufferedReader(new FileReader(var12));
            String var14 = "";

            while ((var14 = var13.readLine()) != null)
            {
                try
                {
                    String[] var15 = var14.split(":");

                    if (var15[0].equals("ofRenderDistanceFine") && var15.length >= 2)
                    {
                        this.ofRenderDistanceFine = Integer.valueOf(var15[1]).intValue();
                        this.ofRenderDistanceFine = Config.limit(this.ofRenderDistanceFine, 32, 512);
                    }

                    if (var15[0].equals("ofFogType") && var15.length >= 2)
                    {
                        this.ofFogType = Integer.valueOf(var15[1]).intValue();
                        this.ofFogType = Config.limit(this.ofFogType, 1, 3);
                    }

                    if (var15[0].equals("ofFogStart") && var15.length >= 2)
                    {
                        this.ofFogStart = Float.valueOf(var15[1]).floatValue();

                        if (this.ofFogStart < 0.2F)
                        {
                            this.ofFogStart = 0.2F;
                        }

                        if (this.ofFogStart > 0.81F)
                        {
                            this.ofFogStart = 0.8F;
                        }
                    }

                    if (var15[0].equals("ofMipmapLevel") && var15.length >= 2)
                    {
                        this.ofMipmapLevel = Integer.valueOf(var15[1]).intValue();

                        if (this.ofMipmapLevel < 0)
                        {
                            this.ofMipmapLevel = 0;
                        }

                        if (this.ofMipmapLevel > 4)
                        {
                            this.ofMipmapLevel = 4;
                        }
                    }

                    if (var15[0].equals("ofMipmapLinear") && var15.length >= 2)
                    {
                        this.ofMipmapLinear = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofLoadFar") && var15.length >= 2)
                    {
                        this.ofLoadFar = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofPreloadedChunks") && var15.length >= 2)
                    {
                        this.ofPreloadedChunks = Integer.valueOf(var15[1]).intValue();

                        if (this.ofPreloadedChunks < 0)
                        {
                            this.ofPreloadedChunks = 0;
                        }

                        if (this.ofPreloadedChunks > 8)
                        {
                            this.ofPreloadedChunks = 8;
                        }
                    }

                    if (var15[0].equals("ofOcclusionFancy") && var15.length >= 2)
                    {
                        this.ofOcclusionFancy = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofSmoothFps") && var15.length >= 2)
                    {
                        this.ofSmoothFps = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofSmoothInput") && var15.length >= 2)
                    {
                        this.ofSmoothInput = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofAoLevel") && var15.length >= 2)
                    {
                        this.ofAoLevel = Float.valueOf(var15[1]).floatValue();
                        this.ofAoLevel = Config.limit(this.ofAoLevel, 0.0F, 1.0F);
                        this.ambientOcclusion = this.ofAoLevel > 0.0F;
                    }

                    if (var15[0].equals("ofClouds") && var15.length >= 2)
                    {
                        this.ofClouds = Integer.valueOf(var15[1]).intValue();
                        this.ofClouds = Config.limit(this.ofClouds, 0, 3);
                    }

                    if (var15[0].equals("ofCloudsHeight") && var15.length >= 2)
                    {
                        this.ofCloudsHeight = Float.valueOf(var15[1]).floatValue();
                        this.ofCloudsHeight = Config.limit(this.ofCloudsHeight, 0.0F, 1.0F);
                    }

                    if (var15[0].equals("ofTrees") && var15.length >= 2)
                    {
                        this.ofTrees = Integer.valueOf(var15[1]).intValue();
                        this.ofTrees = Config.limit(this.ofTrees, 0, 2);
                    }

                    if (var15[0].equals("ofGrass") && var15.length >= 2)
                    {
                        this.ofGrass = Integer.valueOf(var15[1]).intValue();
                        this.ofGrass = Config.limit(this.ofGrass, 0, 2);
                    }

                    if (var15[0].equals("ofRain") && var15.length >= 2)
                    {
                        this.ofRain = Integer.valueOf(var15[1]).intValue();
                        this.ofRain = Config.limit(this.ofRain, 0, 3);
                    }

                    if (var15[0].equals("ofWater") && var15.length >= 2)
                    {
                        this.ofWater = Integer.valueOf(var15[1]).intValue();
                        this.ofWater = Config.limit(this.ofWater, 0, 3);
                    }

                    if (var15[0].equals("ofAnimatedWater") && var15.length >= 2)
                    {
                        this.ofAnimatedWater = Integer.valueOf(var15[1]).intValue();
                        this.ofAnimatedWater = Config.limit(this.ofAnimatedWater, 0, 2);
                    }

                    if (var15[0].equals("ofAnimatedLava") && var15.length >= 2)
                    {
                        this.ofAnimatedLava = Integer.valueOf(var15[1]).intValue();
                        this.ofAnimatedLava = Config.limit(this.ofAnimatedLava, 0, 2);
                    }

                    if (var15[0].equals("ofAnimatedFire") && var15.length >= 2)
                    {
                        this.ofAnimatedFire = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofAnimatedPortal") && var15.length >= 2)
                    {
                        this.ofAnimatedPortal = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofAnimatedRedstone") && var15.length >= 2)
                    {
                        this.ofAnimatedRedstone = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofAnimatedExplosion") && var15.length >= 2)
                    {
                        this.ofAnimatedExplosion = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofAnimatedFlame") && var15.length >= 2)
                    {
                        this.ofAnimatedFlame = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofAnimatedSmoke") && var15.length >= 2)
                    {
                        this.ofAnimatedSmoke = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofVoidParticles") && var15.length >= 2)
                    {
                        this.ofVoidParticles = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofWaterParticles") && var15.length >= 2)
                    {
                        this.ofWaterParticles = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofPortalParticles") && var15.length >= 2)
                    {
                        this.ofPortalParticles = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofDrippingWaterLava") && var15.length >= 2)
                    {
                        this.ofDrippingWaterLava = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofAnimatedTerrain") && var15.length >= 2)
                    {
                        this.ofAnimatedTerrain = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofAnimatedTextures") && var15.length >= 2)
                    {
                        this.ofAnimatedTextures = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofAnimatedItems") && var15.length >= 2)
                    {
                        this.ofAnimatedItems = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofRainSplash") && var15.length >= 2)
                    {
                        this.ofRainSplash = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofFastDebugInfo") && var15.length >= 2)
                    {
                        this.ofFastDebugInfo = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofAutoSaveTicks") && var15.length >= 2)
                    {
                        this.ofAutoSaveTicks = Integer.valueOf(var15[1]).intValue();
                        this.ofAutoSaveTicks = Config.limit(this.ofAutoSaveTicks, 40, 40000);
                    }

                    if (var15[0].equals("ofBetterGrass") && var15.length >= 2)
                    {
                        this.ofBetterGrass = Integer.valueOf(var15[1]).intValue();
                        this.ofBetterGrass = Config.limit(this.ofBetterGrass, 1, 3);
                    }

                    if (var15[0].equals("ofConnectedTextures") && var15.length >= 2)
                    {
                        this.ofConnectedTextures = Integer.valueOf(var15[1]).intValue();
                        this.ofConnectedTextures = Config.limit(this.ofConnectedTextures, 1, 3);
                    }

                    if (var15[0].equals("ofWeather") && var15.length >= 2)
                    {
                        this.ofWeather = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofSky") && var15.length >= 2)
                    {
                        this.ofSky = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofStars") && var15.length >= 2)
                    {
                        this.ofStars = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofSunMoon") && var15.length >= 2)
                    {
                        this.ofSunMoon = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofChunkUpdates") && var15.length >= 2)
                    {
                        this.ofChunkUpdates = Integer.valueOf(var15[1]).intValue();
                        this.ofChunkUpdates = Config.limit(this.ofChunkUpdates, 1, 5);
                    }

                    if (var15[0].equals("ofChunkUpdatesDynamic") && var15.length >= 2)
                    {
                        this.ofChunkUpdatesDynamic = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofTime") && var15.length >= 2)
                    {
                        this.ofTime = Integer.valueOf(var15[1]).intValue();
                        this.ofTime = Config.limit(this.ofTime, 0, 3);
                    }

                    if (var15[0].equals("ofClearWater") && var15.length >= 2)
                    {
                        this.ofClearWater = Boolean.valueOf(var15[1]).booleanValue();
                        this.updateWaterOpacity();
                    }

                    if (var15[0].equals("ofDepthFog") && var15.length >= 2)
                    {
                        this.ofDepthFog = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofProfiler") && var15.length >= 2)
                    {
                        this.ofProfiler = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofBetterSnow") && var15.length >= 2)
                    {
                        this.ofBetterSnow = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofSwampColors") && var15.length >= 2)
                    {
                        this.ofSwampColors = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofRandomMobs") && var15.length >= 2)
                    {
                        this.ofRandomMobs = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofSmoothBiomes") && var15.length >= 2)
                    {
                        this.ofSmoothBiomes = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofCustomFonts") && var15.length >= 2)
                    {
                        this.ofCustomFonts = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofCustomColors") && var15.length >= 2)
                    {
                        this.ofCustomColors = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofShowCapes") && var15.length >= 2)
                    {
                        this.ofShowCapes = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofNaturalTextures") && var15.length >= 2)
                    {
                        this.ofNaturalTextures = Boolean.valueOf(var15[1]).booleanValue();
                    }

                    if (var15[0].equals("ofFullscreenMode") && var15.length >= 2)
                    {
                        this.ofFullscreenMode = var15[1];
                    }
                }
                catch (Exception var8)
                {
                    System.out.println("Skipping bad option: " + var14);
                    var8.printStackTrace();
                }
            }

            KeyBinding.resetKeyBindingArrayAndHash();
            var13.close();
        }
        catch (Exception var9)
        {
            System.out.println("Failed to load options");
            var9.printStackTrace();
        }
    }

    /**
     * Parses a string into a float.
     */
    private float parseFloat(String par1Str)
    {
        return par1Str.equals("true") ? 1.0F : (par1Str.equals("false") ? 0.0F : Float.parseFloat(par1Str));
    }

    /**
     * Saves the options to the options file.
     */
    public void saveOptions()
    {
        PrintWriter var1;

        try
        {
            var1 = new PrintWriter(new FileWriter(this.optionsFile));
            var1.println("music:" + this.musicVolume);
            var1.println("sound:" + this.soundVolume);
            var1.println("invertYMouse:" + this.invertMouse);
            var1.println("mouseSensitivity:" + this.mouseSensitivity);
            var1.println("fov:" + this.fovSetting);
            var1.println("gamma:" + this.gammaSetting);
            var1.println("viewDistance:" + this.renderDistance);
            var1.println("guiScale:" + this.guiScale);
            var1.println("particles:" + this.particleSetting);
            var1.println("bobView:" + this.viewBobbing);
            var1.println("anaglyph3d:" + this.anaglyph);
            var1.println("advancedOpengl:" + this.advancedOpengl);
            var1.println("fpsLimit:" + this.limitFramerate);
            var1.println("difficulty:" + this.difficulty);
            var1.println("fancyGraphics:" + this.fancyGraphics);
            var1.println("ao:" + this.ambientOcclusion);
            var1.println("clouds:" + this.clouds);
            var1.println("skin:" + this.skin);
            var1.println("lastServer:" + this.lastServer);
            var1.println("lang:" + this.language);
            var1.println("chatVisibility:" + this.chatVisibility);
            var1.println("chatColors:" + this.chatColours);
            var1.println("chatLinks:" + this.chatLinks);
            var1.println("chatLinksPrompt:" + this.chatLinksPrompt);
            var1.println("chatOpacity:" + this.chatOpacity);
            var1.println("serverTextures:" + this.serverTextures);
            var1.println("snooperEnabled:" + this.snooperEnabled);
            var1.println("fullscreen:" + this.fullScreen);
            var1.println("enableVsync:" + this.enableVsync);
            var1.println("hideServerAddress:" + this.field_80005_w);
            KeyBinding[] var2 = this.keyBindings;
            int var3 = var2.length;

            for (int var4 = 0; var4 < var3; ++var4)
            {
                KeyBinding var5 = var2[var4];
                var1.println("key_" + var5.keyDescription + ":" + var5.keyCode);
            }

            var1.close();
        }
        catch (Exception var7)
        {
            System.out.println("Failed to save options");
            var7.printStackTrace();
        }

        try
        {
            var1 = new PrintWriter(new FileWriter(this.optionsFileOF));
            var1.println("ofRenderDistanceFine:" + this.ofRenderDistanceFine);
            var1.println("ofFogType:" + this.ofFogType);
            var1.println("ofFogStart:" + this.ofFogStart);
            var1.println("ofMipmapLevel:" + this.ofMipmapLevel);
            var1.println("ofMipmapLinear:" + this.ofMipmapLinear);
            var1.println("ofLoadFar:" + this.ofLoadFar);
            var1.println("ofPreloadedChunks:" + this.ofPreloadedChunks);
            var1.println("ofOcclusionFancy:" + this.ofOcclusionFancy);
            var1.println("ofSmoothFps:" + this.ofSmoothFps);
            var1.println("ofSmoothInput:" + this.ofSmoothInput);
            var1.println("ofAoLevel:" + this.ofAoLevel);
            var1.println("ofClouds:" + this.ofClouds);
            var1.println("ofCloudsHeight:" + this.ofCloudsHeight);
            var1.println("ofTrees:" + this.ofTrees);
            var1.println("ofGrass:" + this.ofGrass);
            var1.println("ofRain:" + this.ofRain);
            var1.println("ofWater:" + this.ofWater);
            var1.println("ofAnimatedWater:" + this.ofAnimatedWater);
            var1.println("ofAnimatedLava:" + this.ofAnimatedLava);
            var1.println("ofAnimatedFire:" + this.ofAnimatedFire);
            var1.println("ofAnimatedPortal:" + this.ofAnimatedPortal);
            var1.println("ofAnimatedRedstone:" + this.ofAnimatedRedstone);
            var1.println("ofAnimatedExplosion:" + this.ofAnimatedExplosion);
            var1.println("ofAnimatedFlame:" + this.ofAnimatedFlame);
            var1.println("ofAnimatedSmoke:" + this.ofAnimatedSmoke);
            var1.println("ofVoidParticles:" + this.ofVoidParticles);
            var1.println("ofWaterParticles:" + this.ofWaterParticles);
            var1.println("ofPortalParticles:" + this.ofPortalParticles);
            var1.println("ofDrippingWaterLava:" + this.ofDrippingWaterLava);
            var1.println("ofAnimatedTerrain:" + this.ofAnimatedTerrain);
            var1.println("ofAnimatedTextures:" + this.ofAnimatedTextures);
            var1.println("ofAnimatedItems:" + this.ofAnimatedItems);
            var1.println("ofRainSplash:" + this.ofRainSplash);
            var1.println("ofFastDebugInfo:" + this.ofFastDebugInfo);
            var1.println("ofAutoSaveTicks:" + this.ofAutoSaveTicks);
            var1.println("ofBetterGrass:" + this.ofBetterGrass);
            var1.println("ofConnectedTextures:" + this.ofConnectedTextures);
            var1.println("ofWeather:" + this.ofWeather);
            var1.println("ofSky:" + this.ofSky);
            var1.println("ofStars:" + this.ofStars);
            var1.println("ofSunMoon:" + this.ofSunMoon);
            var1.println("ofChunkUpdates:" + this.ofChunkUpdates);
            var1.println("ofChunkUpdatesDynamic:" + this.ofChunkUpdatesDynamic);
            var1.println("ofTime:" + this.ofTime);
            var1.println("ofClearWater:" + this.ofClearWater);
            var1.println("ofDepthFog:" + this.ofDepthFog);
            var1.println("ofProfiler:" + this.ofProfiler);
            var1.println("ofBetterSnow:" + this.ofBetterSnow);
            var1.println("ofSwampColors:" + this.ofSwampColors);
            var1.println("ofRandomMobs:" + this.ofRandomMobs);
            var1.println("ofSmoothBiomes:" + this.ofSmoothBiomes);
            var1.println("ofCustomFonts:" + this.ofCustomFonts);
            var1.println("ofCustomColors:" + this.ofCustomColors);
            var1.println("ofShowCapes:" + this.ofShowCapes);
            var1.println("ofNaturalTextures:" + this.ofNaturalTextures);
            var1.println("ofFullscreenMode:" + this.ofFullscreenMode);
            var1.println((new StringBuilder()).append("see_global:").append(global).toString());
            var1.println((new StringBuilder()).append("see_commerce:").append(commerce).toString());
            var1.println((new StringBuilder()).append("see_local:").append(local).toString());
            var1.println((new StringBuilder()).append("talk_global:").append(talkGlobal).toString());
            var1.println((new StringBuilder()).append("talk_commerce:").append(talkCommerce).toString());
            var1.println((new StringBuilder()).append("talk_local:").append(talkLocal).toString());
            var1.println((new StringBuilder()).append("hd_skins:").append(hdSkins).toString());
            var1.close();
        }
        catch (Exception var6)
        {
            System.out.println("Failed to save options");
            var6.printStackTrace();
        }

        if (this.mc.thePlayer != null)
        {
            this.mc.thePlayer.sendQueue.addToSendQueue(new Packet204ClientInfo(this.language, this.renderDistance, this.chatVisibility, this.chatColours, this.difficulty));
        }
    }

    public void resetSettings()
    {
        this.renderDistance = 1;
        this.viewBobbing = true;
        this.anaglyph = false;
        this.advancedOpengl = false;
        this.limitFramerate = 0;
        this.fancyGraphics = true;
        this.ambientOcclusion = true;
        this.clouds = true;
        this.fovSetting = 0.0F;
        this.gammaSetting = 0.0F;
        this.guiScale = 0;
        this.particleSetting = 0;
        this.ofRenderDistanceFine = 32 << 3 - this.renderDistance;
        this.ofFogType = 1;
        this.ofFogStart = 0.8F;
        this.ofMipmapLevel = 0;
        this.ofMipmapLinear = false;
        this.ofLoadFar = false;
        this.ofPreloadedChunks = 0;
        this.ofOcclusionFancy = false;
        this.ofSmoothFps = false;
        this.ofSmoothInput = true;

        if (this.ambientOcclusion)
        {
            this.ofAoLevel = 1.0F;
        }
        else
        {
            this.ofAoLevel = 0.0F;
        }

        this.ofClouds = 0;
        this.ofCloudsHeight = 0.0F;
        this.ofTrees = 0;
        this.ofGrass = 0;
        this.ofRain = 0;
        this.ofWater = 0;
        this.ofBetterGrass = 3;
        this.ofAutoSaveTicks = 4000;
        this.ofFastDebugInfo = false;
        this.ofWeather = true;
        this.ofSky = true;
        this.ofStars = true;
        this.ofSunMoon = true;
        this.ofChunkUpdates = 1;
        this.ofChunkUpdatesDynamic = false;
        this.ofTime = 0;
        this.ofClearWater = false;
        this.ofDepthFog = true;
        this.ofProfiler = false;
        this.ofBetterSnow = false;
        this.ofFullscreenMode = "Default";
        this.ofSwampColors = true;
        this.ofRandomMobs = true;
        this.ofSmoothBiomes = true;
        this.ofCustomFonts = true;
        this.ofCustomColors = true;
        this.ofShowCapes = true;
        this.ofConnectedTextures = 2;
        this.ofNaturalTextures = false;
        this.ofAnimatedWater = 0;
        this.ofAnimatedLava = 0;
        this.ofAnimatedFire = true;
        this.ofAnimatedPortal = true;
        this.ofAnimatedRedstone = true;
        this.ofAnimatedExplosion = true;
        this.ofAnimatedFlame = true;
        this.ofAnimatedSmoke = true;
        this.ofVoidParticles = true;
        this.ofWaterParticles = true;
        this.ofRainSplash = true;
        this.ofPortalParticles = true;
        this.ofDrippingWaterLava = true;
        this.ofAnimatedTerrain = true;
        this.ofAnimatedItems = true;
        this.ofAnimatedTextures = true;
        this.global = true;
        this.commerce = true;
        this.local = true;
        this.talkGlobal = true;
        this.talkCommerce = false;
        this.talkLocal = false;
        this.hdSkins = true;
        this.mc.renderGlobal.updateCapes();
        this.updateWaterOpacity();
        this.mc.renderGlobal.setAllRenderersVisible();
        this.mc.renderEngine.refreshTextures();
        this.mc.renderGlobal.loadRenderers();
        this.saveOptions();
    }

    /**
     * Should render clouds
     */
    public boolean shouldRenderClouds()
    {
        return this.ofRenderDistanceFine > 64 && this.clouds;
    }
}
