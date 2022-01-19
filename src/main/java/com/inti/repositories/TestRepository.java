package com.inti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Test;

@Repository
public interface TestRepository extends JpaRepository<Test,Long>{

}
