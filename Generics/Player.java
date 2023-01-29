package Generics;

public abstract class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");

        Team<FootballPlayer> crazyCats = new Team<>("Crazy Cats");
        crazyCats.addPlayer(joe);

        Team<BaseballPlayer> chicagoCubs = new Team<>("Chicago Cubs");
        chicagoCubs.addPlayer(pat);
    }
}
