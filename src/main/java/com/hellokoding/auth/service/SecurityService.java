package com.hellokoding.auth.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String firstname, String password);
}
