package example.spring.async.infrastructure.payment;

class PaymentException extends RuntimeException {
     PaymentException() {
        super("Insufficient Funds");
    }
}
