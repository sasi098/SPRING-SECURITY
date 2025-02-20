package com.example.SECURITY.DATAREST.REPOSITORY;


import com.example.SECURITY.DATAREST.ENTITY.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employeerepo extends JpaRepository <Employee , Integer> {
}//TAKES ENTITY NAME AND PRIMARY KEY
