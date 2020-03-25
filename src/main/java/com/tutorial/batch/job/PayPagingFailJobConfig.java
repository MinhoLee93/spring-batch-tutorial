///*
//package com.tutorial.batch.job;
//
//import com.tutorial.batch.domain.PaySuccess;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.JobScope;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.database.JdbcCursorItemReader;
//import org.springframework.batch.item.database.JpaItemWriter;
//import org.springframework.batch.item.database.JpaPagingItemReader;
//import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
//import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import sun.dc.pr.PRError;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//@Slf4j
//@RequiredArgsConstructor
//@Configuration
//@ConditionalOnProperty(name = "job.name", havingValue = "payCursorJob")
//public class PayPagingFailJobConfig {
//    public static final String JOB_NAME = "payCursorJob";
//
//    private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory;
//    private final EntityManagerFactory entityManagerFactory;
//    private final DataSource dataSource;
//
//    private final int chunkSize = 10;
//
//    @Bean
//    public Job payPagingJob() {
//        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>");
//        return jobBuilderFactory.get(JOB_NAME)
//                .start(payPagingStep())
//                .build();
//    }
//
//    @Bean
//    @JobScope
//    public Step payPagingStep() {
//        return stepBuilderFactory.get("payPagingStep")
//                .<PaySuccess, PaySuccess>chunk(chunkSize)
//                .reader(payPagingReader())
//                .processor(payPagingProcessor())
//                .writer(writer())
//                .build();
//    }
//
//    @Bean
//    @StepScope
//    public JdbcCursorItemReader<PaySuccess> payPagingReader() {
//        return new JdbcCursorItemReaderBuilder<PaySuccess>()
//                .sql("SELECT * FROM pay_success p WHERE p.success = false")
//                .rowMapper(new BeanPropertyRowMapper<>(PaySuccess.class))
//                .fetchSize(chunkSize)
//                .dataSource(dataSource)
//                .name("payPagingReader")
//                .build();
//    }
//
//    @Bean
//    @StepScope
//    public ItemProcessor<PaySuccess, PaySuccess> payPagingProcessor() {
//        return item -> {
//            item.success();
//            return item;
//        };
//    }
//
//    @Bean
//    @StepScope
//    public JpaItemWriter<PaySuccess> writer() {
//        JpaItemWriter<PaySuccess> writer = new JpaItemWriter<>();
//        writer.setEntityManagerFactory(entityManagerFactory);
//        return writer;
//    }
//}
//*/
