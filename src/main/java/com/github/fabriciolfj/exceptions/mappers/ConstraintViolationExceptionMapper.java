package com.github.fabriciolfj.exceptions.mappers;

import com.github.fabriciolfj.exceptions.dto.Error;
import com.github.fabriciolfj.exceptions.dto.Errors;
import org.apache.http.HttpStatus;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.stream.Collectors;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(final ConstraintViolationException ex) {
        var erros = ex.getConstraintViolations().stream().map(e -> Error.builder()
                        .message(e.getMessage()).build()).collect(Collectors.toList());

        return Response.status(HttpStatus.SC_BAD_REQUEST).entity(Errors.builder().errors(erros).build()).build();
    }
}
