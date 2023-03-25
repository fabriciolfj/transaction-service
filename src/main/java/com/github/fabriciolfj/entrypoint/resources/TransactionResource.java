package com.github.fabriciolfj.entrypoint.resources;

import com.github.fabriciolfj.adapters.controllers.TransactionController;
import com.github.fabriciolfj.adapters.controllers.TransactionFindController;
import com.github.fabriciolfj.entities.values.StatusEnum;
import com.github.fabriciolfj.entrypoint.resources.convert.TransactionDTOConvert;
import com.github.fabriciolfj.entrypoint.resources.convert.TransactionFindResponseDTOConvert;
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
    private final TransactionFindController findController;

    @POST
    public Response process(final TransactionRequestDTO dto) {
        log.info("request received {}", dto);
        var entity = TransactionDTOConvert.toEntity(dto);
        return Response.accepted(TransactionDTOConvert
                        .toResponse(controller.process(entity)))
                .build();
    }

    @GET
    @Path("/{code}/{status}")
    public Response processFind(@PathParam("code") final String code, @PathParam("status") final String status) {
        log.info("request received {}", code);
        final var transaction = findController.process(code, StatusEnum.toEnum(status));

        return Response.accepted().entity(TransactionFindResponseDTOConvert.toDTO(transaction)).build();
    }

}

