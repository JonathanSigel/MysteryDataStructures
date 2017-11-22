import com.cs210x.CPUClock;
import com.cs210x.Collection210X;
import com.cs210x.MysteryDataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Collection210XTesterImpl implements Collection210XTester {

    private String mType;
    private String mID;

    protected Collection210XTesterImpl(String type, String canvasID){
        mType = type;
        mID = canvasID;
    }

    public String getType(){
        return mType;
    }

    private Collection210X fill(int dataStructureIndex, int n){
        Collection210X dataStructure = MysteryDataStructure.getMysteryDataStructure(mID.hashCode(), dataStructureIndex, new Integer(0));
        List<Integer> tmpList = new ArrayList<Integer>();
        Random r = new Random(CPUClock.getNumTicks());

        for(int i = 0; i < n; i++) {
            tmpList.add(2 * i); //only add evens
        }
        for(int j = n; j > 0; j--) {
            dataStructure.add(tmpList.remove(r.nextInt(j)));
        }

        return dataStructure;
    }

    public long runTest(int dataStructureIndex, int n, int numTests){
        long total = 0;

        for(int i = 0; i < numTests; i++) {
            Collection210X dataStructure = fill(dataStructureIndex, n);
            total += timeTest(dataStructure, n);
        }
        return total/numTests;
    }

    protected long timeTest(Collection210X dataStructure, int n)
    {
        return 0;
    }
}