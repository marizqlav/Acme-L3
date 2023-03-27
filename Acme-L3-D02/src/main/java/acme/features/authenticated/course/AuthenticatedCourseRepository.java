
package acme.features.authenticated.course;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Course;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedCourseRepository extends AbstractRepository {

	@Query("select c from Course c where c.draftMode = false")
	Collection<Course> findPublishedCourses();

	@Query("select c from Course c where c.id = :id")
	Course findCourseById(int id);
}
