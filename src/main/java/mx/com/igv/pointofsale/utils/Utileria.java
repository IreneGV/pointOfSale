package mx.com.igv.pointofsale.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import mx.com.igv.pointofsale.exception.NegocioException;

public class Utileria {	

	public static class Fechas{

		public static LocalDateTime castDate(String fecha, String formato) throws NegocioException {
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(formato);
			return LocalDateTime.parse(fecha, dateFormatter);
		}
	}

}