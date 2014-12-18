package com.mulyadi.teddy.artivisi.test;

import com.mulyadi.teddy.artivisi.App;
import com.mulyadi.teddy.artivisi.model.User;
import com.mulyadi.teddy.artivisi.service.UserService;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author teddy
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;
    
//    @Test
//    public void findUserByRoleId(){
//        List<User> users = userService.findByRole("1");
//        System.out.println("jumlah data user : "+users.size());
//        
//        for (User user : users){
//            System.out.println("Nama "+user.getRole().getAlamat());
//        }
//    }
    
    

    public void findById() {
        User users = userService.findByid(1);
        if (users != null) {
            System.out.println("ketemu");
        }
    }
    public void countUser() {
        long count = userService.count();
        System.out.println("jumlah : " + count);
    }
//    @Test
    public void findUserByUsername() {
        User users = userService.findByUsername("tedimulyadi");
        if (users != null) {
            System.out.println("user ketemu");
        } else {
            System.out.println("tidak ditemukan");
        }
    }
}
