package com.mindex.challenge.controller;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ReportingController {
    private static final Logger LOG = LoggerFactory.getLogger(com.mindex.challenge.controller.EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/reportingStructure/{id}")
    public ReportingStructure getReportingByID(@PathVariable String id) {
        LOG.debug("Received reporting structure request for id [{}]", id);

        return employeeService.getReportingStructure(id);
    }

}
