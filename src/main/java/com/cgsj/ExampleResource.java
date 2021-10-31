package com.cgsj;

import com.cgsj.client.csm.CsmClientService;
import com.cgsj.engineer.Table;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/hello")
public class ExampleResource {
    @Inject
    Logger log;

    @Inject
    CsmClientService csmClientService;

    @GET
    public List<Table> hello() throws JsonProcessingException {
        return csmClientService.getEngineerTables();
    }
}