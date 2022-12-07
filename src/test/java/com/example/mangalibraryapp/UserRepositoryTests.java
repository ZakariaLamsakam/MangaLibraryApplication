package com.example.mangalibraryapp;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.mangalibraryapp.entity.User;
import com.example.mangalibraryapp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser(){

        User user = new User();
        user.setEmail("Lana@hotmail.com");
        user.setPassword("Lana1234");
        user.setFirstName("Lana");
        user.setLastName("Delacroix");

        User savedUser = repo.save(user);
        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());

    }
}
