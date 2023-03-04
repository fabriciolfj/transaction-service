package com.github.fabriciolfj.entrypoint.resources;

import com.github.fabriciolfj.adapters.controllers.TransactionController;
import com.github.fabriciolfj.entrypoint.resources.convert.TransactionDTOConvert;
import com.github.fabriciolfj.entrypoint.resources.dto.TransactionRequestDTO;
import com.github.fabriciolfj.usecase.TransactionCreateUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
}
