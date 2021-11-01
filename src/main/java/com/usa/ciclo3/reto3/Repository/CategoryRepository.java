package com.usa.ciclo3.reto3.Repository;


import com.usa.ciclo3.reto3.Interface.InterfaceCategory;
import com.usa.ciclo3.reto3.Model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    private InterfaceCategory interfaceCategory;

    public List<Category> getAllCategory(){
        return (List<Category>) interfaceCategory.findAll();
    }

    public Optional<Category> getCategory(int id){
        return interfaceCategory.findById(id);
    }
    public Category save(Category category){
        return interfaceCategory.save(category);
    }

    public void delete(Category category){
        interfaceCategory.delete (category);
    }
}



