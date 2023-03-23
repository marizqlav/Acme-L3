
package acme.features.authenticated.practicum;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Practicum;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedPracticumRepository extends AbstractRepository {

	@Query("select p from Practicum p where p.course.id = :courseId")
	Collection<Practicum> findPracticumByCourse(int courseId);

	@Query("select p from Practicum p where p.id = :id")
	Practicum findOnePracticumById(int id);
}
