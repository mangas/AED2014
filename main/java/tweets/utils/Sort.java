package tweets.utils;

import tweets.model.HashCount;

/**
 * Created by fa on 11/11/14.
 */
public class Sort {

    public static int deleteMin(HashCount[] maxHeap, int sizeHeap) {

        if (maxHeap==null || sizeHeap<1)
            return sizeHeap;

        int menor = sizeHeap/2;

        for (int i=sizeHeap/2;i<sizeHeap;i++)
            if (maxHeap[menor].getCount()>maxHeap[i].getCount() )
                menor=i;

        if (menor!=sizeHeap-1)
            //exchange(maxHeap,menor,sizeHeap-1);
            maxHeap[menor]=maxHeap[sizeHeap-1];


        sizeHeap--;
        //maxHeap = java.util.Arrays.copyOf(maxHeap,sizeHeap-1);

        int parent=menor;

        do {
            parent=parent(parent);
            maxHeapify(maxHeap, parent, sizeHeap);
        } while (parent!=0);


        return sizeHeap;
    }

    public static int left(int i) {
        return 2 * i + 1;
    }

    public static int right(int i) {
        return 2 * i + 2;
    }

    public static void maxHeapify(HashCount[] h, int i, int n) {

        int l = left(i);
        int r = right(i);
        int largest;
        if (l < n && h[l].getCount() > h[i].getCount())
            largest = l;
        else largest = i;
        if (r < n && h[r].getCount() > h[largest].getCount())
            largest = r;
        if (largest != i) {
            exchange(h, i, largest);
            maxHeapify(h, largest+1, n);
        }
    }

    public static int parent(int i) {
        return (i - 1) / 2;
    }

    private static void exchange(Object[] n,int i, int j) {
        Object aux= n[i];
        n[i]=n[j];
        n[j]=aux;

    }

}
