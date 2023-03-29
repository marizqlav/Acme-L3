
package acme.features.student.lecture;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Course;
import acme.entities.Lecture;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface StudentLectureRepository extends AbstractRepository {

	@Query("select lc.lecture from LectureCourse lc where lc.course.id=?1")
	Collection<Lecture> findLecturesByCourseId(int courseId);

	@Query("select lc from Lecture lc")
	Collection<Lecture> findLectures();

	@Query("select c from Course c where c.id=?1")
	Course findCourseById(int courseId);

}
