package c5_lld_payment_gateway;

import c5_lld_payment_gateway.factory.GatewayType;

/*
 * https://github.com/adityatandon15/LLD/blob/main/Lecture%2023/Java%20Code/PaymentGatewayApplication.java
 * https://youtu.be/36FDqIRBGRg?si=RTj2IJpKZdD1aT_2
 * https://youtu.be/NxjGFIgFCbg?si=97VpIk4qz0LkFmtm
 * https://youtu.be/7MXV7RfNtv0?si=dlVOgaAGRSziauUX
 */
public class PaymentGatewayApplication {
	public static void main(String[] args) {
		PaymentRequest req1 = new PaymentRequest("Aditya", "Shubham", 1000.0, "INR");

		System.out.println("Processing via Paytm");
		System.out.println("------------------------------");
		boolean res1 = PaymentController.getInstance().handlePayment(GatewayType.PAYTM, req1);
		System.out.println("Result: " + (res1 ? "SUCCESS" : "FAIL"));
		System.out.println("------------------------------\n");

		PaymentRequest req2 = new PaymentRequest("Shubham", "Aditya", 500.0, "USD");

		System.out.println("Processing via Razorpay");
		System.out.println("------------------------------");
		boolean res2 = PaymentController.getInstance().handlePayment(GatewayType.RAZORPAY, req2);
		System.out.println("Result: " + (res2 ? "SUCCESS" : "FAIL"));
		System.out.println("------------------------------");
	}
}