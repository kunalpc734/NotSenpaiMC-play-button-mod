package app.enderlab.notsenpai_play_buttons.registry;

import app.enderlab.notsenpai_play_buttons.NotSenpaiPlayButtons;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModItems {

    public static final Item WOODEN_PLAY_BUTTON = registerBlockItem("wooden_play_button", ModBlocks.WOODEN_PLAY_BUTTON);
    public static final Item STONE_PLAY_BUTTON = registerBlockItem("stone_play_button", ModBlocks.STONE_PLAY_BUTTON);
    public static final Item IRON_PLAY_BUTTON = registerBlockItem("iron_play_button", ModBlocks.IRON_PLAY_BUTTON);
    public static final Item SILVER_PLAY_BUTTON = IRON_PLAY_BUTTON;
    public static final Item GOLDEN_PLAY_BUTTON = registerBlockItem("golden_play_button", ModBlocks.GOLDEN_PLAY_BUTTON);
    public static final Item GOLD_PLAY_BUTTON = GOLDEN_PLAY_BUTTON;
    public static final Item DIAMOND_PLAY_BUTTON = registerBlockItem("diamond_play_button", ModBlocks.DIAMOND_PLAY_BUTTON);
    public static final Item NETHERITE_PLAY_BUTTON = registerBlockItem("netherite_play_button", ModBlocks.NETHERITE_PLAY_BUTTON);
    public static final Item RUBY_PLAY_BUTTON = registerBlockItem("ruby_play_button", ModBlocks.RUBY_PLAY_BUTTON);

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(NotSenpaiPlayButtons.MOD_ID, name),
                new BlockItem(block, new Item.Properties()));
    }

    public static void register() {
        // Static initialization
    }
}
