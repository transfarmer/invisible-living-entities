package transfarmer.invisibleentities.event;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import transfarmer.invisibleentities.Main;
import transfarmer.invisibleentities.util.ReflectUtil;

import static transfarmer.invisibleentities.util.ReflectUtil.renderLivingLabel;

@EventBusSubscriber(modid = Main.MOD_ID)
public class EventListeners {
    @SubscribeEvent
    public static void onRenderLiving(final RenderLivingEvent.Pre<EntityLiving> event) {
        final EntityLivingBase entity = event.getEntity();

        if (cancelRender(entity)) {
            ReflectUtil.invoke(renderLivingLabel, event.getRenderer(), entity, entity.getDisplayName().getFormattedText(), event.getX(), event.getY(), event.getZ(), 64);

//            final Minecraft minecraft = Minecraft.getMinecraft();
//            if (!minecraft.debugRenderer.shouldRender()) {
//                final EntityPlayer player = minecraft.player;
//                final double partialTicks = minecraft.getRenderPartialTicks();
//                final double renderPosX = player.lastTickPosX + (player.posX - player.lastTickPosX) * partialTicks;
//                final double renderPosY = player.lastTickPosY + (player.posY - player.lastTickPosY) * partialTicks;
//                final double renderPosZ = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * partialTicks;
//
//                GlStateManager.enableBlend();
//                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
//                GlStateManager.glLineWidth(2F);
//                GlStateManager.disableTexture2D();
//                GlStateManager.depthMask(false);
//
//                RenderGlobal.drawSelectionBoundingBox(entity.getEntityBoundingBox().grow(0.002D).offset(-renderPosX, -renderPosY, -renderPosZ), 1F, 1F, 1F, 1F);
//
//                GlStateManager.depthMask(true);
//                GlStateManager.enableTexture2D();
//                GlStateManager.disableBlend();
//            }

            event.setCanceled(true);
        }
    }

    private static boolean cancelRender(final Entity entity) {
        return entity instanceof EntityLiving || entity instanceof EntityPlayer;
    }

    @SubscribeEvent
    public static void onRenderHand(final RenderHandEvent event) {
        final EntityPlayer player = Minecraft.getMinecraft().player;

        if (player.getHeldItemMainhand().isEmpty() || player.getHeldItemOffhand().isEmpty()) {
            event.setCanceled(true);
        }
    }
}
