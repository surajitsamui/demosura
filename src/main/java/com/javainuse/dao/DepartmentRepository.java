/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javainuse.dao;

/**
 *
 * @author surajit.samui
 */
import com.javainuse.model.Department;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.util.concurrent.ListenableFuture;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{
		
	public List<Department> findByName(String name);	
		
    @Async
    public Future<List<Department>> findAllByDeptid(Integer deptid);
    
    @Async
    public CompletableFuture<Department> findIgnoreCaseByName(String name);
   
    @Async
    public ListenableFuture<Department> findDeptById(Integer id);

}