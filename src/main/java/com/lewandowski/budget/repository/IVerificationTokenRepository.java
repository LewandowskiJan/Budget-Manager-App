package com.lewandowski.budget.repository;

import com.lewandowski.budget.model.User;
import com.lewandowski.budget.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

    VerificationToken findByToken(String token);

    VerificationToken findByUser(User user);
}
