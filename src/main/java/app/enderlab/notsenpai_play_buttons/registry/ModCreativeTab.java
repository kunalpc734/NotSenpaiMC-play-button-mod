package app.enderlab.notsenpai_play_buttons.registry;

import app.enderlab.notsenpai_play_buttons.NotSenpaiPlayButtons;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTab {

    public static final ResourceKey<CreativeModeTab> PLAY_BUTTONS_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(),
            ResourceLocation.fromNamespaceAndPath(NotSenpaiPlayButtons.MOD_ID, "play_buttons_tab")
    );

    public static final CreativeModeTab PLAY_BUTTONS_TAB = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            PLAY_BUTTONS_KEY,
            CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
                    .title(Component.translatable("itemGroup.notsenpai_play_buttons.play_buttons_tab"))
                    .icon(() -> new ItemStack(ModBlocks.WOODEN_PLAY_BUTTON_ITEM))
                    .displayItems((displayParameters, output) -> {
                        output.accept(ModBlocks.WOODEN_PLAY_BUTTON_ITEM);
                        output.accept(ModBlocks.STONE_PLAY_BUTTON_ITEM);
                        output.accept(ModBlocks.IRON_PLAY_BUTTON_ITEM);
                        output.accept(ModBlocks.GOLDEN_PLAY_BUTTON_ITEM);
                        output.accept(ModBlocks.DIAMOND_PLAY_BUTTON_ITEM);
                        output.accept(ModBlocks.NETHERITE_PLAY_BUTTON_ITEM);
                        output.accept(ModBlocks.RUBY_PLAY_BUTTON_ITEM);
                    })
                    .build()
    );

    public static void register() {
        // Tab initialized via static field registration
    }
}
