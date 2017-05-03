package org.lacos.baby.security;

import org.apache.log4j.Logger;
import org.lacos.baby.permission.PermissionEntity;
import org.lacos.baby.user.UserEntity;
import org.lacos.baby.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetail implements UserDetailsService {

	private static final Logger LOGGER = Logger.getLogger(UserDetail.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		LOGGER.info("Loging com o email " + email);
		UserEntity user = this.userRepository.findByEmail(email);
		LOGGER.info("Usuario encontrado " + user);

		if (user == null) {
			throw new UsernameNotFoundException("User with email \"" + email + "\" was not found");
		}


		LoginDetailBean login = new LoginDetailBean(user.getName(),user.getEmail(),user.getPassword(),user.getMimeType(),user.getFile());

		for (PermissionEntity permission : user.getPermissions()) {
			login.addRole(permission.getRole());
		}
		return login;

	}

}
