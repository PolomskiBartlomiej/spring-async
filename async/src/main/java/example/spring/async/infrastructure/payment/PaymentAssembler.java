package example.spring.async.infrastructure.payment;

import example.spring.async.domain.model.PaymentStatusEnum;

class PaymentAssembler {

    static PaymentStatusEnum toPaymentStatus(String s) {
        return PaymentStatusEnum.REJECTED;
    }
}
