package PowerToTwo.Power;

import java.util.ArrayList;
import java.util.List;

public class Power {
  
	public List<Integer> powers(int left,int right){
		int i;
		System.out.println("=== INPUT ===");
		System.out.println(left);
		System.out.println(right);
		System.out.println("=============");
		
		List<Integer> result = new ArrayList<Integer>();
		for(i=left; i<=right; i++){
			result.add(2<<i);
			System.out.println("result.add(" + (2<<i) + ")");
		}
		return result;
	}
}
