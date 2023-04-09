
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
public class LecturerCourseCreateService extends AbstractService<Lecturer, Course> {

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
		Course course;
		Lecturer lecturer;
		lecturer = this.repository.findLecturerById(super.getRequest().getPrincipal().getActiveRoleId());
		course = new Course();
		course.setDraftMode(true);
		course.setLecturer(lecturer);
		super.getBuffer().setData(course);
	}

	@Override
	public void bind(final Course course) {
		assert course != null;
		int lecturerId;
		Lecturer lecturer;
		lecturerId = super.getRequest().getPrincipal().getActiveRoleId();
		lecturer = this.repository.findLecturerById(lecturerId);
		super.bind(course, "code", "title", "abstractDoc", "type", "price", "moreInfo");
		course.setLecturer(lecturer);
	}

	@Override
	public void validate(final Course course) {
		assert course != null;
		//if (!super.getBuffer().getErrors().hasErrors("type"))
		//	super.state(course.getType() != TypeNature.THEORETICAL, "type", "lecturer.course.error.natureType");
		if (!super.getBuffer().getErrors().hasErrors("code"))
			super.state(!this.repository.checkRepeatCode(course.getCode()).isPresent(), "code", "lecturer.course.error.code");
	}

	@Override
	public void perform(final Course course) {
		assert course != null;
		this.repository.save(course);
	}

	@Override
	public void unbind(final Course course) {
		assert course != null;
		SelectChoices typeChoices;
		Tuple tuple;
		typeChoices = SelectChoices.from(TypeNature.class, course.getType());
		tuple = super.unbind(course, "code", "title", "abstractDoc", "type", "price", "moreInfo", "draftMode");
		tuple.put("types", typeChoices);
		super.getResponse().setData(tuple);
	}
}
