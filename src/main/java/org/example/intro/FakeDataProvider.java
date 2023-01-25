package org.example.intro;

import com.github.javafaker.Faker;

public class FakeDataProvider {
        static Faker faker = new Faker();

        public static void main(String[] args) {
            System.out.println(generateFakeName());
            System.out.println(generateFakeAddress());
            System.out.println(generateFakeCountry());
        }

        public static String generateFakeName(){
            return faker.name().firstName();
        }

        public static String generateLastFakeName(){
            return faker.name().lastName();
        }
        public static String generateFakeEmailAddress(){
            return faker.internet().emailAddress();
        }
        public static String generateFakeFunWords(){
            return faker.chuckNorris().fact();
        }

        public static String generateFakeCountry() {
            return faker.country().name();
        }

        public static String generateFakeAddress(){ return faker.address().streetAddress(); }

        public static String generateFakeJob(){
            return faker.job().toString();
        }
    }

