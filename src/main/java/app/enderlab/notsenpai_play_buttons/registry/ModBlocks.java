package app.enderlab.notsenpai_play_buttons.registry;

import app.enderlab.notsenpai_play_buttons.NotSenpaiPlayButtons;
import app.enderlab.notsenpai_play_buttons.block.PlayButtonBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public final class ModBlocks {

    public static final Block SILVER_PLAY_BUTTON = register("silver_play_button", MapColor.METAL, SoundType.METAL);
    public static final Block GOLD_PLAY_BUTTON = register("gold_play_button", MapColor.GOLD, SoundType.METAL);
    public static final Block DIAMOND_PLAY_BUTTON = register("diamond_play_button", MapColor.DIAMOND, SoundType.AMETHYST);
    public static final Block RUBY_PLAY_BUTTON = register("ruby_play_button", MapColor.COLOR_RED, SoundType.AMETHYST);

    private ModBlocks() {
    }

    private static Block register(String name, MapColor mapColor, SoundType soundType) {
        ResourceLocation id = NotSenpaiPlayButtons.id(name);
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, id);
        Block block = new PlayButtonBlock(BlockBehaviour.Properties.of()
                .setId(key)
                .mapColor(mapColor)
                .strength(1.5F, 6.0F)
                .sound(soundType)
                .noOcclusion());
        return Registry.register(BuiltInRegistries.BLOCK, key, block);
    }

    /** Forces class initialisation so the block fields above run during mod init. */
    public static void register() {
    }
}
