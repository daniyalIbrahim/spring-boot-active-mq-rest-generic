package com.daniyal.generic.object.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@Document(collection = "objects")
public class Contract extends BaseObject {

    @Transient
    public static final String seq_name="contract_seq";

    String  contractName;
    String 	companyName;
    String 	companyId;
    List<String> analyseFileIds;
    List<String>  transportIds;

}
