package ale.yawind;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
public class ClientYawIndicator implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        YawHudRenderer.renderLine();
        long[] lastCallTime = {0};  // Mutable array
        ClientTickEvents.END_CLIENT_TICK.register((client) -> {	
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastCallTime[0] > 200) {
                YawLogic.logYaw();
                lastCallTime[0] = currentTime;
            }
        });
}}  