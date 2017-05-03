package org.lacos.baby.permission;

import org.lacos.baby.utils.GenericService;
import org.lacos.baby.utils.ServicePath;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ServicePath.PERMISSION_PATH)
public class PermissionService extends GenericService<PermissionEntity, Long> {

}
