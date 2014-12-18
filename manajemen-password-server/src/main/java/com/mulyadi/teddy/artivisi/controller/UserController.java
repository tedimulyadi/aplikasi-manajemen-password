package com.mulyadi.teddy.artivisi.controller;

import com.mulyadi.teddy.artivisi.model.User;
import com.mulyadi.teddy.artivisi.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author teddy
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Iterable<User> tampilkanSemuaUser() {
        return userService.findAll();
    }
//    
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
//    public User viewUserById(@PathVariable Long id){
//        return userService.findOne(id);
//    }
//
//    @RequestMapping(value = "/user/{roleId}", method = RequestMethod.GET)
//    public List<User> viewUserByIdRole(@PathVariable Long roleId) {
//        return userService.findByRole(roleId);
//    }
//
//    @RequestMapping(value = "/user/", method = RequestMethod.POST)
//    public void simpanUser(@RequestBody User user) throws Exception {
//        if (user == null) {
//            throw new Exception("User tidak boleh kosong");
//        }
//
//        userService.save(user);
//    }
//    

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public void hapusUser(@PathVariable(value = "id") Long id) throws Exception {
        if (id == null) {
            throw new Exception("id tidak boleh kosong atau null");
        }

        User user = userService.findOne(id);
        if (user == null) {
            throw new Exception("User tidak ditemukan");
        }

        userService.delete(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public void ubahUser(@PathVariable Long id, @RequestBody User u) throws Exception {
        User user = userService.findOne(id);
        if (user == null) {
            throw new Exception("User tidak ditemukan");
        }

        u.setId(user.getId());
        userService.save(u);
    }
}
