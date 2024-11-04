package com.portfolio.portfolio_api.repository;

import com.portfolio.portfolio_api.entity.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {
    Configuration findByName(String name);
}
