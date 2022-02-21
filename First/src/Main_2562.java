import java.util.Scanner;

public class Main_2562 {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int a[] = new int[9];

        for (int i = 0; i < a.length; i++)
            a[i] = sc.nextInt();

        //가장 큰값을 0인덱스로 하였으므로
        int max = a[0];
        int n = 1;

        for (int t = 1; t < a.length; t++) {
            if (max < a[t]) {
                max = a[t];
                n = t + 1;
            }
        }
        System.out.println(max);
        System.out.println(n);
    }
}
