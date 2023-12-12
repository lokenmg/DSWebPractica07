/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package org.uv.DSWeb_Practica07;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/User")
public class ControllerUser {
    
    @Autowired
    private RepositoryUser repositoryUser;
    
    @PostMapping
    public ResponseEntity<User> post(@RequestBody User user) {
        User userNew=repositoryUser.save(user);
        return ResponseEntity.ok(userNew);
    }
    
    @GetMapping()
    public List<User> list() {
        List<User> lstUser=repositoryUser.findAll();
        return lstUser;
    }
    
    @GetMapping("/{id}")
    public User get(@PathVariable long id) {
        User user=new User("loken","12345");

        return user;
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
        return null;
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }
    
   // 
}
