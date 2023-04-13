
package acme.features.lecturer.lectureCourse;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Course;
import acme.entities.Lecture;
import acme.entities.LectureCourse;
import acme.framework.components.jsp.SelectChoices;
import acme.framework.components.models.Tuple;
import acme.framework.controllers.HttpMethod;
import acme.framework.helpers.PrincipalHelper;
import acme.framework.services.AbstractService;
import acme.roles.Lecturer;

@Service
public class LecturerLectureCourseCreateService extends AbstractService<Lecturer, LectureCourse> {

	@Autowired
	protected LecturerLectureCourseRepository repository;


	@Override
	public void check() {
		boolean status;
		status = super.getRequest().hasData("courseId", int.class);
		super.getResponse().setChecked(status);
	}

	@Override
	public void authorise() {
		boolean status;
		int id;
		Course course;
		id = super.getRequest().getData("courseId", int.class);
		course = this.repository.findCourseById(id);
		status = course != null && course.getDraftMode() && course.getLecturer().getId() == super.getRequest().getPrincipal().getActiveRoleId();
		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		int id;
		Course course;
		LectureCourse object;
		id = super.getRequest().getData("courseId", int.class);
		course = this.repository.findCourseById(id);
		object = new LectureCourse();
		object.setCourse(course);
		super.getBuffer().setData(object);
	}

	@Override
	public void bind(final LectureCourse lecCourse) {
		assert lecCourse != null;
		int courseId;
		Course course;
		courseId = super.getRequest().getData("courseId", int.class);
		course = this.repository.findCourseById(courseId);
		super.bind(lecCourse, "lecture");
		lecCourse.setCourse(course);
	}

	@Override
	public void validate(final LectureCourse lecCourse) {
		assert lecCourse != null;
	}

	@Override
	public void perform(final LectureCourse lecCourse) {
		assert lecCourse != null;
		this.repository.save(lecCourse);
	}

	@Override
	public void unbind(final LectureCourse lecCourse) {
		assert lecCourse != null;
		SelectChoices lecChoices;
		Tuple tuple;
		Collection<Lecture> remLectures;
		int courseId;
		int lecturerId;
		Course course;
		courseId = super.getRequest().getData("courseId", int.class);
		lecturerId = super.getRequest().getPrincipal().getActiveRoleId();
		course = this.repository.findCourseById(courseId);
		remLectures = this.repository.findLecturesNotYetInCourse(courseId);
		lecChoices = SelectChoices.from(remLectures, "title", lecCourse.getLecture());
		tuple = super.unbind(lecCourse, "course", "lecture");
		tuple.put("lecture", lecChoices.getSelected().getKey());
		tuple.put("lectures", lecChoices);
		tuple.put("courseId", courseId);
		tuple.put("courseCode", course.getCode());
		super.getResponse().setData(tuple);
	}

	@Override
	public void onSuccess() {
		if (super.getRequest().getMethod().equals(HttpMethod.POST))
			PrincipalHelper.handleUpdate();
	}
}
