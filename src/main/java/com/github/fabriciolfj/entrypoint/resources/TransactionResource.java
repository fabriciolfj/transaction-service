package com.github.fabriciolfj.entrypoint.resources;

import com.github.fabriciolfj.adapters.controllers.TransactionController;
import com.github.fabriciolfj.entrypoint.resources.convert.TransactionDTOConvert;
import com.github.fabriciolfj.entrypoint.resources.dto.TransactionRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/v1/transactions")
@Slf4j
@RequiredArgsConstructor
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransactionResource {

    private final TransactionController controller;

    @POST
    public Response process(final TransactionRequestDTO dto) {
        log.info("request received {}", dto);
        var entity = TransactionDTOConvert.toEntity(dto);
        return Response.accepted(TransactionDTOConvert
                        .toResponse(controller.process(entity)))
                .build();
    }

    @GET
    @Path("/{code}")
    public Response processFind(@PathParam("code") final String code) {
        return Response.accepted().build();
    }

}

