package pathfinding;

public class Edge {

	private Node from;
	private Node to;
	private double weight;
	private String name;
	
	public Edge(Node from, Node to, String name) {
		this.from = from;
		this.to = to;
		this.name = name;
		
		calcWeight();
	}
	
	public Node getFrom() {
		return from;
	}
	
	public Node getTo() {
		return to;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public String getName() {
		return name;
	}
	
	public void setFrom(Node from) {
		this.from = from;
		calcWeight();
	}
	
	public void setTo(Node to) {
		this.to = to;
		calcWeight();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	private void calcWeight() {
		int x = to.getX() - from.getX();
		int y = to.getY() - from.getY();
		this.weight = Math.sqrt(x*x + y*y);
	}
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Edge)) return false;
		
		Edge e = (Edge)obj;
		return (e.from.equals(this.from) && 
				e.to.equals(this.to) && 
				e.name.equals(this.name));
	}
}
