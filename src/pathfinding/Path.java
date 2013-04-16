package pathfinding;

import java.util.ArrayList;

public class Path {

	private ArrayList<Node> nodes;
	
	public Path() {
		nodes = new ArrayList<Node>();
	}
	
	public Path(Node goal) {
		this();
		rebuildPath(goal);
	}
	
	private void rebuildPath(Node n) {
		nodes.add(0, n);
		if (n.getIncoming() != null) {
			rebuildPath(n.getIncoming().getFrom());
		}
	}
	
	public String prettyPrint() {
		String out = "";
		out += "Start:\n";
		for (Node n : nodes) {
			out += n.toString() + "\n";
		}
		out += "Goal";
		return out;
	}
}
