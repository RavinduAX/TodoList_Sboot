package lk.ravax.backend.dto;

public class TodoDto {
    private String id;
    private String todo;

    public TodoDto() {
    }

    public TodoDto(String id, String todo) {
        this.id = id;
        this.todo = todo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }
}
