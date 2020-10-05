package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;

import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CompensationController {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private CompensationService compensationService;


    @PostMapping("/compensation")
    public Compensation create(@RequestBody Compensation compensation) {
        LOG.debug("Received Compensation create request for [{}]", compensation.getEmployee().getEmployeeId());
        return compensationService.makeCompensation(compensation);
    }

    @GetMapping("/compensation/employee/{id}")
    public List<Compensation> read(@PathVariable String id) {
        LOG.debug("Received Compensation retrieval request for employee with ID: [{}]", id);
        return compensationService.getByEmployeeId(id);
    }

}


