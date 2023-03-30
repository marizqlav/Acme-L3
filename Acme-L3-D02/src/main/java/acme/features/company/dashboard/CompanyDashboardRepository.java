
package acme.features.company.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface CompanyDashboardRepository extends AbstractRepository {

	@Query("select count(p) from Practicum p where p.course.type = 0 and p.company.id = :companyId")
	Integer numberOfPracticumByTheoryCoursesPerMonth(int companyId);

	@Query("select count(p) from Practicum p where p.course.type = 1 and p.company.id = :companyId")
	Integer numberOfPracticumByHandsOnCoursesPerMonth(int companyId);

	//	@Query("select avg(TIME_TO_SEC(TIMEDIFF(s.endDate, s.startDate)) / 3600) from SessionPracticum s where s.practicum.company.id = :companyId")
	//	Double avgSessionsPeriodPerPracticum(int companyId);
	//
	//	@Query("select min(TIME_TO_SEC(TIMEDIFF(s.endDate, s.startDate)) / 3600) from SessionPracticum s where s.practicum.company.id = :companyId")
	//	Double minSessionsPeriodPerPracticum(int companyId);
	//
	//	@Query("select max(TIME_TO_SEC(TIMEDIFF(s.endDate, s.startDate)) / 3600) from SessionPracticum s where s.practicum.company.id = :companyId")
	//	Double maxSessionsPeriodPerPracticum(int companyId);
	//
	//	@Query("select stdev(TIME_TO_SEC(TIMEDIFF(s.endDate, s.startDate)) / 3600) from SessionPracticum s.practicum.company.id = :companyId")
	//	Double stdevSessionsPeriodPerPracticum(int companyId);
	//
	//	@Query("select avg(TIME_TO_SEC(TIMEDIFF(s.endDate, s.startDate)) / 3600) from SessionPracticum s where s.practicum.company.id = :companyId")
	//	Double avgPracticumPeriod(int companyId);

	//	@Query("")
	//	Double minPracticumPeriod(int companyId);
	//
	//	@Query("")
	//	Double maxPracticumPeriod(int companyId);
	//
	//	@Query("")
	//	Double stdevPracticumPeriod(int companyId);

}
