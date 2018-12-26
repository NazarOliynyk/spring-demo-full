package ua.com.owu.springdemofull.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.owu.springdemofull.models.Email;

public interface EmailDAO extends JpaRepository<Email, Integer> {
}
