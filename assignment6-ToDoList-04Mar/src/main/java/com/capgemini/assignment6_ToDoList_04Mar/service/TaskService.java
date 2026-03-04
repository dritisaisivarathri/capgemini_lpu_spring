package com.capgemini.assignment6_ToDoList_04Mar.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.capgemini.assignment6_ToDoList_04Mar.entity.Task;

public interface TaskService {
	
	List<Task> getAllTasks();

    void saveTask(Task task, MultipartFile file);

    void toggleStatus(Long id);

    void deleteTask(Long id);

    Task getTask(Long id);

}
