package app.enderlab.notsenpai_play_buttons;

import app.enderlab.notsenpai_play_buttons.registry.ModBlocks;
import app.enderlab.notsenpai_play_buttons.registry.ModCreativeTab;
import app.enderlab.notsenpai_play_buttons.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Common entrypoint. Everything here is data driven and safe to run on a dedicated server:
 * block/item/creative tab registration only, no client classes are touched.
 */
public class NotSenpaiPlayButtons implements ModInitializer {

    public static final String MOD_ID = "notsenpai_play_buttons";
    public static final Logger LOGGER = LoggerFactory.getLogger("NotSenpaiMC Creator Play Buttons");

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    @Override
    public void onInitialize() {
        ModBlocks.register();
        ModItems.register();
        ModCreativeTab.register();
        LOGGER.info("NotSenpaiMC Creator Play Buttons loaded.");
    }
}
