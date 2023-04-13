
package acme.features.lecturer.lecturerDashboard;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.datatypes.TypeNature;
import acme.entities.Statistic;
import acme.forms.LecturerDashboard;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;
import acme.roles.Lecturer;

@Service
public class LecturerDashboardShowService extends AbstractService<Lecturer, LecturerDashboard> {

	@Autowired
	protected LecturerDashboardRepository repository;


	@Override
	public void check() {
		super.getResponse().setChecked(true);
	}

	@Override
	public void authorise() {
		super.getResponse().setAuthorised(true);
	}

	@Override
	public void load() {
		int lecturerId;
		LecturerDashboard dashboard;
		Map<TypeNature, Integer> lectureByType;
		Statistic lectureLearningTime;
		Statistic courseLearningTime;
		lecturerId = super.getRequest().getPrincipal().getActiveRoleId();
		lectureByType = new HashMap<>();
		lectureByType.put(TypeNature.THEORETICAL, this.repository.numLecturesByType(lecturerId, TypeNature.THEORETICAL));
		lectureByType.put(TypeNature.HANDS_ON, this.repository.numLecturesByType(lecturerId, TypeNature.HANDS_ON));
		lectureByType.put(TypeNature.BALANCED, this.repository.numLecturesByType(lecturerId, TypeNature.BALANCED));
		lectureLearningTime = new Statistic();
		lectureLearningTime.setAverage(this.repository.avgTimeLectures(lecturerId));
		lectureLearningTime.setMaximum(this.repository.maxTimeLectures(lecturerId));
		lectureLearningTime.setMinimum(this.repository.minTimeLectures(lecturerId));
		lectureLearningTime.setDeviation(this.repository.stddevTimeLectures(lecturerId));
		courseLearningTime = new Statistic();
		courseLearningTime.setAverage(this.repository.avgTimeCourses(lecturerId));
		courseLearningTime.setMaximum(this.repository.maxTimeCourses(lecturerId));
		courseLearningTime.setMinimum(this.repository.minTimeCourses(lecturerId));
		courseLearningTime.setDeviation(this.repository.stddevTimeCourses(lecturerId));

		dashboard = new LecturerDashboard();
		dashboard.setNumLecturesByType(lectureByType);
		dashboard.setStatisticsTimeLectures(lectureLearningTime);
		dashboard.setStatisticsTimeCourses(courseLearningTime);

		super.getBuffer().setData(dashboard);
	}

	@Override
	public void unbind(final LecturerDashboard dashboard) {
		assert dashboard != null;
		Tuple tuple;
		tuple = super.unbind(dashboard, "numLecturesByType", "statisticsTimeLectures", "statisticsTimeCourses");
		super.getResponse().setData(tuple);
	}

}
