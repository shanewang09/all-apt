public class AlphaPath {
	private char[][] m;
	public String hasPath(String[] maze) {
		makeM(maze);
		
		int r = 0;
		int c = 0;
		
		for (int row = 0; row < maze.length; row++) {
			for (int col = 0; col < maze[0].length(); col++) {
				if (m[row][col] == 'A') {
					r = row;
					c = col;
				}
			}
		}
		
		if (path(r, c, 'A')) {
			return "YES";
		}
		
		return "NO";
	}
	
	private boolean path(int row, int col, int target) {
        if (row < 0 || col < 0 || row >= m.length || col >= m[0].length){
            return false;
        }
        
		if (m[row][col] == target) {
			if (target == 'Z') {
				return true;
			}
			int next = target + 1;
			return path(row + 1, col, next) || path(row - 1, col, next) || path(row, col - 1, next)
					|| path(row, col + 1, next);
		}
		return false;
	}
	
	private void makeM(String[] maze) {
		m  = new char[maze.length][maze[0].length()];
		for (int row = 0; row < maze.length; row++) {
			for (int col = 0; col < maze[0].length(); col++) {
				m[row][col] = maze[row].charAt(col);
			}
		}
	}
}