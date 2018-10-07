package com.lewandowski.budget.service;

import com.lewandowski.budget.custom.exception.EmailExistsException;
import com.lewandowski.budget.dto.UserDto;
import com.lewandowski.budget.model.User;
import com.lewandowski.budget.model.VerificationToken;

public interface IUserService {
    User registerNewUserAccount(UserDto accountDto)
            throws EmailExistsException;

    void createVerificationToken(User user, String token);

    User getUser(String verificationToken);

    void saveRegisteredUser(User user);

    VerificationToken getVerificationToken(String VerificationToken);
}
