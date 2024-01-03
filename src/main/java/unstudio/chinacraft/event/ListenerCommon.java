package unstudio.chinacraft.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.event.ClickEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.StatCollector;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import unstudio.chinacraft.common.ChinaCraft;
import unstudio.chinacraft.common.config.FeatureConfig;
import unstudio.chinacraft.util.FestivalHelper;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by trychen on 16/7/12.
 */
public class ListenerCommon {

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onSpring(GuiScreenEvent.InitGuiEvent event){
        if (event.gui instanceof GuiMainMenu){
            if (FestivalHelper.getFestival() != FestivalHelper.Festival.Spring) return;
            Field text;
            try {
                text = GuiMainMenu.class.getDeclaredField("field_73975_c");
            } catch (NoSuchFieldException e) {
                try {
                    text = GuiMainMenu.class.getDeclaredField("splashText");
                } catch (NoSuchFieldException e1) {
                    return;
                }
            }
            text.setAccessible(true);
            try {
                text.set(event.gui,StatCollector.translateToLocal("splashText.spring." + (new Random().nextInt(3) + 1)));
            } catch (IllegalAccessException e) {
            }
        }
    }
}
