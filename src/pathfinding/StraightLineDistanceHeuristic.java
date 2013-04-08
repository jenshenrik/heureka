package pathfinding;

public class StraightLineDistanceHeuristic implements IHeuristic {

	@Override
	public double getHeuristicDistance(Node current, Node goal) {
		double distX = goal.getX() - current.getX();
		double distY = goal.getY() - current.getY();
		double distance = Math.sqrt(distX * distX + distY * distY);
		return distance;
	}

}
