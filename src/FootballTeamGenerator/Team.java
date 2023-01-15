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
        if (name==null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public void addPlayer(Player player) {
        if (this.players.contains(player)) {
            this.players.add(player);
        }
    }

    public void removePlayer(String name) {
        int index = -1;
        for (int i = 0; i < this.players.size(); i++) {
            if (this.players.get(i).getName().equals(name)){
                index = i;
                break;
            }
        }
        if (index != -1){
            this.players.remove(index);
        } else {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", name, this.name));
        }
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
