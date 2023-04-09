
package acme.features.lecturer.course;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Course;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Lecturer;

@Repository
public interface LecturerCourseRepository extends AbstractRepository {

	@Query("select c from Course c where c.id = :id")
	Course findCourseById(int id);

	@Query("select c from Course c where c.lecturer.id = :lectId")
	Collection<Course> findCourseByLecturer(int lectId);

	@Query("select l from Lecturer l where l.id = :lectId")
	Lecturer findLecturerById(int lectId);

	@Query("select c from Course c where c.code = :code")
	Optional<Course> checkRepeatCode(String code);

}
