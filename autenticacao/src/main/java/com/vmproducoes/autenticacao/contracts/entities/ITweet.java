package com.vmproducoes.autenticacao.contracts.entities;

import java.time.LocalDateTime;

public interface ITweet {
    Long getId();
    IUser getUser();
    String getContent();
    LocalDateTime getCreationTimestamp();
}
