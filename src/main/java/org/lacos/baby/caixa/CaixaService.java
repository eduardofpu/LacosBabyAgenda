package org.lacos.baby.caixa;

import org.lacos.baby.utils.GenericService;
import org.lacos.baby.utils.ServicePath;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(path = ServicePath.CAIXA_PATH)
public class CaixaService extends GenericService<Caixa,Long>{

}
