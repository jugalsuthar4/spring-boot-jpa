package com.jpa.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpa.test.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{
    //custom finder method
    public List<User> findByName(String name);
    
    public List<User> findByNameAndCity(String name,String city);
    
    
    public List<User> findByNameStartingWith(String start);
   //google ->  spring data support keywords
    //findByNameEndingWith
    //findByNameContaining
    //findByNameLike(String words)
    //findByAgeIn(Collection<Integer> ages)
    //find-> introducer
    //byName  -> criteria
    //name -> properties
    
    //it is JPQL
    @Query("select u from User u")
    public List<User> getAllUser();
    
    @Query("select u from User u where u.name= :n")
    public List<User> getUserByName(@Param("n") String Name);
    
    
}
