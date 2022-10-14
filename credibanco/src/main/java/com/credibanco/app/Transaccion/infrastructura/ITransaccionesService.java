package com.credibanco.app.Transaccion.infrastructura;

import com.credibanco.app.Dto.RespuestaServicio;
import com.credibanco.app.Dto.TrasanccionDto;
import com.credibanco.app.Entidades.Transaccion;

public interface ITransaccionesService {
	
	public RespuestaServicio createTransaccion(TrasanccionDto trasanccionDto) throws Exception;
	public RespuestaServicio anularTransaccion(TrasanccionDto trasanccionDto) throws Exception;

}
