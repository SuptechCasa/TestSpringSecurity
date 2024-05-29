package ecole.suptech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import ecole.suptech.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
public UserDetails findByUsername(String username);
}
