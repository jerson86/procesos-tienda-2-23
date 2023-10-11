package com.procesos.tienda.repository;

import com.procesos.tienda.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address,Long> {
}
