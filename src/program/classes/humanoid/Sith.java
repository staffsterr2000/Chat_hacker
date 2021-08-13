package program.classes.humanoid;

public class Sith extends Humanoid {
    private String spawnMessage = "I'm a sith";
    public Sith(String name, boolean sex) {
        super(name, sex);
        setSpawnMessage(spawnMessage);
        setAddress("Planet Of Green Skies");
    }
    public Sith(String name, boolean sex, String address) {
        super(name, sex, address);
        setSpawnMessage(spawnMessage);
    }
}
