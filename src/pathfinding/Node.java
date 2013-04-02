package pathfinding;

import java.util.ArrayList;

public class Node {

	private int x, y;
	private boolean visited = false;
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
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

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Node)) return false;
		
		Node n = (Node)obj;
		return (n.x == this.x && n.y == this.y); 
	}
	
}
