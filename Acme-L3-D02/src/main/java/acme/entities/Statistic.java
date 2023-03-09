
package acme.entities;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import acme.framework.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Statistic extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	@NotNull
	int							counter;

	Double						average;
	Double						deviation;
	Double						minimum;
	Double						maximum;

}
