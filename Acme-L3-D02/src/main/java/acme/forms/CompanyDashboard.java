
package acme.forms;

import acme.entities.Statistic;
import acme.framework.data.AbstractForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDashboard extends AbstractForm {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	int[]						practicaPerCourseLastYear;

	Statistic					statisticsPract;
  
	Statistic					statisticsSess;

}
