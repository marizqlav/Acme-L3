
package acme.features.lecturer.course;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Course;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;
import acme.roles.Lecturer;

@Service
public class LecturerCourseListService extends AbstractService<Lecturer, Course> {

	@Autowired
	protected LecturerCourseRepository repository;


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
		Collection<Course> courses;
		int lectId;
		lectId = super.getRequest().getPrincipal().getActiveRoleId();
		courses = this.repository.findCourseByLecturer(lectId);
		super.getBuffer().setData(courses);
	}

	@Override
	public void unbind(final Course course) {
		assert course != null;
		Tuple tuple;
		tuple = super.unbind(course, "code", "title", "draftMode");
		super.getResponse().setData(tuple);
	}

}
