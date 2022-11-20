package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.component.CalendarComponent;
import pages.component.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final String TITLE_TEXT = "Student Registration Form";
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    //Locators
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $(By.id("userNumber")),
            userGenderInput = $("#genterWrapper"),
            dateOfBirth = $("#dateOfBirthInput"),
            subjectsInput = $(By.id("subjectsInput")),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadPictureForm = $("#uploadPicture"),
            userAddressInput = $("#currentAddress"),
            submitButton = $("#submit"),
            modalContent = $(".modal-content"),
            tableResponsive = $(".table-responsive");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        userGenderInput.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setNumber(String number) {
        userNumberInput.setValue(number);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirth.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setImgPicture(String imgPath) {
        uploadPictureForm.uploadFile(new File(imgPath));
        return this;
    }

    public RegistrationPage chooseHobbie(String hobbies) {
        hobbiesInput.find(byText(hobbies)).click();
        return this;
    }

    public RegistrationPage setAddress(String address) {
        userAddressInput.setValue(address);
        return this;
    }

    public RegistrationPage scrollToSubmitButton() {
        submitButton.scrollTo();
        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        $("#stateCity-wrapper").scrollTo().find(("#state")).click();
        $(byText(state)).click();
        $("#stateCity-wrapper").scrollTo().find(("#city")).click();
        $(byText(city)).click();
        return this;
    }

    public RegistrationPage pressSubmitButton() {
        submitButton.click();
        return this;
    }

    // asserts
    public RegistrationPage checkModalContent() {
        modalContent.shouldBe(visible);
        return this;
    }

    public void checkForm(String firstName, String lastName, String userEmail, String userNumber, String day, String month, String year, String userGender, String hobbies, String address, String state, String city) {
        tableResponsive.shouldHave(text(firstName), text(lastName),
                text(userEmail), text(day), text(month), text(year), text(userGender), text(hobbies), text(address),
                text(userNumber), text(state), text(city));
    }
}
