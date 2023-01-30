package com.sang.commonpersistence.support;

import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.time.LocalDate;

public interface SeqRepository {

    BigInteger nextValue(String seqName);

    @Transactional
    default String nextValue(String prefix, String seqName) {
        return prefix + nextValue(seqName);
    }

    @Transactional
    default String generateCustomerTicketCode() {
        int year = LocalDate.now().getYear();
        return nextValue(Const.TICKET_CUSTOMER.getPrefix() + year, Const.TICKET_CUSTOMER.getSeqName());
    }
}
