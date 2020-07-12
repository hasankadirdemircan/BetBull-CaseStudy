package com.betbull.futboll.repository;

import com.betbull.futboll.model.Player;
import com.betbull.futboll.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository  extends JpaRepository<Team, Integer> {
    Team findFirstById(Integer teamId);
}
