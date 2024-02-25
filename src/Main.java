// Program TodoList
// Clean Architecture + Database + API
// Entities, Repositories, Service, View

import config.Database;
import repositories.TodolistDbRepositoryImpl;
import repositories.TodolistRepository;
import repositories.TodolistRepositoryImpl;
import service.TodolistService;
import service.TodolistServiceImpl;
import view.TodolistApiView;
import view.TodolistTerminalView;

public class Main {
    public static void main(String[] args) {
//        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
//        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
//        TodolistTerminalView todolistTerminalView = new TodolistTerminalView(todolistService);
//        todolistTerminalView.mainScrenn();

        Database database = new Database("root", "","localhost","3306", "final");
        database.setup();
        TodolistRepository todolistRepository =  new TodolistDbRepositoryImpl(database);
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
//        TodolistTerminalView todolistTerminalView = new TodolistTerminalView(todolistService);
//        todolistTerminalView.mainScrenn();
        TodolistApiView todolistApiView = new TodolistApiView("localhost", 8080, todolistService);
        todolistApiView.init();
    }
}