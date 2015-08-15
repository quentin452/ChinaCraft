package unstudio.chinacraft.util;

import com.sun.org.apache.bcel.internal.generic.NEW;

import unstudio.chinacraft.GuiID;
import unstudio.chinacraft.inventory.ContainerBuhrimill;
import unstudio.chinacraft.inventory.ContainerCooker;
import unstudio.chinacraft.inventory.ContainerJadeBench;
import unstudio.chinacraft.inventory.GuiBuhrimill;
import unstudio.chinacraft.inventory.GuiCooker;
import unstudio.chinacraft.inventory.GuiJadeBench;
import unstudio.chinacraft.tileentity.TileBuhrimill;
import unstudio.chinacraft.tileentity.TileCooker;
import unstudio.chinacraft.tileentity.TileJadeBench;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;


public class GuiHandler implements IGuiHandler{

        @Override
        public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
                switch(ID)
                {
                case GuiID.GUI_Buhrimill:
                        return new ContainerBuhrimill(player.inventory, (TileBuhrimill) world.getTileEntity(x, y, z));
                        
                case GuiID.GUI_JadeBench:
                		return new ContainerJadeBench(player.inventory, (TileJadeBench) world.getTileEntity(x, y, z));
                		
                case GuiID.GUI_Cooker:
                	    return new ContainerCooker(player.inventory, (TileCooker) world.getTileEntity(x, y, z));
                }
                return null;
        }

        @Override
        public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
                switch(ID)
                {
                case GuiID.GUI_Buhrimill:
                        return new GuiBuhrimill(player.inventory, (TileBuhrimill) world.getTileEntity(x, y, z));
                        
                case GuiID.GUI_JadeBench:
                		return new GuiJadeBench(player.inventory, (TileJadeBench) world.getTileEntity(x, y, z));	
                		
                case GuiID.GUI_Cooker:
            		return new GuiCooker(player.inventory, (TileCooker) world.getTileEntity(x, y, z));	
                }
                return null;
        }

}

