package com.capgemini.assignment6_ToDoList_04Mar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.assignment6_ToDoList_04Mar.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
