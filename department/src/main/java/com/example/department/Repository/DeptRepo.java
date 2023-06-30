package com.example.department.Repository;

import com.example.department.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeptRepo extends JpaRepository<Department, Integer> {
    Optional<Department> findBydeptId(int deptid);
}
