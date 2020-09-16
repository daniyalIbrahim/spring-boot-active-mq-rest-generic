package com.daniyal.generic.object.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@Document(collection = "objects")
public class Transport extends BaseObject {

    String startAddress;
    String finishAddress;
    List<String> trackId;
    Instant dateStart;
    Instant dateEnd;
    List<String> avvNumber;
    Date avvNumberFrom;
    Date avvNumberTo;
    List<String> hazardClass;
    Date hazardClassFrom;
    Date hazardClassTo;
    List<String> unNumber;
    Date unNumberFrom;
    Date unNumberTo;
}
