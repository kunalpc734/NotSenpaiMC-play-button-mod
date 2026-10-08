package app.enderlab.notsenpai_play_buttons;

import app.enderlab.notsenpai_play_buttons.registry.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;

/**
 * Client only entrypoint. Keeps the tooltip hook off the dedicated server classpath.
 */
public class NotSenpaiPlayButtonsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ItemTooltipCallback.EVENT.register((stack, context, tooltipFlag, lines) -> {
            String milestone = milestoneFor(stack.getItem());
            if (milestone == null) {
                return;
            }
            lines.add(Component.literal("Creator: NotSenpaiMC").withStyle(ChatFormatting.GRAY));
            lines.add(Component.literal("Milestone: " + milestone).withStyle(ChatFormatting.GRAY));
        });
    }

    private static String milestoneFor(Item item) {
        if (item == ModItems.SILVER_PLAY_BUTTON) {
            return "100K Subscribers";
        }
        if (item == ModItems.GOLD_PLAY_BUTTON) {
            return "1M Subscribers";
        }
        if (item == ModItems.DIAMOND_PLAY_BUTTON) {
            return "10M Subscribers";
        }
        if (item == ModItems.RUBY_PLAY_BUTTON) {
            return "100M Subscribers";
        }
        return null;
    }
}
