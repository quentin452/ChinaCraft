package unstudio.chinacraft.item;

import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemHangingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import unstudio.chinacraft.common.ChinaCraft;
import unstudio.chinacraft.entity.especial.EntityCCWord;

/**
 * Created by trychen on 17/1/19.
 */
public class CCItemWord extends ItemHangingEntity {
    public CCItemWord() {
        super(EntityCCWord.class);
        setCreativeTab(ChinaCraft.tabCore);
        setUnlocalizedName("chinese_character");
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        if (p_77648_7_ == 0) {
            return false;
        } else if (p_77648_7_ == 1) {
            return false;
        } else {
            int i1 = Direction.facingToDirection[p_77648_7_];
            EntityHanging entityhanging = this.createHangingEntity(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, i1);

            if (!p_77648_2_.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_)) {
                return false;
            } else {
                if (entityhanging != null && entityhanging.onValidSurface()) {
                    if (!p_77648_3_.isRemote) {
                        p_77648_3_.spawnEntityInWorld(entityhanging);
                    }
                    --p_77648_1_.stackSize;
                }
                return true;
            }
        }
    }

    /**
     * Create the hanging entity associated to this item.
     */
    private EntityHanging createHangingEntity(World p_82810_1_, int p_82810_2_, int p_82810_3_, int p_82810_4_, int p_82810_5_) {
        return new EntityCCWord(p_82810_1_, p_82810_2_, p_82810_3_, p_82810_4_, p_82810_5_);
    }
}
