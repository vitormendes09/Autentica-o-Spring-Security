package com.vmproducoes.autenticacao.domain.entities;
import com.vmproducoes.autenticacao.contracts.entities.ITweet;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tweets")
public class Tweet implements ITweet {
    

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "tweet_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    private String content;


    @CreationTimestamp
    private LocalDateTime creationTimestamp;

    public Tweet() {}

    public Tweet(User user, String content) {
        this.user = user;
        this.content = content;
    }

    // Implementação dos métodos da interface
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public LocalDateTime getCreationTimestamp() {
        return creationTimestamp;
    }

    // Setters opcionais
    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreationTimestamp(LocalDateTime creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }
}
