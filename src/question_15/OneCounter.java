package question_15;

public class OneCounter {

    private static int countOne(int num) {
        int count = 0;
        if (num < 0) {
            count++;
            num = -num;
        }
        while (num != 0) {
            count++;
            num = num & (num - 1);
        }
        return count;
    }

    private static int countOne2(int num) {
        int count = 0;
        if (num < 0) {
            count++;
            num = -num;
        }
        int flag = 1;
        while (flag != 0) {
            if ((num & flag) > 0)
                count++;
            flag = flag << 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countOne(-9));
        System.out.println(countOne2(-9));
    }

}
