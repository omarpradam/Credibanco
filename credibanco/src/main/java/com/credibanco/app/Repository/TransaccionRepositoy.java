package com.credibanco.app.Repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.credibanco.app.Dto.TarjetaDto;
import com.credibanco.app.Entidades.Tarjeta;
import com.credibanco.app.Entidades.Transaccion;

@Repository
public interface TransaccionRepositoy extends CrudRepository<Transaccion, Long> {

	Transaccion save(Transaccion Transaccion);
	
	List<Transaccion> findByNumerTarjeta(String numerTarjeta);
	

	
	
}
