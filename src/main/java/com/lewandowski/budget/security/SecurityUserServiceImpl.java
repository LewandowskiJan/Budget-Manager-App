package com.lewandowski.budget.security;

import com.lewandowski.budget.persistence.model.PasswordResetToken;
import com.lewandowski.budget.persistence.model.User;
import com.lewandowski.budget.persistence.repository.IPasswordResetTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Calendar;

@Service
@Transactional
public class SecurityUserServiceImpl implements ISecurityUserService {

    @Autowired
    private final IPasswordResetTokenRepository passwordTokenRepository;

    @Autowired
    public SecurityUserServiceImpl(IPasswordResetTokenRepository passwordTokenRepository) {
        this.passwordTokenRepository = passwordTokenRepository;
    }

    // API

    @Override
    public String validatePasswordResetToken(long id, String token) {
        final PasswordResetToken passToken = passwordTokenRepository.findByToken(token);
        if ((passToken == null) || (passToken.getUser().getId() != id)) {
            return "invalidToken";
        }

        final Calendar cal = Calendar.getInstance();
        if ((passToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            return "expired";
        }

        final User user = passToken.getUser();
        final Authentication auth = new UsernamePasswordAuthenticationToken(user, null, Arrays.asList(new SimpleGrantedAuthority("CHANGE_PASSWORD_PRIVILEGE")));
        SecurityContextHolder.getContext().setAuthentication(auth);
        return null;
    }

}

