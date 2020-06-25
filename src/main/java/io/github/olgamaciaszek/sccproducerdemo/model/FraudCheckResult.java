package io.github.olgamaciaszek.sccproducerdemo.model;

/**
 * @author Olga Maciaszek-Sharma
 */
public class FraudCheckResult {

	private final FraudCheckStatus fraudCheckStatus;
	private final String rejectionReason;

	public FraudCheckResult(FraudCheckStatus fraudCheckStatus, String rejectionReason) {
		this.fraudCheckStatus = fraudCheckStatus;
		this.rejectionReason = rejectionReason;
	}

	public FraudCheckStatus getFraudCheckStatus() {
		return fraudCheckStatus;
	}

	public String getRejectionReason() {
		return rejectionReason;
	}
}
