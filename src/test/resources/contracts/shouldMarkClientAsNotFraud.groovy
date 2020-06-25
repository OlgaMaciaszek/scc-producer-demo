package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	request {
		method 'POST'
		url '/fraudcheck'
		body(
				clientId: anyUuid(),
				loanAmount: 123.123
		)
		headers {
			header('Content-Type', 'application/vnd.fraud.v1+json;charset=UTF-8')

		}

	}
	response {
		status 200
		body(fraudCheckStatus: "OK",
				rejectionReason: null)
		headers {
			header('Content-Type': 'application/vnd.fraud.v1+json;charset=UTF-8')

		}

	}

}
