package com.lewandowski.budget.security;

public interface ISecurityUserService {

    String validatePasswordResetToken(long id, String token);

}