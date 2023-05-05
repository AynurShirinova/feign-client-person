package com.example.feign;

import com.example.feign.client.PersonClient;
import com.example.feign.rest.response.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.time.LocalDate;
import java.util.List;

@EnableFeignClients
@SpringBootApplication
public class FeignApplication implements CommandLineRunner {

	@Autowired
	private  PersonClient personClient;
	public static void main(String[] args) {
		SpringApplication.run(FeignApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String token = "your_token_here";
		Person p = new Person();
		for (Long i = 0L; i < 100_000_000_000L; i++) {


				    p.setName("frg"+i);
					p.setSurname("jjhkhi"+i);
					p.setPatron(" adi"+i);
					p.setSex("nk"+i);
					p.setNationality_id(1) ;
					p.setPlace_of_birth_id(2);
					p.setDateOfBirth(LocalDate.now()) ;
					p.setCardNo("1234"+i) ;
					p.setPersonalNo("123456"+i) ;
					p.setDate_of_expire(LocalDate.now());
					p.setBlood_group_id(3);

			 personClient.create(p);
			// do something with persons...
		}
	}
}
