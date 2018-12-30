/**	Stephen Barrack
 *	cssc0868
 *	Program #3
 */

import data_structures.*;

public class MazeSolver {
	private MazeGrid maze;
	private Queue<GridCell> queue;
	private Stack<GridCell> stack;
	private int dim, x, y;
	private GridCell first, last, here, north, south, east, west;

	public MazeSolver(int dimension) {
		dim = dimension;
		maze = new MazeGrid(this, dim);
		queue = new Queue<GridCell>();
		stack = new Stack<GridCell>();
		first = maze.getCell(0, 0);
		last = maze.getCell(dim-1, dim-1);
	}
	
	public void mark() {
		first.setDistance(0);
		maze.markDistance(first);
		queue.enqueue(first);
		while(!queue.isEmpty()) {
			here = queue.dequeue();
			setInfo();
			check(north);
			check(south);
			check(east);
			check(west);
		}
	}
	
	public boolean move() {
		int distance = last.getDistance();
		if(distance == -1) return false;
		stack.push(last);
		while(distance != 0) {
			here = stack.peek();
			setInfo();
			if(maze.isValidMove(north) && (north.getDistance() == distance-1)) {
				maze.markMove(north);
				stack.push(north);
			}else if(maze.isValidMove(south) && (south.getDistance() == distance-1)) {
				maze.markMove(south);
				stack.push(south);
			}else if(maze.isValidMove(east) && (east.getDistance() == distance-1)) {
				maze.markMove(east);
				stack.push(east);
			}else if(maze.isValidMove(west) && (west.getDistance() == distance-1)) {
				maze.markMove(west);
				stack.push(west);
			}else
				distance = 1;
			distance--;
		}
		while(!stack.isEmpty()) {
			maze.markMove(stack.pop());
		}
		return true;
	}
	
	public void reset() {
		stack.makeEmpty();
		queue.makeEmpty();
	}
	
	private void setInfo() {
		x = here.getX(); 
		y = here.getY();
		north = maze.getCell(x, y-1);
		south = maze.getCell(x, y+1);
		east = maze.getCell(x+1, y);
		west = maze.getCell(x-1, y);
	}
	
	private void check(GridCell cell) {
		if(maze.isValidMove(cell) && !cell.wasVisited()) {
			cell.setDistance(here.getDistance()+1);
			maze.markDistance(cell);
			queue.enqueue(cell);
		}
	}
	
	public static void main(String[] args) {
		new MazeSolver(33);
	}

}
