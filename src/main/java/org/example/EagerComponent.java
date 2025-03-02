package org.example;

import org.springframework.stereotype.Component;

@Component
public class EagerComponent {
    public EagerComponent() {
        System.out.println("EagerComponent создан!");
    }

    public void doSomething() {
        System.out.println("Eager компонент работает!");
    }
}
