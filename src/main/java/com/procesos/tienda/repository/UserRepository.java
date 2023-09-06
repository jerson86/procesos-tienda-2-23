package com.procesos.tienda.repository;

import com.procesos.tienda.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
