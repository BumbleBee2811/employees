package com.home.employees.controller;

import com.home.employees.dao.EmployeeEntity;
import com.home.employees.dao.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This project is used to connect MS SQL Server from Spring Boot
 * Steps:
 * 1: Download Microsoft JDBC Driver 12.2 for SQL Server (zip) from https://learn.microsoft.com/en-us/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server?view=sql-server-ver15
 * 2: Unzip and copy mssql-jdbc_auth-12.2.0.x64.dll from the location sqljdbc_12.2.0.0_enu\sqljdbc_12.2\enu\auth\x64
 * 3: Paste it in C:\Program Files\Java\jdk1.8.0_333\bin and C:\Program Files\Java\jdk1.8.0_333\jre\lib
 */

@RestController
@RequestMapping(value = "/employee-service")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping(value = "/employees")
    public ResponseEntity<List<EmployeeEntity>> getEmployees() {
        return new ResponseEntity<>(employeeRepo.findAll(), HttpStatus.OK);
    }
}
