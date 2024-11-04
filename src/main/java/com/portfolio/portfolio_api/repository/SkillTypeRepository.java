package com.portfolio.portfolio_api.repository;

import com.portfolio.portfolio_api.entity.SkillType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillTypeRepository extends JpaRepository<SkillType, Long> {
}
