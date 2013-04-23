package pathfinding;

import graph.Graph;
import graph.Node;

public class MissionControl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "src/pathfinding/Graphset.txt";
		Graph graphical = new Graph(path);
		Node start = graphical.getNode(10, 20);
		Node goal = graphical.getNode(75, 45);
		
		Pathfinder pf = new Pathfinder(graphical);
		Path route = pf.aStar(start, goal);
		if (route == null) {
			System.out.println("route null");
		} else {
			System.out.println(route.prettyPrint());
		}
	}

}
