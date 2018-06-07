package 자바연습용;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class Main {
	static int[] circularArrayRotation(int[] a, int[] m, int k) {
		
		if(a.length == 1)
			k=0;
		else 
			k = k % a.length;
		
		List<Integer> dataList = Arrays.stream(a).boxed().collect(Collectors.toList());
		for(int i=0; i<k; i++) {
			dataList.add(0, dataList.get(dataList.size()-1));
			dataList.remove(dataList.size()-1);
		}
		
		int[] result = new int[m.length];
		for(int i=0; i<m.length; i++) 
			result[i] = dataList.get( m[i] );
		
		return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] m = new int[q];
        for(int m_i = 0; m_i < q; m_i++){
            m[m_i] = in.nextInt();
        }
        int[] result = circularArrayRotation(a, m, k);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}

