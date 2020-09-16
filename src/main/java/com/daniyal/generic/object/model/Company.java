package com.daniyal.generic.object.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.checkerframework.common.aliasing.qual.Unique;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@Document(collection = "objects")
@RequiredArgsConstructor
public class Company extends BaseObject {

    @Transient
    public static final String seq_name="company_seq";

    @Unique
    String companyName;
    String contactPersonId;
    String institutionRole;
    String zip;
    String city;
    String street;
    String phone;
    String web;
    String mail;
}
