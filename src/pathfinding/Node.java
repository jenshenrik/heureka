package pathfinding;

import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node>{

	private int x, y;
	private boolean visited = false;
	private List<Edge> edges;
	private double h, g;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
		this.edges = new ArrayList<Edge>();
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public boolean getVisited() {
		return this.visited; 
	}
	
	public void addPath(Edge edge) {
		edges.add(edge);
	}

	public double getH() {
		return h;
	}
	
	public void setH(double h) {
		this.h = h;
	}
	
	public double getG() {
		return g;
	}
	
	public void setG(double g) {
		this.g = g;
	}
	
	public double getTotalDistance() {
		return h+g;
	}
	
	public double distanceTo(Node n) {
		double distX = n.getX() - this.x;
		double distY = n.getY() - this.y;
		return Math.sqrt(distX*distX + distY*distY);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Node)) return false;
		
		Node n = (Node)obj;
		return (n.x == this.x && n.y == this.y); 
	}

	@Override
	public int compareTo(Node o) {
		double totalDistance = getTotalDistance();
		if (totalDistance < o.getTotalDistance())
			return -1;
		if (totalDistance > o.getTotalDistance())
			return 1;
		return 0;
	}

	public List<Edge> getEdges() {
		return edges;
	}
	
}
