
package acme.features.lecturer.lecture;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Lecture;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Lecturer;

@Repository
public interface LecturerLectureRepository extends AbstractRepository {

	@Query("select l from Lecture l where l.id = :id")
	Lecture findLectureById(int id);

	@Query("select l from Lecture l where l.lecturer.id= :lectId")
	Collection<Lecture> findLecturesByLecturer(int lectId);

	@Query("select l from Lecture l join LectureCourse cl on cl.lecture.id = l.id where cl.course.id = ?1")
	Collection<Lecture> findLecturesByCourse(int courseId);

	@Query("select l from Lecturer l where l.id = :lectId")
	Lecturer findLecturerById(int lectId);

}
