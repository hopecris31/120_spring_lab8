import java.util.ArrayList;

public class ListProcessor
{
    /**
     * Swaps elements i and j in the given list.
     */
    private void swap(ArrayList<String> aList, int i, int j)
    {
        String tmp = aList.get(i);
        aList.set(i, aList.get(j));
        aList.set(j, tmp);
    }

    /**
     * Finds the minimum element of a list, returns it.
     *
     * @param aList the list in which to find the minimum element.
     * @return the minimum element of the list.
     */
    public String getMin(ArrayList<String> aList)
    {
        String firstElement = aList.get(0);
        if(aList.size() == 1){
            return firstElement;
        }
        ArrayList<String> rest = new ArrayList<>(aList.subList(1, aList.size()));
        String getMinOfRest = getMin(rest);
        if(getMinOfRest.compareTo(firstElement) < 0){
            return getMinOfRest;
        }
        return firstElement;
    }


    /**
     * Finds the minimum element of a list, returns the index of that
     * element.
     *
     * @param aList the list in which to find the minimum element.
     * @return the index of the minimum element in the list.
     */
    public int getMinIndex(ArrayList<String> aList)
    {
        String minElement = aList.get(0);
        if(aList.size() == 1){
            return 0;
        }
        ArrayList<String> rest = new ArrayList<>(aList.subList(1, aList.size()));
        int minIndexOfRest = getMinIndex(rest) +1;
        int minCompare = minElement.compareTo(aList.get(minIndexOfRest));
        if(minCompare < 0 || minCompare == 0){
            return 0;

        }
        return minIndexOfRest;
    }

    
    /**
     * Sorts a list in place. I.E. the list is modified so that it is in order.
     *
     * @param aList: the list to sort.
     */
    public void sort(ArrayList<String> aList)
    {
      sortSublist(aList, 0);
    }

    /**
     * Sorts the portion of 'aList' from index 'start' to the end of
     * 'aList'. The list is sorted in place.
     *
     * @param aList the list to sort
     * @param start the index of the first element of interest.
     */
    private void sortSublist(ArrayList<String> aList, int start){
        if(aList.size() == start){
            return;
        }
        int minIndex = getMinIndex(new ArrayList<>(aList.subList(start, aList.size())))+start; //add start, because the index needs to be relative to aList and not the sublist
        swap(aList, minIndex, start);
        sortSublist(aList, start+1);
    }

}
    

