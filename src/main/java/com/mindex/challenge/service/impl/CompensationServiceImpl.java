package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;



@Service
public class CompensationServiceImpl implements CompensationService {

    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    @Autowired
    private CompensationRepository compensationRepository;

    @Override
    public List<Compensation> getByEmployeeId(String employeeID) throws NullPointerException {

        if (employeeID == null || employeeID.isEmpty()) {
            throw new NullPointerException("ID Provided is null");
        }
        List<Compensation> compensations = compensationRepository.findByEmployeeEmployeeId(employeeID);
        return compensations;
    }

    @Override
    public Compensation makeCompensation(Compensation compensation) {

        compensation.setCompensationID(UUID.randomUUID().toString()); // assigns random ID to compensation to help find later
        compensationRepository.insert(compensation); // puts new compensation into the DB
        System.out.println("hehhehehehehhehe    " + compensation.getEmployee().getEmployeeId() + "   " + compensation.getSalary()  + compensation.getEffectiveDate());
        return compensation;
    }
}

