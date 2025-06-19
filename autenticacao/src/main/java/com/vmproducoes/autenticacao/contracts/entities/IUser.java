
package com.vmproducoes.autenticacao.contracts.entities;


import java.util.UUID;

public interface IUser {
    UUID getId();
    String getUsername();
    String getPassword();
    
}
