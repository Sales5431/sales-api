package com.property.sales.app.service;

import com.property.sales.app.model.entity.User;
import com.property.sales.app.model.request.UserRequestData;
import com.property.sales.app.repository.UserRepository;
import com.property.sales.app.util.GenericConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import static com.property.sales.app.util.GenericConstants.SEARCH_BY_ID;
import static com.property.sales.app.util.GenericConstants.SEARCH_BY_NAME;

@Service
public class UserDataService {
    @Autowired
    UserRepository userRepository;

    public void addUserdata(UserRequestData userRequestData) {
        User user = User.builder()
                .name(populateName(userRequestData))
                .dob(userRequestData.getDob().toString())
                .age(getAge(userRequestData))
                .gender(userRequestData.getGender())
                .aadharNumber(userRequestData.getAadharNumber())
                .panNumber(userRequestData.getPanNumber())
                .emailAddress(userRequestData.getEmailAddress())
                .address(userRequestData.getCurrentAddress())
                .phoneNumber(userRequestData.getPhoneNumber())
                .aadharPath(userRequestData.getAadharPath())
                .panPath(userRequestData.getPanPath()).build();
        userRepository.save(user);

    }

    private int getAge(UserRequestData userRequestData) {
        int years;
        long currentTime = System.currentTimeMillis();
        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(currentTime);

        Calendar birthDay = Calendar.getInstance();
        birthDay.setTimeInMillis(userRequestData.getDob().getTime());

        years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
        return years;
    }

    public List<User> retrieveAllUserData() {
        return userRepository.findAll();
    }

    private String populateName(UserRequestData userRequestData) {
        return userRequestData.getFirstName() + GenericConstants.SINGLE_SPACE
                + userRequestData.getMiddleName() + GenericConstants.SINGLE_SPACE
                + userRequestData.getLastName();
    }

    public Optional<User> retrieveFilteredUser(String searchParam, String searchBy) {
        if (searchBy.equalsIgnoreCase(SEARCH_BY_ID)) {
            System.out.println(Long.parseLong(searchParam));
            return userRepository.findById(Long.parseLong(searchParam));
        } else if (searchBy.equalsIgnoreCase(SEARCH_BY_NAME)) {
            return Optional.ofNullable(userRepository.findByName(searchParam));
        }
        return Optional.empty();
    }
}
