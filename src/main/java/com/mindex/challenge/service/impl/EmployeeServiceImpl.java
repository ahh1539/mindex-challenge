package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee employee) {
        LOG.debug("Creating employee [{}]", employee);

        employee.setEmployeeId(UUID.randomUUID().toString());
        System.out.println(employee.getEmployeeId() + employee.getFirstName() +employee.getDirectReports() +employee.getLastName()+employee.getDepartment()+employee.getPosition());
        employeeRepository.insert(employee);

        return employee;
    }

    @Override
    public Employee read(String id) {
        LOG.debug("Creating employee with id [{}] ggffg", id);

        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        LOG.debug("Updating employee [{}]", employee);

        return employeeRepository.save(employee);
    }

    @Override
    public ReportingStructure getReportingStructure(String employee_id) throws NullPointerException {
        if (employee_id == null && employee_id.isEmpty()) {
            throw new NullPointerException("Employee id is null.");
        } else {
            Employee employee = employeeRepository.findByEmployeeId(employee_id);

            if (employee == null) {
                throw  new NullPointerException("Employee could not be found!");
            } else {
                ReportingStructure reportingStructure = new ReportingStructure();
                reportingStructure.setEmployee(employee);
                reportingStructure.setNumReporting(getNumberReporting(employee_id));
                return reportingStructure;

            }
        }
    }

    @Override
    public int getNumberReporting(String employee_id) {
        Employee employee = read(employee_id);

        int count = 0;

        List<Employee> directReports = employee.getDirectReports();

        if(directReports.isEmpty() || directReports == null) {
            return count;
        } else {
            for(Employee directReport : directReports) {
                count += getNumberReporting(directReport.getEmployeeId()) + 1;
            }
        }
        return count;
    }
}
