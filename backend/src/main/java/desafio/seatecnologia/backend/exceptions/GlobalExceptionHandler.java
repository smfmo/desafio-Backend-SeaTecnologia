package desafio.seatecnologia.backend.exceptions;

import desafio.seatecnologia.backend.controller.dto.ErroCampoDto;
import desafio.seatecnologia.backend.controller.dto.ErroRespostaDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErroRespostaDto handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {

        List<FieldError> errosDeCampo = e.getFieldErrors();

        List<ErroCampoDto> listaDeErros = errosDeCampo
                .stream()
                .map(erro -> new ErroCampoDto(erro.getField(), erro.getDefaultMessage()))
                .collect(Collectors.toList());
        return new ErroRespostaDto(HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "Erro de validação", listaDeErros);
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErroRespostaDto handleAccessDeniedException(AccessDeniedException e) {
        return new ErroRespostaDto(HttpStatus.FORBIDDEN.value(),
                "usuário não possui permissão", Collections.emptyList());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErroRespostaDto handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return new ErroRespostaDto(HttpStatus.BAD_REQUEST.value(),
                "Verifique os dados fornecidos. Campos obrigatórios estão ausentes ou inválidos.",
                Collections.emptyList());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErroRespostaDto handleNotFoundException(EntityNotFoundException e) {
        return new ErroRespostaDto(HttpStatus.NOT_FOUND.value(),
                "O recurso solicitado não foi encontrado ou não existe.",
                Collections.emptyList());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErroRespostaDto handleErrosNaoTratados(RuntimeException e) {
        return new ErroRespostaDto(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Ocorreu um erro inesperado", Collections.emptyList());
    }
}
