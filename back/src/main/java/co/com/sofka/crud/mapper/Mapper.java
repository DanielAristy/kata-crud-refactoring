package co.com.sofka.crud.mapper;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.model.Todo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

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
        todoDto.setId(todo.getId_todo());
        todoDto.setName(todo.getName());
        todoDto.setCompleted(todo.isCompleted());
        todoDto.setCategory(todo.getCategory());
        return todoDto;
    }

    public Todo convertToEntity(TodoDto todoDto){
        Todo todo = mapper.map(todoDto, Todo.class);

        if (todoDto.getId() != null){
            todo.setId_todo(todoDto.getId());
            todo.setName(todoDto.getName());
            todo.setCompleted(todoDto.isCompleted());
            todo.setCategory(todoDto.getCategory());
        }
        return todo;
    }
}
