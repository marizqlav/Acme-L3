
package acme.features.company.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.CompanyDashboard;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;
import acme.roles.Company;

@Service
public class CompanyDashboardShowService extends AbstractService<Company, CompanyDashboard> {

	@Autowired
	protected CompanyDashboardRepository repository;


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
		CompanyDashboard dashboard;

		dashboard = new CompanyDashboard();

		super.getBuffer().setData(dashboard);
	}

	@Override
	public void unbind(final CompanyDashboard object) {
		Tuple tuple;

		tuple = super.unbind(object, "");

		super.getResponse().setData(tuple);
	}

}
