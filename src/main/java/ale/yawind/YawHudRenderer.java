package ale.yawind;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;

public class YawHudRenderer {
    public static void renderLine() {
        HudRenderCallback.EVENT.register((drawContext,tickCounter) -> {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.player == null) return;

            int screenWidth = drawContext.getScaledWindowWidth();
            int screenHeight = drawContext.getScaledWindowHeight();

            int startX = screenWidth / 2;
            int startY = (screenHeight / 2) - 10 + (int) YawLogic.editLineLength()/4;
            int endY = (screenHeight / 2) + 8 + (int) YawLogic.editLineLength()/4;
            int color = 0x50FF0000;

            if (((int) YawLogic.returnYaw() >= 39 && (int) YawLogic.returnYaw() <= 41 )|| ((int) YawLogic.returnYaw() <= -29 && (int) YawLogic.returnYaw() >= -31)) {
                color = 0x5000FF00;
            }
            if(YawLogic.isUsingElytra(client.player)){
                drawContext.fill(startX-1, startY, startX, endY, color);
            }
        });        
    }
}
