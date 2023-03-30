
package acme.features.company.practicum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Practicum;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;
import acme.roles.Company;

@Service
public class CompanyPracticumShowService extends AbstractService<Company, Practicum> {

	@Autowired
	protected CompanyPracticumRepository repository;


	@Override
	public void check() {
		boolean status;

		status = super.getRequest().hasData("id", int.class);

		super.getResponse().setChecked(status);
	}

	@Override
	public void authorise() {
		boolean status;
		int id;
		Practicum practicum;

		id = super.getRequest().getData("id", int.class);
		practicum = this.repository.findOneById(id);
		status = practicum != null && practicum.getCompany().getId() == super.getRequest().getPrincipal().getActiveRoleId();

		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		Practicum object;
		int id;

		id = super.getRequest().getData("id", int.class);
		object = this.repository.findOneById(id);

		super.getBuffer().setData(object);
	}

	@Override
	public void unbind(final Practicum object) {
		assert object != null;
		Double estimatedTime;

		estimatedTime = this.repository.findEstimatedTimeSessionsPerPracticum(object.getId());
		if (estimatedTime == null)
			estimatedTime = 0.0;

		Tuple tuple;
		tuple = super.unbind(object, "code", "title", "overview", "goals");
		tuple.put("estimatedTime", estimatedTime);
		super.getResponse().setData(tuple);
	}

}
