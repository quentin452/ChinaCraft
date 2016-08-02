package unstudio.chinacraft.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import unstudio.chinacraft.client.model.block.ModelKongmingLantern;
import unstudio.chinacraft.client.model.entity.ModelBlackDog;
import unstudio.chinacraft.client.model.entity.ModelChinaZombie;
import unstudio.chinacraft.entity.animal.EntityBlackDog;
import unstudio.chinacraft.entity.especial.EntityKongmingLantern;
import unstudio.chinacraft.entity.mob.EntityChinaZombie;

public class EntityRenderingRegistry {


    /**
     * 开始注册渲染器
     */
    public static void init() {

        EntityRenderingHandler(EntityBlackDog.class, new ModelBlackDog(), "chinacraft",
                "textures/entity/blackwolf/blackwolf.png");
        EntityRenderingHandler(EntityChinaZombie.class, new ModelChinaZombie(), "chinacraft",
                "textures/entity/chinazombie/chinazombie.png");
        EntityRenderingHandler(EntityKongmingLantern.class, new ModelKongmingLantern(), "chinacraft",
                "textures/entity/kongminglantern/kongminglantern.png");
//        RenderingRegistry.registerEntityRenderingHandler(EntityThrownBomb.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), ChinaCraft.bomb, C));
//
//        RenderingRegistry.registerEntityRenderingHandler(EntityThrownFirecracker.class,
//                new RenderSnowball(ChinaCraft.firecracker));
    }

    /**
     * 注册实体的渲染器
     * @param entityClass 实体主类
     * @param modelBase 模型
     * @param resource 材质资源主类,"chinacraft"
     * @param location 材质地址,"textures/entity/example.png"
     */
    public static void EntityRenderingHandler(Class<? extends Entity> entityClass, ModelBase modelBase,
            final String resource, final String location) {
        RenderingRegistry.registerEntityRenderingHandler(entityClass, new RenderLiving(Minecraft.getMinecraft().getRenderManager(), modelBase, 0) {
            @Override
            protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
                return new ResourceLocation(resource, location);
            }
        });
    }
}
