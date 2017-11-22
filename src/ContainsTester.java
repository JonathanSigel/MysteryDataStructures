import com.cs210x.CPUClock;
import com.cs210x.Collection210X;

import java.util.Random;

/**
 * Tester for testing how long it takes to see if the data structure contains an object
 */
public class ContainsTester extends Collection210XTesterImpl {

    /**
     * Constructs a tester for testing how long it takes for a data structure to perform the contains method
     * to check if a random object in the data structure is in the data structure
     * @param canvasID the canvas ID used for retrieving the data structures
     */
    public ContainsTester(String canvasID) {
        super("CONTAINS", canvasID);
    }

    /**
     * Tests how long it takes to check if a random object in the data structure is currently in the data structure
     * @param dataStructure the data structure to be tested
     * @param n the size of the data structure tested
     * @return how long the test took
     */
    @Override
    protected long timeTest(Collection210X dataStructure, int n)
    {
        Random random = new Random(CPUClock.getNumTicks());
        Integer item = random.nextInt(2 * n);

        // Makes sure item checked is even, and so is in the data structure
        if (item % 2 != 0) {
            item = item ++;
        }

        final long start = CPUClock.getNumTicks();
        dataStructure.contains(item);
        final long end = CPUClock.getNumTicks();

        return end - start;
    }
}