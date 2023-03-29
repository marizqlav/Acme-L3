
package acme.features.student.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Course;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;
import acme.roles.Student;

@Service
public class StudentCourseShowService extends AbstractService<Student, Course> {

	@Autowired
	protected StudentCourseRepository repository;


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
		status = course != null;
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
		Tuple tuple;
		tuple = super.unbind(course, "code", "title", "abstractDoc", "type", "price", "moreInfo");
		tuple.put("lecturer", course.getLecturer().getIdentity().getFullName());
		super.getResponse().setData(tuple);
	}

}
