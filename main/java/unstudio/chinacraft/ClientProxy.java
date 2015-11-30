package unstudio.chinacraft;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;
import unstudio.chinacraft.block.model.ModelBuhrimill;
import unstudio.chinacraft.entity.EntityRenderingRegistry;
import unstudio.chinacraft.item.combat.models.ModelChinaCrown;
import unstudio.chinacraft.item.combat.models.ModelNightClothes;
import unstudio.chinacraft.nei.NEIAPI;
import unstudio.chinacraft.renderer.*;
import unstudio.chinacraft.tileentity.TileBuhrimill;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import unstudio.chinacraft.tileentity.TileSericultureFrame;

import java.util.HashMap;

public class ClientProxy extends CommonProxy {
    public static HashMap<Item,ModelBiped> arrmorModel = new HashMap<Item, ModelBiped>();

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        ChinaCraft.bronzeArmorTexture = RenderingRegistry.addNewArmourRendererPrefix("bronze"); //闈掗摐濂楄澶栭儴鏉愯川娉ㄥ唽

        super.preInit(event);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        if (ChinaCraft.NEIIsLoad) {
            new NEIAPI().loadConfig();
        }
        ModelChinaCrown modelChinaCrown;
        ModelNightClothes modelNightClothes;
        ModelNightClothes modelNightClothesleg;
        modelChinaCrown = new ModelChinaCrown(0.5f);
        ChinaCraft.chinaCrown.setArmorModel(modelChinaCrown);

        modelNightClothes = new ModelNightClothes(1F);
        modelNightClothesleg = new ModelNightClothes(0.5F);

        ChinaCraft.nightClothesHead.setArmorModel(modelNightClothes);
        ChinaCraft.nightClothesBody.setArmorModel(modelNightClothes);
        ChinaCraft.nightClothesLeg.setArmorModel(modelNightClothesleg);
        ChinaCraft.nightClothesShoe.setArmorModel(modelNightClothes);
        ClientRegistry.bindTileEntitySpecialRenderer(TileBuhrimill.class, new TileEntityBuhrimillRenderer());
        MinecraftForgeClient.registerItemRenderer(ChinaCraft.itemBuhrimill,new ModelBlockItemRenderer(new ModelBuhrimill(),new ResourceLocation("chinacraft:textures/models/block/buhrimill.png")));
        ClientRegistry.bindTileEntitySpecialRenderer(TileSericultureFrame.class, new TileEntitySericultureFrameRenderer());
        RenderingRegistry.registerBlockHandler(new BlockWoodenBucketRenderer());
//		ClientRegistry.bindTileEntitySpecialRenderer(TilePotteryBlock.class, new TileEntityPotteryBlockRenderer());
//		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ChinaCraft.blockPotteryBase), new ItemPotteryBlockRenderer(new TilePotteryBlock(), 0.0D, -0.1D, 0.0D));

        RenderingRegistry.registerBlockHandler(new BlockLanternRenderer());
        EntityRenderingRegistry.init();
        ChinaCraft.copperOre.setBlockTextureName("chinacraft:copper_ore");
        ChinaCraft.bronzeBlock.setBlockTextureName("chinacraft:bronze_block");
        ChinaCraft.tinOre.setBlockTextureName("chinacraft:tin_ore");
        ChinaCraft.jadeOre.setBlockTextureName("chinacraft:jade_ore");
        ChinaCraft.marble.setBlockTextureName("chinacraft:marble");
        ChinaCraft.smoothMarble.setBlockTextureName("chinacraft:smooth_marble");
        ChinaCraft.chiseledMarble.setBlockTextureName("chinacraft:chiseled_marble");
        ChinaCraft.marbleSlab.setBlockTextureName("chinacraft:smooth_marble");
        ChinaCraft.marbleDoubleSlab.setBlockTextureName("chinacraft:smooth_marble");
        ChinaCraft.silverOre.setBlockTextureName("chinacraft:silver_ore");
        ChinaCraft.blockBamboo.setBlockTextureName("chinacraft:bamboo");
        ChinaCraft.mulberrySapling.setBlockTextureName("chinacraft:mulberry_sapling");
        ChinaCraft.mulberryWood.setBlockTextureName("chinacraft:mulberry_wood");
        ChinaCraft.bambooBlock.setBlockTextureName("chinacraft:bamboo_block");
        ChinaCraft.jadeWorkingTable.setBlockTextureName("chinacraft:jade_table");
        ChinaCraft.bambooShoot.setBlockTextureName("chinacraft:bamboo_shoot");

        ChinaCraft.tinPowder.setTextureName("chinacraft:tin_powder");
        ChinaCraft.copperPowder.setTextureName("chinacraft:copper_powder");
        ChinaCraft.copperIngot.setTextureName("chinacraft:copper_ingot");
        ChinaCraft.bronzeIngot.setTextureName("chinacraft:bronze_ingot");
        ChinaCraft.copperTinMixedPowder.setTextureName("chinacraft:copper_tin_mixed_powder");
        ChinaCraft.bronzeSword.setTextureName("chinacraft:bronze_sword");
        ChinaCraft.bronzeBroadSword.setTextureName("chinacraft:bronze_bigsword");
        ChinaCraft.bronzeBroadSwordGreen.setTextureName("chinacraft:bronze_bigsword_green");
        ChinaCraft.bronzeBroadSwordGreen2.setTextureName("chinacraft:bronze_bigsword_green2");
        ChinaCraft.bronzeBroadSwordPink.setTextureName("chinacraft:bronze_bigsword_pink");
        ChinaCraft.bronzeBroadSwordPurple.setTextureName("chinacraft:bronze_bigsword_purple");
        ChinaCraft.yanLung_Giantknife.setTextureName("chinacraft:yanlung_giantknife");
        ChinaCraft.jiuqu_tang.setTextureName("chinacraft:jiuqu_tang");
        ChinaCraft.mace.setTextureName("chinacraft:mace");
        ChinaCraft.tinIngot.setTextureName("chinacraft:tin_ingot");
        ChinaCraft.silverIngot.setTextureName("chinacraft:silver_ingot");
        ChinaCraft.rices.setTextureName("chinacraft:barley_rice");
        ChinaCraft.soy.setTextureName("chinacraft:soy_item");
        ChinaCraft.lcker.setTextureName("chinacraft:lcker");
        ChinaCraft.soyPod.setTextureName("chinacraft:soy_pod");
        ChinaCraft.itemBuhrimill.setTextureName("chinacraft:item_buhrimill");
        ChinaCraft.bamboo.setTextureName("chinacraft:bamboo");
        ChinaCraft.itemMulberryLeaf.setTextureName("chinacraft:mulberry_leaf");
        ChinaCraft.woodenBucket.setTextureName("chinacraft:woodenbucket");
        ChinaCraft.woodenBucket_Water.setTextureName("chinacraft:woodenbucket_water");
        ChinaCraft.silkwormChrysalis.setTextureName("chinacraft:silkworm_chrysalis");
        ChinaCraft.redPacket.setTextureName("chinacraft:redpacket");
        ChinaCraft.firecracker.setTextureName("chinacraft:firecracker");
        ChinaCraft.bomb.setTextureName("chinacraft:bomb");
        ChinaCraft.blackDogBlood.setTextureName("chinacraft:blackdogblood");
        ChinaCraft.moonCake.setTextureName("chinacraft:mooncake");
        ChinaCraft.xinjiangNutCake.setBlockTextureName("chinacraft:xinjiang_nut_cake");
        ChinaCraft.appleCake.setBlockTextureName("chinacraft:apple_cake");
        ChinaCraft.itemAppleCake.setTextureName("chinacraft:apple_cake");
        //闈掗摐
        ChinaCraft.bronzePickaxe.setTextureName("chinacraft:bronze_pickaxe");
        ChinaCraft.bronzeAxe.setTextureName("chinacraft:bronze_axe");
        ChinaCraft.bronzeHoe.setTextureName("chinacraft:bronze_hoe");
        ChinaCraft.bronzeShovel.setTextureName("chinacraft:bronze_shovel");

        ChinaCraft.bronzeHelmet.setTextureName("chinacraft:bronze_helmet");
        ChinaCraft.bronzeChestplate.setTextureName("chinacraft:bronze_chestplate");
        ChinaCraft.bronzeLeggings.setTextureName("chinacraft:bronze_leggings");
        ChinaCraft.bronzeBoots.setTextureName("chinacraft:bronze_boots");
        ChinaCraft.hammerStone.setTextureName("chinacraft:hammer_stone");
        ChinaCraft.hammerIron.setTextureName("chinacraft:hammer_iron");
        ChinaCraft.hammerDiamond.setTextureName("chinacraft:hammer_diamond");
        ChinaCraft.hammerBronze.setTextureName("chinacraft:hammer_bronze");

        //鐜�
        ChinaCraft.jadeGreenItem.setTextureName("chinacraft:jade_green");
        ChinaCraft.jadeGreen2Item.setTextureName("chinacraft:jade_green2");
        ChinaCraft.jadePinkItem.setTextureName("chinacraft:jade_pink");
        ChinaCraft.jadePurpleItem.setTextureName("chinacraft:jade_purple");
        ChinaCraft.jadeKnife.setTextureName("chinacraft:jade_knife");
        ChinaCraft.artKnife.setTextureName("chinacraft:art_knife");

        //鑰愮伀鐮�
        ChinaCraft.blockFirebrick.setBlockTextureName("chinacraft:firebrick");
        ChinaCraft.firebrick.setTextureName("chinacraft:firebrick");
        ChinaCraft.blockPotteryKiln.setBlockTextureName("chinacraft:firebrick");
        ChinaCraft.claySandMixture.setTextureName("chinacraft:clay_sand_mixture");

        //楗搧銆侀鐗�
        ChinaCraft.cup.setTextureName("chinacraft:cup");
        ChinaCraft.cup_Clay.setTextureName("chinacraft:cup_clay");
        ChinaCraft.cupChocolate.setTextureName("chinacraft:cup_chocolate");
        ChinaCraft.cocoa.setTextureName("chinacraft:cocoa");
        ChinaCraft.ladyfinger.setTextureName("chinacraft:ladyfinger");
        ChinaCraft.cupWater.setTextureName("chinacraft:cup_water");
        ChinaCraft.cupChrysanthemum.setTextureName("chinacraft:cup_chrysanthemum");
        ChinaCraft.flour.setTextureName("chinacraft:flour");
        ChinaCraft.riceFlour.setTextureName("chinacraft:riceflour");
        ChinaCraft.barleyRice.setTextureName("chinacraft:barley_rice");

        //闈堢
        ChinaCraft.spiritualMagicFigures.setTextureName("chinacraft:spiritual_magic_figures");
        ChinaCraft.smfFire.setTextureName("chinacraft:spiritual_magic_figures_fire");
        ChinaCraft.smfNightVision.setTextureName("chinacraft:spiritual_magic_figures_night_vision");
        ChinaCraft.smfPoison.setTextureName("chinacraft:spiritual_magic_figures_poison");
        ChinaCraft.smfPower.setTextureName("chinacraft:spiritual_magic_figures_power");
        ChinaCraft.smfHeal.setTextureName("chinacraft:spiritual_magic_figures_heal");
        ChinaCraft.smfProtect.setTextureName("chinacraft:spiritual_magic_figures_protect");
        ChinaCraft.smfSuper.setTextureName("chinacraft:spiritual_magic_figures_super");
        ChinaCraft.debug.setTextureName("chinacraft:debug");

        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
}
