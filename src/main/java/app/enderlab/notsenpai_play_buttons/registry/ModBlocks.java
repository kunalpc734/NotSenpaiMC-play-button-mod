package app.enderlab.notsenpai_play_buttons.registry;

import app.enderlab.notsenpai_play_buttons.NotSenpaiPlayButtons;
import app.enderlab.notsenpai_play_buttons.block.PlayButtonBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ModBlocks {

    public static final Block WOODEN_PLAY_BUTTON = registerBlock("wooden_play_button",
            new PlayButtonBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final Block STONE_PLAY_BUTTON = registerBlock("stone_play_button",
            new PlayButtonBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));

    public static final Block IRON_PLAY_BUTTON = registerBlock("iron_play_button",
            new PlayButtonBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));

    public static final Block SILVER_PLAY_BUTTON = IRON_PLAY_BUTTON;

    public static final Block GOLDEN_PLAY_BUTTON = registerBlock("golden_play_button",
            new PlayButtonBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));

    public static final Block GOLD_PLAY_BUTTON = GOLDEN_PLAY_BUTTON;

    public static final Block DIAMOND_PLAY_BUTTON = registerBlock("diamond_play_button",
            new PlayButtonBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)));

    public static final Block NETHERITE_PLAY_BUTTON = registerBlock("netherite_play_button",
            new PlayButtonBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK)));

    public static final Block RUBY_PLAY_BUTTON = registerBlock("ruby_play_button",
            new PlayButtonBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_BLOCK)));

    private static Block registerBlock(String name, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(NotSenpaiPlayButtons.MOD_ID, name), block);
    }

    public static void register() {
        // Static initialization
    }
}
