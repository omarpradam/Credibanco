package com.credibanco.app.Transaccion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.app.Dto.RespuestaServicio;
import com.credibanco.app.Dto.RespustaTarjetaDto;
import com.credibanco.app.Dto.TarjetaDto;
import com.credibanco.app.Dto.TrasanccionDto;
import com.credibanco.app.Tarjeta.infrastructuta.ITarjetaService;
import com.credibanco.app.Transaccion.infrastructura.ITransaccionesService;

@RestController
@RequestMapping("/api/transacciones")
public class TransaccionController {
	
	private RespuestaServicio respuestaServicio = null;
	
	@Autowired
	private ITransaccionesService iTransaccionesService;
	
	// crear tarjeta 
		@RequestMapping(value = "/crearTrasaccion", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseStatus(HttpStatus.OK)
		public @ResponseBody RespuestaServicio create(@RequestBody TrasanccionDto trasanccionDto) {
			try {
				return iTransaccionesService.createTransaccion(trasanccionDto);
			} catch (Exception e) {
				
				respuestaServicio = new RespuestaServicio("Fallido", "01", false);
			}
			return respuestaServicio;
		}
		
		@RequestMapping(value = "/anularTransaccion", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseStatus(HttpStatus.OK)
		public @ResponseBody RespuestaServicio enrolarTarjeta(@RequestBody TrasanccionDto trasanccionDto) {
			try {
				return iTransaccionesService.anularTransaccion(trasanccionDto);
			} catch (Exception e) {
				
				respuestaServicio = new RespuestaServicio(e.getMessage() , "01", false);
			}
			return respuestaServicio;
		}
	

}
