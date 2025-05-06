import java.util.*;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = directions.length();
        Pair[] arr = new Pair[n];
        for (int i = 0 ; i < n ; i++) {
            arr[i] = new Pair(positions[i], healths[i], directions.charAt(i), i);
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a.position, b.position));
        Stack<Pair> stack = new Stack<>();

        for (int i = 0 ; i < n ; i++) {
            Pair curr = arr[i];
            if (curr.direction == 'R') {
                stack.push(curr);
            } else {
                while (!stack.isEmpty() && stack.peek().direction == 'R') {
                    Pair top = stack.peek();
                    if (curr.health > top.health) {
                        stack.pop();
                        curr.health -= 1;
                    } else if (top.health > curr.health) {
                        top.health -= 1;
                        curr = null;
                        break;
                    } else {
                        stack.pop();
                        curr = null;
                        break;
                    }
                }
                if (curr != null) {
                    stack.push(curr);
                }
            }
        }

        List<Pair> survivors = new ArrayList<>(stack);
        survivors.sort((a, b) -> Integer.compare(a.index, b.index));

        List<Integer> result = new ArrayList<>();
        for (Pair p : survivors) {
            result.add(p.health);
        }

        return result;
    }
}

class Pair {
    int position;
    int health;
    char direction;
    int index;

    Pair(int position, int health, char direction, int index) {
        this.position = position;
        this.health = health;
        this.direction = direction;
        this.index = index;
    }
}
