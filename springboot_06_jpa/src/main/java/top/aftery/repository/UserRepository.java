package top.aftery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.aftery.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
}
