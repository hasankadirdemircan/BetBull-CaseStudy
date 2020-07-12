package com.betbull.futboll.repository;

import com.betbull.futboll.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository  extends JpaRepository<Player, Integer> {
    Player findFirstById(Integer playerId);
}
