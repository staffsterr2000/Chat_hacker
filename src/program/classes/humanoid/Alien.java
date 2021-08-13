package program.classes.humanoid;

public class Alien extends Humanoid {
    private String spawnMessage = "I'm an alien";
    public Alien(String name, boolean sex) {
        super(name, sex);
        setSpawnMessage(spawnMessage);
        setAddress("Alpha Centavra");
    }
    public Alien(String name, boolean sex, String address) {
        super(name, sex, address);
        setSpawnMessage(spawnMessage);
    }
}
