package test;

import java.util.List;

public class SquareArray {
	
	private List<Integer> list;

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}
	
	public void increaseListByOne(List<Integer> l) {
		List<Integer> list = this.getList();
		int size = list.size();
		for(int i = 0; i < size; i++) {
			list.set(i, list.get(i)+1);
		}
	}
	
	public boolean findValue(int val) {
		List<Integer> list = this.getList();
		int size = list.size();
		boolean found = false;
		for(int i = 0; i < size; i++) {
			if (list.get(i) == val){
				found = true;
				break;
			}
		}
		return found;
	}
	
	

}
