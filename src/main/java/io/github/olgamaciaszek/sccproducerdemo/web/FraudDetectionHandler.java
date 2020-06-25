package io.github.olgamaciaszek.sccproducerdemo.web;

import io.github.olgamaciaszek.sccproducerdemo.FraudDetectionService;
import io.github.olgamaciaszek.sccproducerdemo.model.FraudCheck;
import io.github.olgamaciaszek.sccproducerdemo.model.FraudCheckResult;
import reactor.core.publisher.Mono;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author Olga Maciaszek-Sharma
 */
@Component
public class FraudDetectionHandler {

	private final FraudDetectionService fraudDetectionService;

	public FraudDetectionHandler(FraudDetectionService fraudDetectionService) {
		this.fraudDetectionService = fraudDetectionService;
	}

	Mono<ServerResponse> processFraudDetectionRequest(ServerRequest serverRequest) {
		return ServerResponse.ok()
				.contentType(MediaType
						.valueOf("application/vnd.fraud.v1+json;charset=UTF-8"))
				.body(fraudDetectionService.verify(
						serverRequest
								.bodyToMono(FraudCheck.class)), FraudCheckResult.class);
	}
}
