package com.tutorial.batch.job;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.NoRepositoryBean;

import static com.tutorial.batch.job.PayPagingFailJobConfig.JOB_NAME;

@Slf4j
@RequiredArgsConstructor
@Configuration
@ConditionalOnProperty(name = "job.name", havingValue = "simpleJob")
public class SimpleJobConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    @JobScope
    public Job simpleJob(){
        log.info(">>>>>>>>>>>>>> definition simpleJob");
        return jobBuilderFactory.get("simpleJob")
                .start(simpleStep1())
                .build();
    }

    private final SimpleJobTasklet tasklet1;

    @Bean
    @StepScope
    public Step simpleStep1(){
        log.info(">>>>>>>>>>>>>> definition simpleStep1");
        return stepBuilderFactory.get("simpleStep1")
                .tasklet(tasklet1)
                .build();
    }

    @Bean
    @StepScope
    public Step simpleStep2(@Value("#{jobParameters[requestDate]}") String requestDate){
        return stepBuilderFactory.get("simpleStep1")
                .tasklet((contribution , chunkContext )->{
                    log.info(">>>>>>> This is Step2");
                    log.info(">>>>>>> requestDate= {}", requestDate);
                    return RepeatStatus.FINISHED;
                })
                .build();
    }
}
