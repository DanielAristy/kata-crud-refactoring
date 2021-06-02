package co.com.sofka.crud.dto;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class TodoDTO implements Serializable {
    private Long id;
    private String name;
    private boolean completed;
    private String groupListId;

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

    public String getGroupListId() {
        return groupListId;
    }

    public void setGroupListId(String groupListId) {
        this.groupListId = groupListId;
    }
}