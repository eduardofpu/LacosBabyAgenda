package org.lacos.baby.user;


import org.lacos.baby.permission.PermissionEntity;
import org.lacos.baby.permission.PermissionRepository;
import org.lacos.baby.userpermission.UserPermissionEntity;
import org.lacos.baby.userpermission.UserPermissionKey;
import org.lacos.baby.userpermission.UserPermissionRepository;
import org.lacos.baby.utils.GenericService;
import org.lacos.baby.utils.ServicePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ServicePath.VISITANTES_PATH)
public class Visitante extends GenericService<UserEntity, Long> {



	@Autowired
	private UserRepository userRepository;

	@Autowired
	PermissionRepository permissaoRepository;


	@Autowired
	UserPermissionRepository userPermission;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserEntity insert(@RequestBody UserEntity user) {

		user.setPassword(this.passwordEncoder.encode(user.getPassword()));

		this.userRepository.saveAndFlush(user);

		PermissionEntity permissao = this.permissaoRepository.findByRole("ROLE_VISITANTE");

		if (permissao == null) {
			PermissionEntity permissao2 = new PermissionEntity();
			permissao2.setRole("ROLE_VISITANTE");

			permissao = this.permissaoRepository.save(permissao2);
		}
		UserPermissionKey userPermissionKey = new UserPermissionKey();
		userPermissionKey.setPermissionId(permissao.getId());
		userPermissionKey.setUserId(user.getId());

		UserPermissionEntity userPermission = new UserPermissionEntity();
		userPermission.setId(userPermissionKey);

		this.userPermission.save(userPermission);

		return this.userRepository.saveAndFlush(user);

		//return ((Visitante) this.userRepository).insert(user);
	}

}