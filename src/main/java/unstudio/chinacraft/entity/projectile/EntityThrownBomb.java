package unstudio.chinacraft.entity.projectile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityThrownBomb extends EntityThrowable {

    public EntityThrownBomb(World par1World) {
        super(par1World);
    }

    public EntityThrownBomb(World par2World, EntityPlayer par3EntityPlayer) {
        super(par2World, par3EntityPlayer);
    }

    @Override
    protected void entityInit() {}

    @Override
    public void onUpdate() {
        super.onUpdate();
        this.worldObj.spawnParticle(EnumParticleTypes.SPELL, this.posX, this.posY, this.posZ, 1.0D, 0.0D, 0.0D);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (!this.worldObj.isRemote) {

            this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 1.5F, true);
            setDead();
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {}

    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {}
}
