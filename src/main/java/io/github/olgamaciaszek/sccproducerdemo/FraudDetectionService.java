package io.github.olgamaciaszek.sccproducerdemo;

import java.math.BigDecimal;

import io.github.olgamaciaszek.sccproducerdemo.model.FraudCheck;
import io.github.olgamaciaszek.sccproducerdemo.model.FraudCheckResult;
import io.github.olgamaciaszek.sccproducerdemo.model.FraudCheckStatus;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Component;

/**
 * @author Olga Maciaszek-Sharma
 */
@Component
public class FraudDetectionService {

	private static final String NO_REASON = null;
	private static final String AMOUNT_TOO_HIGH = "Amount too high";
	private static final BigDecimal MAX_AMOUNT = new BigDecimal(5000);

	public Mono<FraudCheckResult> verify(Mono<FraudCheck> fraudCheck) {
		return fraudCheck.flatMap(check -> {
			if (amountGreaterThanThreshold(check)) {
				return Mono
						.just(new FraudCheckResult(FraudCheckStatus.FRAUD, AMOUNT_TOO_HIGH));
			}
			return Mono.just(new FraudCheckResult(FraudCheckStatus.OK, NO_REASON));
		});

	}

	boolean amountGreaterThanThreshold(FraudCheck fraudCheck) {
		return (MAX_AMOUNT.compareTo(fraudCheck.getLoanAmount())) < 0;
	}
}
