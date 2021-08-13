package program.classes.util;

import program.classes.humanoid.Humanoid;
import program.interfaces.Connectible;

import java.util.Random;

public class Chat implements Connectible {
    private int key = new Random().nextInt(100);
    private Pair pair;
    private Humanoid first;
    private Humanoid second;
    private boolean isConnected;

    @Override
    public String toString() {
        return first + " & " + second + " chat.";
    }

    public Pair getPair() {
        return pair;
    }

    public Chat(Pair pair) {
        this.pair = pair;
        first = pair.getFirst();
        second = pair.getSecond();
        pair.setChat(this);
    }

    public Chat(Humanoid first, Humanoid second) {
        this.first = first;
        this.second = second;
        pair = new Pair(first, second);
        pair.setChat(this);
    }

    private void successConnect() {
        isConnected = true;
        System.out.println("\nWelcome!\n" + this);
    }

    public boolean connect(int key) {
        if (key == this.key) successConnect();
        return isConnected;
    }
}
