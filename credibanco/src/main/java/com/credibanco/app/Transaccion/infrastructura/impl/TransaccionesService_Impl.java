package com.credibanco.app.Transaccion.infrastructura.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.app.Dto.RespuestaServicio;
import com.credibanco.app.Dto.RespuetsTransaccionDto;
import com.credibanco.app.Dto.TrasanccionDto;
import com.credibanco.app.Entidades.Tarjeta;
import com.credibanco.app.Entidades.Transaccion;
import com.credibanco.app.Repository.TarjetaRepositoy;
import com.credibanco.app.Repository.TransaccionRepositoy;
import com.credibanco.app.Transaccion.infrastructura.ITransaccionesService;

@Service("TransaccionesService_Impl")
public class TransaccionesService_Impl implements ITransaccionesService {

	@Autowired
	private TarjetaRepositoy tarjetaRepositoy;

	@Autowired
	private TransaccionRepositoy transaccionRepositoy;

	@Override
	public RespuestaServicio createTransaccion(TrasanccionDto trasanccionDto) throws Exception {

		List<Tarjeta> ListTarjeta = tarjetaRepositoy.findByNumerTarjeta(trasanccionDto.getPan());
		RespuetsTransaccionDto respuesta = new RespuetsTransaccionDto();
		
		if (ListTarjeta.isEmpty()) {
			respuesta.setEstado("rechazada");
			respuesta.setNumeroRefe(trasanccionDto.getNúmeroReferencia());
			return new RespuestaServicio("Tarjeta no existe", "01", respuesta);

		} 
		
		if (ListTarjeta.get(0).getNumerTarjeta().equals(trasanccionDto.getPan())
				& ListTarjeta.get(0).getEstado().equals("Enrolada")) {
			Transaccion transaccion = new Transaccion();
			transaccion.setDireccion(trasanccionDto.getDireccion());
			transaccion.setEstado("Aprobada");
			transaccion.setTotalCompra(trasanccionDto.getTotalCompra());
			transaccion.setNumeroReferencia(trasanccionDto.getNúmeroReferencia());
			transaccion.setNumerTarjeta(trasanccionDto.getPan());

			Date fecha = new Date();
			transaccion.setCreate(fecha);
			transaccionRepositoy.save(transaccion);

			respuesta.setEstado("Aprobada");
			respuesta.setNumeroRefe(trasanccionDto.getNúmeroReferencia());
			return new RespuestaServicio("Compra exitosa", "00", respuesta);

		} else if (!ListTarjeta.get(0).getEstado().equals("Enrolada")) {
			respuesta.setEstado("rechazada");
			respuesta.setNumeroRefe(trasanccionDto.getNúmeroReferencia());
			
			return new RespuestaServicio("Tarjeta no enrolada", "02", respuesta);
		}
		return null;
	

		
	}

	@Override
	public RespuestaServicio anularTransaccion(TrasanccionDto trasanccionDto) throws Exception {

		List<Transaccion> listaTransaccion = transaccionRepositoy.findByNumerTarjeta(trasanccionDto.getPan());
		
		Date hoy = new Date();
		Calendar fecha = Calendar.getInstance();
		fecha.setTime(hoy);
		Integer minuto = fecha.get(Calendar.MINUTE);
		
		
		Calendar fechaTransa = Calendar.getInstance();
		fechaTransa.setTime(listaTransaccion.get(0).getCreate());
		Integer minutTran = fecha.get(Calendar.MINUTE);

		RespuetsTransaccionDto respuesta = new RespuetsTransaccionDto();
		if(listaTransaccion.isEmpty()) {
			return new RespuestaServicio("numero de referencia inválido", "01", trasanccionDto.getNúmeroReferencia());
		}else if (minutTran <= minuto & listaTransaccion.get(0).getNumeroReferencia().equals(trasanccionDto.getNúmeroReferencia()) ) {
			
			
			return new RespuestaServicio("Compra anulada", "00", trasanccionDto.getNúmeroReferencia());

		}else {
			
			return new RespuestaServicio("No se puede anular transacción", "02", trasanccionDto.getNúmeroReferencia());
		}
		

		
	}

}
