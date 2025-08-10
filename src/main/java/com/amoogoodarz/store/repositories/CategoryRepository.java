package com.amoogoodarz.store.repositories;

import com.amoogoodarz.store.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}