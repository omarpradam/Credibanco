package com.credibanco.app.Repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.credibanco.app.Dto.TarjetaDto;
import com.credibanco.app.Entidades.Tarjeta;

@Repository
public interface TarjetaRepositoy extends CrudRepository<Tarjeta, Long> {

	Tarjeta save(TarjetaDto tarjeta);
	
	List<Tarjeta> findByNumerTarjeta(String numerTarjeta);
	

	
	
}
