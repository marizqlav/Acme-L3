
package acme.features.assistant.tutorial;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Tutorial;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AssistantTutorialRepository extends AbstractRepository {

	@Query("select tutorial from Tutorial tutorial where tutorial.id = :id")
	Tutorial findOneById(int id);

	@Query("select tutorial from Tutorial tutorial where tutorial.assistant.id= :assistantId")
	Collection<Tutorial> findTutorialsByAssistantId(int assistantId);

}
