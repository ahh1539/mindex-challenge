
package com.mindex.challenge.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.UUID;


public class Compensation {

    @JsonIgnore
    @Id
    private String compensationID;

    private Employee employee;
    private int salary;
    private LocalDate effectiveDate;

    public Compensation() {
    }

    public String getCompensationID() {
        return compensationID;
    }

    public void setCompensationID(String  compensationID) {
        this.compensationID = compensationID;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate date) {
        this.effectiveDate = date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

/**
 * JSON Schema for Compensation Obj
 * {
 *   "type":"Compensation",
 *   "properties": {
 *     "employee": {
 *        "employeeId": {
 *          "type": "string"
 *         },
 *         "firstName": {
 *           "type": "string"
 *         },
 *         "lastName": {
 *           "type": "string"
 *         },
 *         "position": {
 *           "type": "string"
 *         },
 *         "department": {
 *           "type": "string"
 *         },
 *         "directReports": {
 *           "type": "array",
 *           "items" : "string"
 *         }
 *      },
 *      "salary": {
 *          "type" "int"
 *      },
 *      "effectiveDate": {
 *          "type": "string"
 *      }
 *   }
 * }
 */
