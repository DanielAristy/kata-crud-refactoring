package co.com.sofka.crud.controller;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.model.Todo;
import co.com.sofka.crud.service.TodoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping(value = "api/todos")
    public Iterable<TodoDto> list(){
        List<Todo> todos = (List<Todo>) service.list();
        return todos.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    
    @PostMapping(value = "api/todo")
    public TodoDto save(@RequestBody TodoDto todoDto){
        Todo todo = convertToEntity(todoDto);
        Todo todoCreate = service.save(todo);
        return convertToDto(todoCreate);
    }

    @PutMapping(value = "api/todo")
    public TodoDto update(@RequestBody TodoDto todoDto){
        Todo todo = convertToEntity(todoDto);
        if(todoDto.getId() != null){
            Todo todoUpdate = service.update(todo);
            return convertToDto(todoUpdate);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }

    @DeleteMapping(value = "api/{id}/todo")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "api/{id}/todo")
    public Todo get(@PathVariable("id") Long id){
        return service.get(id);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    private TodoDto convertToDto(Todo todo){
        TodoDto todoDto = mapper.map(todo, TodoDto.class);
        todoDto.setId(todo.getId());
        todoDto.setName(todo.getName());
        todoDto.setCompleted(todo.isCompleted());
        return todoDto;
    }

    private Todo convertToEntity(TodoDto todoDto){
        Todo todo = mapper.map(todoDto, Todo.class);

        if (todoDto.getId() != null){
            todo.setId(todo.getId());
            todo.setName(todo.getName());
            todo.setCompleted(todo.isCompleted());
        }
        return todo;
    }

}
