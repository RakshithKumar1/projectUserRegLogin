package com.dxc.project.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxc.project.model.*;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	Optional<User> findByUserNameAndPassword(String username,String password);

}
