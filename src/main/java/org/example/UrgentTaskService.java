package org.example;

import org.springframework.stereotype.Service;

@Service("urgent")
public class UrgentTaskService implements TaskService {
    private final TaskRepository taskRepository;

    public UrgentTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void addTask(String title) {
        taskRepository.addTask(new Task(title, true));
        System.out.println("Срочная задача добавлена: " + title);
    }

    @Override
    public void showTasks() {
        taskRepository.getAllTasks().forEach(System.out::println);
    }

    @Override
    public void removeTask(String title) {
        taskRepository.removeTask(title);
        System.out.println("Срочная задача удалена: " + title);
    }
}
