import java.util.HashMap;

public class CommandWords {
    private HashMap<String, String> perintah;

    public CommandWords(){
        perintah = new HashMap<>();
        perintah.put("go", "go");
        perintah.put("quit", "quit");
        perintah.put("help", "help");
    }

    public String getCommandWord(String CommandWord){
        return perintah.get(CommandWord);
    }

    public void showAll(){
        for(String perintah : perintah.keySet()){
            System.out.print(perintah + " ");
        }
        System.out.println();
    }
}