package org.lacos.baby.mes;

import javax.transaction.Transactional;

import org.lacos.baby.caixa.Caixa;
import org.lacos.baby.caixa.CaixaRepository;
import org.lacos.baby.utils.GenericService;
import org.lacos.baby.utils.ServicePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(path = ServicePath.MES_PATH)
public class MesService extends GenericService<Mes,Long>{


	@Autowired

	CaixaRepository caixaRepository;

	@Override
	@Transactional
	public Mes insert(@RequestBody Mes mes){


		Caixa caixa = caixaRepository.findAll(new PageRequest(0,1)).getContent().get(0);
		caixa.adicionarValor(mes.getValor());
		caixaRepository.save(caixa);

		return  super.insert(mes);
	}

}
