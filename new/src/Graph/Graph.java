package Graph;

import java.util.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph {
	private class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	HashMap<String, Vertex> vtces;

	Graph() {
		vtces = new HashMap<>();
	}

	public int numOfVertex() {
		return this.vtces.size();
	}

	public boolean containsVertex(String vname) {
		return this.vtces.containsKey(vname);
	}

	public void addVertex(String vname) {
		Vertex vtx = new Vertex();
		vtces.put(vname, vtx);
	}

	public void removeVertex(String vname) {

		Vertex vtx = vtces.get(vname);
		ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());
		for (String key : keys) {
			Vertex vtx1 = vtces.get(key);
			vtx1.nbrs.remove(vname);
		}
		vtces.remove(vname);

	}

	public int numOfEdges() {
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		int count = 0;
		for (String key : keys) {
			count += vtces.get(key).nbrs.size();
		}
		return count / 2;

	}

	public boolean containsEdge(String vname1, String vname2) {
		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);
		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return false;
		}
		return true;
	}

	public void addEdge(String vname1, String vname2, int cost) {
		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);
		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)) {
			return;
		}
		vtx1.nbrs.put(vname2, cost);
		vtx2.nbrs.put(vname1, cost);//Remove this edge at time of bellman ford
	}

	public void removeEdge(String vname1, String vname2) {
		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);
		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return;
		}
		vtx1.nbrs.remove(vname2);
		vtx2.nbrs.remove(vname1);
	}

	public void display() {
		System.out.println("------------------------------------");
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		for (String key : keys) {
			Vertex vtx = vtces.get(key);
			System.out.println(key + " : " + vtx.nbrs);
		}
		System.out.println("------------------------------------");
	}

	public boolean hasPath(String vname1, String vname2) {
		HashMap<String, Boolean> process = new HashMap<>();
		return this.hasPath(vname1, vname2, process);
	}

	private boolean hasPath(String vname1, String vname2, HashMap<String, Boolean> process) {
		process.put(vname1, true);
		if (this.containsEdge(vname1, vname2)) {
			return true;
		}
		Vertex vtx = vtces.get(vname1);
		ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());
		for (String nbr : nbrs) {
			if (!process.containsKey(nbr) && this.hasPath(nbr, vname2, process)) {
				return true;
			}
		}
		return false;
	}

	class Pair {
		String vname;
		String psf;
	}

	public boolean bfs(String vname1, String vname2) {//Time Complexity-log(e+v)
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		Pair pair = new Pair();
		pair.vname = vname1;
		pair.psf = vname1;
		queue.addLast(pair);
		while (!queue.isEmpty()) {
			Pair rp = queue.removeFirst();
			if (processed.containsKey(rp.vname)) {
				continue;
			}
			processed.put(rp.vname, true);

			if (this.containsEdge(rp.vname, vname2)) {
				System.out.println(rp.psf + vname2);
				return true;
			}

			Vertex vtx = vtces.get(rp.vname);
			ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());

			for (String nbr : nbrs) {
				if (!processed.containsKey(nbr)) {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;
					queue.addLast(np);
				}
			}
		}
		return false;
	}

	public boolean dfs(String vname1, String vname2) {//Time Complexity-log(e+v)
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();
		Pair pair = new Pair();
		pair.vname = vname1;
		pair.psf = vname1;
		stack.addFirst(pair);
		while (!stack.isEmpty()) {
			Pair rp = stack.removeFirst();
			if (processed.containsKey(rp.vname)) {
				continue;
			}
			processed.put(rp.vname, true);

			if (this.containsEdge(rp.vname, vname2)) {
				System.out.println(rp.psf + vname2);
				return true;
			}

			Vertex vtx = vtces.get(rp.vname);
			ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());

			for (String nbr : nbrs) {
				if (!processed.containsKey(nbr)) {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;
					stack.addFirst(np);
				}
			}
		}
		return false;
	}

	public void bft() { // breadth first traversal //Time Complexity-log(e+v)
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		for (String key : keys) {
			if (processed.containsKey(key)) {
				continue;
			}
			Pair pair = new Pair();
			pair.vname = key;
			pair.psf = key;
			queue.addLast(pair);
			while (!queue.isEmpty()) {
				Pair rp = queue.removeFirst();
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				processed.put(rp.vname, true);

				System.out.println(rp.vname + " via " + rp.psf);

				Vertex vtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());

				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						queue.addLast(np);
					}
				}
			}
		}

	}

	public void dft() { //Time Complexity-log(e+v)
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		for (String key : keys) {
			if (processed.containsKey(key)) {
				continue;
			}
			Pair pair = new Pair();
			pair.vname = key;
			pair.psf = key;
			stack.addFirst(pair);
			while (!stack.isEmpty()) {
				Pair rp = stack.removeFirst();
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				processed.put(rp.vname, true);

				System.out.println(rp.vname + " via " + rp.psf);

				Vertex vtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());

				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						stack.addFirst(np);
					}
				}
			}
		}

	}

	public boolean iscyclic() {//Time Complexity-log(e+v)
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		for (String key : keys) {
			if (processed.containsKey(key)) {
				continue;
			}
			Pair pair = new Pair();
			pair.vname = key;
			pair.psf = key;
			queue.addLast(pair);
			while (!queue.isEmpty()) {
				Pair rp = queue.removeFirst();
				if (processed.containsKey(rp.vname)) {
					return true;
				}
				processed.put(rp.vname, true);
				Vertex vtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());

				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						queue.addLast(np);
					}
				}
			}
		}
		return false;
	}

	public boolean isConnected() {//Time Complexity-log(e+v)
		int flag = 0;
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		for (String key : keys) {
			if (processed.containsKey(key)) {
				continue;
			}
			flag++;
			Pair pair = new Pair();
			pair.vname = key;
			pair.psf = key;
			queue.addLast(pair);
			while (!queue.isEmpty()) {
				Pair rp = queue.removeFirst();
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				processed.put(rp.vname, true);

				Vertex vtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());

				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						queue.addLast(np);
					}
				}
			}
		}
		if (flag >= 2) {
			return false;
		} else {
			return true;
		}
	}

	public boolean isTree() {//Time Complexity-log(e+v)
		return !this.iscyclic() && this.isConnected();
	}

	public ArrayList<ArrayList<String>> getConnectedComponents() {//Time Complexity-log(e+v)
		ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		for (String key : keys) {
			if (processed.containsKey(key)) {
				continue;
			}
			ArrayList<String> arrayList = new ArrayList<String>();

			Pair pair = new Pair();
			pair.vname = key;
			pair.psf = key;
			queue.addLast(pair);
			while (!queue.isEmpty()) {
				Pair rp = queue.removeFirst();
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				processed.put(rp.vname, true);

				arrayList.add(rp.vname);
				Vertex vtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());

				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						queue.addLast(np);
					}
				}
			}
			ans.add(arrayList);
		}
		return ans;

	}

	private class PrimsPair implements Comparable<PrimsPair> {
		String vname;
		String acqname;
		int cost;

		@Override
		public int compareTo(PrimsPair o) {
			return o.cost - this.cost;
		}
	}

	public Graph prims() {//Time Complexity-elog(v)
		Graph mst = new Graph();
		GenericHeap<PrimsPair> heap = new GenericHeap<>();
		HashMap<String, PrimsPair> map = new HashMap<>();
		for (String key : vtces.keySet()) {
			PrimsPair np = new PrimsPair();
			np.vname = key;
			np.acqname = null;
			np.cost = Integer.MAX_VALUE;
			heap.add(np);
			map.put(key, np);

		}
		while (!heap.isEmpty()) {
			PrimsPair rp = heap.remove();

			map.remove(rp.vname);

			if (rp.acqname == null) {
				mst.addVertex(rp.vname);
			} else {
				mst.addVertex(rp.vname);
				mst.addEdge(rp.vname, rp.acqname, rp.cost);
			}

			for (String nbr : vtces.get(rp.vname).nbrs.keySet()) {
				if (map.containsKey(nbr)) {
					int oc = map.get(nbr).cost;
					int nc = vtces.get(rp.vname).nbrs.get(nbr);
					if (nc < oc) {
						PrimsPair gp = map.get(nbr);
						gp.acqname = rp.vname;
						gp.cost = nc;

						heap.updatePriority(gp);
					}
				}
			}
		}

		return mst;

	}
	private class DijisktraPair2 implements Comparable<DijisktraPair2> {
		String vname;
		String psf;
		int cost;

		@Override
		public int compareTo(DijisktraPair2 o) {
			return  this.cost-o.cost;
		}
	}

	public void dijisktra2(String src) {//Time Complexity-elog(v)
		
		HashMap<String, Boolean> processed = new HashMap<>();
		PriorityQueue<DijisktraPair2> queue = new PriorityQueue<>();
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		
			DijisktraPair2 pair = new DijisktraPair2();
			pair.vname = src;
			pair.psf = src;
			pair.cost=0;
			queue.add(pair);
			while (!queue.isEmpty()) {
				DijisktraPair2 rp = queue.remove();
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				processed.put(rp.vname, true);

				System.out.println(rp.vname + " via " + rp.psf+ " cost "+rp.cost);

				Vertex vtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());

				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						DijisktraPair2 np = new DijisktraPair2();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						np.cost=rp.cost+vtx.nbrs.get(nbr);
						queue.add(np);
					}
				}
			}
		
	}
	private class PrimsPair2 implements Comparable<PrimsPair2> {
		String vname;
		String acqname;
		int cost;

		@Override
		public int compareTo(PrimsPair2 o) {
			return this.cost - o.cost;
		}
	}

	public void prims2() {
		String src="A";//Time Complexity-elog(v)
		HashMap<String, Boolean> processed = new HashMap<>();
		PriorityQueue<PrimsPair2> queue = new PriorityQueue<>();
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		
		PrimsPair2 pair = new PrimsPair2();
			pair.vname = src;
			pair.acqname = "Z";
			pair.cost=0;
			queue.add(pair);
			while (!queue.isEmpty()) {
				PrimsPair2 rp = queue.remove();
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				processed.put(rp.vname, true);
				if(rp.acqname!="Z") {
				System.out.println(rp.vname + " via " + rp.acqname+ " cost "+rp.cost);
				}
				Vertex vtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());

				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						PrimsPair2 np = new PrimsPair2();
						np.vname = nbr;
						np.acqname = rp.vname;
						np.cost=vtx.nbrs.get(nbr);
						queue.add(np);
					}
				}
			}

	}

	public class DisjointSet {
		HashMap<String, Node> map = new HashMap<>();

		private class Node {
			String data;
			Node parent;
			int rank;
		}

		public void create(String data) {

			Node nn = new Node();
			nn.data = data;
			nn.parent = nn;
			nn.rank = 0;
			map.put(data, nn);
		}

		public void union(String value1, String value2) {

			Node n1 = map.get(value1);
			Node n2 = map.get(value2);

			Node re1 = find(n1);
			Node re2 = find(n2);

			if (re1.data.equals(re2.data)) {
				return;
			} else {
				if (re1.rank == re2.rank) {
					re2.parent = re1;
					re1.rank = re1.rank + 1;
				}

				else if (re1.rank > re2.rank) {
					re2.parent = re1;
				} else {
					re1.parent = re2;
				}

			}

		}

		public String find(String value) {
			return this.find(map.get(value)).data;

		}

		private Node find(Node node) {
			if (node.parent == node) {
				return node;
			}
			Node rr = find(node.parent);
			node.parent = rr;
			return rr;
		}

	}

	private class EdgePair implements Comparable<EdgePair> {
		String v1;
		String v2;
		int cost;

		@Override
		public int compareTo(EdgePair o) {
			return this.cost - o.cost;
		}
	}

	public ArrayList<EdgePair> getAllEdges() {
		ArrayList<EdgePair> edges = new ArrayList<>();
		for (String vname : vtces.keySet()) {
			Vertex vtx = vtces.get(vname);
			for (String nbr : vtx.nbrs.keySet()) {
				EdgePair nn = new EdgePair();
				nn.v1 = vname;
				nn.v2 = nbr;
				nn.cost = vtx.nbrs.get(nbr);
				edges.add(nn);
			}
		}

		
		return edges;
	}

	public void Kruskal() {//Elogv
		ArrayList<EdgePair> edges = this.getAllEdges();
		Collections.sort(edges);

		DisjointSet set = new DisjointSet();
		for (String vname : vtces.keySet()) {
			set.create(vname);

		}
		for (EdgePair edge : edges) {
			String re1=set.find(edge.v1);
			String re2=set.find(edge.v2);
			if(re1.equals(re2)) {
				continue;
			}else {
				System.out.println(edge.v1+"-"+edge.v2+"-"+edge.cost);
				set.union(re1, re2);
			}
		}
		
	}
	public HashMap<String,Integer> BellmanFord(String src) { //E.V
		ArrayList<EdgePair> edges = this.getAllEdges();

		HashMap<String,Integer> map = new HashMap<>();
		for(String vname:vtces.keySet()) {
			map.put(vname, 100000);
			if(vname==src) {
				map.put(vname,0);	
			}
		}
		int V= vtces.size();
		for(int i=1;i<V;i++) {
			for(EdgePair edge:edges) {
				int oc = map.get(edge.v2);
				int nc = map.get(edge.v1)+edge.cost;
				if(oc>nc) {
					map.put(edge.v2, nc);
				}
			}
		}
		return map;
		
	}
	
	public void FloydWarshall() {
		int V=4;
		int[][] graph= {{0,3,10000,7},{8,0,2,10000},{5,10000,0,1},{2,10000,10000,0}};//take this graph as set of 4 nodes and the matrix contains distance(10000 means no edge between them(basically infinty))
		int[][] dist= new int[V][V];
		for(int i=0;i<V;i++) {
			for(int j=0;j<V;j++) {
				dist[i][j]=graph[i][j];
			}
		}
		for(int k=0;k<V;k++) {
			for(int i=0;i<V;i++) {
				for(int j=0;j<V;j++) {
					int oc=dist[i][j];
					int nc=dist[i][k]+dist[k][i];
					
					if(nc<oc) {
						dist[i][j]=dist[i][k]+dist[k][i];
					}
				}
			}
		}
	}
}
