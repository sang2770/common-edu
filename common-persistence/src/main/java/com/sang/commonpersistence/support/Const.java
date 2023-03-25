package com.sang.commonpersistence.support;

public enum Const {
    ROOM("R", "ROOM_SEQ"),
    CLASSES("CL", "CLASS_SEQ"),
    DEPARTMENT("DE", "DEPARTMENT_SEQ"),
    ROLE("RO", "ROLE_SEQ"),
    PERIOD("PE", "PERIOD_SEQ"),
    SUBJECT("SU", "SUBJECT_SEQ"),
    USER_EXAM("UX", "USER_EXAM_SEQ"),
    QUESTION("QE", "QUESTION_SEQ"),
    GROUP_QUESTION("GRO_QUE", "GRO_QUE_SEQ"),
    EXAM("EX", "EXAM_SEQ"),
    TEST("TE", "TEST_SEQ")
    ;

    private final String prefix;

    // must upper case
    private final String seqName;

    Const(String prefix, String seqName) {
        this.prefix = prefix;
        this.seqName = seqName.toUpperCase();
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSeqName() {
        return seqName;
    }

}
