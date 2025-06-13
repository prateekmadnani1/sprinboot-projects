//package com.masters.crud.configuration;
//
//import com.masters.crud.model.Ticket;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.data.MongoItemReader;
//import org.springframework.batch.item.xml.StaxEventItemWriter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.oxm.xstream.XStreamMarshaller;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class ApplicationConfig {
//
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    @Autowired
//    private MailUtil util;
//
//    @Bean
//    public MongoItemReader<Ticket> reader() {
//        MongoItemReader<Ticket> reader = new MongoItemReader<>();
//        reader.setTemplate(mongoTemplate);
//        reader.setQuery("{}"); // fetch all documents
//        reader.setTargetType(Ticket.class);
//        reader.setSort(new HashMap<>()); // no sorting
//        return reader;
//    }
//
//    @Bean
//    public StaxEventItemWriter<Ticket> writer() {
//        StaxEventItemWriter<Ticket> writer = new StaxEventItemWriter<>();
//        writer.setRootTagName("Tickets");
//        writer.setResource(new FileSystemResource("xml/ticket.xml"));
//        writer.setMarshaller(marshaller());
//        return writer;
//    }
//
//    @Bean
//    public XStreamMarshaller marshaller() {
//        XStreamMarshaller marshaller = new XStreamMarshaller();
//        Map<String, Class<?>> map = new HashMap<>();
//        map.put("Ticket", Ticket.class); // Fixed alias
//        marshaller.setAliases(map);
//        return marshaller;
//    }
//
//    @Bean
//    public Step step1() {
//        return stepBuilderFactory.get("step1")
//                .<Ticket, Ticket>chunk(10)
//                .reader(reader())
//                .processor(process())
//                .writer(writer())
//                .build();
//    }
//
//    @Bean
//    public Job runJob() {
//        return jobBuilderFactory.get("reportGenerationJob")
//                .flow(step1())
//                .end()
//                .build();
//    }
////
////    @Bean
////    public ItemProcessor<Ticket, Ticket> process() {
////        return ticket -> {
////            if ("Pending".equalsIgnoreCase(ticket.getStatus())) {
////                String msg = util.sendEmail(ticket.getEmail(), buildMessage(ticket));
////                System.out.println("Email sent: " + msg);
////                return ticket;
////            }
////            return null; // filtered out
////        };
////    }
////
////    private String buildMessage(Ticket ticket) {
////        return "Dear " + ticket.getId() + ",\n"
////                + "Statement of your credit card ending with " + ticket.getPrice() + "** has been generated.\n"
////                + "Dues amount: " + ticket.getDescription() + "\n"
////                + "Last payment date: \n\n"
////                + "If you already paid, please ignore this email.\n"
////                + "Thanks for using our credit card.";
////    }
//}
