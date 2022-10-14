package com.credibanco.app.Tarjeta.infrastructuta.impl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.app.Dto.PanDto;
import com.credibanco.app.Dto.ResponseDto;
import com.credibanco.app.Dto.RespuestaServicio;
import com.credibanco.app.Dto.RespustaTarjetaDto;
import com.credibanco.app.Dto.TarjetaDto;
import com.credibanco.app.Entidades.Tarjeta;
import com.credibanco.app.Repository.TarjetaRepositoy;
import com.credibanco.app.Repository.interfaces.TarjetaServiceRepository;
import com.credibanco.app.Tarjeta.infrastructuta.ITarjetaService;

@Service("TarjetaService_Impl")
public class TarjetaService_Impl implements ITarjetaService {

	@Autowired
	private TarjetaRepositoy tarjetaRepositoy;

	@Override
	public RespuestaServicio create(TarjetaDto tarjetaDTO) throws Exception {

		Tarjeta tarjeta = tarjetaDTO.getTarjeta();

		Random aleatorio = new Random(System.currentTimeMillis());

		Integer intAletorio = aleatorio.nextInt(100) + 1;

		tarjeta.setNumerValidacion(intAletorio);
		tarjeta.setEstado("Creada");

		TarjetaDto tarjetaTem = new TarjetaDto();
		tarjetaTem.setTarjeta(tarjeta);

		RespustaTarjetaDto respuest = new RespustaTarjetaDto();

		String numero = tarjeta.getNumerTarjeta();
		numero = numero.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");

		respuest.setNumeroTarjeta(numero);
		respuest.setNumeroValidacion(intAletorio);

		tarjeta = tarjetaRepositoy.save(tarjetaTem.getTarjeta());
		return new RespuestaServicio("Exito", "00", respuest);
	}

	@Override
	public RespuestaServicio enrolarTarjeta(RespustaTarjetaDto respustaTarjetaDto) throws Exception {

		List<Tarjeta> ListTarjeta = tarjetaRepositoy.findByNumerTarjeta(respustaTarjetaDto.getNumeroTarjeta());
		if (ListTarjeta.isEmpty()) {
			String numero = respustaTarjetaDto.getNumeroTarjeta();
			numero = numero.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");

			PanDto pan = new PanDto();
			pan.setNumero(numero);
			return new RespuestaServicio("Tarjeta no existe", "01", pan);
		}

		if (ListTarjeta.get(0).getNumerValidacion().equals(respustaTarjetaDto.getNumeroValidacion())) {

			ListTarjeta.get(0).setEstado("Enrolada");

			TarjetaDto tarjetaTem = new TarjetaDto();
			tarjetaTem.setTarjeta(ListTarjeta.get(0));
			tarjetaTem.getTarjeta().setEstado("Enrolada");

			tarjetaRepositoy.save(tarjetaTem.getTarjeta());
			String numero = respustaTarjetaDto.getNumeroTarjeta();
			numero = numero.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");

			PanDto pan = new PanDto();
			pan.setNumero(numero);
			return new RespuestaServicio("Exito", "00", pan);
		} else {

			String numero = respustaTarjetaDto.getNumeroTarjeta();
			numero = numero.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");

			PanDto pan = new PanDto();
			pan.setNumero(numero);
			return new RespuestaServicio("Número de validación inválido", "02", pan);
		}

	}

	@Override
	public ResponseDto tarjetaByNumero(String numero) throws Exception {

		String numeroTarjeta = numero;

		List<Tarjeta> ListTarjeta = tarjetaRepositoy.findByNumerTarjeta(numeroTarjeta);

		ResponseDto respuesta = new ResponseDto();

		String numTarjeta = ListTarjeta.get(0).getNumerTarjeta();
		numTarjeta = numTarjeta.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");

		respuesta.setCédula(ListTarjeta.get(0).getCedula());
		respuesta.setEstado(ListTarjeta.get(0).getEstado());
		respuesta.setPan(numTarjeta);
		respuesta.setTeléfono(ListTarjeta.get(0).getTelefono().toString());
		respuesta.setTirular(ListTarjeta.get(0).getTitular());

		return respuesta;
	}

	@Override
	public RespuestaServicio deleteTarjeta(RespustaTarjetaDto respustaTarjetaDto) {
		String numeroTarjeta = respustaTarjetaDto.getNumeroTarjeta();

		List<Tarjeta> ListTarjeta = tarjetaRepositoy.findByNumerTarjeta(numeroTarjeta);
		
		if(ListTarjeta.get(0).getNumerTarjeta().equals(respustaTarjetaDto.getNumeroTarjeta())
				&ListTarjeta.get(0).getNumerValidacion().equals(respustaTarjetaDto.getNumeroValidacion()) ) {
			
			tarjetaRepositoy.deleteById(ListTarjeta.get(0).getId());
			
			return new RespuestaServicio("Se ha eliminado la tarjeta", "00", true);
		}else{
			
			return new RespuestaServicio("No se ha eliminado la tarjeta", "01", false);
		}
		
	}

}
