package Graph;

import java.util.ArrayList;
import java.util.HashMap;

public class GenericHeap<T extends Comparable<T>> {
		
	ArrayList<T> data = new ArrayList<>();
	HashMap<T,Integer> map = new HashMap<>();
	public void add(T item) {
		data.add(item);
		map.put(item, data.size()-1);
		upheapify(data.size()-1);
	}

	private void upheapify(int ci) {
			
		int pi=(ci-1)/2;
		if(this.isLarger(data.get(ci), data.get(pi))>0) {
			swap(ci,pi);
			upheapify(pi);
		}
		
	}

	private void swap(int ci, int pi) {
		T ith = data.get(ci);
		T jth = data.get(pi);
		data.set(ci, jth);
		data.set(pi, ith);
		
		map.put(jth, ci);
		map.put(ith, pi);
	}
	
	public void display() {
		System.out.println(this.data);
	}
	public int size() {
		return this.data.size();
	}
	public boolean isEmpty() {
		return this.data.isEmpty();
	}
	public T remove() {
		this.swap(0, data.size()-1);
		T rv= data.remove(data.size()-1);
		map.remove(rv);
		downheapify(0);
		return rv;
	}

	private void downheapify(int i) {
		int lci=2*i+1;
		int rci= 2*i+2;
		int mini=i;
		if(lci<data.size()&&this.isLarger(data.get(lci), data.get(mini))>0) {
			mini=lci;
		}
		if(rci<data.size()&&this.isLarger(data.get(rci), data.get(mini))>0) {
			mini=rci;
		}
		if(mini!=i) {
			this.swap(i, mini);
			this.downheapify(mini);
		}
	}
	
	public T get() {
		return this.data.get(0);
	}
	public int isLarger(T t, T o) {
		return t.compareTo(o);
	}
	public void updatePriority(T t) {
		int index = map.get(t);
		this.upheapify(index);
	}
}
