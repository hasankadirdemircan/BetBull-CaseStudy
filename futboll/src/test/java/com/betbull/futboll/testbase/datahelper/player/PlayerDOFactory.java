package com.betbull.futboll.testbase.datahelper.player;

import com.betbull.futboll.model.Player;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlayerDOFactory {
    public Player player(){
        Player player = new Player();
        player.setId(1);
        String date = "1995-02-26";

        //default, ISO_LOCAL_DATE
        LocalDate localDate = LocalDate.parse(date);
        player.setBirthday(localDate);
        player.setUsername("kadir");

        return player;
    }

    public List<Player> playerList(){
        List<Player> playerList = new ArrayList<>();
        Player player = new Player();
        player.setId(1);
        player.setBirthday(LocalDate.now());
        player.setUsername("kadir");

        Player player2 = new Player();
        player.setId(2);
        player.setBirthday(LocalDate.now());
        player.setUsername("hasan");

        playerList.add(player);
        playerList.add(player2);
        return playerList;
    }
}
