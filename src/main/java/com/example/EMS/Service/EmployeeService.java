package com.example.EMS.Service;


import com.example.EMS.Model.Employee;

import java.util.List;

public interface EmployeeService {

    String createEmployee(Employee employee);

    Employee getEmployeeById(String employeeId);

    List<Employee> getAllEmployee();

    String updateEmployee(Employee updatedEmployee);

    String deleteEmployeeById(String employeeId);

    void deleteEmployee(Employee employee);
}
