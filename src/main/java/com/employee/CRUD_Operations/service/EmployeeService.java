package com.employee.CRUD_Operations.service;

import com.employee.CRUD_Operations.model.Employee;
import com.employee.CRUD_Operations.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo emprepo;
     public String addEmployee(Employee e){
         if(emprepo.findById(e.getId()).isPresent())
             return "exists";
        emprepo.save(e);
        return "added";
        // save is a inbuilt method by jpa repository

    }

     public boolean deleteEmployee(int id){
         if(emprepo.findById(id).isPresent()) {
             emprepo.deleteById(id);
             return true;
         }
         return false;
     }
      public Optional<Employee> findEmployeeById(int id){
        Optional<Employee> e=emprepo.findById(id);
        if(e.isPresent())
            return e;
        return e;
      }

      public List<Employee> findAll(){
         return emprepo.findAll();
     }

     public boolean updateEmployee(Employee e1,int id){
         Optional<Employee> optionalEmployee=emprepo.findById(id);
         if (optionalEmployee.isPresent()) {
           Employee e=optionalEmployee.get();
           e.setName(e1.getName());
           e.setCity(e1.getCity());
           e.setEmail(e1.getEmail());
           e.setDepartment(e1.getDepartment());
           emprepo.save(e);
             return true;
         }
         return false;

     }
}
