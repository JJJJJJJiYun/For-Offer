package question_49;

public class UglyNumber {

    /**
     * 找到第 index 个丑数
     */
    private static int findUglyNumber(int index) {
        if (index <= 0)
            return 0;
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int nextUglyIndex = 1;
        int multiply2Index = 0;
        int multiply3Index = 0;
        int multiply5Index = 0;
        while (nextUglyIndex < index) {
            int min = Math.min(Math.min(uglyNumbers[multiply2Index] * 2,
                    uglyNumbers[multiply3Index] * 3),
                    uglyNumbers[multiply5Index] * 5);
            uglyNumbers[nextUglyIndex] = min;
            while (uglyNumbers[multiply2Index] * 2 <= uglyNumbers[nextUglyIndex])
                multiply2Index++;
            while (uglyNumbers[multiply3Index] * 3 <= uglyNumbers[nextUglyIndex])
                multiply3Index++;
            while (uglyNumbers[multiply5Index] * 5 <= uglyNumbers[nextUglyIndex])
                multiply5Index++;
            nextUglyIndex++;
        }
        return uglyNumbers[nextUglyIndex - 1];
    }

    public static void main(String[] args) {
        System.out.println(findUglyNumber(1500));
    }

}
