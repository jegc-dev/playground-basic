package com.resource;

import com.model.ExecutionTimer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ExecutionTimerRepository extends JpaRepository<ExecutionTimer, Long> {


}
