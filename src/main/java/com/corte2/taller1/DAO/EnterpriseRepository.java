package com.corte2.taller1.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.corte2.taller1.models.Enterprise;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {
}
