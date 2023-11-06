package com.praga.springdemo.aopdemo;

import com.praga.springdemo.aopdemo.dao.AccountDAO;
import com.praga.springdemo.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO){
		return runner ->{
			checkAccount(accountDAO, membershipDAO);
		};
	}

	private void checkAccount(AccountDAO accountDAO, MembershipDAO membershipDAO){
		accountDAO.addAccount();
		membershipDAO.addAccount();
		accountDAO.setName("praga");
		accountDAO.getName();
		accountDAO.setTech("tect");
		accountDAO.getTech();
	}

}
