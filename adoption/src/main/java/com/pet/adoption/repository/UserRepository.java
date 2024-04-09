package com.pet.adoption.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pet.adoption.model.User;
public interface UserRepository extends JpaRepository<User, String> {

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
    void deleteByEmail(String email);

}
