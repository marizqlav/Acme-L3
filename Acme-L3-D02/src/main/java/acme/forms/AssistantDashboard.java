
package acme.forms;

import java.util.Map;

import acme.datatypes.TypeNature;
import acme.entities.Statistic;
import acme.framework.data.AbstractForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssistantDashboard extends AbstractForm {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	Map<TypeNature, Integer>	numTutorialsByType;

	Statistic					statisticsSessions;

	Statistic					statisticsTutorials;
}
