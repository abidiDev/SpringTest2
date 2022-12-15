package com.example.testt.controllers;

import com.example.testt.entities.User;
import com.example.testt.services.Iservice;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("controller")
@RestController
@AllArgsConstructor

public class Controller {
    Iservice iservice;

    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return  iservice.getAllUsers();
    }

    @PostMapping("/add")
    @ResponseBody
    public User addUser(@RequestBody User c){
        return iservice.addUser(c);
    }
    @PutMapping("/update")
    @ResponseBody
    public User updateUser(@RequestBody User c){
        return  iservice.updateUser(c);
    }

    @DeleteMapping("/delete/{id}")
    public void getUser(@PathVariable Integer id) {
        iservice.deleteDetailUser(id);
    }
}
