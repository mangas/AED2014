package serie1;

import java.lang.reflect.Array;

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
	
	public static int hIndex(int[] v){
		throw new UnsupportedOperationException();
	}

	
	public static int deleteMin(int[] maxHeap, int sizeHeap){
		throw new UnsupportedOperationException();
	}
	
	public static void sortIPv4Addresses(String[] v, int l, int r) {
		throw new UnsupportedOperationException();
	}
}
