package com.daniyal.generic.object.model;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.checkerframework.common.aliasing.qual.Unique;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@RequiredArgsConstructor
@Document(collection = "objects")
public class Employee extends BaseObject {

    @Transient
    public static final String seq_name="employee_seq";

    String companyBid;
    String employeeIdentifier;
    List<String> roleName;

    String companyName;
    String title;
    String firstName;
    String lastName;
    @Unique
    String username;
    String password;
    @Unique
    String Email;

}
