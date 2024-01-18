package org.example.model;

public enum ContactUsFormFields {
    FIRST_NAME("firstname"),
    LAST_NAME("lastname"),
    EMAIL("email"),
    COMPANY_NAME("company"),
    JOB_TITLE("jobtitle"),
    PHONE_NUMBER("phone"),
    COUNTRY("country"),
    CONTACT_TOPIC("contact_topic"),
    MESSAGE("situation__c"),
    AGREEMENT_CHECKBOX("LEGAL_CONSENT.subscription_type_181847195");

    public final String nameValue;

    ContactUsFormFields(String nameValue){
        this.nameValue = nameValue;
    }
}
