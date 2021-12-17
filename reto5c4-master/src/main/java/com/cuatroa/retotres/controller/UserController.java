package com.cuatroa.retotres.controller;

import com.cuatroa.retotres.model.User;
import com.cuatroa.retotres.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    /**
     * Atributo de la clase de tipo UserService
     */
    private UserService userService;

    @GetMapping("/all")
    /**
     * Metodo que asociado al endpoint @GetMapping("/all"), optiene la lista de todos los usuarios de la DB
     * @return todos los usuarios de la DB
     */
    public List<User> getAll() {
        return userService.getAll();
    }
    
    @GetMapping("/{id}")
    /**
     * Metodo que asociado al endpoint  @GetMapping("/{id}"), optiene un usuario en particular según su id
     * @param id
     * @return Un usuario por su id
     */
    public Optional <User> getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    /**
     * Metodo que asociado al endpoint @PostMapping("/new"), crea un usuario en la DB
     * @param user
     * @return El usuario creado
     */
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    /**
     * Metodo que asociado al endpoint @PutMapping("/update"), actualiza un usuario en la DB
     * @param user
     * @return El usuario actualizado
     */
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    /**
     * Metodo que asociado al endpoint @DeleteMapping("/{id}"), borra un usuario de la DB
     * @param id
     * @return True si se borra el usuario, False si no se encuentra el usuario a borrar
     */
    public boolean delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }
    
    @GetMapping("/{email}/{password}")
    /**
     * Metodo que asociado al endpoint @GetMapping("/{email}/{password}"), verifica si el usuario
     * tiene una cuenta y si coinciden su email y su contraseña
     * @param email
     * @param password
     * @return El usuario autenticado correctamente
     */
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.authenticateUser(email, password);
    }
    
    @GetMapping("/emailexist/{email}")
    /**
     * Metodo que asociado al endpoint  @GetMapping("/emailexist/{email}"), verifica si el email
     * ingresado en el login existe en la colección de usuarios de la DB
     * @param email
     * @return True si el email existe, False si no esta registrado en la DB
     */
    public boolean emailExists(@PathVariable("email") String email) {
        return userService.emailExists(email);
    }
    @GetMapping("/birthday/{month}")
    public List<User> birthtDayList(@PathVariable("month") String monthBirthtDay) {
        return userService.birthtDayList(monthBirthtDay);
    }
}