
package acme.features.company.sessionPracticum;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.SessionPracticum;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;
import acme.roles.Company;

@Service
public class CompanySessionPracticumListService extends AbstractService<Company, SessionPracticum> {

	@Autowired
	protected CompanySessionPracticumRepository repository;


	@Override
	public void check() {
		super.getResponse().setChecked(true);
	}

	@Override
	public void authorise() {
		super.getResponse().setAuthorised(true);
	}

	@Override
	public void load() {
		Collection<SessionPracticum> objects;
		int companyId;

		companyId = super.getRequest().getPrincipal().getActiveRoleId();
		objects = this.repository.findManySessionPracticumByCompanyId(companyId);

		super.getBuffer().setData(objects);
	}

	@Override
	public void unbind(final SessionPracticum object) {
		assert object != null;

		Tuple tuple;

		tuple = super.unbind(object, "title", "overview", "practicum.title");

		super.getResponse().setData(tuple);
	}

}
