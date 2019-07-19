/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javainuse.service;

/**
 *
 * @author surajit.samui
 */
import com.javainuse.model.Department;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import org.springframework.util.concurrent.ListenableFuture;

public interface DepartmentService {
	
   public List<Department> findAllDeptList();
   public Department findAllDeptById(Integer id);
   public List<Department> findAllByDeptName(String name);
    
   public Future<List<Department>> findAllByDeptId(Integer deptId);
   public CompletableFuture<Department> findAllFirstByNameIgnoreCase(String name);
   public ListenableFuture<Department> findAllFirstById(Integer id);  
}