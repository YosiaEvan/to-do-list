package entities;

public class Todolist {
    private String todo;
    private Integer id;

    public Todolist(String todo) {
        this.todo = todo;
    }

    public Todolist() {
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
