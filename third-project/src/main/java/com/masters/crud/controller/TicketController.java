package com.masters.crud.controller;

import com.masters.crud.dao.TicketDao;
import com.masters.crud.model.Ticket;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class TicketController {

    Logger logger = LoggerFactory.getLogger(TicketController.class);

    @Value("classpath:ticket.graphqls")
    private Resource schemaResource;

    @Autowired
    private TicketDao ticketDao;

    private GraphQL graphQL;

    @PostConstruct
    public void loadSchema() throws IOException {
        File schemaFile = schemaResource.getFile();
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        this.graphQL = GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring buildWiring() {
        DataFetcher<List<Ticket>> fetcher1 = data -> (List<Ticket>) ticketDao.findAll();

        //DataFetcher<Ticket> fetcher2 = data -> ticketDao.findByEmail(data.getArgument("email"));

        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("getAllTickets", fetcher1))
                .build();
    }

    @PostMapping("/book/tickets")
    public String bookTicket(@RequestBody List<Ticket> tickets) {
        ticketDao.saveAll(tickets);
        return "Tickets Booked";
    }

    @GetMapping("/get/tickets")
    public List<Ticket> getTickets() {
        return (List<Ticket>) ticketDao.findAll();
    }

    // GraphQL query endpoint
    @PostMapping("/graphql")
    public ExecutionResult executeGraphQL(@RequestBody String query) {
        return graphQL.execute(query);
    }
}
