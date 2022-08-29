package com.jpa.test;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;



@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
	ApplicationContext context=SpringApplication.run(BootjpaexampleApplication.class, args);
	
	UserRepository userRepository=context.getBean(UserRepository.class);
	
	/*User user=new User();
	user.setCity("Mumbai");
	user.setName("Sanket Joshi");
	user.setState("Borivali");
	
	  User user1=userRepository.save(user);
	  //userRepository.deleteById(1);;
	  System.out.println(user1);*/
	  
	  //to save multiple users
	  
	 /** 	User user2=new User();
		user2.setCity("Dubai");
		user2.setName("Habibi");
		user2.setState("UAE");
		
		User user3=new User();
		user3.setCity("abud dhabi");
		user3.setName("Shek sahaba");
		user3.setState("oyee");
		
		User user4=new User();
		user4.setCity("Mumbai");
		user4.setName("Sanket Joshi");
		user4.setState("Borivali");
		
		User user5=new User();
		user5.setCity("Junagadh");
		user5.setName("Sanket Joshi");
		user5.setState("Borivali");
		
	 List<User> users = Arrays.asList(user2,user3, user4, user5);
        
       List<User> savedUsers=(List<User>) userRepository.saveAll(users);
       
       for(User usr:savedUsers) {
    	   System.out.println(usr);
       }
	**/
	
      //to update id no. 30
	
	Optional<User> optional=userRepository.findById(30);
	
	User user=optional.get();
	System.out.println(user);
	
	user.setCity("malad");
	
    User updatedUser=userRepository.save(user);
    
    System.out.println(updatedUser);
       
     
    //to get all data;
    System.out.println("*****printing all users*****");
    List<User> allUsers=(List<User>)userRepository.findAll();
    
    for(User curUser:allUsers) {
    	System.out.println(curUser);
    }
    
    
    /* to delete 
     */
    
    /*userRepository.deleteById(31);
    System.out.println("deleted");*/
    
    List<User> userByName= userRepository.findByName("Jugal");
    System.out.println("*****by name*****");
    userByName.forEach(ele -> System.out.println(ele));
    
    
    System.out.println("find by name and city");
     
    List<User> userr=userRepository.findByNameAndCity("jugal", "mumbai");
    userr.forEach(ele -> System.out.println(ele));
    
    System.out.println("***find by name starting with***");
    
    List<User> user8=userRepository.findByNameStartingWith("j");
    user8.forEach(ele -> System.out.println(ele));
    
    System.out.println("+++++******using jpql******++++++");
    
    List<User> user10=userRepository.getAllUser();
    user10.forEach(ele -> System.out.println(ele));
    
     System.out.println("***user11 -> jpql*****");
    List<User> user11=userRepository.getUserByName("jay");
    user11.forEach(ele -> System.out.println(ele));
    
    
    
	}

}
