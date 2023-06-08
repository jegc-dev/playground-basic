package com.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "execution_timer")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExecutionTimer {

    @Id
    @GeneratedValue
    private Long timerId;

    private Long time;

}
