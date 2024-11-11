package com.java.crud.service;

import com.java.crud.dto.UserData;

public interface UserService {

    UserData getUserById(Long userId);

    UserData saveUser(UserData userData);

    UserData updateUser(Long id, UserData userData) throws Exception;

    void deleteUser(Long id) throws Exception;

}
