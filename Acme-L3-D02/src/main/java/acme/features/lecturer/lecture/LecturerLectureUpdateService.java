
package acme.features.lecturer.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.datatypes.TypeNature;
import acme.entities.Lecture;
import acme.framework.components.jsp.SelectChoices;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;
import acme.roles.Lecturer;

@Service
public class LecturerLectureUpdateService extends AbstractService<Lecturer, Lecture> {

	@Autowired
	protected LecturerLectureRepository repository;


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
		Lecture lecture;
		id = super.getRequest().getData("id", int.class);
		lecture = this.repository.findLectureById(id);
		status = lecture != null && lecture.getDraftMode() && lecture.getLecturer().getId() == super.getRequest().getPrincipal().getActiveRoleId();
		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		int id;
		Lecture lecture;
		id = super.getRequest().getData("id", int.class);
		lecture = this.repository.findLectureById(id);
		super.getBuffer().setData(lecture);
	}

	@Override
	public void bind(final Lecture lecture) {
		assert lecture != null;
		int lecturerId;
		Lecturer lecturer;
		lecturerId = super.getRequest().getPrincipal().getActiveRoleId();
		lecturer = this.repository.findLecturerById(lecturerId);
		super.bind(lecture, "title", "abstractDoc", "estimatedHours", "body", "type", "moreInfo");
		lecture.setLecturer(lecturer);
	}

	@Override
	public void validate(final Lecture lecture) {
		assert lecture != null;
	}

	@Override
	public void perform(final Lecture lecture) {
		assert lecture != null;
		this.repository.save(lecture);
	}

	@Override
	public void unbind(final Lecture lecture) {
		assert lecture != null;
		SelectChoices typeChoices;
		Tuple tuple;
		typeChoices = SelectChoices.from(TypeNature.class, lecture.getType());
		tuple = super.unbind(lecture, "title", "abstractDoc", "estimatedHours", "body", "type", "moreInfo", "draftMode");
		tuple.put("types", typeChoices);
		super.getResponse().setData(tuple);
	}
}
