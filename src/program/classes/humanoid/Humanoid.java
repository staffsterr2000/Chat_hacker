package program.classes.humanoid;

import program.interfaces.Communicative;
import program.interfaces.Informative;

public abstract class Humanoid implements Informative, Communicative {
    private String name;        // name of a Humanoid
    private String address;     // address
    private boolean sex;        // sex
    private String intonation;          // intonation of a humanoid, which will be added to every message of this object
    private void setIntonation() {      // which we calculating here (boys - rude, girls - erotic) (Maybe I too much generate at all)
        intonation = (sex) ? "*rude*" : "*erotic*";
    }
    private String spawnMessage;
    private String messageToSay = "*nothing*";  // realisation for future chats (default value: *nothing*)
    private String messageLastHeard = "*nothing*";   // realisation for future chats (default value: *nothing*)

    // Overriden toString() which is a shortInformation() method
    @Override
    public String toString() {
        return shortInformation();
    }

    // here we have short information about object (from interface Informative)
    public String shortInformation() {
        return getClass().getSimpleName() + " \"" + name + "\"";
    }

    // full information about object (from interface Informative)
    public String fullInformation() {
        String sexString = (sex) ? " (Male)" : " (Female)";   // gender
        String sexPronoun = (sex) ? " His" : " Her";   // gender pronounce
        return shortInformation() + sexString + " from " + address  // (Class) (name) (sex) from (address). And (pronoun)'s saying: (message)
                + "." + sexPronoun + " status: \"" + entertain() + "\"";
    }

    // say the message with an intonation (from interface Communicative)
    @Override
    public String say() {
        return messageToSay + " " + intonation;
    }

    @Override
    public String entertain() {
        return spawnMessage;
    }

    // listen message (from interface Communicative)
    @Override
    public void listen(String messageToListen) {
        if (messageToListen == null || messageToListen.isEmpty()) {}    /* if message to listen is empty -> last listened
                                                                        message is previous message */
        else messageLastHeard = messageToListen;
    }

    // getters
    public String getName() {
        return name;
    }
    public boolean getSex() {
        return sex;
    }
    public String getAddress() {
        return address;
    }
    public String getSpawnMessage() {
        return spawnMessage;
    }

    // setters
    protected void setAddress(String address) {
        if (address == null || address.isEmpty()) throw new RuntimeException("No null/empty addresses!");   // pulls RuntimeException if address is empty
        this.address = address;
    }
    protected void setSpawnMessage(String message) {
        spawnMessage = message;
    }

    // constructors with calling setIntonation()
    public Humanoid(String name, boolean sex) {
        this.name = name;
        this.sex = sex;
        setIntonation();    // uses when creating an object to set intonation
        System.out.println("\tCreated new " + this);     // information about creating
    }
    public Humanoid(String name, boolean sex, String address) {
        this.name = name;
        this.sex = sex;
        this.address = address;
        setIntonation();    // uses when creating an object to set intonation
        System.out.println("\tCreated new " + this);     // information about creating
    }
}
