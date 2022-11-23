package com.sniffer0;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class UserDataPageObjectTest extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationFakerTest reg = new RegistrationFakerTest();
    String img = "1.png";

    @Test
    void registrationTest() {
        registrationPage.openPage();
        registrationPage.setFirstName(reg.firstName);
        registrationPage.setLastName(reg.lastName);
        registrationPage.setUserEmail(reg.userEmail);
        registrationPage.setGender(reg.userGender);
        registrationPage.setNumber(reg.userNumber);
        registrationPage.setBirthDate(reg.day, reg.month, reg.year);
        registrationPage.setSubjects(reg.subject);
        registrationPage.chooseHobbie(reg.hobbies);
        registrationPage.setImgPicture(img);
        registrationPage.setAddress(reg.address1);
        registrationPage.scrollToSubmitButton();
        registrationPage.setStateAndCity(reg.state, reg.city);
        registrationPage.pressSubmitButton();

        registrationPage.verifyModalAppears()
                .verifyResult("Student Name", reg.firstName + " " + reg.lastName)
                .verifyResult("Student Email", reg.userEmail)
                .verifyResult("Gender", reg.userGender)
                .verifyResult("Mobile", reg.userNumber)
                .verifyResult("Date of Birth", reg.day + " " + reg.month + "," + reg.year)
                .verifyResult("Subjects", reg.subject)
                .verifyResult("Hobbies", reg.hobbies)
                .verifyResult("Picture", img)
                .verifyResult("Address", reg.address1)
                .verifyResult("State and City", reg.state + " " + reg.city);
    }
}
