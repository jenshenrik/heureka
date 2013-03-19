package pathfinding;

public class Node {

	private int x, y;
	
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
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Node)) return false;
		
		Node n = (Node)obj;
		return (n.x == this.x && n.y == this.y); 
	}
	
}
