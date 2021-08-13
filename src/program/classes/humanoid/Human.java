package program.classes.humanoid;

public class Human extends Humanoid {
    private String spawnMessage = "I'm a human";
    public Human(String name, boolean sex) {
        super(name, sex);
        setSpawnMessage(spawnMessage);
        setAddress("The Earth");
    }
    public Human(String name, boolean sex, String address) {
        super(name, sex, address);
        setSpawnMessage(spawnMessage);
    }
}
