
package acme.features.company;

import org.springframework.stereotype.Controller;

import acme.entities.Practicum;
import acme.framework.controllers.AbstractController;
import acme.roles.Company;

@Controller
public class CompanyPracticumController extends AbstractController<Company, Practicum> {

}
