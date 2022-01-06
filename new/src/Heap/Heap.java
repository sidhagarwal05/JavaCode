package Heap;

import java.util.ArrayList;

public class Heap {
		
	ArrayList<Integer> data = new ArrayList<>();
	
	public void add(int item) {
		data.add(item);
		upheapify(data.size()-1);
	}

	private void upheapify(int ci) {
			
		int pi=(ci-1)/2;
		if(data.get(pi)>data.get(ci)) {
			swap(ci,pi);
			upheapify(pi);
		}
		
	}

	private void swap(int ci, int pi) {
		int ith = data.get(ci);
		int jth = data.get(pi);
		data.set(ci, jth);
		data.set(pi, ith);
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
	public int remove() {
		this.swap(0, data.size()-1);
		int rv= data.remove(data.size()-1);
		downheapify(0);
		return rv;
	}

	private void downheapify(int i) {
		int lci=2*i+1;
		int rci= 2*i+2;
		int mini=i;
		if(lci<data.size()&&data.get(lci)<data.get(mini)) {
			mini=lci;
		}
		if(rci<data.size()&&data.get(rci)<data.get(mini)) {
			mini=rci;
		}
		if(mini!=i) {
			this.swap(i, mini);
			this.downheapify(mini);
		}
	}
	
	public int get() {
		return this.data.get(0);
	}
}
