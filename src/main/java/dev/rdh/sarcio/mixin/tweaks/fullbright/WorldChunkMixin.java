package dev.rdh.sarcio.mixin.tweaks.fullbright;

import dev.rdh.sarcio.SarcioMod;
import net.minecraft.world.chunk.WorldChunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WorldChunk.class)
public class WorldChunkMixin {
    @Inject(method = {
        "getLight(Lnet/minecraft/world/LightType;Lnet/minecraft/util/math/BlockPos;)I",
        "getLight(Lnet/minecraft/util/math/BlockPos;I)I"
    }, at = @At("HEAD"), cancellable = true)
    private void sarcio$fullbright(CallbackInfoReturnable<Integer> cir) {
        if (SarcioMod.isFullbright()) {
            cir.setReturnValue(15);
        }
    }
}
