package com.codewithmosh.mystore.repositories;

import com.codewithmosh.mystore.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}