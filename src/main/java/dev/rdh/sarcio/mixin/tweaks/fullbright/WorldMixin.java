package dev.rdh.sarcio.mixin.tweaks.fullbright;

import dev.rdh.sarcio.SarcioMod;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(World.class)
public class WorldMixin {
    @Inject(method = "updateLight", at = @At("HEAD"), cancellable = true)
    private void sarcio$updateLight_fullbright(CallbackInfoReturnable<Boolean> cir) {
        if (sarcio$checkFullbright()) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = {
        "getBrightness(Lnet/minecraft/world/LightType;Lnet/minecraft/util/math/BlockPos;)I",
        "getRawBrightness(Lnet/minecraft/util/math/BlockPos;)I",
        "getRawBrightness(Lnet/minecraft/util/math/BlockPos;Z)I",
        "getActualLight", "findLight"
    }, at = @At("HEAD"), cancellable = true)
    private void sarcio$getLight_fullbright(CallbackInfoReturnable<Integer> cir) {
        if (sarcio$checkFullbright()) {
            cir.setReturnValue(15);
        }
    }

    @Unique
    private static boolean sarcio$checkFullbright() {
        return SarcioMod.isFullbright() && Minecraft.getInstance().isOnSameThread();
    }
}
