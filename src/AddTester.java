import com.cs210x.CPUClock;
import com.cs210x.Collection210X;

import java.util.Random;

/**
 * Tester for testing how long it takes to add
 */
public class AddTester extends Collection210XTesterImpl {

    /**
     * Constructs a tester for testing how long it takes for a data structure to perform the add method
     * on a random object that is not currently in the data structure
     * @param canvasID the canvas ID used for retrieving the data structures
     */
    public AddTester(String canvasID) {
        super("ADD", canvasID);
    }

    /**
     * Tests how long it takes to add a random object not currently in the data structure to the data structure
     * @param dataStructure the data structure to be tested
     * @param n the size of the data structure tested
     * @return how long the test took
     */
    @Override
    protected long timeTest(Collection210X dataStructure, int n)
    {
        Random random = new Random(CPUClock.getNumTicks());
        Integer item = random.nextInt(2 * n);

        // Makes sure item being added is odd, and so not already in the data structure
        if (item % 2 == 0) {
            item = item ++;
        }

        final long start = CPUClock.getNumTicks();
        dataStructure.add(item);
        final long end = CPUClock.getNumTicks();

        return end - start;
    }
}
