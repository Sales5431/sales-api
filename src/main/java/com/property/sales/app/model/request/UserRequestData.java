package com.property.sales.app.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
public class UserRequestData {
    private String firstName;
    private String middleName;
    private String lastName;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dob;
    private String gender;
    private String phoneNumber;
    private String emailAddress;
    private String currentAddress;
    private String aadharNumber;
    private String panNumber;
    private String aadharPath;
    private String panPath;
}
