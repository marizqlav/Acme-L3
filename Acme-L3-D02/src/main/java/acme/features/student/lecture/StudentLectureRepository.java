
package acme.features.student.lecture;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Course;
import acme.entities.Lecture;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface StudentLectureRepository extends AbstractRepository {

	@Query("select lc.lecture from LectureCourse lc where lc.course.id=?1 AND lc.lecture.draftMode = false")
	Collection<Lecture> findLecturesByCourseId(int courseId);

	@Query("select c from Course c where c.id=?1")
	Course findCourseById(int courseId);

	@Query("select l from Lecture l where l.id=?1")
	Lecture findLectureById(int lectureId);
}
