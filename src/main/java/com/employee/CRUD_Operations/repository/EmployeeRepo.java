package com.employee.CRUD_Operations.repository;

import com.employee.CRUD_Operations.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {


}
