import utils.Kattio;

public class counting_liars {
    public static void main(String[] args) {
        Kattio io = new Kattio();

        int n = io.nextInt();
        char[] chars = new char[n];
        int[] nums = new int[n];

        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            chars[i] = io.next().charAt(0);
            nums[i] = io.nextInt();
            maxVal = Math.max(nums[i], maxVal);
            minVal = Math.min(nums[i], minVal);
        }

        int minLying = n;
        for (int i : nums) {
            int fallsWithin = 0;
            for (int j = 0; j < n; j++) {
                int amt = nums[j];
                char c = chars[j];
                if (c == 'G' && i >= amt || c == 'L' && i <= amt)
                    fallsWithin++;
            }
            minLying = Math.min(minLying, n - fallsWithin);
        }

        io.println(minLying);

        io.close();
    }
}
