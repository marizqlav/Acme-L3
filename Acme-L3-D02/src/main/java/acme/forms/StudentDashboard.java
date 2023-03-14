
package acme.forms;

import java.util.Map;

import acme.datatypes.TypeNature;
import acme.entities.Statistic;
import acme.framework.data.AbstractForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDashboard extends AbstractForm {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	Map<TypeNature, Integer>	numWorkbooksByType;

	Statistic					statisticsActivities;

	Statistic					statisticsCourses;

}
