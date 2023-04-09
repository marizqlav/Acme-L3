
package acme.features.authenticated.tutorial;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Tutorial;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedTutorialRepository extends AbstractRepository {

	@Query("select tutorial from Tutorial tutorial where tutorial.id = :id")
	Tutorial findOneTutorialById(int id);

	@Query("select tutorial from Tutorial tutorial where tutorial.course.id = :courseId and tutorial.draftMode = false")
	Collection<Tutorial> findTutorialByCourse(int courseId);

}
