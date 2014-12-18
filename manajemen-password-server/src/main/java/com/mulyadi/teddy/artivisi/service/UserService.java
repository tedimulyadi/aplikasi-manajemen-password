package com.mulyadi.teddy.artivisi.service;

import com.mulyadi.teddy.artivisi.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author teddy
 */
@Repository
public interface UserService extends PagingAndSortingRepository<User, Long> {

    //method untuk mencari data user berdasarkan id user
    public User findByid(long id);

    public User findByUsername(String username);

    @Query("select u from User u where u.role.id = :idRole")
    public List<User> findByRole(@Param("idRole") Long idRole);

}
