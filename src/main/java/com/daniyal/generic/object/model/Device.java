package com.daniyal.generic.object.model;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.checkerframework.common.aliasing.qual.Unique;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.time.Instant;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@Document(collection = "objects")
public class Device extends BaseObject {
    @Transient
    public static final String seq_name="device_seq";

    @Unique
    String deviceName;
    String compoundBid;
    Date deviceCheck;

    String    	mc_init_ID;
    String    	transport_ID;
    byte    	pressure_on_off;
    float  		pressure_min;
    float  		pressure_max;
    byte    	light_A_on_off;
    byte    	light_B_on_off;
    byte    	light_C_on_off;
    byte   		temperature_on_off;
    float  		temperature_min;
    float  		temperature_max;
    float  		temperature_gradient;
    byte    	inclination_on_off_transfer;
    float  		inclination_threshold_X_transfer;
    float  		inclination_threshold_Y_transfer;
    float  		inclination_threshold_Z_transfer;
    float  		inclination_threshold_X_loading;
    float  		inclination_threshold_Y_loading;
    float  		inclination_threshold_Z_loading;
    byte  		gpsOnOff;
    int  		gpsLimit1;
    int  		gpsLimit2;
    byte		gpsHomeOnOff;
    double 		gpsHomeLongitude;
    double 		gpsHomeLatitude;
    double 		gpsHomeAltitude;
    byte  		vibration_on_off;
    float  		vibration_limit_amplitude;
    float  		vibration_limit_constantly;
    byte  		battery_on_off;
    float  		battery_min;
    byte  		contact_switch_1_on_off;
    byte  		contact_switch_2_on_off;
    byte 		contact_switch_3_on_off;
    Instant  	transport_start_time;
    Instant  	transport_end_time;
    Instant  	data_query_start_time;
    int  		data_query_repetitionrate;
    byte  status;

}
