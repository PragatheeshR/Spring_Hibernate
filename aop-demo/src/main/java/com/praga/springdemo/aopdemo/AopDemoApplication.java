package com.praga.springdemo.aopdemo;

import com.praga.springdemo.aopdemo.dao.AccountDAO;
import com.praga.springdemo.aopdemo.dao.MembershipDAO;
import com.praga.springdemo.aopdemo.entity.Account;
import com.praga.springdemo.aopdemo.service.TrafficFortuneService;
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
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO, TrafficFortuneService trafficFortuneService){
		return runner ->{
			//checkAccount(accountDAO, membershipDAO);
			//findAccounts(accountDAO);
			//demoForAfterThrowingAscpect(accountDAO);
			//demoAroundAdvice(trafficFortuneService);
			demoAroundAdviceWithException(trafficFortuneService);
		};
	}

	private void demoAroundAdviceWithException(TrafficFortuneService trafficFortuneService) {
		System.out.println("====> Starting with app demoAroundAdviceWithException");
		String op = trafficFortuneService.getInfo(true);
		System.out.println("Main App Output: "+op);
	}

	private void demoAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("====> Starting main app");
		String s =  trafficFortuneService.getInfo();
		System.out.println("Data "+s);
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
