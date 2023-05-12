package com.example.tpcarnet;

import com.example.tpcarnet.entity.Contact;
import com.example.tpcarnet.entity.Role;
import com.example.tpcarnet.entity.User;
import com.example.tpcarnet.repository.RoleRepository;
import com.example.tpcarnet.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class TpCarnetApplication implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public static void main(String[] args) {

        SpringApplication.run(TpCarnetApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        User user1 = new User("cherni@gmail.com", passwordEncoder.encode("qwerty"));
        Contact c1 = new Contact("firstname1", "lastname1");
        c1.setUser(user1);

        user1.getContactList().add(c1);
        Contact c2 = new Contact("firstname2", "lastname2");
        c2.setUser(user1);
        user1.getContactList().add(c2);

        user1.setRoleList(Arrays.asList(new Role("user")));
        userRepository.save(user1);

        User user2 = new User("amina@gmail.com", passwordEncoder.encode("qwerty"));
        Contact c3 = new Contact("firstname3", "lastname3");
        user2.getContactList().add(c3);
        c3.setUser(user2);

        Contact c4 = new Contact("firstname4", "lastname4");
        c4.setUser(user2);
        user2.getContactList().add(c4);
        user2.setRoleList(Arrays.asList(new Role("admin")));
        userRepository.save(user2);




    }

}
