package com.corte2.taller1.DAO;

import com.corte2.taller1.models.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IEnterpriseRepository extends JpaRepository<Enterprise, Long> {
    List<Enterprise> findEnterpriseByNIT(String NIT);

    Enterprise findById(long Id);

}
