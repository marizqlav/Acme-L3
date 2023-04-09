
package acme.features.lecturer.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.datatypes.TypeNature;
import acme.entities.Course;
import acme.framework.components.jsp.SelectChoices;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;
import acme.roles.Lecturer;

@Service
public class LecturerCourseShowService extends AbstractService<Lecturer, Course> {

	@Autowired
	protected LecturerCourseRepository repository;


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
		Course course;
		id = super.getRequest().getData("id", int.class);
		course = this.repository.findCourseById(id);
		status = course != null && course.getLecturer().getId() == super.getRequest().getPrincipal().getActiveRoleId();
		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		Course course;
		int id;
		id = super.getRequest().getData("id", int.class);
		course = this.repository.findCourseById(id);
		super.getBuffer().setData(course);
	}

	@Override
	public void unbind(final Course course) {
		assert course != null;
		SelectChoices typeChoices;
		Tuple tuple;
		typeChoices = SelectChoices.from(TypeNature.class, course.getType());
		tuple = super.unbind(course, "code", "title", "abstractDoc", "type", "price", "moreInfo");
		tuple.put("types", typeChoices);
		super.getResponse().setData(tuple);
	}

}
