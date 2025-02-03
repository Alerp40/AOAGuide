package ale.yawind;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Items;


public class YawLogic {
    static Logger LOGGER = LoggerFactory.getLogger("YawLogic");
    static ClientPlayerEntity player;

    public static void logYaw() {
        LOGGER.info(String.valueOf(returnYaw()));
    }
    public static void getPlayer() {
        ClientTickEvents.END_CLIENT_TICK.register((client) -> {	
            player = MinecraftClient.getInstance().player;
        });
    }
    public static float returnYaw() {
        getPlayer();
        if (player == null) return 0;
        try {
            return player.getPitch();
        } catch (Exception e) {
            return 0;
        }
    }
    public static int editLineLength() {
        int currentYaw = (int) returnYaw();
        if(currentYaw <= -30) {
            return -30;
        }else if(currentYaw >= 40) {
            return 40;
        }else {
            return currentYaw;
        }
    }
    public static boolean isUsingElytra(PlayerEntity player) {
        if (player == null) return false;
        return player.isGliding() && player.getEquippedStack(EquipmentSlot.CHEST).isOf(Items.ELYTRA);
    }
}
