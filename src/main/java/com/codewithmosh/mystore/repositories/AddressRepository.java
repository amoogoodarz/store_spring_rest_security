package com.codewithmosh.mystore.repositories;

import com.codewithmosh.mystore.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}