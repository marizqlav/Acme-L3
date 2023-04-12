
package acme.features.lecturer.lecture;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Lecture;
import acme.framework.controllers.AbstractController;
import acme.roles.Lecturer;

@Controller
public class LecturerLectureController extends AbstractController<Lecturer, Lecture> {

	@Autowired
	protected LecturerLectureListService		listService;

	@Autowired
	protected LecturerLectureShowService		showService;

	@Autowired
	protected LecturerLectureListCourseService	listCourseService;

	@Autowired
	protected LecturerLectureCreateService		createService;

	@Autowired
	protected LecturerLectureUpdateService		updateService;

	@Autowired
	protected LecturerLectureDeleteService		deleteService;

	@Autowired
	protected LecturerLecturePublishService		publishService;


	@PostConstruct
	protected void initialise() {
		super.addCustomCommand("list-mine", "list", this.listService);
		super.addBasicCommand("show", this.showService);
		super.addCustomCommand("list-course", "list", this.listCourseService);
		super.addBasicCommand("create", this.createService);
		super.addBasicCommand("update", this.updateService);
		super.addBasicCommand("delete", this.deleteService);
		super.addCustomCommand("publish", "update", this.publishService);

	}

}
