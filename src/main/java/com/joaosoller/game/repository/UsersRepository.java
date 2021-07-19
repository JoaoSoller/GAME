package com.joaosoller.game.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.joaosoller.game.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
