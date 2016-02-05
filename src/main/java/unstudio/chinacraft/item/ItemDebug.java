package unstudio.chinacraft.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.util.StatCollector;
import unstudio.chinacraft.common.ChinaCraft;
import unstudio.chinacraft.tileentity.TileBuhrimill;
import unstudio.chinacraft.tileentity.TileSericultureFrame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemDebug extends Item{

	public ItemDebug() {
		setCreativeTab(ChinaCraft.tabCore);
		setUnlocalizedName("debug");
		setMaxStackSize(1);
	}
	
    @Override
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
    	if(world.isRemote) return false;
    	player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("debug.firstline")));
		player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("debug.blockinfo")+": "+ (StatCollector.canTranslate(world.getBlock(x, y, z).getUnlocalizedName()+".name")? StatCollector.translateToLocal(world.getBlock(x, y, z).getUnlocalizedName()+".name") : StatCollector.translateToLocal(world.getBlock(x, y, z).getUnlocalizedName()+".default.name") )+ " "+ Block.getIdFromBlock(world.getBlock(x, y, z))+" "+ world.getBlock(x, y, z).getUnlocalizedName().replace("tile.","")));
		player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("debug.position")+": "+x+"/"+y+"/"+z+" (X/Y/Z)"));
    	player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("debug.metadata")+": "+world.getBlockMetadata(x, y, z)));
//    	player.addChatMessage(new ChatComponentText(String.valueOf(player.inventory.currentItem)));
    	TileEntity tile = world.getTileEntity(x, y, z);
    	if(world.getTileEntity(x, y, z)!=null){
    	player.addChatMessage(new ChatComponentText("TileEntity:"+tile.getClass().getSimpleName()));
    	}
    	if(tile instanceof TileBuhrimill) {
    		
    	}else if(tile instanceof TileSericultureFrame) {
    		player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("debug.deathrate")+": "+((TileSericultureFrame)tile).getMortality()));
//    		player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("debug.progress")+": "+((TileSericultureFrame)tile).getSchedule()));
    	}
		return true;
    }

	@Override
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
		p_77624_3_.add(StatCollector.translateToLocal("item.debug.lore"));
	}
}