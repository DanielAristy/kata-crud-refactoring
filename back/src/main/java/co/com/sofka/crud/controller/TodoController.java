package co.com.sofka.crud.controller;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.mapper.Mapper;
import co.com.sofka.crud.model.Todo;
import co.com.sofka.crud.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService service;

    @Autowired
    private Mapper mapper;

    @GetMapping(value = "api/todos")
    public Iterable<TodoDto> list(){

        List<Todo> todos = (List<Todo>) service.list();
        return todos.stream().map(dto ->
                mapper.convertToDto(dto)
        ).collect(Collectors.toList());
    }
    
    @PostMapping(value = "api/todo")
    public TodoDto save(@RequestBody TodoDto todoDto){
        Todo todo = mapper.convertToEntity(todoDto);
        Todo todoCreate = service.save(todo);
        return mapper.convertToDto(todoCreate);
    }

    @PutMapping(value = "api/todo")
    public TodoDto update(@RequestBody TodoDto todoDto){
        Todo todo = mapper.convertToEntity(todoDto);
        if(todoDto.getId() != null){
            Todo todoUpdate = service.update(todo);
            return mapper.convertToDto(todoUpdate);
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
}
