package ua.training.services;


public interface SecurityService {
    String findLoggedInEmail();

    void autoLoginAfterReg(String username, String password);
}
