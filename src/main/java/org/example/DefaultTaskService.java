package org.example;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class DefaultTaskService implements TaskService {
    private final TaskRepository taskRepository;

    public DefaultTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void addTask(String title) {
        taskRepository.addTask(new Task(title, false));
        System.out.println("Добавлена обычная задача: " + title);
    }

    @Override
    public void showTasks() {
        taskRepository.getAllTasks().forEach(System.out::println);
    }

    @Override
    public void removeTask(String title) {
        taskRepository.removeTask(title);
        System.out.println("Удалена обычная задача: " + title);
    }
}
