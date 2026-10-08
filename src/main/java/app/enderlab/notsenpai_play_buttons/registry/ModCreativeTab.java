package app.enderlab.notsenpai_play_buttons.registry;

import app.enderlab.notsenpai_play_buttons.NotSenpaiPlayButtons;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public final class ModCreativeTab {

    public static final ResourceKey<CreativeModeTab> PLAY_BUTTONS =
            ResourceKey.create(Registries.CREATIVE_MODE_TAB, NotSenpaiPlayButtons.id("play_buttons"));

    private ModCreativeTab() {
    }

    public static void register() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, PLAY_BUTTONS,
                FabricItemGroup.builder()
                        .title(Component.translatable("itemGroup.notsenpai_play_buttons.play_buttons"))
                        .icon(() -> new ItemStack(ModItems.SILVER_PLAY_BUTTON))
                        .displayItems((parameters, output) -> {
                            output.accept(ModItems.SILVER_PLAY_BUTTON);
                            output.accept(ModItems.GOLD_PLAY_BUTTON);
                            output.accept(ModItems.DIAMOND_PLAY_BUTTON);
                            output.accept(ModItems.RUBY_PLAY_BUTTON);
                        })
                        .build());
    }
}
