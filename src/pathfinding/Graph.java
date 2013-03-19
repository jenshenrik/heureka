package pathfinding;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;

public class Graph {

	private Set<Node> nodes;
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
				
				Node from = new Node(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
				Node to = new Node(Integer.parseInt(data[3]), Integer.parseInt(data[4]));
				String name = data[2];
				
				nodes.add(from);
				nodes.add(to);
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
