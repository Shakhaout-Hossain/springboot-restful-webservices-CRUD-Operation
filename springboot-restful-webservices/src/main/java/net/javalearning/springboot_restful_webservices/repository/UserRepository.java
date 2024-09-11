package net.javalearning.springboot_restful_webservices.repository;

import net.javalearning.springboot_restful_webservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
