package com.sniffer0;

import com.github.javafaker.Faker;

import java.util.Random;

public class RegistrationFakerTest {

    Faker faker = new Faker();
    Random rnd = new Random();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userGender = getSex(),
            userNumber = String.valueOf(faker.phoneNumber().subscriberNumber(10)),
            year = String.valueOf(faker.number().numberBetween(1900, 2022)),
            month = getMonth(),
            day = String.valueOf(faker.number().numberBetween(1, 30)),
            subject = getSubject(),
            hobbies = getHobbies(),
            address1 = faker.address().fullAddress(),
            state = "NCR",
            city = "Gurgaon";

    public String getSex() {
        String[] sex = {"Male", "Female", "Other"};
        int index = rnd.nextInt(sex.length);
        return sex[index];
    }

    public String getHobbies() {
        String[] arrHobbies = {"Sports", "Reading", "Music"};
        int index = rnd.nextInt(arrHobbies.length);
        return arrHobbies[index];
    }

    public String getSubject() {
        String[] arrSubjects = {"Hindi", "English", "Civics", "Computer Science", "Social Studies",
                "Maths", "Commerce", "Arts", "Biology", "Accounting", "Chemistry", "Economics", "History", "Physics"};
        int index = rnd.nextInt(arrSubjects.length);
        return arrSubjects[index];
    }

    public String getMonth() {
        String[] arrMonth = {"January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October", "November", "December"};
        int index = rnd.nextInt(arrMonth.length);
        return arrMonth[index];
    }
}
