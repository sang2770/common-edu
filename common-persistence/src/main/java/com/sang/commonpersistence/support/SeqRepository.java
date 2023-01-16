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

    @Transactional
    default String generateInternalTicketCode() {
        int year = LocalDate.now().getYear();
        return nextValue(Const.TICKET_INTERNAL.getPrefix() + year, Const.TICKET_INTERNAL.getSeqName());
    }

    @Transactional
    default String generateComplaintTicketCode() {
        int year = LocalDate.now().getYear();
        return nextValue(Const.TICKET_COMPLAINT.getPrefix() + year, Const.TICKET_COMPLAINT.getSeqName());
    }

    @Transactional
    default String generateIndividualCustomerCode() {
        return nextValue(Const.INDIVIDUAL.getPrefix(), Const.INDIVIDUAL.getSeqName());
    }

    @Transactional
    default String generateVendorCode() {
        return nextValue(Const.VENDOR.getPrefix(), Const.VENDOR.getSeqName());
    }

    @Transactional
    default String generateInternalOrganizationCode() {
        return nextValue(Const.ORGANIZATION_INTERNAL.getPrefix(), Const.ORGANIZATION_INTERNAL.getSeqName());
    }

    @Transactional
    default String generateExternalOrganizationCode() {
        return nextValue(Const.ORGANIZATION_EXTERNAL.getPrefix(), Const.ORGANIZATION_EXTERNAL.getSeqName());
    }

    @Transactional
    default String generateMBInternalOrganizationCode() {
        return nextValue(Const.ORGANIZATION_MB.getPrefix(), Const.ORGANIZATION_MB.getSeqName());
    }

    @Transactional
    default String generateBuildingCode() {
        return nextValue(Const.BUILDING.getPrefix(), Const.BUILDING.getSeqName());
    }

    @Transactional
    default String generateUnitCode() {
        return nextValue(Const.UNIT_CODE.getPrefix(), Const.UNIT_CODE.getSeqName());
    }

    @Transactional
    default String generateComplaintCode() {
        int year = LocalDate.now().getYear();
        return nextValue(Const.COMPLAINT_CODE.getPrefix() + year, Const.COMPLAINT_CODE.getSeqName());
    }

    @Transactional
    default String generateRequestCodeOvertimeRegistration() {
        return nextValue(Const.REQUEST_CODE_OVERTIME_REGISTRATION.getPrefix(), Const.REQUEST_CODE_OVERTIME_REGISTRATION.getSeqName());
    }

    @Transactional
    default String generateNotificationTemplateCode() {
        return nextValue(Const.NOTIFICATION_TEMPLATE_CODE.getPrefix(), Const.NOTIFICATION_TEMPLATE_CODE.getSeqName());
    }

    @Transactional
    default String generateWorkflowTemplateCode() {
        return nextValue(Const.WORKFLOW_TEMPLATE_CODE.getPrefix(), Const.WORKFLOW_TEMPLATE_CODE.getSeqName());
    }

    @Transactional
    default String generateFloorCode() {
        return nextValue(Const.FLOOR_CODE.getPrefix(), Const.WORKFLOW_TEMPLATE_CODE.getSeqName());
    }
}
