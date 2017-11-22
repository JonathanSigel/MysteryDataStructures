import com.cs210x.Collection210X;
import com.cs210x.MysteryDataStructure;

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

        for (int i = 1; i < n; i++) { //starts at 1 because data structure was initialized with a value
            dataStructure.add(i);
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