
package acme.forms;

import java.util.Map;

import acme.framework.data.AbstractForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDashboard extends AbstractForm {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	Map<String, Integer>		totalPracticaByMonth;

	Double						avgPract;
	Double						devPract;
	Double						minPract;
	Double						maxPract;

	Map<String, Double>			maxDurationSessionByPractica;

	Double						avgSession;
	Double						devSession;
	Double						minSession;
	Double						maxSession;
}
