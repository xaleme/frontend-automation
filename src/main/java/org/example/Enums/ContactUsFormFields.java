package org.example.Enums;

public enum ContactUsFormFields {
    FIRST_NAME("firstname"),
    LAST_NAME("lastname"),
    EMAIL("firstname"),
    COMPANY_NAME("firstname"),
    JOB_TITLE("firstname"),
    PHONE_NUMBER("firstname"),
    COUNTRY("firstname"),
    CONTACT_TOPIC("firstname"),
    MESSAGE("firstname"),
    AGREEMENT_CHECKBOX("firstname");

    public final String nameValue;

    ContactUsFormFields(String nameValue){
        this.nameValue = nameValue;
    }
}
