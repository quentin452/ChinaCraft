package unstudio.chinacraft.common.config;

import net.minecraftforge.common.config.Configuration;

import unstudio.chinacraft.common.ChinaCraft;

/**
 * Created by trych on 2016/1/9.
 */
public class FeatureConfig {

    public static boolean EnableUpdate;
    public static boolean EnableSanpShot;
    public static boolean ItemBombDestoryBlock;
    public static boolean ItemBombInRedPackerExplosion;
    public static boolean enableDoubleJump;
    public static boolean enableAdvancedSericulture;
    public static boolean enableShiftShootFirecrackers;
    public static int copperOreFrequency;
    public static int tinOreFrequency;
    public static int silverOreFrequency;
    public static int jadeOreFrequency;
    public static int marbleOreFrequency;

    private Configuration c = ChinaCraft.getMainConfig();

    public FeatureConfig() {
        EnableUpdate = c.getBoolean("EnableUpdate","Common",true,"If Open Auto Version Checker");
        EnableSanpShot = c.getBoolean("EnableSanpShot","Common",true,"If receive SanpShot Version");
        enableShiftShootFirecrackers = c.getBoolean("EnableShiftShootFirecrackers","Common",true,"If Player can shoot all firecrackers by Sneaking");
        ItemBombDestoryBlock = c.getBoolean("ItemBombDestoryBlock","Bomb",true,"Bomb Will Destory Block If True");
        ItemBombInRedPackerExplosion = c.getBoolean("ItemBombInRedPackerExplosion","Bomb",true,"While The Red Pakcer Witch Include a Bomb Was Opened , It Will Explose If True");
        enableDoubleJump = c.getBoolean("enableDoubleJump","Common",true,"If enable double jump of night clothes");
        enableAdvancedSericulture = c.getBoolean("EnableAdvancedSericulture", "Sericulture", true, "Set this to true will enable the advanced Sericulture, which means that the silkworms will have extra attributes, such like the productivity, speed and fertility. This is more complicated but is also more interesting to play with.");
        copperOreFrequency = c.get("ores", "CopperFrequency", 20).getInt();
        tinOreFrequency = c.get("ores", "TinFrequency", 10).getInt();
        silverOreFrequency = c.get("ores", "SilverFrequency", 4).getInt();
        jadeOreFrequency = c.get("ores", "JadeFrequency", 4).getInt();
        marbleOreFrequency = c.get("ores", "MarbleFrequency", 1).getInt();
    }
}
