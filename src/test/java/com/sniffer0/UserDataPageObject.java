package com.sniffer0;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;

public class UserDataPageObject extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();

    String firstName = "Serg";
    String lastName = "Grey";
    String userEmail = "grey@gmail.com";
    String userGender = "Male";
    String userNumber = "89997775646";
    String day = "17";
    String month = "July";
    String year = "2011";
    String subject = "Computer Science";
    String hobbies = "Sports";
    String img = "1.jpeg";
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


        registrationPage.checkModalContent();
        registrationPage.checkForm(firstName, lastName, userEmail, userNumber, day, month, year, userGender, hobbies, address, state, city);
    }
}
