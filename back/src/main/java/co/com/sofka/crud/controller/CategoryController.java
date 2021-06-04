package co.com.sofka.crud.controller;

import co.com.sofka.crud.model.Category;
import co.com.sofka.crud.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

    @Autowired
    private CategoryService service;
    @GetMapping(value = "api/categories")
    public Iterable<Category> list(){
        return service.list();
    }

    @PostMapping(value = "api/category")
    public Category save(@RequestBody Category todo){
        return service.save(todo);
    }

    @PutMapping(value = "api/category")
    public Category update(@RequestBody Category todo){
        return service.save(todo);
    }

    @DeleteMapping(value = "api/{id}/category")
    public void delete(@PathVariable("id") Long id){
        service.delete(get(id));
    }

    @GetMapping(value = "api/{id}/category")
    public Long get(@PathVariable("id") Long id){
        return service.get(id).getId_category();
    }
}
