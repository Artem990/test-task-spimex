package com.spimex.demospimex.repository;

import com.spimex.demospimex.models.ClientAccount;

public interface ClientAccountRepository {
    ClientAccount findById(int id);
    void save(ClientAccount clientAccount);

}
