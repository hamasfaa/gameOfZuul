import java.util.HashMap;

public class Game {
    private Parser parser;
    private Room currentRoom;

    public Game() {
        createRooms();
        parser = new Parser();
    }

    private void createRooms() {
        Room luar, teater, kantin, lab, kantor;

        luar = new Room("di luar pintu masuk utama universitas");
        teater = new Room("di dalam ruang kuliah");
        kantin = new Room("di kantin kampus");
        lab = new Room("di laboratorium komputer");
        kantor = new Room("di kantor administrasi");

        luar.setExit("timur", teater);
        luar.setExit("selatan", lab);
        luar.setExit("barat", kantin);

        teater.setExit("barat", luar);

        kantin.setExit("timur", luar);

        lab.setExit("utara", luar);
        lab.setExit("timur", kantor);

        kantor.setExit("barat", lab);

        currentRoom = luar;
    }

    public void play() {
        printWelcome();

        boolean selesai = false;
        while (!selesai) {
            Command command = parser.getCommand();
            selesai = processCommand(command);
        }
        System.out.println("Terima kasih telah bermain. Selamat tinggal.");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Selamat datang di Dunia Zuul!");
        System.out.println("Dunia Zuul adalah permainan petualangan yang sangat membosankan.");
        System.out.println("Ketik 'help' jika Anda membutuhkan bantuan.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) {
        boolean inginKeluar = false;

        if (command.isUnknown()) {
            System.out.println("Saya tidak tahu apa yang Anda maksud...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        } else if (commandWord.equals("go")) {
            goRoom(command);
        } else if (commandWord.equals("quit")) {
            inginKeluar = true;
        }

        return inginKeluar;
    }

    private void printHelp() {
        System.out.println("Anda tersesat. Anda sendirian. Anda berkeliaran");
        System.out.println("di sekitar universitas.");
        System.out.println();
        System.out.println("Kata perintah Anda adalah:");
        parser.showCommands();
    }

    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Pergi ke mana?");
            return;
        }

        String direction = command.getSecondWord();
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("Tidak ada pintu ke arah " + direction + "!");
            System.out.println(currentRoom.getExitString());
        } else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}