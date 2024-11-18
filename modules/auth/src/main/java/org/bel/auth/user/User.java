package org.bel.auth.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "\"user\"")

public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        public UUID id;

        @Column(unique = true, nullable = false)
        private String username;

        @Column(nullable = true)
        private String password;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private Role role;


}
