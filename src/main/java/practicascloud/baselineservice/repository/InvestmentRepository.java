package practicascloud.baselineservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import practicascloud.baselineservice.model.InvestmentEntity;

@Repository
public interface InvestmentRepository extends JpaRepository<InvestmentEntity, Long> {
	
}
