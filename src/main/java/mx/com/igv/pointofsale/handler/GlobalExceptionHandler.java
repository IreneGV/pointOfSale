package mx.com.igv.pointofsale.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import mx.com.igv.pointofsale.exception.MyNotFoundException;
import mx.com.igv.pointofsale.exception.NegocioException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<Object> handleGenericException(Exception ex) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, null);
    }

    @ExceptionHandler(value = { NegocioException.class })
    protected ResponseEntity<Object> handleNegocioException(NegocioException ne) {
        return handleExceptionInternal(ne, ne.getMessage(), new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY, null);
    }

    @ExceptionHandler(value = { MyNotFoundException.class })
    protected ResponseEntity<Object> handleNotFoundException(MyNotFoundException nfe) {
        return handleExceptionInternal(nfe, nfe.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, null);
    }
    
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            org.springframework.web.bind.MissingServletRequestParameterException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        String mensaje = "Falta el parámetro requerido: " + ex.getParameterName();
        return handleExceptionInternal(ex, mensaje, headers, HttpStatus.BAD_REQUEST, request);
    }
    
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex,
            HttpHeaders headers,
            HttpStatus status,
            org.springframework.web.context.request.WebRequest request) {

        String mensaje = "❌ Error al interpretar los datos enviados. Verifica que todos los campos estén completos y con el formato correcto.";
        return handleExceptionInternal(ex, mensaje, headers, HttpStatus.BAD_REQUEST, request);
    }
}