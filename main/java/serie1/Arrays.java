package serie1;

public class Arrays {

    private static int incIfPossible(int l, int r) {
        return (r-l > 0)?l+1:l;
    }

    private static int countEqualsOn1n2 (int[] v1, int l1, int r1, int[] v2, int l2, int r2) {
        if (l1>r1) return 0;
        if (l2>r2) return 0;

        int count=0;

        while (true) {


            if (l1==r1 && l2==r2)
                return count;

            if (l1==r1) {
                if (v1[l1]<v2[l2])
                    return count;
            } else if (l2==r2) {
                if (v1[l1]>v2[l2])
                    return count;
            }

            if (v1[l1] < v2[l2]) {
                l1 = incIfPossible(l1, r1);
                continue;
            }
            if (v1[l1] > v2[l2]) {
                l2 = incIfPossible(l2, r2);
                continue;
            }

            count++;
            l1=incIfPossible(l1,r1);
            l2=incIfPossible(l2,r2);

        }
    }

    private static int countEqualsOn1n2Recur(int[] v1, int l1, int r1, int[] v2, int l2, int r2) {

        if (l1>r1) return 0;
        if (l2>r2) return 0;

        if (l1==r1 && l2==r2)
            return 0;

        if (l1==r1) {
            if (v1[l1]<v2[l2])
                return 0;
        } else if (l2==r2) {
            if (v1[l1]>v2[l2])
                return 0;
        }

        if (v1[l1] < v2[l2]) {
            l1 = incIfPossible(l1, r1);
                return countEqualsOn1n2Recur(v1, l1, r1, v2, l2, r2);
        }

        if (v1[l1] > v2[l2]) {
            l2 = incIfPossible(l2, r2);
            return countEqualsOn1n2Recur(v1, l1, r1, v2, l2, r2);
        }

        l1=incIfPossible(l1,r1);
        l2=incIfPossible(l2,r2);
        return 1+ countEqualsOn1n2Recur(v1, l1, r1, v2, l2, r2);
    }

    private static boolean breakArrayAndCheck(int[] n, int l, int r, int val) {

        if (l>r)
            return false;

        int m = (r+l)/2;

        if (n[m]==val)
            return true;

        //if (size==1)
          //  System.out.println("Cenas");

        if (val<n[m])
            return breakArrayAndCheck(n,l,m-1,val);
        else
            return breakArrayAndCheck(n,m+1,r,val);


    }

    public static int countEqualsDivideAndConquer(int[] v1, int l1, int r1, int[] v2, int l2, int r2) {
        if (l1>r1) return 0;
        if (l2>r2) return 0;

        int count=0;

        for (int i=l1;i<=r1;i++) {
            if (breakArrayAndCheck(v2,l2,r2,v1[i]))
                count++;
        }

        return count;
    }

	public static int countEquals(int[] v1, int l1, int r1, int[] v2, int l2, int r2){
        //return countEqualsOn1n2(v1,l1,r1,v2, l2, r2);
        //return countEqualsOn1n2Recur(v1, l1, r1, v2, l2, r2);
        return countEqualsDivideAndConquer(v1, l1, r1, v2, l2, r2);
	}


    private static void quicksort(int n[], int low, int high) {

        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = n[low + (high-low)/2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (n[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (n[j] > pivot) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(n, i, j);
                i++;
                j--;
            }
        }

        if (low<j)
            quicksort(n,low,j);
        if (i<high)
            quicksort(n,i,high);

    }

    private static void exchange(int[] n,int i, int j) {
        int aux= n[i];
        n[i]=n[j];
        n[j]=aux;

    }

    private static void exchange(Object[] n,int i, int j) {
        Object aux= n[i];
        n[i]=n[j];
        n[j]=aux;

    }

    private static int hIndexQuickSort( int[] v) {
        if (v == null || v.length==0)
            return -1;

        if (v.length==1)
            return (v[0]==0)?-1:1;


        quicksort(v,0,v.length-1);

        int elementsLeft = v.length;

        for (int i=0;v[i]<elementsLeft;i++,elementsLeft--);

        return elementsLeft;

    }

    public static int hIndex(int[] v){
        return hIndexQuickSort(v);
	}

	
	public static int deleteMin(int[] maxHeap, int sizeHeap){throw new UnsupportedOperationException();}

    private static void quicksort(String n[], int field, int low, int high) {

        int i = low, j = high;

        // Get the pivot element from the middle of the list
        int pivot = getOctet( n[low + (high-low)/2],field);

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while ( getOctet(n[i], field) < pivot) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (getOctet(n[j],field) > pivot) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(n,i, j);
                i++;
                j--;
            }
        }

        if (low<j)
            quicksort(n, field, low, j);
        if (i<high)
            quicksort(n, field, i, high);
    }

    private static int getOctet(String ip, int field) {
        return Integer.parseInt(ip.split("[.]")[field]);
    }

    public static void sortIPv4Addresses(String[] v, int l, int r) {
        ipSort(v, l, r);
    }

    private static void ipSort(String[] v, int l, int r) {
        if (v == null || v.length<=1)
            return;

        quicksort(v, 0, l, r);
        ipSubSort(v, l, r, 1);
    }

    private static void ipSubSort(String v[], int l, int r, int field) {
        int previous= getOctet(v[l],field-1);
        int lastIndex=l;

        if (field > 3) return;

        if (l>=r) return;

        for (int i = l; i <= r; i++) {
            if (getOctet(v[i], field - 1) != previous) {
                quicksort(v, field, lastIndex, i - 1);
                ipSubSort(v, lastIndex, i - 1, field+1);
                previous = getOctet(v[i], field - 1);
                lastIndex = i;
            } else {
                if (i==r)
                    quicksort(v,field,lastIndex,i);
                    ipSubSort(v,lastIndex,i,field+1);
            }
        }
    }
}
