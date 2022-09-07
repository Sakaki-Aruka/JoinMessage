package joinmessage.joinmessage;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.Map;

public class SettingsLoad {

    private static FileConfiguration FC;
    public static Map<Integer, TextComponent> componentMap = new HashMap<>();

    public void fcPass(FileConfiguration fileConfiguration){
        FC = fileConfiguration;
        this.load();
    }

    private void load(){
        int counter=1;

        while (true){
            if(FC.contains("message."+counter)){
                String path = "message."+counter;

                TextComponent textComponent = new TextComponent();

                String valueDescription = FC.getString(path);
                int keyInteger = counter;
                textComponent.setText(valueDescription);

                if(FC.contains(path+".url")){
                    String valueUrl = FC.getString(path+".url");
                    ClickEvent clickEvent = new ClickEvent(ClickEvent.Action.OPEN_URL,valueUrl);
                    textComponent.setClickEvent(clickEvent);
                    if(FC.contains(path+".copy")){
                        ClickEvent clickEventCopy = new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD,valueUrl);
                        textComponent.setClickEvent(clickEventCopy);
                    }
                }

                if(FC.contains(path+".command")){
                    String valueCommand = FC.getString(path+".command");
                    ClickEvent clickEvent = new ClickEvent(ClickEvent.Action.RUN_COMMAND,valueCommand);
                    textComponent.setClickEvent(clickEvent);
                }

                if(FC.contains(path+".suggest")) {
                    String valueSuggest = FC.getString(path + ".suggest");
                    ClickEvent clickEvent = new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND,valueSuggest);
                    textComponent.setClickEvent(clickEvent);
                }
                componentMap.put(keyInteger,textComponent);

                counter++;

            }else{
                Server server  = Bukkit.getServer();
                server.getLogger().info("[JoinMessage]:Description load completed.");
                break;
            }

        }
    }
}
