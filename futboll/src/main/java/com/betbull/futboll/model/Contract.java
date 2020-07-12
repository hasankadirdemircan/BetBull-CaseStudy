package com.betbull.futboll.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jdk.vm.ci.meta.Local;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name="contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "player_id")
    private Integer playerId;
    @Column(name = "team_id")
    private Integer teamId;

    @Column(name = "contract_payment")
    private Long contractPayment;

    @Column(name = "transfer_payment")
    private Long transferPayment;

    @Column(name = "team_commission")
    private Long teamCommission;

    @Column(name = "start_date")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private LocalDate startDate;

    @Column(name = "end_date")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private LocalDate endDate;

}
