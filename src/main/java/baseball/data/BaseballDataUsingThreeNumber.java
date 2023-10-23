package baseball.data;

public class BaseballDataUsingThreeNumber implements IBaseballData<Integer> {

    private int value;

    public BaseballDataUsingThreeNumber(int value) {
        this.value = value;
    }


    @Override
    public BaseballDataCompareResult compare(IBaseballData baseballData) {
        if (!(baseballData instanceof BaseballDataUsingThreeNumber)) {
            throw new IllegalArgumentException();
        }

        int value1 = this.value;
        int value2 = (int) baseballData.getValue();
        int[] value1Arr = this.numberToArray(value1);
        int[] value2Arr = this.numberToArray(value2);

        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < value1Arr.length; i++) {
            for (int j = 0; j < value2Arr.length; j++) {
                if (value1Arr[i] == value2Arr[j]) {
                    if (i == j) {
                        strikeCount++;
                    } else {
                        ballCount++;
                    }
                }
            }
        }

        return new BaseballDataCompareResult(strikeCount, ballCount);
    }

    public Integer getValue() {
        return this.value;
    }

    @Override
    public int getSize() {
        String numberAsString = Integer.toString(this.value);
        int length = numberAsString.length();

        return length;
    }

    private int[] numberToArray(int num) {
        int[] array = new int[3];
        for (int i = 2; i >= 0; i--) {
            array[i] = num % 10;
            num /= 10;
        }

        return array;
    }
}
