/*
 * UserIdentity.java
 *
 * Copyright (C) 2012-2023 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.datatypes;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import acme.framework.data.AbstractDatatype;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Currency extends AbstractDatatype {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;
	@NotBlank
	@Pattern(regexp = "[A-Z]{3}")
	protected String			defaultCurrency;

	@NotBlank
	@Pattern(regexp = " [A-Z]{3}(,[A-Z]{3})+")
	protected String			acceptedCurrencies;
}
