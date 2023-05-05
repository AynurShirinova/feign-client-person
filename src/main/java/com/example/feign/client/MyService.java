package com.example.feign.client;
import com.example.feign.rest.response.Person;
import java.util.List;


public class MyService {
        private final PersonClient personClient;

        public MyService(PersonClient personClient) {
            this.personClient = personClient;
        }

        public void send100Requests() {
            String token = "your_token_here";
            for (int i = 0; i < 100; i++) {

                List<Person> persons = personClient.readPersons(token);
                // do something with persons...
            }
        }
}
