
package acme.features.authenticated.assistant;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.components.accounts.UserAccount;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Assistant;

@Repository
public interface AuthenticatedAssistantRepository extends AbstractRepository {

	@Query("select assistant from Assistant assistant where assistant.userAccount.id = :id")
	Assistant findOneAssistantByUserAccountId(int id);

	@Query("select userAccount from UserAccount userAccount where userAccount.id = :id")
	UserAccount findOneUserAccountById(int id);

}
