package com.credibanco.app.Tarjeta.infrastructuta;

import com.credibanco.app.Dto.ResponseDto;
import com.credibanco.app.Dto.RespuestaServicio;
import com.credibanco.app.Dto.RespustaTarjetaDto;
import com.credibanco.app.Dto.TarjetaDto;

public interface ITarjetaService {
	
	
	public RespuestaServicio create(TarjetaDto tarjetaDTO) throws Exception;
	
	public RespuestaServicio enrolarTarjeta(RespustaTarjetaDto respustaTarjetaDto) throws Exception;
	
	public ResponseDto tarjetaByNumero(String numero) throws Exception;
	
	public RespuestaServicio deleteTarjeta(RespustaTarjetaDto respustaTarjetaDto);

}
