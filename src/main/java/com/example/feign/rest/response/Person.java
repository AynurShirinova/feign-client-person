package com.example.feign.rest.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Person {

    private int Id;

    private String name;

    private String surname;

    private String patron;

    private String sex;

    private Integer nationality_id;

    private Integer place_of_birth_id;
  private  LocalDate date_of_expire;
    private LocalDate dateOfBirth;

    private String cardNo;

    private String personalNo;

    private Integer blood_group_id;

}
