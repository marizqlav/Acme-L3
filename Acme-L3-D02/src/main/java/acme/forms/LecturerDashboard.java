
package acme.forms;

import java.util.Map;

import acme.datatypes.TypeNature;
import acme.entities.Statistic;
import acme.framework.data.AbstractForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LecturerDashboard extends AbstractForm {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	Map<TypeNature, Integer>	numLecturesByType;

	Statistic					statisticsTimeLectures;

	Statistic					statisticsTimeCourses;

}
