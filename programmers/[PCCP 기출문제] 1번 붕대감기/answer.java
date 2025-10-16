import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int ct = 0;
        int maxHealth = health;
        int bonusTime = bandage[0];
        int bonusHealth = bandage[2];
        int until = attacks[attacks.length - 1][0];

        int cnt = 0;
        for(int t=1; t<=until; t++) {
            if(health > maxHealth) {
                health = maxHealth;
            }

            if(attacks[cnt][0] == t) {
                health -= attacks[cnt++][1];
                ct = 0;
                if(health <= 0) {
                    return -1;
                }

                continue;
            }

            if(health == maxHealth) {
                continue;
            }

            health += bandage[1];
            ct++;
            if(ct == bonusTime) {
                health += bonusHealth;
                ct = 0;
            }
        }

        return health;
    }
}