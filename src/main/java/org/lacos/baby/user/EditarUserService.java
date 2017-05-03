package org.lacos.baby.user;

import java.util.List;

import org.lacos.baby.security.CurrentUser;
import org.lacos.baby.utils.GenericService;
import org.lacos.baby.utils.ServicePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ServicePath.EDITUSER_PATH)
public class EditarUserService extends GenericService<UserEntity, Long> {
	@Autowired
	private CurrentUser currentUser;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;


	@Override
	public List<UserEntity> findAll() {
		UserEntity user = this.userRepository.findByEmail(currentUser.getActiveUser().getEmail());

		return this.userRepository.findById(user.getId());
	}

	@Override
	public UserEntity insert(@RequestBody UserEntity user) {
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));

		return super.insert(user);
	}

	@Override
	public void update(@RequestBody UserEntity user) {
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));

		super.update(user);
	}






}
