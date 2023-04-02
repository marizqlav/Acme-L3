
package acme.features.any.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Course;
import acme.framework.components.accounts.Any;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;

@Service
public class AnyCourseShowService extends AbstractService<Any, Course> {

	@Autowired
	protected AnyCourseRepository repository;


	@Override
	public void check() {
		boolean status;
		status = super.getRequest().hasData("id", int.class);
		super.getResponse().setChecked(status);
	}

	@Override
	public void authorise() {
		super.getResponse().setAuthorised(true);
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
		super.getResponse().setData(tuple);
	}

}
