/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queueoperations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 *
 * @author Abhishek
 */
public class TestUser {
    
    public static void main(String[] args) {
        User user1 = new User("A", 0, new Date(2011, 10, 1));
        User user2 = new User("B", 1, new Date(2012, 5, 8));
        User user3 = new User("C", 2, new Date(2013, 11, 10));
        User user5 = new User("E", 3, new Date(2014, 3, 5));
        User user4 = new User("D", 4, new Date(2016, 1, 9));
        
        System.out.println(user1.equals(user1));
        System.out.println(user1.equals(user2));
        ArrayList<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user4);
        System.out.println(user1.compareTo(user5));
        
    }
    
}
