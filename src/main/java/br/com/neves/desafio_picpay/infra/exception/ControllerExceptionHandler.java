package br.com.neves.desafio_picpay.infra.exception;

import br.com.neves.desafio_picpay.domain.dto.exceptions.ErrorValidationResponseDto;
import br.com.neves.desafio_picpay.domain.dto.exceptions.ResponseExceptionDto;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import jakarta.mail.MessagingException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.security.sasl.AuthenticationException;
import java.nio.file.AccessDeniedException;
import java.sql.SQLException;


@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    ResponseEntity<ResponseExceptionDto> notFoundException (EntityNotFoundException e){
        return ResponseEntity.status(404).body(new ResponseExceptionDto(404, e));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorValidationResponseDto> exception (MethodArgumentNotValidException e){
        return  ResponseEntity.badRequest().body(new ErrorValidationResponseDto(e));
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    ResponseEntity<ResponseExceptionDto> methodArgument(HttpMessageNotReadableException e){
        return ResponseEntity.badRequest().body(new ResponseExceptionDto(400, e));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    ResponseEntity<ResponseExceptionDto> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        return ResponseEntity.status(405).body(new ResponseExceptionDto(405, e));
    }

    @ExceptionHandler(JWTCreationException.class)
    ResponseEntity<ResponseExceptionDto> jwtCreate(JWTCreationException e){
        return ResponseEntity.badRequest().body(new ResponseExceptionDto(400, e));
    }

    @ExceptionHandler(JWTVerificationException.class)
    ResponseEntity<ResponseExceptionDto> JwtVerification(JWTVerificationException e){
        return ResponseEntity.badRequest().body(new ResponseExceptionDto(400, e));
    }

    @ExceptionHandler(SQLException.class)
    ResponseEntity<ResponseExceptionDto> sqlException(SQLException e){
        return ResponseEntity.badRequest().body(new ResponseExceptionDto(400, e));
    }

    @ExceptionHandler(AuthenticationException.class)
    ResponseEntity<ResponseExceptionDto> validateUserException(AuthenticationException e){
        return ResponseEntity.status(401).body(new ResponseExceptionDto(401, e));
    }
    @ExceptionHandler({AccessDeniedException.class, DisabledException.class})
    ResponseEntity<ResponseExceptionDto> accessDenied(Exception e){
        return ResponseEntity.status(403).body(new ResponseExceptionDto(403, e));
    }
    @ExceptionHandler(BadCredentialsException.class)
    ResponseEntity<ResponseExceptionDto> badCredentialsException(Exception e){
        return ResponseEntity.status(401).body(new ResponseExceptionDto(401, e));
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    ResponseEntity<ResponseExceptionDto> usernameNotFoundException(Exception e){
        return ResponseEntity.status(401).body(new ResponseExceptionDto(401, e));
    }
    @ExceptionHandler(MessagingException.class)
    ResponseEntity<ResponseExceptionDto> notSendEmail (Exception e){
        return ResponseEntity.badRequest().body(new ResponseExceptionDto(400, e));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseExceptionDto> exception (Exception e){
        return  ResponseEntity.internalServerError().body(new ResponseExceptionDto(500, e));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ResponseExceptionDto> exception (DataIntegrityViolationException e){
        return  ResponseEntity.badRequest().body(new ResponseExceptionDto(400, e, "Integridade do banco de dados violada"));
    }

}
