package com.example.feign.client;
import com.example.feign.rest.response.Person;
import feign.Headers;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "person-api", url = "localhost:8083/")
public interface PersonClient {

    @RequestMapping(method = RequestMethod.GET, value = "/persons")
    List<Person> readPersons();




    //@RequestMapping(method = RequestMethod.POST, value = "/persons")
    @PostMapping("/persons")
//    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    Person create(@RequestBody Person person);

    @RequestMapping(method = RequestMethod.GET, value = "/persons/{personId}")
    Person readPersonById(@PathVariable("personId") String personId);

    @RequestMapping(method = RequestMethod.GET, value = "/persons")
    List<Person> readPersons(@RequestHeader("X-Auth-Token") String token);
}
//public class MyService {
//    private final PersonClient personClient;
//
//    public MyService(PersonClient personClient) {
//        this.personClient = personClient;
//    }
//
//    public void send100Requests() {
//        String token = "your_token_here";
//        for (int i = 0; i < 100; i++) {
//            List<Person> persons = personClient.readPersons(token);
//        }
//    }}