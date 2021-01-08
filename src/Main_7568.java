
import java.util.*;

public class Main_7568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());

        String[] arr = new String[size]; //String으로 사이즈만큼 배열만들어주기
        int[] arrInt = new int[size];

        for(int i=0; i<size; i++) {
            arr[i] = sc.nextLine();
            arrInt[i] = 1;
        }

        for(int i=0; i<size; i++) {
            String[] str1 = arr[i].split(" "); //공백제거
            for(int j=0; j<size; j++) { //size() 까지
                if(i==j) continue; //i==j 계속되기
                String[] str2 = arr[j].split(" "); //공백으로 제거

                if(Integer.parseInt(str1[0]) < Integer.parseInt(str2[0]) && Integer.parseInt(str1[1]) < Integer.parseInt(str2[1])) {
                        arrInt[i]++;
                // str[0]
                }
            }
        }

        for(int i=0; i<size; i++) {
            System.out.print(arrInt[i] + " ");
        }

    }
}