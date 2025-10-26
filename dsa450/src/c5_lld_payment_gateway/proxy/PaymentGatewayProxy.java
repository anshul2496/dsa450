package c5_lld_payment_gateway.proxy;

import c5_lld_payment_gateway.PaymentRequest;
import c5_lld_payment_gateway.paymentgateway.PaymentGateway;

//----------------------------
//Proxy class that wraps a PaymentGateway to add retries (Proxy Pattern)
//----------------------------
public class PaymentGatewayProxy extends PaymentGateway {
	private PaymentGateway realGateway;
	private int retries;

	public PaymentGatewayProxy(PaymentGateway gateway, int maxRetries) {
		this.realGateway = gateway;
		this.retries = maxRetries;
	}

	@Override
	public boolean processPayment(PaymentRequest request) {
		boolean result = false;
		for (int attempt = 0; attempt < retries; ++attempt) {
			if (attempt > 0) {
				System.out.println(
						"[Proxy] Retrying payment (attempt " + (attempt + 1) + ") for " + request.sender + ".");
			}
			result = realGateway.processPayment(request);
			if (result)
				break;
		}
		if (!result) {
			System.out.println("[Proxy] Payment failed after " + retries + " attempts for " + request.sender + ".");
		}
		return result;
	}

	@Override
	public boolean validatePayment(PaymentRequest request) {
		return realGateway.validatePayment(request);
	}

	@Override
	public boolean initiatePayment(PaymentRequest request) {
		return realGateway.initiatePayment(request);
	}

	@Override
	public boolean confirmPayment(PaymentRequest request) {
		return realGateway.confirmPayment(request);
	}
}
