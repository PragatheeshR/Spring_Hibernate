package com.praga.springdemo.aopdemo;

import com.praga.springdemo.aopdemo.dao.AccountDAO;
import com.praga.springdemo.aopdemo.dao.MembershipDAO;
import com.praga.springdemo.aopdemo.entity.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO){
		return runner ->{
			//checkAccount(accountDAO, membershipDAO);
			//findAccounts(accountDAO);
			demoForAfterThrowingAscpect(accountDAO);
		};
	}

	private void demoForAfterThrowingAscpect(AccountDAO accountDAO) {
		try {
			accountDAO.findAccounts(true);
		}
		catch(Exception exception){
			System.out.println("Main app caught the exception "+exception.getMessage());
		}
	}

	private void findAccounts(AccountDAO accountDAO) {
		List<Account> accountList = accountDAO.findAccounts();
		System.out.println("======> FROM MAIN APP <=======");
		System.out.println(accountList);
		System.out.println("======> FROM MAIN APP <=======");
	}

	private void checkAccount(AccountDAO accountDAO, MembershipDAO membershipDAO){
		accountDAO.addAccount(new Account("Praga","Vellore"),2,true);
		membershipDAO.addAccount();
		accountDAO.setName("praga");
		accountDAO.getName();
		accountDAO.setTech("tect");
		accountDAO.getTech();
	}

}
