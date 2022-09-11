package com.cg.education_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.education_system.entity.TrainingSchudle;

@Repository
public interface TrainingSchuduleRepository extends JpaRepository<TrainingSchudle, Long>{

}
