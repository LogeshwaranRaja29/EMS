package com.example.EMS.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@NoArgsConstructor
@Document(collection = "EmployeeDb")
public class Employee {
    @Id
    String id;

    String employeeName;
    Double Salary;
    int experience;

    public Employee(String employeeName, Double Salary, int experience) {
        this.employeeName = employeeName;
        this.Salary = Salary;
        this.experience = experience;
    }
}
