package unstudio.chinacraft.common.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;
import unstudio.chinacraft.common.ChinaCraft;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class RedPacketMessageHandler implements IMessageHandler<RedPacketMessage, IMessage> { //包处理类
	@Override
	public IMessage onMessage(RedPacketMessage message, MessageContext ctx) {
		EntityPlayer player = ctx.getServerHandler().playerEntity;
		ItemStack itemstack1 = player.inventory.getCurrentItem();
        if (itemstack1 == null)
        {
            return null;
        }

        if (itemstack1.getItem() == ChinaCraft.redPacket && itemstack1.getItem() == itemstack1.getItem())
        {
            itemstack1.setTagInfo("Redpacket", message.itemstack.getTagCompound().getCompoundTag("Redpacket"));
        }
        
        
        return null; 
	}
	
	private EntityPlayer getPlayer(String name){
//        ServerConfigurationManager manager = MinecraftServer.getServer().getConfigurationManager();
//        EntityPlayer player = manager.func_152612_a(name);
		for(WorldServer world:MinecraftServer.getServer().worldServers){
			EntityPlayer player = world.getPlayerEntityByName(name);
			if(player!=null){
				return player;
			}
		}
		return null;
	}
}