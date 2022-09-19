package com.example.EMS.Repository;

import com.example.EMS.Model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface EmployeeRepository extends MongoRepository<Employee,String>
{

}
