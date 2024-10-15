package com.nt.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nt.Entity.Task;
import com.nt.service.TaskService;

@RestController
@RequestMapping("/api/tasks") // in postman - http://localhost:8080/api/tasks
public class TaskController {

	@Autowired
	private TaskService taskService;

	@GetMapping
	public List<Task> getAllTasks() {
		return taskService.getAllTasks();
	}

	@PostMapping
	public ResponseEntity<Task> createTask(@RequestBody Task task) {
		return new ResponseEntity<>(taskService.createTask(task), HttpStatus.CREATED);
		// use in postman -postrequest
		/*
		 * { "title": "New Task",
		 *  "description": "This is a new task", 
		 *  "isCompleted": false }
		 */
	}

	@PutMapping("/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
		return new ResponseEntity<>(taskService.updateTask(id, task), HttpStatus.OK);
		// put request in postman
		/*
		 * { "title": "Updated Task", "description": "This task has been updated",
		 * "isCompleted": true }
		 */
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
		taskService.deleteTask(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
