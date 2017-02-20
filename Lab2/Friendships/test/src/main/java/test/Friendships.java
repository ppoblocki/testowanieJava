package test;

import java.util.*;

public class Friendships {
	
    private Map<String, List<String>> friendships = new HashMap<String, List<String>>();

    //Dodanie przyjaciół - wykorzystuje funkcje addFriend!	
    public void makeFriends(String person1, String person2) {
        addFriend(person1, person2);
        addFriend(person2, person1);
    }
    
    //Pobranie listy przyjaciol
    public List<String> getFriendsList(String person) {
        return this.friendships.get(person);
    }
    
    //Sprawdzenie czy przyjaciele
    public boolean areFriends(String person1, String person2) {
        boolean areFriends = false;
        if (this.friendships.get(person1).contains(person2) == true)
			areFriends = true;
        return areFriends;
    }
    //Dodanie do listy przyjaciol do danej osoby
    private void addFriend(String person, String friend) {
    	List<String> currentFriends = getFriendsList(person);
    	currentFriends.add(friend);
    	this.friendships.put(person, currentFriends);
    }
    
}