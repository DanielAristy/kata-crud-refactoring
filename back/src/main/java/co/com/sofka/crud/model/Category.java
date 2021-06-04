package co.com.sofka.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private Long id_category;
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Todo> todos;

    public Long getId_category() {
        return id_category;
    }

    public void setId_category(Long id) {
        this.id_category = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }
}
