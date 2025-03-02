package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Scanner scanner = new Scanner(System.in);
        TaskService taskService = context.getBean(TaskService.class); // Используется DefaultTaskService

        while (true) {
            System.out.println("\nМенеджер задач:");
            System.out.println("1) Добавить задачу");
            System.out.println("2) Показать задачи");
            System.out.println("3) Удалить задачу");
            System.out.println("4) Выйти");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите название задачи: ");
                    String title = scanner.nextLine();
                    taskService.addTask(title);
                    break;
                case 2:
                    taskService.showTasks();
                    break;
                case 3:
                    System.out.print("Введите название задачи для удаления: ");
                    String removeTitle = scanner.nextLine();
                    taskService.removeTask(removeTitle);
                    break;
                case 4:
                    System.out.println("Выход...");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}