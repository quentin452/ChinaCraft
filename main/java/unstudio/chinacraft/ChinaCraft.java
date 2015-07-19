package unstudio.chinacraft;

import unstudio.chinacraft.block.CopperBlock;
import unstudio.chinacraft.block.CopperOre;
import unstudio.chinacraft.block.Marble;
import unstudio.chinacraft.block.TinOre;
import unstudio.chinacraft.combat.CopperAxe;
import unstudio.chinacraft.combat.CopperPickaxe;
import unstudio.chinacraft.combat.CopperSword;
import unstudio.chinacraft.item.CopperIngot;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = ChinaCraft.MODID, version = ChinaCraft.VERSION)
public class ChinaCraft {
	    public static final String MODID = "chinacraft";
	    public static final String VERSION = "0.0.1";
	 
	    @SidedProxy(clientSide = "unstudio.chinacraft.ClientProxy",
	            serverSide = "unstudio.chinacraft.CommonProxy")
	    public static CommonProxy proxy;
	 
	    @Instance("ChinaCraft")
	    public static ChinaCraft instance;
	 
	    @EventHandler
	    public void preInit(FMLPreInitializationEvent event) {
	        proxy.preInit(event);
	    }
	 
	    @EventHandler
	    public void init(FMLInitializationEvent event) {
	        proxy.init(event);
	    }
	 
	    @EventHandler
	    public void postInit(FMLPostInitializationEvent event) {
	        proxy.postInit(event);
	    }
	    
	    public static CreativeTabs tabCore = new CreativeTabs(StatCollector.translateToLocal("core")) {
	        @Override
	        @SideOnly(Side.CLIENT)
	        public Item getTabIconItem() {
	            return Item.getItemFromBlock(copperOre);
	        }
	    };
	    
	    //方块
	    public static CopperOre copperOre = new CopperOre();  //铜矿
	    public static CopperBlock copperBlock = new CopperBlock();  //铜矿
	    public static TinOre tinOre = new TinOre(); //锡矿
	    public static Marble marble = new Marble();  //大理石
	    
	    //物品
	    public static CopperIngot copperIngot = new CopperIngot();  //铜锭
	    
	    //防具武器
	    public static CopperSword copperSword = new CopperSword();  //铜剑
	    
	    //工具
	    public static CopperPickaxe copperPickaxe = new CopperPickaxe();//铜稿
	    public static CopperAxe copperAxe =  new CopperAxe();//铜斧
}
