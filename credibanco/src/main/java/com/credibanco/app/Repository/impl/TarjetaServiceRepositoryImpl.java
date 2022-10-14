package com.credibanco.app.Repository.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.credibanco.app.Dto.RespuestaServicio;
import com.credibanco.app.Dto.TarjetaDto;
import com.credibanco.app.Entidades.Tarjeta;
import com.credibanco.app.Repository.TarjetaRepositoy;
import com.credibanco.app.Repository.interfaces.TarjetaServiceRepository;

@Service
public class TarjetaServiceRepositoryImpl implements TarjetaServiceRepository{

	@Autowired
	private TarjetaRepositoy tarjetaRepositoy;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Tarjeta> findAll() {
		
		return tarjetaRepositoy.findAll();
	}


	@Override
	@Transactional(readOnly = true)
	public Optional<Tarjeta> findById(Long id) {
		
		return tarjetaRepositoy.findById(id);
	}

	@Override
	@Transactional
	public Tarjeta saver(TarjetaDto tarjeta) {
		
		return tarjetaRepositoy.save(tarjeta);
	}

	@Override
	public List<Tarjeta> findByIdNum(String numero) {
		// TODO Auto-generated method stub
		return tarjetaRepositoy.findByNumerTarjeta(numero);
	}


	@Override
	public Tarjeta update(TarjetaDto tarjetaDto, Long id) {
		Optional<Tarjeta> tarjeta = this.tarjetaRepositoy.findById(id);
		
		Tarjeta tarjetaTem = tarjeta.get();
		
		tarjetaTem.setCedula(tarjetaDto.getTarjeta().getCedula());
		tarjetaTem.setEstado(tarjetaDto.getTarjeta().getEstado());
		tarjetaTem.setId(id);
		tarjetaTem.setNumerTarjeta(tarjetaDto.getTarjeta().getNumerTarjeta());
		tarjetaTem.setNumerValidacion(tarjetaDto.getTarjeta().getNumerValidacion());
		tarjetaTem.setTelefono(tarjetaDto.getTarjeta().getTelefono());
		tarjetaTem.setTipo(tarjetaDto.getTarjeta().getTipo());
		tarjetaTem.setTitular(tarjetaDto.getTarjeta().getTitular());
		return tarjetaRepositoy.save(tarjetaTem);
	}


	@Override
	@Transactional
	public void deleteByNumero(Long id) {
	tarjetaRepositoy.deleteById(id);
		
	}


	



	

	
	


}
