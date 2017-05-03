package org.lacos.baby.permission;

import java.util.List;

import org.lacos.baby.utils.GenericService;
import org.lacos.baby.utils.ServicePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ServicePath.PERVISIT_PATH)
public class PermissionVisitante extends GenericService<PermissionEntity, Long> {



	@Autowired
	private PermissionRepository permissaoRepository;

	@RequestMapping(value = "/findRole/{role}", method = RequestMethod.GET)
	public PermissionEntity findRole(@PathVariable("role") String role) {
		return this.permissaoRepository.findByRole(role);
	}

	@Override
	public List<PermissionEntity> findAll() {
		return super.findAll();
	}


}
