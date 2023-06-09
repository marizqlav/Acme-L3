
package acme.features.company.sessionPracticum;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Practicum;
import acme.entities.SessionPracticum;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface CompanySessionPracticumRepository extends AbstractRepository {

	@Query("select p from Practicum p where p.id = :companyId")
	Practicum findOnePracticumById(int companyId);

	@Query("select s from SessionPracticum s where s.id = :id")
	SessionPracticum findOneSessionPracticumById(int id);

	@Query("select s.practicum from SessionPracticum s where s.id = :id")
	Practicum findOnePracticumBySessionPracticumId(int id);

	@Query("select s from SessionPracticum s where s.practicum.id = :practicumId")
	Collection<SessionPracticum> findSessionPracticumsByPracticumId(int practicumId);

	@Query("select s.practicum from SessionPracticum s where s.id = :id")
	Practicum findPracticumBySessionPracticumId(int id);

}
