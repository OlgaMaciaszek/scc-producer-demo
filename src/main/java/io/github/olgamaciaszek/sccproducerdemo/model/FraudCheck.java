package io.github.olgamaciaszek.sccproducerdemo.model;

import java.math.BigDecimal;

/**
 * @author Olga Maciaszek-Sharma
 */
public class FraudCheck {

	private final String clientId;
	private final BigDecimal loanAmount;

	public FraudCheck(String clientId, BigDecimal loanAmount) {
		this.clientId = clientId;
		this.loanAmount = loanAmount;
	}

	// Added for Jackson
	private FraudCheck() {
		this(null, null);
	}

	public String getClientId() {
		return clientId;
	}

	public BigDecimal getLoanAmount() {
		return loanAmount;
	}
}
