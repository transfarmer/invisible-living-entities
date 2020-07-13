package user11681.invisiblelivingentities.mixin.mixin;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.DolphinEntity;
import net.minecraft.entity.passive.DonkeyEntity;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.HorseEntity;
import net.minecraft.entity.passive.LlamaEntity;
import net.minecraft.entity.passive.OcelotEntity;
import net.minecraft.entity.passive.PandaEntity;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntityRenderer.class)
public abstract class LivingEntityRendererMixin<T extends LivingEntity, M extends EntityModel<T>> extends EntityRenderer<T> {
    private LivingEntityRendererMixin(final EntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void cancelRender(final T entity, final float yaw, final float tickDelta, final MatrixStack matrices, final VertexConsumerProvider vertexConsumerProvider, final int light, final CallbackInfo info) {
        if (entity instanceof ChickenEntity || entity instanceof PigEntity || entity instanceof CowEntity || entity instanceof SheepEntity
                || entity instanceof HorseEntity || entity instanceof BeeEntity || entity instanceof DonkeyEntity || entity instanceof LlamaEntity
                || entity instanceof PandaEntity || entity instanceof PolarBearEntity || entity instanceof WolfEntity || entity instanceof OcelotEntity
                || entity instanceof CatEntity || entity instanceof ParrotEntity || entity instanceof FishEntity || entity instanceof TurtleEntity
                || entity instanceof SquidEntity || entity instanceof DolphinEntity || entity instanceof PlayerEntity) {
            this.renderLabelIfPresent(entity, entity.getDisplayName(), matrices, vertexConsumerProvider, light);

            info.cancel();
        }
    }
}
