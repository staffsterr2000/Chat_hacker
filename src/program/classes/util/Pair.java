package program.classes.util;

import program.classes.humanoid.Alien;
import program.classes.humanoid.Human;
import program.classes.humanoid.Humanoid;
import program.classes.humanoid.Sith;

public class Pair {
    private Humanoid first;     // Pair of Humanoids
    private Humanoid second;
    private Chat chat;

    // construct Pair
    public Pair(Humanoid first, Humanoid second) {
        this.first = first;
        this.second = second;
    }

    // getters
    public Humanoid getFirst() {
        return first;
    }
    public Humanoid getSecond() {
        return second;
    }
    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    // Overriden method toString() returns information about Pair
    @Override
    public String toString() {
        String returnString = printPairTitle();
        if (chat == null) {
            returnString += "Have no chat.";
            returnString = returnString.toUpperCase();
        }
        else {
            returnString += chat.toString();
            returnString = returnString.toUpperCase();
            returnString += printPairByPersons();
        }
        System.out.println();
        return returnString;
    }

    public String printPairTitle() {
        String returnString;
        if (!(first.getClass().equals(second.getClass()))) {    // checks if Humanoids aren't the same race
            returnString = "A hybrid pair: ";
        }
        else if (first instanceof Human) {          // then checks all the races
            returnString = "A human pair: ";
        }
        else if (first instanceof Alien) {
            returnString = "An alien pair: ";
        }
        else if (first instanceof Sith) {
            returnString = "A sith pair: ";
        }
        else returnString = "An unknown humanoid pair: ";      // if the race is unknown

        return returnString;
    }

    // prints after full information in toString()
    private String printPairByPersons() {
        return "\n\t" + first.fullInformation() + "\n\t" + second.fullInformation();
    }
}
