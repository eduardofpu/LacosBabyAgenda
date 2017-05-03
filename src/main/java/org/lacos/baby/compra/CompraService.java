package org.lacos.baby.compra;

import java.util.Date;

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
@RequestMapping(path = ServicePath.COMPRA_PATH)
public class CompraService extends GenericService<Compra,Long>{
	@Autowired
	private CaixaRepository caixaRepository;

	@Override
	@Transactional
	public Compra insert(@RequestBody Compra compra){

		compra.setDia(new Date());

		Caixa caixa = caixaRepository.findAll(new PageRequest(0,1)).getContent().get(0);

		caixa.subtrairValor(compra.getValor());
		caixaRepository.save(caixa);

		return super.insert(compra);
	}

}
