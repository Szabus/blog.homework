package com.example.blog.homework.controllers;

import com.example.blog.homework.models.Blog;
import com.example.blog.homework.models.BlogUser;
import com.example.blog.homework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(value = {"/", "/home"})
    public String getHome() {
        return "Welcome Home";
    }

    @GetMapping("/user")
    public BlogUser getLoggedInUser() {
        return service.getLoggedInUser();
    }

    // csak admin
    @GetMapping("/users")
    public List<BlogUser> getAllUsers() {
        return service.getAllUsers();
    }

    // akár user, akár admin
    // ezt is csak admin
    @GetMapping(value = {"/users/", "/users/{username}"})
    public BlogUser getOneUser(
            @PathVariable("username") String username
    ) {
        if (username != null) {
            return service.getOneUser(username);
        }
        return null;
    }

    @GetMapping("/register")
    public String registerUser() {
        boolean registered = service.registerUsers();
        if (registered) {
            return "ok";
        }
        return "not ok";
    }

    /*
    * /users
method: GET
feladat: visszaadja az összes felhasználót az adatbázisból
/users/{id}
method: GET
@PathVariable Long id
feladat: visszaadja az adott id-jű felhasználót adatbázisból
megjegyzés: ha nincs szám típusú id-ja a felhasználóidnak, akkor ebben az endpoint-ban lecserélhető a Long id arra az adattípusra, amilyen PRIMARY KEY-t használsz
/user
method: GET
feladat: visszaadja a bejelentkezett felhasználót
/register
method: POST
@RequestBody User user
feladat: új felhasználót rögzít az adatbázisba
megjegyzés: a User típus nem kötelező - a saját felhasználói típusodat használd
*/

}