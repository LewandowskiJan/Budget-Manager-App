package com.lewandowski.budget.persistence.repository;

import com.lewandowski.budget.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long > {

    User findByFirstName( String name );

    User findByEmail(String email);

}
