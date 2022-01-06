package com.plass.webapp.control;

import com.plass.webapp.model.Employee;
import com.plass.webapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping("/")
    public String home(Model model){
        Iterable<Employee> listEmployee = service.getEmployees();
        model.addAttribute("employees", listEmployee);
        return "home";
    }

    @GetMapping("updateEmployee/{id}")
    public String updateEmployee(@PathVariable("id") final int id, Model model){
        Employee e = service.getEmployee(id);
        model.addAttribute("employee", e);
        return "formUpdateEmployee";
    }

    @GetMapping("/createEmployee")
    public String createEmployee(Model model){
        Employee e = new Employee();
        model.addAttribute("employee", e);
        return "formUpdateEmployee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public ModelAndView deleteEmployee(@PathVariable("id") final int id){
        service.deleteEmployee(id);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/saveEmployee")
    public ModelAndView saveEmployee(@ModelAttribute Employee employee){
        if(employee.getId() != null){
            Employee current = service.getEmployee(employee.getId());
            employee.setPassword(current.getPassword());
        }
        service.saveEmployee(employee);
        return new ModelAndView("redirect:/");
    }
}
