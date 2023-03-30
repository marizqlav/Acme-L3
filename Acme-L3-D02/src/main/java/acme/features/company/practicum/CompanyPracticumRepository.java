
package acme.features.company.practicum;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Practicum;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface CompanyPracticumRepository extends AbstractRepository {

	@Query("select p from Practicum p where p.id = :id")
	Practicum findOneById(int id);

	@Query("select p from Practicum p where p.company.id= :activeCompanyId")
	Collection<Practicum> findPracticumByCompanyId(int activeCompanyId);

}
