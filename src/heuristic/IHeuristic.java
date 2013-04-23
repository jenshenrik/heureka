package heuristic;

import graph.Node;

public interface IHeuristic {

	public double getHeuristicDistance(Node current, Node goal);
	
}
