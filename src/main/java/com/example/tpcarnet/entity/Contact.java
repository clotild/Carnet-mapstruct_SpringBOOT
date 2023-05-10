package com.example.tpcarnet.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private String firstname;
    @NonNull
    private String lastname;
    @ManyToOne
    @JoinColumn(name = "user_fk")
    private User user;
    @OneToMany(mappedBy = "contact")
    private List<Email> email;
}
