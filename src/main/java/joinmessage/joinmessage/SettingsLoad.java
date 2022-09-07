package joinmessage.joinmessage;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SettingsLoad {

    private static FileConfiguration FC;

    public static Map<Integer,String> descriptionUrl = new HashMap<>();
    public static Map<Integer,String> lineDescription = new HashMap<>();
    public static ArrayList<Integer> clipboardBool = new ArrayList<>();
    public static Map<Integer,String> clickCommand = new HashMap<>();
    public static Map<Integer,String> suggest = new HashMap<>();

    public void fcPass(FileConfiguration fileConfiguration){
        FC = fileConfiguration;
        this.load();
    }

    private void load(){
        int counter=1;

        while (true){
            if(FC.contains("message."+counter)){
                String path = "message."+counter;

                String valueDescription = FC.getString(path);
                int keyInteger = counter;
                lineDescription.put(keyInteger,valueDescription);

                if(FC.contains(path+".url")){
                    String valueUrl = FC.getString(path+".url");
                    int keyInteger2 = counter;
                    descriptionUrl.put(keyInteger2,valueUrl);
                }
                
                counter++;

            }else{
                Server server  = Bukkit.getServer();
                server.getLogger().info("[JoinMessage]:Description load completed.");
                break;
            }

        }
    }
}
