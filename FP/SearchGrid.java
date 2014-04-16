package FP;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SearchGrid {
	private static ArrayList<GridCell> cells;
	private static Map<Character, String> cellTypes;
	private Map<Integer, ArrayList<GridCell>> adjacencyMap;
	private ArrayList<SearchTeam> teams;
	private String csv, legend;
	private int rows, columns;

	public SearchGrid() {

	}

	public SearchGrid(String csvFile, String legendFile) throws FileNotFoundException {
		this.csv = csvFile;
		this.legend = legendFile;

		// reading file quickly to determine rows and columns for later
		BufferedReader br = new BufferedReader(new FileReader(csv));
		cells = new ArrayList<GridCell>();
		String separationString = ",";
		String line = "";
		int rows = 0;
		int columns = 0;
		try {
			while ((line = br.readLine()) != null) {
				// line now contains a row
				columns = 0;
				String[] rowElem = line.split(separationString);
				for (String s : rowElem) {
					// count each letter
					columns++;
				}
				rows++;
			}
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
		// determine rows, columns
		this.rows = rows;
		this.columns = columns;
	}

	public void loadConfigFiles() {
		try {
			loadLegendConfig();
			loadGridConfig();
			System.out.println();
		} catch (BadConfigFormatException e) {
			e.getLocalizedMessage();
		} catch (FileNotFoundException e) {
			e.getLocalizedMessage();
		}

	}

	public void loadLegendConfig() throws FileNotFoundException,
	BadConfigFormatException {
		cellTypes = new HashMap<Character, String>();
		FileReader reader = new FileReader(legend);
		Scanner s = new Scanner(reader);
		String infoString;
		char abbreviation;
		String cellName;

		while (s.hasNextLine()) {
			// grab line
			infoString = s.nextLine();
			// ensure line contains comma
			if (infoString.charAt(1) != ',') {
				throw new BadConfigFormatException("Bad Legend File");
			}
			abbreviation = infoString.charAt(0);
			// 3 is where the string starts with a space in between comma and
			// string
			cellName = infoString.substring(3);
			cellTypes.put(abbreviation, cellName);
		}
	}

	public void loadGridConfig() throws FileNotFoundException,
	BadConfigFormatException {
		BufferedReader br = new BufferedReader(new FileReader(csv));
		cells = new ArrayList<GridCell>();
		String separationString = ",";
		String line = "";
		int rowTracker = 0;
		// row and column trackers are used to ensure correct amount of columns
		// in each row
		ArrayList<Integer> columnTrackers = new ArrayList<Integer>();
		int columnCount = 0;
		GridCell gc = null;
		try {
			while ((line = br.readLine()) != null) {
				String[] rowElem = line.split(separationString);
				int columnTracker = 0;
				for (String s : rowElem) {
					// if statement prevents null pointer
					if ((s != null) && (cellTypes != null)) {
						// if you find a key not contained in legend, throw
						// exception
						if (!cellTypes.containsKey(s.charAt(0))) {
							throw new BadConfigFormatException(
									"Room not found in legend.");
						}
					}
					if (s.equals("F")) {
            gc = new ForestCell(rowTracker, columnTracker);
					} else if (s.equals("G")) {
            gc = new GroundCell(rowTracker, columnTracker);
					} else if (s.equals("M")) {
            gc = new MountainCell(rowTracker, columnTracker);
          } else if (s.equals("W")) {
            gc = new WaterCell(rowTracker, columnTracker);
          }
					if (gc != null) {
						cells.add(calcIndex(rowTracker, columnTracker), gc);
					}
					columnTracker++;
				}
				columnTrackers.add(rowTracker, columnTracker);
				if (rowTracker == 0)
					columnCount = columnTracker;
				rowTracker++;
			}
			// check for bad columns
			for (int i = 1; i < columnTrackers.size(); i++) {
				if (columnTrackers.get(i) != columnCount) {
					throw new BadConfigFormatException(
							"There is an unequal amount of columns in each row.");
				}
			}
		} catch (IOException e) {
			e.getLocalizedMessage();
		}
		this.rows = rowTracker;
		this.columns = columnTrackers.get(0);
	}

	public int calcIndex(int r, int c) {
		return (this.columns * r) + c;
	}

	public static ArrayList<GridCell> getCells() {
		return cells;
	}

	public static Map<Character, String> getCellTypes() {
		return cellTypes;
	}

	public ArrayList<SearchTeam> getTeams() {
		return teams;
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public GridCell getGridCellAt(int xCoord, int yCoord) {
		return cells.get(calcIndex(xCoord, yCoord));
	}
}
