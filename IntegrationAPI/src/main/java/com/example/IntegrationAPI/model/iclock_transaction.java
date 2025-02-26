package com.example.IntegrationAPI.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

import java.time.ZonedDateTime;


@Entity
@Immutable
@Table(name="iclock_transaction")
public class iclock_transaction {

    @Id
    private Integer id;
private String emp_code ;
    private Integer terminal_id;
    private Integer emp_id;
    private ZonedDateTime punch_time;

    public iclock_transaction() {
    }

    public iclock_transaction(Integer id,String emp_code,  Integer terminal_id, Integer emp_id, ZonedDateTime punch_time) {
        this.id = id;
        this.emp_code=emp_code;
        this.terminal_id = terminal_id;
        this.emp_id = emp_id;
        this.punch_time = punch_time;
    }

    public Integer getId() {
        return id;
    }

    public Integer getTerminal_id() {
        return terminal_id;
    }

    public Integer getEmp_id() {
        return emp_id;
    }

    public ZonedDateTime getPunch_time() {
        return punch_time;
    }

    public String getEmp_code() {
        return emp_code;
    }
}