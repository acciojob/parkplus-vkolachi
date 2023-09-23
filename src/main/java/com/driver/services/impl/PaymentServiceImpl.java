package com.driver.services.impl;

import com.driver.model.InsufficientAmountException;
import com.driver.model.Payment;
import com.driver.model.PaymentMode;
import com.driver.model.Reservation;
import com.driver.repository.PaymentRepository;
import com.driver.repository.ReservationRepository;
import com.driver.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    ReservationRepository reservationRepository2;
    @Autowired
    PaymentRepository paymentRepository2;

    @Override
    public Payment pay(Integer reservationId, int amountSent, String mode) throws Exception {
        Reservation reservation=reservationRepository2.findById(reservationId).get();
        Payment payment=new Payment();
        int z=payment.getReservation().getNumberOfHours()*payment.getReservation().getSpot().getPricePerHour();
        if(z>amountSent){
           throw new InsufficientAmountException("Insufficient Amount") ;
        }
        if(!mode.equals("cash") && !mode.equals("card") && !mode.equals("upi") ){
            throw  new InsufficientAmountException("Payment mode not detected");}
            if(mode.equals("cash"))
            {
                payment.setPaymentMode(PaymentMode.CASH);
            }else if(mode.equals("card")){
                payment.setPaymentMode(PaymentMode.CARD);
            }else if(mode.equals("upi")) {
                payment.setPaymentMode(PaymentMode.UPI);
            }



        payment.setPaymentCompleted(true);

        payment.setReservation(reservation);
        paymentRepository2.save(payment);
        return  payment;


    }
}
