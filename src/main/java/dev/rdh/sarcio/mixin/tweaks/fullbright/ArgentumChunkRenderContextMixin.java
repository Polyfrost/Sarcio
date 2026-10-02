package dev.rdh.sarcio.mixin.tweaks.fullbright;

import dev.rdh.sarcio.SarcioMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Pseudo
@Mixin(targets = "dev.rdh.argentum.impl.world.cloned.ChunkRenderContext", remap = false)
public class ArgentumChunkRenderContextMixin {
    @Inject(method = "getBrightness", at = @At("HEAD"), cancellable = true)
    private void sarcio$fullbright(CallbackInfoReturnable<Integer> cir) {
        if (SarcioMod.isFullbright()) {
            cir.setReturnValue(15);
        }
    }
}
