package com.batdev.eticaret.app.ticaret.repository;

import com.batdev.eticaret.app.ticaret.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
