package pathfinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pathfinder {

	private Graph graph;
	
	public Pathfinder(Graph g) {
		this.graph = g;
	}
	
	public void aStar(Node start, Node goal) {
		if (!graph.contains(start) || !graph.contains(goal)) {
			// Fail -- start or goal node not in graph
		}
		
		ArrayList<Node> closedList = new ArrayList<Node>();
		SortedList openList = new SortedList();
		
		// Loop while open-list has nodes
		while (!openList.isEmpty()) {
			
		}
		
		// Return no path found
	}
	
	private class SortedList {
		private List<Node> nodes;
		
		protected SortedList() {
			nodes = new ArrayList<Node>();
		}
		
		protected void add(Node n) {
			nodes.add(n);
			Collections.sort(this.nodes);
		}

		protected boolean isEmpty() {
			return nodes.isEmpty();
		}
	}
}
