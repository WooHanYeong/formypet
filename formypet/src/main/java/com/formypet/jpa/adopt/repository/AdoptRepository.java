package com.formypet.jpa.adopt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formypet.jpa.adopt.entity.Adopt;

public interface AdoptRepository extends JpaRepository<Adopt, Long>{

}
