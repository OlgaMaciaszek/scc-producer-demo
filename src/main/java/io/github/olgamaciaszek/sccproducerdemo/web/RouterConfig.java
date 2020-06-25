package io.github.olgamaciaszek.sccproducerdemo.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author Olga Maciaszek-Sharma
 */
@Configuration
public class RouterConfig {

	public static RouterFunction<ServerResponse> fraudDetectionPost(FraudDetectionHandler handler) {
		return route(POST("/fraudcheck").and(contentType(MediaType
						.valueOf("application/vnd.fraud.v1+json;charset=UTF-8"))),
				handler::processFraudDetectionRequest);
	}

	@Bean
	RouterFunction<ServerResponse> routerFunction(FraudDetectionHandler handler) {
		return fraudDetectionPost(handler);
	}

}

