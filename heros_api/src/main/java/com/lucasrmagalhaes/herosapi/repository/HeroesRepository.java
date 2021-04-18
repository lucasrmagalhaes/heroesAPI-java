package com.lucasrmagalhaes.herosapi.repository;

import com.lucasrmagalhaes.herosapi.document.Heroes;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface HeroesRepository extends CrudRepository<Heroes, String> {}
