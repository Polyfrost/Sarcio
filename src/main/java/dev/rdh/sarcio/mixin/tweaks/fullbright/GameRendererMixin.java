package dev.rdh.sarcio.mixin.tweaks.fullbright;

import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Unique
    private boolean sarcio$createdLightmap;

    @Inject(method = "updateLightMap", at = @At("HEAD"), cancellable = true)
    private void sarcio$cancelLightmapBuild(CallbackInfo ci) {
        if (this.sarcio$createdLightmap) {
            ci.cancel();
        }
    }

    @Inject(method = "updateLightMap", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/profiler/Profiler;pop()V"))
    private void sarcio$setCreatedLightmap(CallbackInfo ci) {
        this.sarcio$createdLightmap = true;
    }
}
