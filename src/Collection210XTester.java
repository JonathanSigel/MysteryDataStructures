/**
 * Interface for testing the time it takes for a certain data structure to run an opperation
 */
public interface Collection210XTester {

    /**
     * Gets the type of test being ran
     * @return a string representing the name of the test being ran
     */
    public String getType();

    /**
     * Runs a given amount of tests on a data structure and averages the time results
     * @param dataStructureIndex the index of the data structure
     * @param n the size of the data structure when running the tests
     * @param numTests the number of tests to run then average
     * @return a long representing how many clicks the tests took on average according to the CPUClock
     */
    public long runTest(int dataStructureIndex, int n, int numTests);
}
