
package acme.features.lecturer.lectureCourse;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Course;
import acme.entities.Lecture;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface LecturerLectureCourseRepository extends AbstractRepository {

	@Query("select c from Course c where c.id = :id")
	Course findCourseById(int id);

	@Query("select l from Lecture l where l.id = :id")
	Lecture findLectureById(int id);

	@Query("select l from Lecture l left join LectureCourse lc on lc.lecture.id = l.id where lc.course.id != :id")
	Collection<Lecture> findLecturesNotYetInCourse(int id);

}
