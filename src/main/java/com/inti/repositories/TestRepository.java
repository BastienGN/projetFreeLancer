package com.inti.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entities.Test;

@Repository
public interface TestRepository extends JpaRepository<Test,Long>{

	final String commandeSQL="UPDATE test SET test.resultat=?1 WHERE test.id_test =?2";
	@Modifying()
    @Transactional
    @Query(
            value=commandeSQL,
            nativeQuery = true
    )
    void fonction(String resultat, Long idTest);
    
}
