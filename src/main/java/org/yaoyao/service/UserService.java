package org.yaoyao.service;

import org.yaoyao.entity.User;

public interface UserService {
    boolean addUser(User user);

    User getUserById(String userId);
}
