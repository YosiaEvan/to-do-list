package service;

import entities.Todolist;
import repositories.TodolistRepository;

import java.util.Objects;

public class TodolistServiceImpl implements TodolistService {
    private final TodolistRepository todolistRepository;

    public TodolistServiceImpl(TodolistRepository todolistRepository) {
        this.todolistRepository = todolistRepository;
    }

    @Override
    public Todolist[] getTodolist() {
        return todolistRepository.getAll();
    }

    @Override
    public void addTodolist(Todolist todolist) {
        if(Objects.isNull(todolist)){
            System.out.println("Todo list is null, please make sure todo is not null");
            return;
        }
        todolistRepository.add(todolist);
    }

    @Override
    public boolean removeTodolist(Integer number, Boolean isNumberId) {
        if (number < 0) {
            System.out.println("please input number correctly");
            return false;
        }
        return todolistRepository.remove(number, isNumberId);
    }
}
