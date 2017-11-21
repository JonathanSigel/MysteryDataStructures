import java.util.*;
import com.cs210x.*;

/**
  * Class to deduce the identity of mystery data structures.
  */
public class ExperimentRunner {
	private static final int NUM_DATA_STRUCTURES_TO_DEDUCE = 5;
	private static final Random random = new Random(); //!!!is it fine that I just put this as a member variable so I don't have to constantly instantiate it?
	private static final String CS_210X_TEAM_ID_FOR_PROJECT_4 = "ksegenchuk";
	private static int[] N_VALUES = {1, 2, 5, 10, 20, 30, 40, 50, 60, 70, 80, 90,
			100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 2000, 3000, 4000, 5000,
			6000, 7000, 8000, 9000, 10000};
	public static void main (String[] args) {
		addTestOutput();
		removeTestOutput();
		containsTestOutput();
	}

	public static long testAdd(int dataStructureIndex, int n) {
		Collection210X dataStructure = fill(dataStructureIndex, n);
		Integer toAdd = random.nextInt(n);

		final long start = CPUClock.getNumTicks();
		dataStructure.add(toAdd);
		final long end = CPUClock.getNumTicks();

		return end - start;
	}

	public static long testRemove(int dataStructureIndex, int n) {
		Collection210X dataStructure = fill(dataStructureIndex, n);
		//!!! should I make sure that what I'm removing is in the data structure?
		Integer toRemove = random.nextInt(n);

		final long start = CPUClock.getNumTicks();
		dataStructure.remove(toRemove);
		final long end = CPUClock.getNumTicks();

		return end - start;
	}

	public static long testContains(int dataStructureIndex, int n) {
		Collection210X dataStructure = fill(dataStructureIndex, n);
		//!!! should I make sure that what I'm checking for is in the data structure?
		Integer toLook = random.nextInt(n);

		final long start = CPUClock.getNumTicks();
		dataStructure.contains(toLook);
		final long end = CPUClock.getNumTicks();

		return end - start;
	}

	private static Collection210X fill(int dataStructureIndex, int n) {
		Collection210X dataStructure = MysteryDataStructure.getMysteryDataStructure(CS_210X_TEAM_ID_FOR_PROJECT_4.hashCode(), dataStructureIndex, new Integer(0));

		for (int i = 1; i < n; i++) { //starts at 1 because data structure was initialized with a value
			dataStructure.add(random.nextInt(n));
		}

		return dataStructure;
	}

	private static void addTestOutput() {
		System.out.println("---ADD---");

		int counter = 0;
		for (int i = 0; i < NUM_DATA_STRUCTURES_TO_DEDUCE; i++) {
			System.out.println("Data Structure Being Tested: " + i);
			for (int j = 0; j < N_VALUES.length; j++) {
				for (int k = 0; k < 30; k++) {
					counter += testAdd(i, N_VALUES[j]);
				}
				int average = counter / 30;
				System.out.println(average);
			}
		}
	}

	public static void removeTestOutput() {
		System.out.println("---REMOVE---");

		int counter = 0;
		for (int i = 0; i < NUM_DATA_STRUCTURES_TO_DEDUCE; i++) {
			System.out.println("Data Structure Being Tested: " + i);
			for (int j = 0; j < N_VALUES.length; j++) {
				for (int k = 0; k < 30; k++) {
					counter += testRemove(i, N_VALUES[j]);
				}
				int average = counter / 30;
				System.out.println(average);
			}
		}
	}
    //borpdorp
	private static void containsTestOutput() {
		System.out.println("---CONTAINS---");

		int counter = 0;
		for (int i = 0; i < NUM_DATA_STRUCTURES_TO_DEDUCE; i++) {
			System.out.println("Data Structure Being Tested: " + i);
			for (int j = 0; j < N_VALUES.length; j++) {
				for (int k = 0; k < 30; k++) {
					counter += testContains(i, N_VALUES[j]);
				}
				int average = counter / 30;
				System.out.println(average);
			}
		}
	}
}
