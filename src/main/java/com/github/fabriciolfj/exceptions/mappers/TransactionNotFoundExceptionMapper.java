package com.github.fabriciolfj.exceptions.mappers;

import com.github.fabriciolfj.exceptions.TransactionNotFoundException;
import com.github.fabriciolfj.exceptions.dto.Error;
import com.github.fabriciolfj.exceptions.dto.Errors;
import org.apache.http.HttpStatus;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.List;

@Provider
public class TransactionNotFoundExceptionMapper implements ExceptionMapper<TransactionNotFoundException> {

    @Override
    public Response toResponse(final TransactionNotFoundException exception) {
        var errors =  Errors.builder()
                .errors(List.of(Error.builder().message(exception.getMessage()).build()))
                .build();

        return Response.status(HttpStatus.SC_NOT_FOUND).entity(errors).build();
    }
}
