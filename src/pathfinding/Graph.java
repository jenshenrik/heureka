package pathfinding;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;

public class Graph {

	private ArrayList<Node> nodes;
	private ArrayList<Edge> edges;
	
	public Graph(String path) {
		readFile(path);
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
				edges.add(new Edge(from, to, name));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
