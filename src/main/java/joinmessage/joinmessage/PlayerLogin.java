package joinmessage.joinmessage;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerLoginEvent;

import static joinmessage.joinmessage.SettingsLoad.componentMap;

public class PlayerLogin {
    public void login(PlayerLoginEvent event){
        Player player = event.getPlayer();

        for(int i=1;i <= componentMap.size();i++){
            player.spigot().sendMessage(componentMap.get(i));
        }
    }
}
