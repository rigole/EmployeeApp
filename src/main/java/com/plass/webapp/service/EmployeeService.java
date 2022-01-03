package com.plass.webapp.service;


import com.plass.webapp.control.Employee;
import com.plass.webapp.repository.EmployeeProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class EmployeeService {

    @Autowired
    private EmployeeProxy employeeProxy;

    public Employee getEmployee(final int id){
        return  employeeProxy.getEmployee(id);
    }

    public Iterable<Employee> getEmployees(){
        return employeeProxy.getEmployees();
    }

    public void deleteEmployee(final int id){
        employeeProxy.deleteEmployees(id);
    }

    public Employee saveEmployee(Employee employee){
        Employee savedEmployee;

        // name must be capitalize
        employee.setLastName(employee.getLastName().toUpperCase());

        if (employee.getId() == null){
            savedEmployee = employeeProxy.createEmployee(employee);
        }else{
            savedEmployee = employeeProxy.updateEmployee(employee);
        }

        return savedEmployee;
    }

}
