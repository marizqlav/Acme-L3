
package acme.features.company.practicum;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Course;
import acme.entities.Practicum;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Company;

@Repository
public interface CompanyPracticumRepository extends AbstractRepository {

	@Query("select p from Practicum p where p.id = :id")
	Practicum findOnePracticumById(int id);

	@Query("select c from Company c where c.id = :id")
	Company findOneCompanyById(int id);

	@Query("select c from Course c where c.id = :id")
	Course findOneCourseById(int id);

	@Query("select p from Practicum p where p.company.id= :activeCompanyId")
	Collection<Practicum> findPracticumByCompanyId(int activeCompanyId);

	@Query("select sum(TIME_TO_SEC(TIMEDIFF(s.endDate, s.startDate)) / 3600) from SessionPracticum s where s.practicum.id= :practicumId")
	Double findEstimatedTimeSessionsPerPracticum(int practicumId);

	@Query("select p.code from Practicum p")
	Collection<String> findAllCodes();

	@Query("select c from Course c where c.draftMode = false")
	Collection<Course> findFinishedCourses();

	@Query("select c from Course c")
	Collection<Course> findAllCourses();

}
