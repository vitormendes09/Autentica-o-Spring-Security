package com.vmproducoes.autenticacao.domain.entities;
import com.vmproducoes.autenticacao.contracts.entities.IUser;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.Set;


@Entity
@Table(name = "users")
public class User implements IUser {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID userid;

    @Column(unique = true, nullable = false)
    private String username;
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = jakarta.persistence.FetchType.EAGER)
    @JoinTable(
        name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

      // Construtores
    public User() {}

    public User(UUID id, String username, String password, Set<Role> roles) {
        this.userid = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    // Getters da interface
    @Override
    public UUID getId() {
        return userid;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

   

}
