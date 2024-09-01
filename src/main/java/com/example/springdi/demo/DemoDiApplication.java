package com.example.springdi.demo;
import com.example.springdi.demo.databases.BaseDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoDiApplication implements CommandLineRunner {

	@Autowired
	BaseDB db;

	public static void main(String[] args) {
		System.out.println("Hello Di");
		SpringApplication.run(DemoDiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello Di Run Method");
		System.out.println(db.getDatabase());
	}
}
