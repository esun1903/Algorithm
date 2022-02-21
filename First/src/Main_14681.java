import java.util.*;
public class Main_14681 {
    public static void main(String ... args){

        Scanner sc = new Scanner(System.in);

        //x,y좌표 입력받기
        int x = sc.nextInt();
        int y = sc.nextInt();

        // 1- 4분면까지 어디에 속하는지 확인

        if(x>0 && y>0)
            System.out.println("1");
        else if(x<0 && y>0)
            System.out.println("2");
        else if(x<0 && y<0)
            System.out.println("3");
        else
            System.out.println("4");

    }
}
