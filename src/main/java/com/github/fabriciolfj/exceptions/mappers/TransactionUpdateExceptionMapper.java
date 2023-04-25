package com.github.fabriciolfj.exceptions.mappers;

import com.github.fabriciolfj.exceptions.TransactionUpdateException;
import com.github.fabriciolfj.exceptions.dto.Error;
import com.github.fabriciolfj.exceptions.dto.Errors;
import org.apache.http.HttpStatus;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.List;

@Provider
public class TransactionUpdateExceptionMapper implements ExceptionMapper<TransactionUpdateException> {

    @Override
    public Response toResponse(final TransactionUpdateException exception) {
        var errors =  Errors.builder()
                .errors(List.of(Error.builder().message(exception.getMessage()).build()))
                .build();

        return Response.status(HttpStatus.SC_BAD_REQUEST).entity(errors).build();
    }
}
