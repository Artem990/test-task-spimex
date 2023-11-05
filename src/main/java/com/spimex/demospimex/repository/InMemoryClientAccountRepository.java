package com.spimex.demospimex.repository;

import com.spimex.demospimex.models.ClientAccount;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class InMemoryClientAccountRepository implements ClientAccountRepository {
    private final Map<Integer, ClientAccount> accounts = new ConcurrentHashMap<>();

    private static final int ACCOUNT_ID = 1;

    // добавим дефолтного пользователя
    {
        accounts.put(ACCOUNT_ID, new ClientAccount(5000, 0));
    }

    @Override
        public ClientAccount findById(int id) {
        return accounts.get(id);
    }

    @Override
    public void save(ClientAccount clientAccount) {
        accounts.put(ACCOUNT_ID, clientAccount);
    }
}