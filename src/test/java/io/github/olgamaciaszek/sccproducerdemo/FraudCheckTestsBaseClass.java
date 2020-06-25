package io.github.olgamaciaszek.sccproducerdemo;

import io.github.olgamaciaszek.sccproducerdemo.web.FraudDetectionHandler;
import io.github.olgamaciaszek.sccproducerdemo.web.RouterConfig;
import io.restassured.module.webtestclient.RestAssuredWebTestClient;
import org.junit.jupiter.api.BeforeAll;

/**
 * @author Olga Maciaszek-Sharma
 */
public class FraudCheckTestsBaseClass {

	@BeforeAll
	static void setup() {
		RestAssuredWebTestClient.standaloneSetup(RouterConfig
				.fraudDetectionPost(new FraudDetectionHandler(new FraudDetectionService())));
	}
}
