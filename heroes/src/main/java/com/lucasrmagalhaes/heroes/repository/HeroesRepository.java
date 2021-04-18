package com.lucasrmagalhaes.heroes.repository;

import com.lucasrmagalhaes.heroes.document.Heroes;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface HeroesRepository extends CrudRepository<Heroes, String> {}
