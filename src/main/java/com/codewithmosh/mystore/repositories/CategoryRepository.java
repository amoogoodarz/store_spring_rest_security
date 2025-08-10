package com.codewithmosh.mystore.repositories;

import com.codewithmosh.mystore.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}