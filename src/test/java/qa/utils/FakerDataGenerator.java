package qa.utils;

import com.github.javafaker.Faker;

public class FakerDataGenerator {

    private static final Faker faker = new Faker();

    // ===== DATA VALID =====
    public static String validName() {
        return faker.name().fullName();
    }


    public static String validEmployeeId() {
        return faker.number().digits(3);
    }

    public static String invalidName30(){
        return faker.lorem().characters(31);
    }

    public static String validDivisionName() {
        return faker.company().industry();
    }

    public static String validTrainingName() {
        return faker.educator().course();
    }

    public static String validEmail() {
        return faker.internet().emailAddress();
    }

    public static String validPhoneNumber() {
        return "08" + faker.number().digits(10);
    }

    public static String validDescription() {
        return faker.lorem().sentence(6);
    }

    // ===== DATA NEGATIVE =====
    public static String invalidEmail() {
        return faker.name().username() + ".com";
    }


    public static String longNameOver30Char() {
        return faker.lorem().characters(35);
    }



















}
