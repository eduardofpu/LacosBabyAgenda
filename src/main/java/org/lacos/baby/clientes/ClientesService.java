package org.lacos.baby.clientes;


import org.lacos.baby.utils.GenericService;
import org.lacos.baby.utils.ServicePath;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(path = ServicePath.CLIENTES_PATH)
public class ClientesService extends GenericService<Clientes,Long>{

}
