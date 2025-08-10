package com.amoogoodarz.store.repositories;

import com.amoogoodarz.store.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}