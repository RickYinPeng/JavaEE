/**
 * @author RickYinPeng
 * @ClassName Test
 * @Description
 * @date 2018/10/11/17:18
 */
public class Test {
    public static void main(String[] args) {
        int count = 0;
        int num = 0;
        for(int i = 0;i<=100;i++){
            num = num+i;
            count = count++;
        }
        System.out.println("num*count="+(num*count));
    }
}
