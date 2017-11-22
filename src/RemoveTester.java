import com.cs210x.CPUClock;
import com.cs210x.Collection210X;

import java.util.Random;

/**
 * Tester for testing how long it takes to remove
 */
public class RemoveTester extends Collection210XTesterImpl {

    /**
     * Constructs a tester for testing how long it takes for a data structure to perform the remove method
     * on a random object that is in the data structure
     * @param canvasID the canvas ID used for retrieving the data structures
     */
    public RemoveTester(String canvasID) {
        super("REMOVE", canvasID);
    }

    /**
     * Tests how long it takes to remove a random object currently in the data structure
     * @param dataStructure the data structure to be tested
     * @param n the size of the data structure tested
     * @return how long the test took
     */
    @Override
    protected long timeTest(Collection210X dataStructure, int n)
    {
        Random random = new Random(CPUClock.getNumTicks());
        Integer item = random.nextInt(2 * n);

        // Makes sure item being removed is even, and so is in the data structure
        if (item % 2 != 0) {
            item = item ++;
        }

        final long start = CPUClock.getNumTicks();
        dataStructure.remove(item);
        final long end = CPUClock.getNumTicks();

        return end - start;
    }
}