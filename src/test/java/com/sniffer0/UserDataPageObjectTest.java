package com.sniffer0;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;

public class UserDataPageObjectTest extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();

    String firstName = "Serg";
    String lastName = "Grey";
    String userEmail = "grey@gmail.com";
    String userGender = "Male";
    String userNumber = "8999777564";
    String day = "17";
    String month = "June";
    String year = "2011";
    String subject = "Computer Science";
    String hobbies = "Sports";
    String img = "1.png";
    String address = "Moscow, Kamchatovscaya 68";
    String state = "NCR";
    String city = "Gurgaon";

    @Test
    void registrationTest() {
        registrationPage.openPage();
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setUserEmail(userEmail);
        registrationPage.setGender(userGender);
        registrationPage.setNumber(userNumber);
        registrationPage.setBirthDate(day, month, year);
        registrationPage.setSubjects(subject);
        registrationPage.chooseHobbie(hobbies);
        registrationPage.setImgPicture(img);
        registrationPage.setAddress(address);
        registrationPage.scrollToSubmitButton();
        registrationPage.setStateAndCity(state, city);
        registrationPage.pressSubmitButton();

        registrationPage.verifyModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", day + " " + month + "," + year)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", img)
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);
    }
}
