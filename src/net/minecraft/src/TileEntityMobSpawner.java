package net.minecraft.src;

import java.util.Iterator;

public class TileEntityMobSpawner extends TileEntity
{
    /** The stored delay before a new spawn. */
    public int delay = -1;

    /**
     * The string ID of the mobs being spawned from this spawner. Defaults to pig, apparently.
     */
    private String mobID = "Pig";

    /** The extra NBT data to add to spawned entities */
    private NBTTagCompound spawnerTags = null;
    public double yaw;
    public double yaw2 = 0.0D;
    private int minSpawnDelay = 200;
    private int maxSpawnDelay = 800;
    private int spawnCount = 4;
    private Entity spawnedMob;

    public TileEntityMobSpawner()
    {
        this.delay = 20;
    }

    public String getMobID()
    {
        return this.mobID;
    }

    public void setMobID(String par1Str)
    {
        this.mobID = par1Str;
    }

    /**
     * Returns true if there is a player in range (using World.getClosestPlayer)
     */
    public boolean anyPlayerInRange()
    {
        return this.worldObj.getClosestPlayer((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D, 16.0D) != null;
    }

    /**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    public void updateEntity()
    {
        if (this.anyPlayerInRange())
        {
            if (this.worldObj.isRemote)
            {
                double var1 = (double)((float)this.xCoord + this.worldObj.rand.nextFloat());
                double var3 = (double)((float)this.yCoord + this.worldObj.rand.nextFloat());
                double var5 = (double)((float)this.zCoord + this.worldObj.rand.nextFloat());
                this.worldObj.spawnParticle("smoke", var1, var3, var5, 0.0D, 0.0D, 0.0D);
                this.worldObj.spawnParticle("flame", var1, var3, var5, 0.0D, 0.0D, 0.0D);
                this.yaw2 = this.yaw % 360.0D;
                this.yaw += 4.545454502105713D;
            }
            else
            {
                if (this.delay == -1)
                {
                    this.updateDelay();
                }

                if (this.delay > 0)
                {
                    --this.delay;
                    return;
                }

                for (int var11 = 0; var11 < this.spawnCount; ++var11)
                {
                    Entity var2 = EntityList.createEntityByName(this.mobID, this.worldObj);

                    if (var2 == null)
                    {
                        return;
                    }

                    int var12 = this.worldObj.getEntitiesWithinAABB(var2.getClass(), AxisAlignedBB.getAABBPool().addOrModifyAABBInPool((double)this.xCoord, (double)this.yCoord, (double)this.zCoord, (double)(this.xCoord + 1), (double)(this.yCoord + 1), (double)(this.zCoord + 1)).expand(8.0D, 4.0D, 8.0D)).size();

                    if (var12 >= 6)
                    {
                        this.updateDelay();
                        return;
                    }

                    if (var2 != null)
                    {
                        double var4 = (double)this.xCoord + (this.worldObj.rand.nextDouble() - this.worldObj.rand.nextDouble()) * 4.0D;
                        double var6 = (double)(this.yCoord + this.worldObj.rand.nextInt(3) - 1);
                        double var8 = (double)this.zCoord + (this.worldObj.rand.nextDouble() - this.worldObj.rand.nextDouble()) * 4.0D;
                        EntityLiving var10 = var2 instanceof EntityLiving ? (EntityLiving)var2 : null;
                        var2.setLocationAndAngles(var4, var6, var8, this.worldObj.rand.nextFloat() * 360.0F, 0.0F);

                        if (var10 == null || var10.getCanSpawnHere())
                        {
                            this.writeNBTTagsTo(var2);
                            this.worldObj.spawnEntityInWorld(var2);
                            this.worldObj.playAuxSFX(2004, this.xCoord, this.yCoord, this.zCoord, 0);

                            if (var10 != null)
                            {
                                var10.spawnExplosionParticle();
                            }

                            this.updateDelay();
                        }
                    }
                }
            }

            super.updateEntity();
        }
    }

    public void writeNBTTagsTo(Entity par1Entity)
    {
        if (this.spawnerTags != null)
        {
            NBTTagCompound var2 = new NBTTagCompound();
            par1Entity.addEntityID(var2);
            Iterator var3 = this.spawnerTags.getTags().iterator();

            while (var3.hasNext())
            {
                NBTBase var4 = (NBTBase)var3.next();
                var2.setTag(var4.getName(), var4.copy());
            }

            par1Entity.readFromNBT(var2);
        }
    }

    /**
     * Sets the delay before a new spawn (base delay of 200 + random number up to 600).
     */
    private void updateDelay()
    {
        this.delay = this.minSpawnDelay + this.worldObj.rand.nextInt(this.maxSpawnDelay - this.minSpawnDelay);
    }

    /**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        this.mobID = par1NBTTagCompound.getString("EntityId");
        this.delay = par1NBTTagCompound.getShort("Delay");

        if (par1NBTTagCompound.hasKey("SpawnData"))
        {
            this.spawnerTags = par1NBTTagCompound.getCompoundTag("SpawnData");
        }
        else
        {
            this.spawnerTags = null;
        }

        if (par1NBTTagCompound.hasKey("MinSpawnDelay"))
        {
            this.minSpawnDelay = par1NBTTagCompound.getShort("MinSpawnDelay");
            this.maxSpawnDelay = par1NBTTagCompound.getShort("MaxSpawnDelay");
            this.spawnCount = par1NBTTagCompound.getShort("SpawnCount");
        }
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setString("EntityId", this.mobID);
        par1NBTTagCompound.setShort("Delay", (short)this.delay);
        par1NBTTagCompound.setShort("MinSpawnDelay", (short)this.minSpawnDelay);
        par1NBTTagCompound.setShort("MaxSpawnDelay", (short)this.maxSpawnDelay);
        par1NBTTagCompound.setShort("SpawnCount", (short)this.spawnCount);

        if (this.spawnerTags != null)
        {
            par1NBTTagCompound.setCompoundTag("SpawnData", this.spawnerTags);
        }
    }

    /**
     * will create the entity from the internalID the first time it is accessed
     */
    public Entity getMobEntity()
    {
        if (this.spawnedMob == null)
        {
            Entity var1 = EntityList.createEntityByName(this.getMobID(), (World)null);
            this.writeNBTTagsTo(var1);
            this.spawnedMob = var1;
        }

        return this.spawnedMob;
    }

    /**
     * signs and mobSpawners use this to send text and meta-data
     */
    public Packet getAuxillaryInfoPacket()
    {
        NBTTagCompound var1 = new NBTTagCompound();
        this.writeToNBT(var1);
        return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, var1);
    }
}
