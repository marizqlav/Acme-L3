
package acme.features.lecturer.lecturerDashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.datatypes.TypeNature;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface LecturerDashboardRepository extends AbstractRepository {

	@Query("select count(distinct l) from Lecture l inner join LectureCourse lc on l = lc.lecture inner join Course c on lc.course = c where c.lecturer.id = :lectId and l.lectureType = :nature")
	Integer numLecturesByType(int lectId, TypeNature nature);

	@Query("select avg(l.estimatedHours) from Lecture l where l.lecturer.id = ?1")
	Double avgTimeLectures(int lecturerId);

	@Query("select max(l.estimatedHours) from Lecture l where l.lecturer.id = ?1")
	Double maxTimeLectures(int lecturerId);

	@Query("select min(l.estimatedHours) from Lecture l where l.lecturer.id = ?1")
	Double minTimeLectures(int lecturerId);

	@Query("select stddev(l.estimatedHours) from Lecture l where l.lecturer.id = ?1")
	Double stddevTimeLectures(int lecturerId);

	@Query("select avg(l.estimatedHours) from Lecture l inner join LectureCourse lc on l = lc.lecture inner join Course c on lc.course = c where c.lecturer.id = :lectId")
	Double avgTimeCourses(int lectId);

	@Query("select stddev(l.estimatedHours) from Lecture l inner join LectureCourse lc on l = lc.lecture inner join Course c on lc.course = c where c.lecturer.id = :lectId")
	Double stddevTimeCourses(int lectId);

	@Query("select min(l.estimatedHours) from Lecture l inner join LectureCourse lc on l = lc.lecture inner join Course c on lc.course = c where c.lecturer.id = :lectId")
	Double minTimeCourses(int lectId);

	@Query("select max(l.estimatedHours) from Lecture l inner join LectureCourse lc on l = lc.lecture inner join Course c on lc.course = c where c.lecturer.id = :lectId")
	Double maxTimeCourses(int lectId);

}
