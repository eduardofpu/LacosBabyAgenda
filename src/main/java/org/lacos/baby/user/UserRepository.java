package org.lacos.baby.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	public UserEntity findByEmail(String email);
	public UserEntity findByEmailAndPassword(String email,String password);
	public List<UserEntity> findById(Long user);

}
