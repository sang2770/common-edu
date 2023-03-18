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
    default String generateRoomCode() {
        int year = LocalDate.now().getYear();
        return nextValue(Const.ROOM.getPrefix() + year, Const.ROOM.getSeqName());
    }
    @Transactional
    default String generateClassesCode() {
        int year = LocalDate.now().getYear();
        return nextValue(Const.CLASSES.getPrefix() + year, Const.CLASSES.getSeqName());
    }
    @Transactional
    default String generateDepartmentCode() {
        int year = LocalDate.now().getYear();
        return nextValue(Const.DEPARTMENT.getPrefix() + year, Const.DEPARTMENT.getSeqName());
    }

    @Transactional
    default String generatePeriodCode() {
        int year = LocalDate.now().getYear();
        return nextValue(Const.DEPARTMENT.getPrefix() + year, Const.DEPARTMENT.getSeqName());
    }
}
