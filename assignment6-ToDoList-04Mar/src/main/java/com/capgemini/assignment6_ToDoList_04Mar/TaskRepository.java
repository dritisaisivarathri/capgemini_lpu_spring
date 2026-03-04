package com.capgemini.assignment6_ToDoList_04Mar;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
