package com.example.EMS.Service.ServiceImpl;

import com.example.EMS.Model.Employee;
import com.example.EMS.Repository.EmployeeRepository;
import com.example.EMS.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public String createEmployee(Employee employee)
    {
        employeeRepository.save(employee);
        return "Employee Created Successfully";
    }

    @Override
    public Employee getEmployeeById(String employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public String updateEmployee(Employee updatedEmployee) {
        Employee E = employeeRepository.findById(updatedEmployee.getId()).get();
        E.setEmployeeName(updatedEmployee.getEmployeeName());
        E.setExperience(updatedEmployee.getExperience());
        E.setSalary(updatedEmployee.getSalary());
        employeeRepository.save(E);
        return "Employee Updated Successfully";
    }

    @Override
    public String deleteEmployeeById(String employeeId) {
        employeeRepository.deleteById(employeeId);
        return "Employee Removed";
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }
}
