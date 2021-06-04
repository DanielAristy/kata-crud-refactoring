package co.com.sofka.crud.model;

import javax.persistence.*;

@Entity
public class Todo {
    @Id
    @GeneratedValue
    private Long id_todo;
    private String name;
    private boolean completed;
//    @ManyToOne
//    @JoinColumn(name = "id_category", insertable = false, updatable = false)
    private Long category;

    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    public void setId_todo(Long id) {
        this.id_todo = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId_todo() {
        return id_todo;
    }
}
