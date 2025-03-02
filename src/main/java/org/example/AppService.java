package org.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class AppService {
    private final TaskService defaultTaskService;
    private final TaskService urgentTaskService;
    private final Scanner scanner = new Scanner(System.in);

    @Autowired
    public AppService(TaskService defaultTaskService, @Qualifier("urgent") TaskService urgentTaskService) {
        this.defaultTaskService = defaultTaskService;
        this.urgentTaskService = urgentTaskService;
    }

    public void run() {
        while (true) {
            System.out.println("\nМенеджер задач:");
            System.out.println("1) Добавить обычную задачу");
            System.out.println("2) Добавить срочную задачу");
            System.out.println("3) Показать задачи");
            System.out.println("4) Удалить задачу");
            System.out.println("5) Выйти");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTask(false);
                    break;
                case 2:
                    addTask(true);
                    break;
                case 3:
                    showTasks();
                    break;
                case 4:
                    removeTask();
                    break;
                case 5:
                    System.out.println("Выход...");
                    return;
                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }

    private void addTask(boolean urgent) {
        System.out.print("Введите название задачи: ");
        String title = scanner.nextLine();

        if (urgent) {
            urgentTaskService.addTask(title);
        } else {
            defaultTaskService.addTask(title);
        }
    }

    private void showTasks() {
        System.out.println("\nСписок задач:");
        defaultTaskService.showTasks();
    }

    private void removeTask() {
        System.out.print("Введите название задачи для удаления: ");
        String title = scanner.nextLine();
        defaultTaskService.removeTask(title);
        urgentTaskService.removeTask(title);
    }
}
