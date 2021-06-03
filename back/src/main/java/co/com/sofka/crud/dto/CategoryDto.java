package co.com.sofka.crud.dto;

import java.util.List;

public class CategoryDto {

    private Long id;
    private String name;
    private List<TodoDto> todos;

    public List<TodoDto> getTodos() {
        return todos;
    }

    public void setTodos(List<TodoDto> todos) {
        this.todos = todos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
