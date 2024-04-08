package com.example.bootcampmicroservice.infrastructure.configuration;

import com.example.bootcampmicroservice.domain.api.ICapacityServicePort;
import com.example.bootcampmicroservice.domain.api.ITechnologyServicePort;
import com.example.bootcampmicroservice.domain.spi.ICapacityPersistencePort;
import com.example.bootcampmicroservice.domain.spi.ITechnologyPersistencePort;
import com.example.bootcampmicroservice.domain.usecase.CapacityUseCase;
import com.example.bootcampmicroservice.domain.usecase.TechnologyUseCase;
import com.example.bootcampmicroservice.infrastructure.out.jpa.adapter.CapacityJpaAdapter;
import com.example.bootcampmicroservice.infrastructure.out.jpa.adapter.TechnologyJpaAdapter;
import com.example.bootcampmicroservice.infrastructure.out.jpa.mapper.CapacityEntityMapper;
import com.example.bootcampmicroservice.infrastructure.out.jpa.mapper.TechnologyMapper;
import com.example.bootcampmicroservice.infrastructure.out.jpa.repository.ICapacityRepository;
import com.example.bootcampmicroservice.infrastructure.out.jpa.repository.ITechnologyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ITechnologyRepository technologyRepository;
    private final TechnologyMapper technologyMapper;
    private final ICapacityRepository capacityRepository;
    private final CapacityEntityMapper capacityEntityMapper;

    @Bean
    public ITechnologyPersistencePort technologyPersistencePort() {
        return new TechnologyJpaAdapter(technologyRepository, technologyMapper);
    }
    @Bean
    public ITechnologyServicePort technologyServicePort() {
        return new TechnologyUseCase(technologyPersistencePort());
    }

    @Bean
    public ICapacityPersistencePort capacityPersistencePort() {
        return new CapacityJpaAdapter(capacityRepository, capacityEntityMapper);
    }
    @Bean
    public ICapacityServicePort capacityServicePort() {
        return new CapacityUseCase(capacityPersistencePort());
    }

}