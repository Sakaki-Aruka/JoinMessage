package joinmessage.joinmessage;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class JoinMessage extends JavaPlugin {

    public void load(){
        FileConfiguration fileConfiguration = getConfig();
        new SettingsLoad().fcPass(fileConfiguration);
    }

    @Override
    public void onEnable() {
        this.load();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
