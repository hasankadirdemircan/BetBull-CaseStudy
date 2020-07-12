package com.betbull.futboll.repository;

import com.betbull.futboll.model.Contract;
import com.betbull.futboll.model.Player;
import jdk.vm.ci.meta.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

public interface ContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "SELECT c.player_id FROM Contract c WHERE c.team_id = :team_id AND c.start_date = :start_date AND c.end_date = :end_date", nativeQuery = true)//
    List<Integer> playerIds(@Param("team_id") Integer team_id, @Param("start_date") String startDate, @Param("end_date") String endDate);//,

    @Query(value = "SELECT c.* FROM Contract c WHERE start_date >= :start_date AND end_date <= :end_date AND team_id = :team_id", nativeQuery = true)
    List<Contract> playerDetail(@Param("team_id") Integer team_id, @Param("start_date") LocalDate startDate, @Param("end_date") LocalDate endDate);

    List<Contract> findByPlayerId(Integer id);
}
