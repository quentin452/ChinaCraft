package unstudio.chinacraft.api;

import net.minecraft.entity.player.EntityPlayer;

/**
 * 提供给其他MOD的API的类
 */
public class ChinaCraftApi {

    /**
     * 判断是否穿着全套夜行衣
     * @param player 玩家
     * @return 是否穿着夜行衣
     */
    public static boolean isWearingWholeNightClothes(EntityPlayer player){
        return player.getEntityData().hasKey("chinacraft.wearingWholeNightClothes");
    }
}
