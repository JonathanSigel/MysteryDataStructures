import com.cs210x.CPUClock;
import com.cs210x.Collection210X;

import java.util.Random;

/**
 * Tester for testing how long it takes to see if the data structure contains the greatest object (max object)
 */
public class ContainsMaxTester extends Collection210XTesterImpl {

    /**
     * Constructs a tester for testing how long it takes for a data structure to perform the contains method
     * to check if the comparatively greatest object in the data structure is in the data structure
     * @param canvasID the canvas ID used for retrieving the data structures
     */
    public ContainsMaxTester(String canvasID) {
        super("CONTAINS MAX", canvasID);
    }

    /**
     * Tests how long it takes to check if the comparatively greatest object in the data structure is in the data structure
     * @param dataStructure the data structure to be tested
     * @param n the size of the data structure tested
     * @return how long the test took
     */
    @Override
    protected long timeTest(Collection210X dataStructure, int n)
    {
        Integer item = 2 * (n - 1); //max number

        final long start = CPUClock.getNumTicks();
        dataStructure.contains(item);
        final long end = CPUClock.getNumTicks();

        return end - start;
    }
}
