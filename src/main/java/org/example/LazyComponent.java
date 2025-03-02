package org.example;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class LazyComponent {
    public LazyComponent() {
        System.out.println("LazyComponent создан!");
    }

    public void doSomething() {
        System.out.println("Lazy компонент работает!");
    }
}
