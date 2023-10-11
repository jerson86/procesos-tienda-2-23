package com.procesos.tienda.controller;

import com.procesos.tienda.model.User;
import com.procesos.tienda.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("users")
    public ResponseEntity<User> create(@Valid @RequestBody User user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping("users/{id}")
    public ResponseEntity<User> update(@Valid @RequestBody User user, @PathVariable Long id){
        return new ResponseEntity<>(userService.updateUser(user,id),HttpStatus.OK);
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<String> delete( @PathVariable Long id){
        return new ResponseEntity(userService.deleteUser(id),HttpStatus.NO_CONTENT);
    }

    @GetMapping("users")
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
