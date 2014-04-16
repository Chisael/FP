package tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import FP.BadConfigFormatException;
import FP.SearchGrid;

public class part1 {

	private static SearchGrid grid;
	public static final int NUM_CELL_TYPES = 4;
	public static final int NUM_ROWS = 2;
	public static final int NUM_COLUMNS = 2;
	public static final String layoutName = "SearchLayout.csv";
	public static final String legendName = "SearchLegend.txt";
	
	@Before
	public void setUp() throws FileNotFoundException, BadConfigFormatException {
		grid = new SearchGrid(layoutName, legendName);
		grid.loadConfigFiles();
	}

	@Test
	public void testGridDimensions() {
		assertEquals(NUM_ROWS, grid.getRows());
		assertEquals(NUM_COLUMNS, grid.getColumns());
	}

	@Test
	public void testIndex() {
		int expected = 3;
		int actual = grid.calcIndex(1, 1);
		assertEquals(expected, actual);
	}

	@Test
	public void testCellTypes() {
		Map<Character, String> cellTypes = grid.getCellTypes();
		assertEquals(NUM_CELL_TYPES, cellTypes.size());
		assertEquals("Forest", cellTypes.get('F'));
		assertEquals("Ground", cellTypes.get('G'));
		assertEquals("Mountain", cellTypes.get('M'));
		assertEquals("Water", cellTypes.get('W'));
	}

	@Test
	public void testRoomInitials() {
		assertEquals('W', grid.getGridCellAt(0, 0).getInitial());
		assertEquals('G', grid.getGridCellAt(0, 1).getInitial());
		assertEquals('F', grid.getGridCellAt(1, 0).getInitial());
		assertEquals('M', grid.getGridCellAt(1, 1).getInitial());
	}

	// Test that an exception is thrown for a bad config file
	@Test (expected = BadConfigFormatException.class)
	public void testBadColumns() throws BadConfigFormatException, FileNotFoundException {
		// overloaded Board ctor takes config file names
		SearchGrid grid = new SearchGrid("SearchLayoutBadColumns.csv", "SearchLegend.txt");
		// You may change these calls if needed to match your function names
		// My loadConfigFiles has a try/catch, so I can't call it directly to
		// see test throwing the BadConfigFormatException
		grid.loadLegendConfig();
		grid.loadGridConfig();
		
	}
	// Test that an exception is thrown for a bad config file
	@Test (expected = BadConfigFormatException.class)
	public void testBadRoom() throws BadConfigFormatException, FileNotFoundException {
		// overloaded Board ctor takes config file name
		SearchGrid grid = new SearchGrid("SearchLayoutBadCellType.csv", "SearchLegend.txt");
		grid.loadLegendConfig();
		grid.loadGridConfig();
	}
	// Test that an exception is thrown for a bad config file
	@Test (expected = BadConfigFormatException.class)
	public void testBadRoomFormat() throws BadConfigFormatException, FileNotFoundException {
		// overloaded Board ctor takes config file name
		SearchGrid grid = new SearchGrid("SearchLayout.csv", "SearchLegendBadFormat.txt");
		grid.loadLegendConfig();
		grid.loadGridConfig();
	}
}
