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
}
