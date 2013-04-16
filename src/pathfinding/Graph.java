package pathfinding;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;

/*
 * Reads the graph file, and loads the information into nodes and edges.
 */

public class Graph {

	private ArrayList<Node> nodes;
	private ArrayList<Edge> edges;
	
	public Graph(String path) {

		nodes = new ArrayList<Node>();
		edges = new ArrayList<Edge>();
		readFile(path);
	}
	
	public boolean contains(Node n) {
		return nodes.contains(n);
	}

	public Node getNode(int x, int y) {
		for (Node n : nodes) {
			if (n.getX() == x && n.getY() == y)
				return n;
		}
		return null;
	}
	
	private void readFile(String path) {
		try {
			FileInputStream fin = new FileInputStream(path);
			BufferedReader br = new BufferedReader(new InputStreamReader(fin));
			
			String line;
			while ((line = br.readLine()) != null) {
				String data[] = line.split(" ");
				// Parse line
				int x1 = Integer.parseInt(data[0]);
				int y1 = Integer.parseInt(data[1]);
				int x2 = Integer.parseInt(data[3]);
				int y2 = Integer.parseInt(data[4]);
				String name = data[2];
				
				Node from = new Node(x1, y1);
				Node to = new Node(x2, y2);
				// Get nodes, if exists
				for (Node n : nodes) {
					if (n.equals(from))
						from = n;
					if (n.equals(to))
						to = n;
				}
				// If nodes not exist, add
				if (!nodes.contains(from))
					nodes.add(from);
				if (!nodes.contains(to))
					nodes.add(to);
				// Add edge
				Edge e = new Edge(from, to, name);
				edges.add(e);
				from.addPath(e);
			}
			/* Test af graph contents.
			for (int i = 0; i < edges.size(); i++)
			{
				System.out.println(nodes.get(i).toString() + edges.get(i).toString());
			}
			*/
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
