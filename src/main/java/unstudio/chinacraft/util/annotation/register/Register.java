package unstudio.chinacraft.util.annotation.register;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import unstudio.chinacraft.common.Recipes;
import unstudio.chinacraft.item.ItemCCSlab;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by trychen on 16/7/9.
 */
public class Register {
    /**
     * 该方法用于对使用了CC注释注册系统的类进行注册,支持以下的注释
     * @see CCRegister
     * @see CCOreRegister
     * @see CCSlabRegister
     * @param c 类
     */
    public static void register(Class c) {
        for (Field f : c.getFields()) {
            if (f.getDeclaredAnnotations().length > 0) {
                Object o;
                try {
                    o = f.get(null);
                } catch (IllegalAccessException e) {
                    System.err.println("Can't register non-public field as a Block/Item");
                    e.printStackTrace();
                    continue;
                } catch (NullPointerException e) {
                    System.err.println("Can't register non-static field as a Block/Item");
                    e.printStackTrace();
                    continue;
                }
                if (f.isAnnotationPresent(CCRegister.class) || f.isAnnotationPresent(CCOreRegister.class)) {

                    String name = null;
                    String ore = null;
                    if (f.isAnnotationPresent(CCRegister.class)) {
                        name = f.getAnnotation(CCRegister.class).value();
                    } else if (f.isAnnotationPresent(CCOreRegister.class)) {
                        CCOreRegister ann = f.getAnnotation(CCOreRegister.class);
                        name = ann.name();
                        ore = ann.ore();
                    }

                    if (o instanceof Block) {
                        //以方块的形式注册
                        GameRegistry.registerBlock((Block) o, name);
                        if (ore != null) OreDictionary.registerOre(ore, (Block) o);
                    } else if (o instanceof Item) {
                        //以物品的形式注册
                        GameRegistry.registerItem((Item) o, name);
                        if (ore != null) OreDictionary.registerOre(ore, (Item) o);
                    } else {
                        //非可注册的物品
                        new IllegalArgumentException("Can't register field which haven't extended Block").printStackTrace();
                        continue;
                    }
                } else if (f.isAnnotationPresent(CCSlabRegister.class)) {
                    CCSlabRegister ann = f.getAnnotation(CCSlabRegister.class);
                    Block fi, se, on;
                    try {
                        fi = (Block) c.getField(ann.first()).get(null);
                        se = (Block) c.getField(ann.second()).get(null);
                        on = (Block) o;
                    } catch (Throwable e) {
                        System.err.println("Cann't register an nonexistent field.");
                        continue;
                    }
                    GameRegistry.registerBlock(on, ItemCCSlab.class, ann.name(), fi, se, true);
                }
            }
        }
    }

    /**
     * 该方法可以对拥有静态Public的recipes方法进行执行,使用以下接口即可自动执行
     * @see Recipes.RecipeAble
     * @param c 实现recipes方法的类
     */
    public static void recipes(Class c) {
        try {
            c.getMethod("recipes").invoke(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
