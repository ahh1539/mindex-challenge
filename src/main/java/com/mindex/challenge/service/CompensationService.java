package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensation;

import java.util.List;


public interface CompensationService {


    List<Compensation> getByEmployeeId(String employeeID);

    Compensation makeCompensation(Compensation compensation);
}

