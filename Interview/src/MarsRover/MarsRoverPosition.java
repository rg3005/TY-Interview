package MarsRover;

interface Position {
	void startMoving(int[] maxPoints, String moves);
}
 class MarsRoverPosition implements Position {
	public int flag;
	private int X;
	private int Y;
	private char direction;

	MarsRoverPosition(int X, int Y, char direction, int flag) {
		this.X = X;
		this.Y = Y;
		this.flag = flag;
		this.direction = direction;
	}

	public boolean validateUpperRightCoordinate(int[] coordinateArray) {

		return (coordinateArray[0] < 0 || coordinateArray[1] < 0);

	}

	public boolean validateRoverLandingPoints(int[] maxPoints) {
		return (X < 0 || X > maxPoints[0] || Y < 0 || Y > maxPoints[1]);

	}

	public boolean validateRoverDirection() {
		return (direction == 'N' || direction == 'S' || direction == 'W' || direction == 'E');

	}

	public boolean validateMoves(String moves) {
		for (int i = 0; i < moves.length(); i++) {
			if (moves.charAt(i) != 'M' && moves.charAt(i) != 'L' && moves.charAt(i) != 'R') {
				return false;
			}
		}
		return true;
	}

	private void rotate90Left() {
		switch (direction) {
		case 'N':
			direction = 'W';
			break;
		case 'S':
			direction = 'E';
			break;
		case 'E':
			direction = 'N';
			break;
		case 'W':
			direction = 'S';
			break;
		default:
			break;
		}
	}

	private void rotate90Right() {
		switch (direction) {
		case 'N':
			direction = 'E';
			break;
		case 'S':
			direction = 'W';
			break;
		case 'E':
			direction = 'S';
			break;
		case 'W':
			direction = 'N';
			break;
		default:
			break;
		}
	}

	private void moveInSameDirection() {
		switch (direction) {
		case 'N':
			Y += 1;
			break;
		case 'S':
			Y -= 1;
			break;
		case 'E':
			X += 1;
			break;
		case 'W':
			X -= 1;
			break;
		default:
			break;
		}
	}

	public void startMoving(int[] maxPoints, String moves) {
		for (int i = 0; i < moves.length(); i++) {
			switch (moves.charAt(i)) {
			case 'M':
				moveInSameDirection();
				break;
			case 'L':
				rotate90Left();
				break;
			case 'R':
				rotate90Right();
				break;
			}

			if (validateRoverLandingPoints(maxPoints)) {
				flag = 1;
				System.out.println("Rover navigation must be within the boundaries (0,0),(" + maxPoints[0] + ","
						+ maxPoints[1] + ").");
				break;
			}
		}
	}

	public void display() {
		System.out.println(X + " " + Y + " " + direction);
	}
}