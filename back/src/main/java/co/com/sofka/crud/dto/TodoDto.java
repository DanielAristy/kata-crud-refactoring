package co.com.sofka.crud.dto;

import co.com.sofka.crud.model.Todo;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;

import java.io.Serializable;

public class TodoDto implements Serializable {
    private Long id;
    private String name;
    private boolean completed;
    private Long category;

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return StringUtils.defaultString(name);
    }

    public void setName(String name) {
        this.name = name;
    }
    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}
