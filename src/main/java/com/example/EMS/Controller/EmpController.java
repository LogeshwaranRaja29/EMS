package com.example.EMS.Controller;

import com.example.EMS.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.EMS.Service.EmployeeService;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class EmpController {

    @Autowired
    private EmployeeService employeeService;

    //handlers

    @GetMapping("/")
    public String health() {
        return "ok";
    }

    @GetMapping("/employees")
    public String getAllEmployee(Model model)
    {
        model.addAttribute("EmployeeList",employeeService.getAllEmployee());
        return "employees.html";
    }

    @GetMapping("/employees/new")
    public String createEmployee(Employee employee,Model model){
        model.addAttribute("Employee",employee);
        return "newEmployee.html";
    }

    @PostMapping
    @RequestMapping("/addEmployees")
    public String newEmployee(@ModelAttribute("employee") Employee employee)
    {
        employeeService.createEmployee(employee);
        return "redirect:/employees";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editEmployee(@PathVariable String id)
    {
        ModelAndView mv =new ModelAndView("editEmployee");
        mv.addObject(employeeService.getEmployeeById(id));
        return mv;
    }

    @PostMapping("/saveUpdate")
    public String saveUpdate(@ModelAttribute("employee") Employee employee)
    {
        employeeService.createEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping
    @RequestMapping("/delete")
    public String deleteEmp(@ModelAttribute Employee employee,Model model)
    {
        employeeService.deleteEmployee(employee);
        return "redirect:/employees";
    }
}
