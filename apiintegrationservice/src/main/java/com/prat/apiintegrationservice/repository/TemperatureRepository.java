package com.prat.apiintegrationservice.repository;

import com.prat.apiintegrationservice.model.Temperature;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureRepository extends MongoRepository<Temperature, String> {

}
