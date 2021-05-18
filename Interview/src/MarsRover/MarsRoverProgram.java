package MarsRover;

import java.util.*;

public class MarsRoverProgram {

	public static void main(String[] args) {
		String upperRightCoordinate = "";
		String roverPosition = "";
		String roverMoves = "";
		int flag = 0;
		Scanner scanner = new Scanner(System.in);
		upperRightCoordinate = scanner.nextLine();
		roverPosition = scanner.nextLine();
		roverMoves = scanner.nextLine();

		String[] coordinateArray = upperRightCoordinate.split(" ");
		int maxPoints[] = new int[coordinateArray.length];
		for (int i = 0; i < coordinateArray.length; i++) {
			maxPoints[i] = Integer.parseInt(coordinateArray[i]);
		}

		String[] positionArray = roverPosition.split(" ");
		int X = Integer.parseInt(positionArray[0]);
		int Y = Integer.parseInt(positionArray[1]);
		char direction = Character.toUpperCase(positionArray[2].charAt(0));
		MarsRoverPosition position = new MarsRoverPosition(X, Y, direction, flag);

		if (position.validateUpperRightCoordinate(maxPoints)) {
			flag = 1;
			System.out.println("Invalid grid coordinates.");
		}
		if (position.validateRoverLandingPoints(maxPoints)) {
			flag = 1;
			System.out.println("Invalid landing points of the rover.");
		}
		if (!position.validateRoverDirection()) {
			flag = 1;
			System.out.println("Initial Rover direction must be N,S,W or E.");
		}
		if (!position.validateMoves(roverMoves.toUpperCase())) {
			flag = 1;
			System.out.println("Rover moves must be M,L or R.");
		}

		if (flag == 0) {
			position.startMoving(maxPoints, roverMoves.toUpperCase());
			if (position.flag != 1) {
				position.display();
			}
		}
	}
}