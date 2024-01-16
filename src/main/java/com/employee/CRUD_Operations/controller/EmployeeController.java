package com.employee.CRUD_Operations.controller;

import com.employee.CRUD_Operations.model.Employee;
import com.employee.CRUD_Operations.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

  @GetMapping("/home")
  public String homePage(){
     return "Welcome";
  }


  @PostMapping("/add")
  public ResponseEntity<String> addEmployee(@RequestBody Employee e){
      String res=employeeService.addEmployee(e);
      if(res.equals("added"))
      return new ResponseEntity<String>("Employee added successfully",HttpStatus.CREATED);
      else
          return new ResponseEntity<String>("Employee already exists",HttpStatus.BAD_REQUEST);

   }

   @GetMapping("findBy/{id}")
    public ResponseEntity<Optional<Employee>> findEmployeeById(@PathVariable int id){
       Optional<Employee> e=employeeService.findEmployeeById(id);
       if(e.isPresent()){
           return new ResponseEntity<Optional<Employee>>(e,HttpStatus.FOUND);
       }
       return new ResponseEntity<Optional<Employee>>(e,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable int id){
       boolean status=employeeService.deleteEmployee(id);
       if(status)
           return new ResponseEntity<String>("Employee deleted successfully",HttpStatus.ACCEPTED);
        return new ResponseEntity<String>("Employee not found",HttpStatus.BAD_REQUEST);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee e,@PathVariable int id){
          boolean status=employeeService.updateEmployee(e,id);
        if(status)
            return new ResponseEntity<String>("Employee updated successfully",HttpStatus.ACCEPTED);
        return new ResponseEntity<String>("Employee not found",HttpStatus.BAD_REQUEST);


    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Employee>> findAll(){
       List<Employee> data=employeeService.findAll();
       return new ResponseEntity<>(data,HttpStatus.FOUND);
    }


}
