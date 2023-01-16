package com.sang.commonpersistence.support;

public enum Const {
    TICKET_CUSTOMER("YC", "TICKET_CUSTOMER_SEQ"),
    TICKET_INTERNAL("NB", "TICKET_INTERNAL_SEQ"),
    TICKET_COMPLAINT("BN", "TICKET_COMPLAINT_SEQ"),
    ORGANIZATION_INTERNAL("NB", "ORGANIZATION_INTERNAL_SEQ"),
    ORGANIZATION_EXTERNAL("TN", "ORGANIZATION_EXTERNAL_SEQ"),
    ORGANIZATION_MB("OR", "ORGANIZATION_MB_SEQ"),
    INDIVIDUAL("IN", "INDIVIDUAL_SEQ"),
    UNIT_CODE("MB", "UNIT_CODE"),
    COMPLAINT_CODE("GY", "COMPLAINT_CODE_SEQ"),
    VENDOR("VE", "VENDOR_CODE_SEQ"),
    BUILDING("MB", "BUILDING_CODE_SEQ"),
    REQUEST_CODE_OVERTIME_REGISTRATION("OR", "OVERTIME_REGISTRATION_SEQ"),
    NOTIFICATION_TEMPLATE_CODE("NT", "NOTIFICATION_TEMPLATE_CODE_SEQ"),
    WORKFLOW_TEMPLATE_CODE("WT", "WORKFLOW_TEMPLATE_CODE_SEQ"),
    FLOOR_CODE("FL", "FLOOR_CODE_SEQ"),
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
