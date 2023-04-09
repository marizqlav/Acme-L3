
package acme.features.student.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Lecture;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;
import acme.roles.Student;

@Service
public class StudentLectureShowService extends AbstractService<Student, Lecture> {

	@Autowired
	protected StudentLectureRepository repository;


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
		status = lecture != null && !lecture.getDraftMode();
		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		Lecture lecture;
		int id;
		id = super.getRequest().getData("id", int.class);
		lecture = this.repository.findLectureById(id);
		super.getBuffer().setData(lecture);
	}

	@Override
	public void unbind(final Lecture lecture) {
		assert lecture != null;
		Tuple tuple;
		tuple = super.unbind(lecture, "title", "abstractDoc", "estimatedHours", "body", "type", "moreInfo");
		tuple.put("lecturer", lecture.getLecturer().getIdentity().getFullName());
		super.getResponse().setData(tuple);
	}

}
