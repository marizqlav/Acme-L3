
package acme.features.company.sessionPracticum;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.SessionPracticum;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface CompanySessionPracticumRepository extends AbstractRepository {

	@Query("select s from SessionPracticum s where s.id = :id")
	SessionPracticum findOneSessionPracticumById(int id);

	@Query("select s from SessionPracticum s where s.practicum.company.id = :id")
	Collection<SessionPracticum> findManySessionPracticumByCompanyId(int id);

}
