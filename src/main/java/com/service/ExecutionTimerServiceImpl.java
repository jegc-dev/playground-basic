package com.service;

import com.model.ExecutionTimer;
import com.resource.ExecutionTimerRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@RequiredArgsConstructor
@Service
@Transactional
public class ExecutionTimerServiceImpl implements ExecutionTimerService{

    private final ExecutionTimerRepository timerRepository;
    @Override
    public List<ExecutionTimer> getAll() {
        return timerRepository.findAll();
    }
}
