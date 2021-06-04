package co.com.sofka.crud.service;

import co.com.sofka.crud.model.Category;
import co.com.sofka.crud.model.Todo;
import co.com.sofka.crud.repository.CategoryRepository;
import co.com.sofka.crud.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Iterable<Category> list(){
        return repository.findAll();
    }

    public Category save(Category category){
        return repository.save(category);
    }

    public Category update(Category category){
        return repository.save(category);
    }

    public void delete(Long id){
        repository.delete(get(id));
    }

    public Category get(Long id){
        return repository.findById(id).orElseThrow();
    }
}
