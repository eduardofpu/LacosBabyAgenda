package org.lacos.baby.userpermission;

import org.lacos.baby.utils.GenericService;
import org.lacos.baby.utils.ServicePath;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ServicePath. USER_PERMISSION_PATH )
public class UserPermissionService extends GenericService<UserPermissionEntity, UserPermissionKey>{

}
