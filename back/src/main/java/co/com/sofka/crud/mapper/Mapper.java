package co.com.sofka.crud.mapper;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.model.Todo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mapper {
    @Autowired
    private ModelMapper mapper;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    public TodoDto convertToDto(Todo todo){
        TodoDto todoDto = mapper.map(todo, TodoDto.class);
        todoDto.setId(todo.getId());
        todoDto.setName(todo.getName());
        todoDto.setCompleted(todo.isCompleted());
        return todoDto;
    }

    public Todo convertToEntity(TodoDto todoDto){
        Todo todo = mapper.map(todoDto, Todo.class);

        if (todoDto.getId() != null){
            todo.setId(todo.getId());
            todo.setName(todo.getName());
            todo.setCompleted(todo.isCompleted());
        }
        return todo;
    }
}
