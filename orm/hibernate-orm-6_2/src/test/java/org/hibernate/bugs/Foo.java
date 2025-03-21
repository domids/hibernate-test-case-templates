package org.hibernate.bugs;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Foo {
    @Id
    private long id;

    private String tenantId;

    private String contactType;

    private String companyName1;
    private String companyName2;

    private String personPrefixTitle;
    private String personFirstName;
    private String personLastName;

    private String markCare;
    private String street;
    private String buildingNumber;
    private String postOfficeBox;
    private String city;
    private String state;
    private String postalCode;
    private String countryIdentificationCode;
    private String countryName;

    private String line;

    private String externalNumber;
    private String customerReferenceNumber;
    private String baseAddressGLN;
}
