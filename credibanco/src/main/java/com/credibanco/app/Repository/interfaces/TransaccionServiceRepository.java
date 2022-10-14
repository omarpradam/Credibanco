package com.credibanco.app.Repository.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.credibanco.app.Dto.RespuestaServicio;
import com.credibanco.app.Dto.TarjetaDto;
import com.credibanco.app.Entidades.Tarjeta;
import com.credibanco.app.Entidades.Transaccion;

public interface TransaccionServiceRepository {

	public Iterable<Transaccion> findAll();
	public Optional<Transaccion> findById(Long id);
	public List<Transaccion> findByIdNum(String numero);
	public Transaccion saver(Transaccion Transaccion);
	public Transaccion update(Transaccion Transaccion, Long id);
	public void deleteByNumero(Long id);
	
	
	
}
