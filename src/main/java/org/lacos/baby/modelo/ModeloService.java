package org.lacos.baby.modelo;


import org.lacos.baby.utils.GenericService;
import org.lacos.baby.utils.ServicePath;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = ServicePath.MODELOS_PATH)
public class ModeloService extends GenericService<Modelo,Long>{

}
