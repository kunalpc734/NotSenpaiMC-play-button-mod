package app.enderlab.notsenpai_play_buttons.registry;

import app.enderlab.notsenpai_play_buttons.NotSenpaiPlayButtons;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public final class ModItems {

    public static final Item SILVER_PLAY_BUTTON = register("silver_play_button", ModBlocks.SILVER_PLAY_BUTTON);
    public static final Item GOLD_PLAY_BUTTON = register("gold_play_button", ModBlocks.GOLD_PLAY_BUTTON);
    public static final Item DIAMOND_PLAY_BUTTON = register("diamond_play_button", ModBlocks.DIAMOND_PLAY_BUTTON);
    public static final Item RUBY_PLAY_BUTTON = register("ruby_play_button", ModBlocks.RUBY_PLAY_BUTTON);

    private ModItems() {
    }

    private static Item register(String name, Block block) {
        ResourceLocation id = NotSenpaiPlayButtons.id(name);
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, id);
        Item item = new BlockItem(block, new Item.Properties().setId(key));
        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }

    /** Forces class initialisation so the item fields above run during mod init. */
    public static void register() {
    }
}
