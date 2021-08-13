package program;

import program.classes.humanoid.Alien;
import program.classes.humanoid.Hacker;
import program.classes.humanoid.Human;
import program.classes.humanoid.Sith;
import program.classes.util.Chat;
import program.classes.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private static final Pair HUMAN_PAIR =
            new Pair(
                    new Human("Stas", true, "Ukraine, The Earth"),
                    new Human("Somebody That I Used To Know", false)
            );
    private static final Pair ALIEN_PAIR =
            new Pair(
                    new Alien("BRRREEEE", true, "Domestic Star Way, Poland, The Earth"),
                    new Alien("TERRREEEE", false, "Consonant Brave Planet")
            );
    private static final Pair HUMANOID_PAIR =
            new Pair(
                    new Human("Misha", true, "The USA, The Earth"),
                    new Alien("TTIIIES", false)
            );
    private static final Pair SITH_PAIR =
            new Pair(
                    new Sith("Brave J", true, "Fallen Star"),
                    new Sith("Wrong Lady", false, "Fallen Star")
            );

    private static final Hacker hacker = new Hacker("Anonymuss2003", true, "Be afraid.");

    private static final Chat HUMAN_CHAT = new Chat(HUMAN_PAIR);
    private static final Chat ALIEN_CHAT = new Chat(ALIEN_PAIR);
    private static final Chat HUMANOID_CHAT = null;
    private static final Chat SITH_CHAT = new Chat(SITH_PAIR);

    private static List<Pair> pairs = new LinkedList<>(Arrays.asList(HUMAN_PAIR, ALIEN_PAIR, HUMANOID_PAIR, SITH_PAIR));
    private static List<Chat> chats = new LinkedList<>(Arrays.asList(HUMAN_CHAT, ALIEN_CHAT, HUMANOID_CHAT, SITH_CHAT));

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < pairs.size(); i++) {
            Pair pair = pairs.get(i);
            System.out.println(i + ". " + pair);
        }

        int decision;
        System.out.println("\nEnter to which dialogue you want to connect (0 - 3): ");
        while (true) {
            try {
                decision = Integer.parseInt(reader.readLine());
                if (decision < 0 || decision > 3)
                    throw new RuntimeException("Please, enter a number from BOUND (0 - 3): ");
                Chat chat = chats.get(decision);
                hacker.hack(chat);
                break;
            }
            catch (NumberFormatException e) {
                System.out.println("Please, enter a NUMBER: ");
            }
            catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
//        String connecting = "Connecting";
//        for (int i = 0; true; i++) {
//            for (int j = 0; j < 9; j++)
//                System.out.println();
//            if (i % 4 == 0) connecting = "Connecting";
//            System.out.println(connecting);
//            connecting += ".";
//            int tryKey = random.nextInt(100);
//            System.out.println("Hacking: " + tryKey);
//            if (chat.connect(tryKey)) {
//                for (int j = 0; j < 9; j++)
//                    System.out.println();
//                System.out.println("Connected!");
//                System.out.println("Key: " + tryKey);
//                break;
//            }
//            Thread.sleep(300L);
//        }
    }
}