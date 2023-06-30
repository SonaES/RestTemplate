package com.example.department.Controller;

import com.example.department.Model.Department;
import com.example.department.Repository.DeptRepo;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/DEPT")

public class deptcontroller {

    @Autowired
    private DeptRepo deptRepo;

    @PostMapping("/")
    public ResponseEntity<Department> createdept(@RequestBody Department department){
        return ResponseEntity.ok().body(deptRepo.save(department));
    }
    @GetMapping("/d")
    public  ResponseEntity<List<Department>> getall(){
        return ResponseEntity.ok().body(deptRepo.findAll());
    }
    @GetMapping("/de")
    public  ResponseEntity<Department>getByid(@PathVariable int deptid){
        Optional<Department>d=deptRepo.findBydeptId(deptid);
        if(d.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(d.get());
    }



}
