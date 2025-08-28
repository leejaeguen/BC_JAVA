package com.worms.chap06.section01.dp;

import java.util.Arrays;

public class Application1 {
    public static Integer solution(Integer input) {
        int[] dp = new int[input + 1];

        for (int i = 0; i <= input; i++) {
            dp[i] = -1;
        }

        dp[0] = 0;
        for (int i = 3; i <= input; i++) {
            if (dp[i - 3] != -1) {   // i번째에서 3kg 봉지 추가했을 경우
                dp[i] = dp[i - 3] + 1;
            }
            if (i >= 5 && dp[i - 5] != -1){   // i번째에서 5kg 봉지 추가했을 경우
                if (dp[i] == -1) {            // 3kg으로는 해당 되지 않는 경우
                    dp[i] = dp[i - 5] + 1;
                }else {                       // 3kg과 5kg이 모두 해당되는 경우
                    dp[i] = Math.min(dp[i], dp[i - 5] + 1);
                }
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[input] == -1? -1 : dp[input] ;
    }
}
