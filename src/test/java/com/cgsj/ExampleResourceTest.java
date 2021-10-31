package com.cgsj;

import com.cgsj.client.csm.CsmClientService;
import com.cgsj.workorder.Table;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.logging.Log;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@QuarkusTest
public class ExampleResourceTest {
    @Inject
    CsmClientService csmClientService;

    @Test
    public void testHelloEndpoint() {
        String login = csmClientService.login();
        Log.info(login);
    }

    @Test
    public void testGetWorkOrderList() throws JsonProcessingException {
        List<Table> workOrderTables = csmClientService.getWorkOrderTables();
        Log.info(new ObjectMapper().writeValueAsString(workOrderTables));
    }

    @Test
    public void receiveWorkOrder() {
        Boolean aBoolean = csmClientService.receiveWorkOrder("3431118");
        Assertions.assertEquals(aBoolean, false);
    }

    @Test
    public void format() {
        String body = "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body><DoTransAction xmlns=\"http://SOD.com/\"><name>派工单</name><id>%s</id><actName>接收</actName><paramlist xmlns:a=\"http://schemas.datacontract.org/2004/07/SOD.Meta\" xmlns:i=\"http://www.w3.org/2001/XMLSchema-instance\"/><userid>17131</userid><token>44636ac5-40e6-48b7-af15-7b7ee3a93e1e</token></DoTransAction></s:Body></s:Envelope>";
        System.out.println(String.format(body, "123456"));
        System.out.println( LocalDate.now().atStartOfDay().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss+08:00")));
        System.out.println( LocalDate.now().atStartOfDay().format(DateTimeFormatter.ISO_DATE_TIME));
    }

    @Test
    public void assign(){
        com.cgsj.engineer.Table table = csmClientService.getEngineerTables().get(0);
        Table workOrder = csmClientService.getWorkOrderTables().get(0);
        System.out.println(csmClientService.buildAssignData(workOrder,table,LocalDate.now()));
    }

}