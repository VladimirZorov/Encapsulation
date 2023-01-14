package FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Team {

    private String name;
    private List<Player> players;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(String name) {
        players.remove(getName());
    }

    public double getRating() {
        double rating = 0;
        double ratingAvrg = rating/ players.size();
         for (Player player : players) {
           rating += player.overallSkillLevel();
        }

        return  ratingAvrg;
    }

}
