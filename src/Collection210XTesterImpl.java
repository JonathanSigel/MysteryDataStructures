import com.cs210x.CPUClock;
import com.cs210x.Collection210X;
import com.cs210x.MysteryDataStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Superclass for testers which implements Collection210XTester
 */
public class Collection210XTesterImpl implements Collection210XTester {

    private String mType;
    private String mID;

    /**
     * Constructs a tester for testing how long it takes for a data structure to perform an operation
     * @param type the type of test
     * @param canvasID the canvas ID used for retrieving the data structures
     */
    protected Collection210XTesterImpl(String type, String canvasID){
        mType = type;
        mID = canvasID;
    }

    /**
     * Gets the type of test being ran
     * @return a string representing the name of the test being ran
     */
    public String getType(){
        return mType;
    }

    /**
     * Initiates and returns a data structure filled to size n
     * with all even numbers 0 through 2*n in a random order
     * @param dataStructureIndex the index of the data structure
     * @param n the size for the data structure to be filled to
     * @return the filled data structure
     */
    private Collection210X fill(int dataStructureIndex, int n){
        Collection210X dataStructure = MysteryDataStructure.getMysteryDataStructure(mID.hashCode(), dataStructureIndex, new Integer(0));
        List<Integer> tmpList = new ArrayList<Integer>();
        Random r = new Random(CPUClock.getNumTicks());

        //fills the data structure with all even numbers 0 through 2*(n-1) in a random order
        for(int i = 0; i < n; i++) {
            tmpList.add(2 * i); //only add evens
        }
        for(int j = n; j > 0; j--) {
            dataStructure.add(tmpList.remove(r.nextInt(j)));
        }

        return dataStructure;
    }

    /**
     * Runs a given amount of tests on a data structure and averages the time results
     * @param dataStructureIndex the index of the data structure
     * @param n the size of the data structure when running the tests
     * @param numTests the number of tests to run then average
     * @return a long representing how many clicks the tests took on average according to the CPUClock
     */
    public long runTest(int dataStructureIndex, int n, int numTests){
        long total = 0;

        for(int i = 0; i < numTests; i++) {
            //at the start of every test, the data structure is re-instantiated once again and filled to the desired size
            Collection210X dataStructure = fill(dataStructureIndex, n);
            total += timeTest(dataStructure, n);
        }
        return total/numTests;
    }

    /**
     * Runs one single test and returns the time result.
     * Must be overridden by subclasses to test specific test
     * @param dataStructure the data structure to be tested
     * @param n the size of the data structure tested
     * @return long representing how long the test took
     */
    protected long timeTest(Collection210X dataStructure, int n)
    {
        return 0;
    }
}