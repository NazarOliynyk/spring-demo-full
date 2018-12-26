package ua.com.owu.springdemofull.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.owu.springdemofull.models.User;

public interface UserDAO extends JpaRepository<User, Integer> {

    //CRUD create, read, update, deleate
}
