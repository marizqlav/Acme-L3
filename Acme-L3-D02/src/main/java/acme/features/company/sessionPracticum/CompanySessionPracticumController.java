
package acme.features.company.sessionPracticum;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.SessionPracticum;
import acme.framework.controllers.AbstractController;
import acme.roles.Company;

@Controller
public class CompanySessionPracticumController extends AbstractController<Company, SessionPracticum> {

	@Autowired
	protected CompanySessionPracticumListService	listService;

	@Autowired
	protected CompanySessionPracticumShowService	showService;


	@PostConstruct
	protected void initialise() {
		super.addBasicCommand("list", this.listService);
		super.addBasicCommand("show", this.showService);

	}

}