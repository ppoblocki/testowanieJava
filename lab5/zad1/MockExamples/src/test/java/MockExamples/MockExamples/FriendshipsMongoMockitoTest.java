package MockExamples.MockExamples;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.mongodb.client.result.DeleteResult;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// Ta linia jest wymagana
@RunWith(MockitoJUnitRunner.class)
public class FriendshipsMongoMockitoTest {
	
	//Nasza atrapa
	@InjectMocks
	FriendshipsMongo friendships;
	
	//Co zastepujemy
	@Mock
	FriendsCollection friends;
		
	@Test
	public void updateWorksAsExpected(){
		Person joe = new Person("Joe");
		doReturn(joe).when(friends).findByName("Joe");
		joe.name = "JoeUpdated";
		doReturn(joe).when(friends).findByName("JoeUpdated");
		assertThat(friends.findByName("JoeUpdated")).isEqualTo(joe);
	}
	
	@Test
	public void deleteWorksAsExpected(){
		Person joe = new Person("Joe");
		doReturn(joe).when(friends).findByName("Joe");
		doReturn(null).when(friends).findByName("Joe");
		assertThat(friends.findByName("JoeUpdated")).isEqualTo(null);
	}
	
	@Test
	public void removeByNameWorksAsExpected()
	{
		Person joe = new Person("Joe");
		doReturn(joe).when(friends).findByName("Joe");
		assertThat(friends.removeByName(joe.name));
	}
	
	@Test
	public void mockingWorskAsExpected(){
		Person joe = new Person("Joe");
		doReturn(joe).when(friends).findByName("Joe");
		assertThat(friends.findByName("Joe")).isEqualTo(joe);
	}
	
	@Test
	public void alexDoesNotHaveFriends(){
		assertThat(friendships.getFriendsList("Alex")).isEmpty();
	}
	
	@Test
	public void joeHas5Friends(){
		List<String> expected = Arrays.asList(new String[]{"Karol","Dawid","Maciej","Tomek","Adam"});
		//Spy przechwytuje wywołania z przekazywanymi pośrednio danymi w celu
		// późniejszego zbadania tych danych w teście - tutaj w przykładzie lista przyjaciół Joe
		Person joe = spy(new Person("Joe"));
		doReturn(joe).when(friends).findByName("Joe");
		doReturn(expected).when(joe).getFriends();
		assertThat(friendships.getFriendsList("Joe")).hasSize(5).containsOnly("Karol","Dawid","Maciej","Tomek","Adam");
	}


}
