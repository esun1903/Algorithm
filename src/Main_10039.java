import java.util.*;

public class Main_10039 {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);

        int [] one = new int [5];
        int result = 0;
        //입력받귀,,,
        for(int i=0; i<5; i++) {
            one[i] = sc.nextInt();
            if(one[i]<40)
                one[i] = 40;

            result +=one[i];
        }

        System.out.println(result/5);
    }
}
