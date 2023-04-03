
package acme.features.company.practicum;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Practicum;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;
import acme.roles.Company;

@Service
public class CompanyPracticumUpdateService extends AbstractService<Company, Practicum> {

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
		Company company;

		id = super.getRequest().getData("id", int.class);
		practicum = this.repository.findOnePracticumById(id);
		company = this.repository.findOneCompanyById(super.getRequest().getPrincipal().getActiveRoleId());

		status = company != null && practicum.getCompany().equals(company) && !practicum.getDraftMode();
		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		int id;
		Practicum object;

		id = super.getRequest().getData("id", int.class);
		object = this.repository.findOnePracticumById(id);

		super.getBuffer().setData(object);
	}

	@Override
	public void bind(final Practicum object) {
		assert object != null;

		super.bind(object, "code", "title", "overview", "goals");
	}

	@Override
	public void validate(final Practicum object) {
		assert object != null;
		Collection<String> codes;

		if (!super.getBuffer().getErrors().hasErrors("code")) {
			codes = this.repository.findAllCodes();
			super.state(codes.contains(object.getCode()), "code", "company.practicum.form.error.code");
		}
	}

	@Override
	public void perform(final Practicum object) {
		assert object != null;

		this.repository.save(object);
	}

	@Override
	public void unbind(final Practicum object) {
		assert object != null;

		Tuple tuple;

		tuple = super.unbind(object, "code", "title", "overview", "goals");

		super.getResponse().setData(tuple);
	}

}
