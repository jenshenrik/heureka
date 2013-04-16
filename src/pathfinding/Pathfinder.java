package pathfinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * A* algorithm
 */
public class Pathfinder {

	private Graph graph;
	private IHeuristic h;
	
	public Pathfinder(Graph g) {
		this.graph = g;
	}
	
	public Path aStar(Node start, Node goal) {
		this.h = new StraightLineDistanceHeuristic();
		if (!graph.contains(start) || !graph.contains(goal)) {
			// Fail -- start or goal node not in graph
			return null;
		}
		
		ArrayList<Node> closedList = new ArrayList<Node>();
		SortedList openList = new SortedList();
		
		// Loop while open-list has nodes
		while (!openList.isEmpty()) {
			Node current = openList.getFirst();
			
			// Check if goal reached
			if (current.equals(goal)) {
				new Path(goal);
			}
			
			// Move current node to visited lists
			openList.remove(current);
			closedList.add(current);
			
			// Iterate over edges running from current node
			for (Edge e : current.getEdges()) {
				// Get destination nodes
				Node n = e.getTo();
				boolean neighborIsBetter;
				// Check if n is already visited
				if (closedList.contains(n)) {
					continue;
				}
				
				// Calculate distance from start to neighbor
				double neighborDistFromStart = current.getG() + current.distanceTo(n);
				
				if (!openList.contains(n)) {
					openList.add(n);
					neighborIsBetter = true;
				} else if (neighborDistFromStart < current.getG()) {
					neighborIsBetter = true;
				} else {
					neighborIsBetter = false;
				}
				
				if (neighborIsBetter) {
					n.setIncoming(e);
					n.setG(neighborDistFromStart);
					n.setH(h.getHeuristicDistance(n, goal));
				}
			}
		}
		
		// Return no path found
		return null;
	}
	
	private class SortedList {
		private List<Node> nodes;
		
		protected SortedList() {
			nodes = new ArrayList<Node>();
		}
		
		public boolean contains(Node n) {
			return nodes.contains(n);
		}

		protected void add(Node n) {
			nodes.add(n);
			Collections.sort(this.nodes);
		}

		protected boolean isEmpty() {
			return nodes.isEmpty();
		}
		
		protected Node getFirst() {
			return nodes.get(0);
		}
		
		protected void remove(Node n) {
			nodes.remove(n);
		}
	}
}
