package com.mindex.challenge.data;

public class ReportingStructure {
    private int numReporting;
    private Employee employee;

    public ReportingStructure() {

    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getNumReporting() {
        return numReporting;
    }

    public void setNumReporting(int numReporting) {
        this.numReporting = numReporting;
    }

}
