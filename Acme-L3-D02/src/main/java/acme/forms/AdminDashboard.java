
package acme.forms;

import java.util.Map;

import acme.entities.Statistic;
import acme.framework.components.datatypes.Money;
import acme.framework.data.AbstractForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDashboard extends AbstractForm {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	Map<String, Integer>		numPrincipalsByRole;

	Double						ratioPeepsEmailAndLink;
	Double						ratioCriticalBulleting;
	Double						ratioNonCriticalBulleting;

	Map<Money, Statistic>		statisticsBudgetByCurrency;
	Statistic					statisticsNotesLastTenWeeks;

}
