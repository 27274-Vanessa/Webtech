package com.example.question5_taskmanagement_api.controller;

import com.example.question5_taskmanagement_api.model.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private List<Task> tasks = new ArrayList<>();

    public TaskController() {
        tasks.add(new Task(1L, "Finish assignment", "Complete REST API assignment", false, "HIGH", "2026-02-15"));
        tasks.add(new Task(2L, "Study Java", "Revise Spring Boot basics", true, "MEDIUM", "2026-02-10"));
        tasks.add(new Task(3L, "Buy groceries", "Milk, bread, eggs", false, "LOW", "2026-02-12"));
        tasks.add(new Task(4L, "Project meeting", "Team discussion", false, "HIGH", "2026-02-11"));
        tasks.add(new Task(5L, "Workout", "Evening exercise", true, "MEDIUM", "2026-02-09"));
    }

    // GET /api/tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return tasks;
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long taskId) {
        return tasks.stream()
                .filter(t -> t.getTaskId().equals(taskId))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/status")
    public List<Task> getByStatus(@RequestParam boolean completed) {
        return tasks.stream()
                .filter(t -> t.isCompleted() == completed)
                .collect(Collectors.toList());
    }

    @GetMapping("/priority/{priority}")
    public List<Task> getByPriority(@PathVariable String priority) {
        return tasks.stream()
                .filter(t -> t.getPriority().equalsIgnoreCase(priority))
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        tasks.add(task);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(
            @PathVariable Long taskId,
            @RequestBody Task updatedTask) {

        for (Task t : tasks) {
            if (t.getTaskId().equals(taskId)) {
                t.setTitle(updatedTask.getTitle());
                t.setDescription(updatedTask.getDescription());
                t.setPriority(updatedTask.getPriority());
                t.setDueDate(updatedTask.getDueDate());
                t.setCompleted(updatedTask.isCompleted());
                return ResponseEntity.ok(t);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{taskId}/complete")
    public ResponseEntity<Task> markCompleted(@PathVariable Long taskId) {
        for (Task t : tasks) {
            if (t.getTaskId().equals(taskId)) {
                t.setCompleted(true);
                return ResponseEntity.ok(t);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable Long taskId) {
        tasks.removeIf(t -> t.getTaskId().equals(taskId));
        return ResponseEntity.ok("Task deleted");
    }
}
