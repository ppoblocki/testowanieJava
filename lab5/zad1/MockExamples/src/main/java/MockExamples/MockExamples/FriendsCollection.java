package MockExamples.MockExamples;

import java.rmi.UnknownHostException;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

import de.undercouch.bson4jackson.types.ObjectId;

public class FriendsCollection {
  
  private MongoCollection friends;
  
  public FriendsCollection() throws UnknownHostException{
    @SuppressWarnings({ "deprecation", "resource" })
	DB db = new MongoClient().getDB("friendships");
	friends = new Jongo(db).getCollection("friends");
  }
  
  public Person findByName(String name){
	  return friends.findOne("{_id: #", name).as(Person.class);
  }
  
  public WriteResult removeByName(String name){
	  return friends.remove("{_name: " + name.toString());
  }
  
  public void save(Person p){
	  friends.save(p);
  }
  
}
