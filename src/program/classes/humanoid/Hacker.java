package program.classes.humanoid;

import program.classes.util.Chat;
import program.classes.util.Screen;
import program.classes.util.Stopwatch;
import program.interfaces.Display;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Hacker extends Human {
    private Random random = new Random();
    private Display stopwatch = new Stopwatch();
    private Set<Integer> keyBase = new HashSet<>(100);
    private Screen screen = new Screen();
    private String spawnMessage = super.getSpawnMessage() + ". But also I'm the coolest hacker!";
    private String address = "Somewhere";

    public Hacker(String name, boolean sex) {
        super(name, sex);
        setSpawnMessage(spawnMessage);
        setAddress(address);
    }
    public Hacker(String name, boolean sex, String message) {
        super(name, sex);
        setSpawnMessage(message);
        setAddress(address);
    }

    public void hack(Chat chat) throws InterruptedException {
        if (chat == null) throw new RuntimeException("This pair chat is UNREAL.");
        int currentKey;
        startOfWork();
        System.out.println("\nConnecting...");
        while (true) {
            Thread.sleep(1000);
            currentKey = random.nextInt(100);
            if (isKeyInSet(currentKey)) continue;
            showWork(currentKey);
            if (chat.connect(currentKey)) {
                endOfWork(currentKey);
                break;
            }
        }
    }

    private void printSet() {
        System.out.println(keyBase);
    }

    private boolean isKeyInSet(int key) {
        boolean isKeyInSet = keyBase.contains(key);
        if (!isKeyInSet) keyBase.add(key);
        return isKeyInSet;
    }

    private void showWork(int key) {
        System.out.print("Hacking: " + key + " ");
        printSet();
    }

    private void startOfWork() {
        stopwatch.start();
    }

    private void endOfWork(int key) {
        System.out.print("Key is: " + key + " ");
        printSet();
        System.out.println("Time to hack: " + (float) stopwatch.display() / 1000 + " sec.");
    }
}
