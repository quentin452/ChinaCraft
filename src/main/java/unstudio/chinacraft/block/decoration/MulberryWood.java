package unstudio.chinacraft.block.decoration;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.StatCollector;

import unstudio.chinacraft.common.ChinaCraft;

public class MulberryWood extends Block {

    public MulberryWood() {
        super(Material.wood);
        setBlockName(StatCollector.translateToLocal("mulberry_wood"));
        setHardness(1.5F);
        setResistance(10.0F);
        setStepSound(soundTypeWood);
        setCreativeTab(ChinaCraft.tabCore);
    }

}
