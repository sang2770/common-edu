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
    default String generateRoleCode() {
        int year = LocalDate.now().getYear();
        return nextValue(Const.ROLE.getPrefix() + year, Const.ROLE.getSeqName());
    }

    @Transactional
    default String generateGroupQuestionCode() {
        int year = LocalDate.now().getYear();
        return nextValue(Const.GROUP_QUESTION.getPrefix() + year, Const.GROUP_QUESTION.getSeqName());
    }

    @Transactional
    default String generateQuestionCode() {
        int year = LocalDate.now().getYear();
        return nextValue(Const.QUESTION.getPrefix() + year, Const.QUESTION.getSeqName());
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
