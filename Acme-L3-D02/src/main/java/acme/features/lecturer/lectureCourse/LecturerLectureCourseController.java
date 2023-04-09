
package acme.features.lecturer.lectureCourse;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.LectureCourse;
import acme.framework.controllers.AbstractController;
import acme.roles.Lecturer;

@Controller
public class LecturerLectureCourseController extends AbstractController<Lecturer, LectureCourse> {

	@Autowired
	protected LecturerLectureCourseCreateService createService;


	@PostConstruct
	protected void initialise() {
		super.addCustomCommand("add-lecture", "create", this.createService);

	}

}
