package org.lacos.baby.pedido;


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
@RequestMapping(path = ServicePath.PEDIDOS_PATH)
public class PedidosService extends GenericService<Pedidos,Long>{
	@Autowired
	CaixaRepository caixaRepository;

	@Override
	@Transactional
	public Pedidos  insert(@RequestBody Pedidos pedido){

		pedido.setRegisterDate(new Date());

		Caixa caixa = caixaRepository.findAll(new PageRequest(0,1)).getContent().get(0);

		caixa.adicionarValor(pedido.getValorTotal());
		caixaRepository.save(caixa);

		return super.insert(pedido);


	}
}
