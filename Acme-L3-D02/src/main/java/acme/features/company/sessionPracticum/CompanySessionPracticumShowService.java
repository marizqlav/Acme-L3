
package acme.features.company.sessionPracticum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.SessionPracticum;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;
import acme.roles.Company;

@Service
public class CompanySessionPracticumShowService extends AbstractService<Company, SessionPracticum> {

	@Autowired
	protected CompanySessionPracticumRepository repository;


	@Override
	public void check() {
		boolean status;

		status = super.getRequest().hasData("id", int.class);

		super.getResponse().setChecked(status);
	}

	@Override
	public void authorise() {
		boolean status;
		int sessionPracticumId;
		SessionPracticum sessionPracticum;

		sessionPracticumId = super.getRequest().getData("id", int.class);
		sessionPracticum = this.repository.findOneSessionPracticumById(sessionPracticumId);
		status = sessionPracticum != null && super.getRequest().getPrincipal().hasRole(sessionPracticum.getPracticum().getCompany());
		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		SessionPracticum object;
		int id;

		id = super.getRequest().getData("id", int.class);
		object = this.repository.findOneSessionPracticumById(id);

		super.getBuffer().setData(object);
	}

	@Override
	public void unbind(final SessionPracticum object) {
		assert object != null;

		Tuple tuple;

		tuple = super.unbind(object, "title", "overview", "startDate", "endDate", "moreInfo");

		super.getResponse().setData(tuple);
	}

}
