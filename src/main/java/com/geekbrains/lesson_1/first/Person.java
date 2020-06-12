package com.geekbrains.lesson_1.first;

public class Person {

    private String firstName;

    private String lastName;

    private String middleName;

    private String country;

    private String address;

    private String phone;

    private int age;

    private String gender;

    public Person() {
    }

    public Person(String firstName, String lastName, String middleName, String country, String address, String phone, int age, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.country = country;
        this.address = address;
        this.phone = phone;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public static class PersonBuilder {

        private String firstName;

        private String lastName;

        private String middleName;

        private String country;

        private String address;

        private String phone;

        private int age;

        private String gender;

        public PersonBuilder setFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder setLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder setMiddleName(String middleName){
            this.middleName = middleName;
            return this;
        }

        public PersonBuilder setCountry(String country){
            this.country = country;
            return this;
        }

        public PersonBuilder setAddress(String address){
            this.address = address;
            return this;
        }

        public PersonBuilder setPhone(String phone){
            this.phone = phone;
            return this;
        }

        public PersonBuilder setAge(int age){
            this.age = age;
            return this;
        }

        public PersonBuilder setGender(String gender){
            this.gender = gender;
            return this;
        }

        //Такой способ возвращает Persone() с пустыми полями
        //Person{firstName='null', lastName='null', middleName='null', country='null', address='null', phone='null', age=0, gender='null'}
        public Person simpleBuild(){
            return new Person();
        }

        public Person build(){
            return new Person(firstName, lastName, middleName, country, address, phone, age, gender);
        }

    }
}
