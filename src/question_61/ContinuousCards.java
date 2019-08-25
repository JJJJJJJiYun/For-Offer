package question_61;

import java.util.Arrays;

public class ContinuousCards {

    /**
     * 判断取出的 5 张牌是否为顺子
     */
    private static boolean isContinuousCards(int[] cards) {
        if (cards == null || cards.length < 5)
            return false;
        int[] places = new int[14];
        for (int num : cards)
            places[num]++;
        int replacement = places[0];
        // 如果 5 个都是百搭
        if (replacement == 5)
            return true;
        int start = 1, end = places.length - 1;
        while (places[start] == 0)
            start++;
        while (places[end] == 0)
            end--;
        int countOfMissing = 0;
        // 如果只有一个不是百搭
        if (start == end)
            countOfMissing = 4;
        else {
            while (start <= end) {
                if (places[start++] == 0)
                    countOfMissing++;
            }
        }
        return countOfMissing == replacement;
    }

    private static boolean isContinuous(int[] cards) {
        if (cards == null || cards.length < 5)
            return false;
        Arrays.sort(cards);
        int countOfZero = 0;
        for (int i = 0; i < cards.length && cards[i] == 0; i++)
            countOfZero++;
        int small = countOfZero, big = small + 1, countOfGap = 0;
        while (big < cards.length) {
            if (cards[small] == cards[big])
                return false;
            countOfGap += cards[big] - cards[small] - 1;
            small = big;
            big++;
        }
        return countOfGap > countOfZero;
    }

    public static void main(String[] args) {
        int[] cards = {0, 0, 0, 0, 0};
        ;
        System.out.println(isContinuousCards(cards));
    }

}
