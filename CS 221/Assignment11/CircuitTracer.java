import java.util.ArrayList;
import java.util.List;
import java.awt.Point;

/**
 * Search for shortest paths between start and end points on a circuit board
 * as read from an input file using either a stack or queue as the underlying
 * search state storage structure and displaying output to the console or to
 * a GUI according to options specified via command-line arguments.
 * 
 * @author mvail
 */
public class CircuitTracer {
	private Storage<TraceState> storageMethod;
	private final String STACK = "-s";
	private final String QUEUE = "-q";
	private final String CMDLINE = "-c";
	private final String GUI = "-g"; //not a thing yet


	/** launch the program
	 * @param args three required arguments:
	 *    first arg: -s stack or -q queue
	 *    second arg: -c console output or -g GUI output (not available)
	 *    third arg: input file name 
	 *  @return void
	 */
	public static void main(String[] args) {
		if (args.length != 3) {
			printUsage();
			System.exit(1);
		}
		
		try {
			new CircuitTracer(args);
		} catch (Exception e) {
			System.out.println(e.toString());
			System.exit(1);
		}
	}

	/** prints directions on how to use program
	 * @param none
	 * @return void
	 * @throws none
	 */
	private static void printUsage() {
		System.out.println("Invalid arguments. Usage: \n$java CircuitTracer -s|-q -c|-g filename \n-s (stack storage) | -q (queue storage) \n-c (console output) | -g (gui output) \nfilename (location of file) \nNote: GUI not available");
		System.exit(1);
	}
	
	/** 
	 * Set up the CircuitBoard and all other components based on command
	 * line arguments.
	 * @param args command line arguments passed through from main()
	 */
	CircuitTracer(String[] args) {
		
		//First args switch for -s (STACK), -q (QUEUE)
		switch (args[0]) {
			case STACK:
				storageMethod = new Storage<TraceState>(Storage.DataStructure.stack);
				break;
			case QUEUE:
				storageMethod = new Storage<TraceState>(Storage.DataStructure.queue);
				break;
			default:
				printUsage();
				
		}

		//Second args switch for -g (GUI), -c (CMDLINE)
		switch (args[1]) {
		case CMDLINE:
			break;
		case GUI:
			printUsage();
		default:
			printUsage();
		}

		try {
			CircuitBoard circuitBoard = new CircuitBoard(args[2]);
			List<TraceState> bestPathList = new ArrayList<TraceState>();
		
			//North relative to the x,y point
			Point startingPoint = circuitBoard.getStartingPoint();
			if (circuitBoard.isOpen(startingPoint.x + 1, startingPoint.y)) {
				TraceState newTrace = new TraceState(circuitBoard, startingPoint.x + 1, startingPoint.y);
				storageMethod.store(newTrace);
			}
			//South relative to the x,y point
			if (circuitBoard.isOpen(startingPoint.x - 1, startingPoint.y)) {
				TraceState newTrace = new TraceState(circuitBoard, startingPoint.x - 1, startingPoint.y);
				storageMethod.store(newTrace);
			}
			//East relative to the x,y point
			if (circuitBoard.isOpen(startingPoint.x, startingPoint.y + 1)) {
				TraceState newTrace = new TraceState(circuitBoard, startingPoint.x, startingPoint.y + 1);
				storageMethod.store(newTrace);
			}
			//West relative to the x,y point
			if (circuitBoard.isOpen(startingPoint.x, startingPoint.y - 1)) {
				TraceState newTrace = new TraceState(circuitBoard, startingPoint.x, startingPoint.y - 1);
				storageMethod.store(newTrace);
			}
			
			while (!storageMethod.isEmpty()) {
				
				TraceState currentPath = storageMethod.retrieve();
				
				if (!currentPath.isComplete()) {
					//North relative to the x,y point
					if (currentPath.isOpen(currentPath.getRow() + 1, currentPath.getCol())) {
						TraceState newTrace = new TraceState(currentPath, currentPath.getRow() + 1, currentPath.getCol());
						storageMethod.store(newTrace);
					}
					//South relative to the x,y point
					if (currentPath.isOpen(currentPath.getRow() - 1, currentPath.getCol())) {
						TraceState newTrace = new TraceState(currentPath, currentPath.getRow() - 1, currentPath.getCol());
						storageMethod.store(newTrace);
					}
					//East relative to the x,y point
					if (currentPath.isOpen(currentPath.getRow(), currentPath.getCol() + 1)) {
						TraceState newTrace = new TraceState(currentPath, currentPath.getRow(), currentPath.getCol() + 1);
						storageMethod.store(newTrace);
					}
					//West relative to the x,y point
					if (currentPath.isOpen(currentPath.getRow(), currentPath.getCol() - 1)) {
						TraceState newTrace = new TraceState(currentPath, currentPath.getRow(), currentPath.getCol() - 1);
						storageMethod.store(newTrace);
					}
					
				} else {
					if (!bestPathList.isEmpty()) {
						//If the current best path is the same length of current path
						if (bestPathList.get(0).pathLength() == currentPath.pathLength()) {
							bestPathList.add(currentPath);
						//If the current best path is longer then the current path
						} else if (bestPathList.get(0).pathLength() >= currentPath.pathLength()) {
							bestPathList.clear();
							bestPathList.add(currentPath);
						} 
						
					} else {
						bestPathList.add(currentPath);
					}
				}
			}
			if (!bestPathList.isEmpty()) {
				for (int i = 0; i < bestPathList.size(); i++) {
					System.out.println(bestPathList.get(i).toString());
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
} // class CircuitTracer