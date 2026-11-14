package dev.rdh.sarcio.mixin.bugfix.gui;

import dev.rdh.sarcio.Feature;
import net.minecraft.client.resource.language.TranslationStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Before 1.13, a language whose strings were mostly non-ASCII turned the whole font into the
 * unicode sheet, so English text in Chinese or Japanese was drawn with the unifont as well.
 * 1.13 dropped that guess and left the choice to the "Force Unicode Font" option; this does the
 * same, which is also what Minecraft.isUnicode() ends up asking for. TextRenderer still picks the
 * default or the unicode glyphs per character, so mixed text keeps working.
 */
@Feature("bugfix.gui.forced_unicode_font")
@Mixin(TranslationStorage.class)
public class TranslationStorageMixin {
    @Inject(method = "isUnicode", at = @At("HEAD"), cancellable = true)
    private void sarcio$leaveFontChoiceToOption(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}
