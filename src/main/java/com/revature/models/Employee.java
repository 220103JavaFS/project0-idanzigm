package com.revature.models;

import java.util.Objects;

public class Employee {

    private int employeeID;
    private String accessLevel;

    public Employee() {
        super();
    }

    public Employee(int employeeID, String accessLevel) {
        this.employeeID = employeeID;
        this.accessLevel = accessLevel;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getEmployeeID() == employee.getEmployeeID() && getAccessLevel().equals(employee.getAccessLevel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeID(), getAccessLevel());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", accessLevel='" + accessLevel + '\'' +
                '}';
    }
}


