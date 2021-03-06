//import java.util.Random;

import java.util.*;

public class Application {
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
    }

    //https://leetcode.com/problems/letter-case-permutation/submissions/
//    List<String> combinations = letterCasePermutation("1a3c");
//    System.out.println(combinations);
    public static List<String> letterCasePermutation(String S) {
        List<String> permute = new ArrayList<>();
        char[] str = S.toCharArray();
        permuteHelper(str, permute, 0);
        return permute;
    }

    private static void permuteHelper(char[] charArray, List<String> permute, int index) {
        if(index == charArray.length) {
            String newStr = new String(charArray);
            permute.add(newStr);
            return;
        }
        char character = charArray[index];
        if (Character.isLetter(character)) {
            charArray[index] = Character.toLowerCase(character);
            permuteHelper(charArray, permute, index + 1);
            charArray[index] = Character.toUpperCase(character);
        }
        permuteHelper(charArray, permute, index + 1);

    }


//        System.out.println(advCalculate("(3   +   (3 + 3))"));
//        System.out.println(advCalculate("((3+ 3) / 2)"));
//        System.out.println(advCalculate("((3 + 3) * (2 + 1))"));
    public static int advCalculate(String expression) {
        String trimmedExpression = expression.replace(" ", "");
        trimmedExpression = trimmedExpression.substring(1, trimmedExpression.length() - 1);
        int firstIndexOfClosingParenthesis = Integer.MAX_VALUE;
        while(firstIndexOfClosingParenthesis > 0) {
            firstIndexOfClosingParenthesis = trimmedExpression.indexOf(")");
            if(firstIndexOfClosingParenthesis == -1) {
                return calculate(trimmedExpression);
            }
            int indexOfOpeningParenthesis = Integer.MIN_VALUE;
            for (int i = firstIndexOfClosingParenthesis; i >= 0; i--) {
                if (trimmedExpression.charAt(i) == '(') {
                    indexOfOpeningParenthesis = i;
                    break;
                }
            }
            int calc = calculate(trimmedExpression.substring(indexOfOpeningParenthesis + 1, firstIndexOfClosingParenthesis));
            trimmedExpression = trimmedExpression.substring(0, indexOfOpeningParenthesis) + calc + trimmedExpression.substring(firstIndexOfClosingParenthesis + 1);
        }
        return Integer.MIN_VALUE;
    }

    //        System.out.println(calculate(" 30 / 10 "));
    public static int calculate(String expression){
        String trimmedExpression = expression.replace(" ", "");
        String[] numbers = trimmedExpression.split("[+\\-\\*\\/]");
        String operand = trimmedExpression.substring(numbers[0].length(), numbers[0].length() + 1);
        Integer num1 = Integer.valueOf(numbers[0]);
        Integer num2 = Integer.valueOf(numbers[1]);
        int answer = Integer.MIN_VALUE;
        switch (operand){
            case "+":
                answer = num1 + num2;
                break;
            case "-":
                answer = num1 - num2;
                break;
            case "*":
                answer = num1 * num2;
                break;
            case "/":
                answer = num1 / num2;
                break;
        }
        return answer;

    }
    //https://leetcode.com/problems/island-perimeter/
    public static int islandPerimeter(int[][] grid) {
        //go over the whole grid
        //check if grid[i][j] == 1 count the island
        //if the current grid is island, check the right and down cells
        //island * 4 - (neighbors * 2)
        //count the neighbors, only count if there exists any right or down ones
        if(grid == null || grid.length == 0) return 0;
        int island = 0;
        int sideLand = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) {island++;
                    if(i < (grid.length - 1)  && grid[i+1][j] == 1) sideLand++;
                    if(j < (grid[0].length - 1)  && grid[i][j+1] == 1) sideLand++;
                }
            }
        }
        island = (island * 4) - (sideLand * 2);
        return island;
    }

    //Eliot's version
    public static int islandPerimeter1(int[][] grid) {

        int primCount = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j]==1){

                    int primSides = 4;

                    if(i-1>=0 && grid[i-1][j]==1)primSides--;
                    if(j-1>=0 && grid[i][j-1]==1)primSides--;
                    if(i+1 < grid.length && grid[i+1][j] == 1)primSides--;
                    if(j+1 < grid[0].length && grid[i][j+1] == 1)primSides--;

                    primCount += primSides;
                }
            }
        }
        return primCount;
    }


    //https://leetcode.com/problems/valid-tic-tac-toe-state/
    public static boolean validTicTacToe(String[] board) {

        int[] rows = new int[3];
        int[] columns = new int[3];
        int horizontal = 0;
        int vertical  = 0;
        boolean player1Wins = false;
        boolean player2Wins = false;
        int  turns = 0 ;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i].charAt(j) == 'X'){
                    turns++;
                    rows[i]++;
                    columns[j]++;
                    if(i == j) vertical++;
                    if (i + j == 2 ) horizontal++;
                    if(rows[i] == 3 || columns[j] == 3 || vertical == 3 || horizontal ==3){
                        player1Wins = true;
                    }
                }
                else if(board[i].charAt(j) == 'O'){
                    turns--;
                    rows[i]--;
                    columns[j]--;
                    if(i == j) vertical--;
                    if (i + j == 2) horizontal--;
                    if(rows[i] == -3 || columns[j] == -3 || vertical == -3 || horizontal == -3){
                        player2Wins = true;
                    }
                }
            }
        }

        // if X wins turns should be 0, if O wins turns must be 1
        //If no one wins, turns must be <= 1

        if (turns == 0 && player1Wins || turns == 1 && player2Wins || turns < 0 || turns > 1) {
            return false;
        }
        return true;
    }



    //https://leetcode.com/problems/two-sum/submissions/
    public static int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                 answer[0] = map.get(nums[i]);
                 answer[1] = i;
                 break;
            }
            else {
                map.put(target - nums[i], i);
            }
        }

        return answer;
    }

    public static int minDays(int n) {
        //eat one orange
        // if n/2, eat n/2 oranges
        // if n/3 , 2*(n/3)

        int minDays = Integer.MAX_VALUE;
        if (n <= 2) return n ;
        if( n == 3) return 2;
        if(!map.containsKey(n)) {
            //map.put(n, Math.min(minDays(n/3)))
            if (n % 3 == 0) {
                minDays = minDays((n / 3)) + 1;
            }
            if (n % 2 == 0) {
                int newMin = minDays(n / 2) + 1;
                if (newMin < minDays) {
                    minDays = newMin;
                }
            }

            int newMin = minDays(n - 1) + 1;
            if (newMin < minDays) {
                minDays = newMin;
            }
            map.put(n, minDays);

        }else {
           minDays =  map.get(n);
        }
        return minDays;
    }



    //https://leetcode.com/problems/minimum-window-substring/
    public static String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        if(t.length() == 1){
            int index = s.indexOf(t.charAt(0));
            return index == -1 ?"" : s.substring(index, index+1);
        }
        int minLength = Integer.MAX_VALUE;
        String minWindow ="";

        for (int begin = 0; begin < s.length(); begin++) {
            char current = s.charAt(begin);
            if (current == t.charAt(0)) {
                int count = 1;
                int end = begin + 1;
                while (end < s.length()) {
                    if(count < t.length() && s.charAt(end) == t.charAt(count)) {
                        count++;

                    if(count == t.length()) {
                        int currentLength = end - begin;
                        if (currentLength < minLength) {
                            minWindow = s.substring(begin, end + 1);
                            minLength = currentLength;
                        }
                        break;
                    }
                    }
                    end++;
                }
            }
        }
        return minWindow;
    }



    //My Version
    // https://leetcode.com/problems/permutations/
    //https://java2blog.com/permutations-array-java/

//    Application newApp=new Application();
//    int[] arr= {1, 2, 3};
//    List<List<Integer>> permutation = newApp.permute(arr);
//        for(List<Integer> permute :permutation)
//    {
//        System.out.println(permute);
//    }
    public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> listOfList = new ArrayList<>();
    List<Integer> permute = new ArrayList<>();
    helperPermute(listOfList, permute, nums);
    return listOfList;
    }

    private static void helperPermute(List<List<Integer>> listOfList, List<Integer> permute, int[] numbs) {

        if (permute.size() == numbs.length) {
            listOfList.add(new ArrayList<>(permute));
        } else {
            for (int i = 0; i < numbs.length; i++) {
                if (permute.contains(numbs[i])) continue; //checks if an element already in the list, if so skip
                permute.add(numbs[i]);
                helperPermute(listOfList, permute, numbs);
                permute.remove(permute.size() - 1);
            }
        }
    }

//David'S VERSION 
        public static List<List<Integer>> permute1(int[] nums) {
            List<List<Integer>> listOfLists = new ArrayList<>();
            List<Integer> available = new ArrayList<>();

            for( int i = 0; i < nums.length; i++) available.add( nums[i] );

            List<Integer> current = new ArrayList<>();
            permute( listOfLists, available, current );
            return listOfLists;
        }

        public static void permute(
                List<List<Integer>> answers,
                List<Integer> availableNums,
                List<Integer> current ){

            if( availableNums.size() == 0 ){
                //we've used all the numbers for this permutation
                //copy current and add it to our list of lists
                List<Integer> copy = new ArrayList<>();
                copy.addAll( current );

                answers.add( copy );
            } else {

                for( int i = 0; i < availableNums.size(); i++ ){
                    Integer toTry = availableNums.get(i);
                    availableNums.remove( i );

                    current.add( toTry );
                    permute( answers, availableNums, current );
                    current.remove( current.size() - 1  );
                    availableNums.add( i, toTry);
                }
            }
        }

    //Binary Search
    //https://leetcode.com/problems/binary-search/
    //[? ? ? ? ? ?]
    //min index = 0
    //max index = length - 1
//        int[] num = {0,1,2,3,4,5,6};
//        System.out.println(search(num, 5));
//        System.out.println(searchRecursively(num, 5, 0, num.length -1));
    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length -1;
        int middle;

        while(left <= right){
            middle = (right + left) / 2;
            if(nums[middle] == target){
                return middle;
            }
            //search right
            else if(nums[middle] < target){
                left = middle + 1;
            }
            //search left
            else {
                right = middle - 1;
            }
        }
        return -1;
    }

    //Binary Search (Recursive version)
    //Can make a private method
    //then inside the public method
    //return searchRecursively(nums, target, 0, nums.length-1)
    public static int searchRecursively(int[] nums, int target, int left, int right){
        if(nums == null || nums.length == 0) return -1;
        if(left > right) return -1;

        int middle = (right + left) / 2;
        if(nums[middle] == target){
            return middle;
        }
        else if(nums[middle] < target){
            return searchRecursively(nums, target, middle + 1, right);
        }
        else {
            return searchRecursively(nums, target, left, middle -1);
        }

    }


        //a perfect number is one where the sum of All factors adds up to 2X the number
    //6: 1+ 2 + 3 + 6
    //28: 1 + 2 + 4+ 7 + 14 + 28
    public static boolean isPerfect(int num) {
        int sum = 0;
        boolean isPerfect = false;
        for (int factor = 1; factor < num; factor++) {  //smallest factor is 1
            if (num % factor == 0) { //means num is evenly divisible by factor

                sum += factor;
            }
        }
        if (sum == num) isPerfect = true;
        return isPerfect;
    }

    public static boolean isPerfect1(int num) {
        //factors come in pairs
        //12:
        //1   12
        //2    6
        //3    4
        //4    3
        int sum = num + 1;  //because of the square case 9 = 3 * 3
        for (int factor = 2; factor * factor < num; factor++) {  //smallest factor is 1
            if (num % factor == 0) { //means num is evenly divisible by factor
                sum += factor;
                sum += num / factor;
            }
        }

        return num * 2 == sum;
    }

    public static int lengthOfLongestSubstring(String s) {

//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring("bbbbb"));
//        System.out.println(lengthOfLongestSubstring("pwwkew"));
//        System.out.println(lengthOfLongestSubstring(""));


        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char[] character = s.toCharArray();
        int tmp = 0;
        int max = 0;
        for (int i = 0; i < character.length; i++) {
            if (!map.containsKey(character[i])) {
                map.put(character[i], i);
                tmp++;
            } else {
                if (map.get(character[i]) + tmp < i) {
                    tmp++;
                } else {
                    max = Math.max(max, tmp);
                    tmp = i - map.get(character[i]);
                }
                map.put(character[i], i);
            }
        }
        max = Math.max(max, tmp);
        return max;
    }


    //123->321
    //2001->2002
    //2000->2
    //2->2
//        System.out.println(digitReverse(321));
//        System.out.println(digitReverse(1));
//        System.out.println(digitReverse(11));
//        System.out.println(digitReverse(2000));
//        System.out.println(digitReverse(20001));
//        System.out.println(digitReverse(-321));
//        System.out.println(digitReverse(0));
    public static int digitReverse(int toFlip) {
        boolean isNeg = false;
        int reverseNum = 0;
        if (toFlip < 0) {
            isNeg = true;
        }

        if (isNeg) {
            toFlip = toFlip * (-1);
        }
        while (toFlip > 0) {
            reverseNum *= 10;
            reverseNum = reverseNum + toFlip % 10;
            toFlip /= 10;
        }
        return isNeg == true ? reverseNum * (-1) : reverseNum;
    }


    //        //New Problem
//
////        The following iterative sequence is defined for the set of positive integers:
////
////        n → n/2 (n is even)
////        n → 3n + 1 (n is odd)
////
////        Using the rule above and starting with 13, we generate the following sequence:
////
////        13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
////        It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
////        Although it has not been proved yet (Collatz Problem), it is thought that
////        all starting numbers finish at 1.
////        Which starting number, under one million, produces the longest chain?
//
//        System.out.println(getChainSteps(837799));
//        System.out.println(getChainSteps(13));
//
//        long sequence;
//        long chainLength = 0;
//        long num = 0;
//
//        for(int i = 2; i <= 1000000; i++){
//            int length = 1;
//
//            sequence = i;
//            while(sequence != 1){
//                if((sequence %2) != 0){
//                    sequence = sequence * 3 +1;
//                }
//                else{
//                    sequence = sequence /2;
//                }
//                length++;
//            }
//            if(chainLength < length) {
//                chainLength = length;
//                num = i;
//            }
//        }
//        System.out.println(num + " Produces the longest chain. ");
//        System.out.println(chainLength + " is the chain length ");
//
//
//    }
//
    public static int getChainSteps(long sequence) {
        List<Long> list = new ArrayList<>();
        int length = 0;
        while (sequence != 1) {
            list.add(sequence);
            if ((sequence % 2) != 0) {
                sequence = sequence * 3 + 1;
            } else {
                sequence = sequence / 2;
            }

        }
        length = list.size() + 1;
        return length;
    }


// End Problem

    //New Problem
//        //The list type is an interface
//        //The concrete class we'll use is an ArrayList
//
//        List<String> testList = new ArrayList<>();
//        testList.add("Bob");
//        testList.add("Bobby");
//        testList.add("Robert");
//        testList.add("Roberto");
//        testList.add("Alice");
//        testList.add("Alica");
//
//        String[] allNames = testList.toArray(new String[0]);
//
//        //how to make a map with values that are lists
//
//        Map<String, List<String>> testMap = new HashMap<>();
//
//
//        List<String> someList = new ArrayList<>();
//        //adds here
//
//        testMap.put("Some String", someList);
//
//
//        for (int i = 0; i < someList.size(); i++) {
//            System.out.println(someList.get(i));
//        }
//
//
//        Map<String, List<String>> groupNames = groupByFirstTwoLetters(allNames);
//        System.out.println(groupNames);
//
//        Map<String, List<String>> groupNames1 = groupByFirstNLetters(allNames, 3);
//        System.out.println(groupNames1);
//
//    }
//
//    //input: ["Bob", "Bobby", "Robert", "Roberto", "Alice", "Alica" ]
//    //output:
//    // Map with 3 keys:
//    // "Bo" -> List {"Bob", "Bobby"}
//    // "Ro" -> List: {"Robert", "Roberto"}
//    // "Al" -> List: {"Alice" , "Alica"}
//
    public static Map<String, List<String>> groupByFirstTwoLetters(String[] toGroup) {

        Map<String, List<String>> groups = new HashMap<>();
        for (String toPlace : toGroup) {

            //for substring() the end index is itself not included
            String key = toPlace.length() < 3 ? toPlace : toPlace.substring(0, 2);

            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }
            groups.get(key).add(toPlace);
        }
        return groups;
    }


    public static Map<String, List<String>> groupByFirstNLetters(String[] toGroup, int numLetters) {

        Map<String, List<String>> groups = new HashMap<>();
        for (String toPlace : toGroup) {

            //for substring() the end index is itself not included
            String key = toPlace.length() < (numLetters + 1) ? toPlace : toPlace.substring(0, numLetters);

            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }
            groups.get(key).add(toPlace);
        }
        return groups;
    }


//End

//        System.out.println(canBalance(new int[]{1, 1, 1, 2, 1}));
//        System.out.println(noTriples1(new int[]{1, 1, 1, 2, 1}));
//        System.out.println(noTriples1(new int[]{5,2,3}));
//        System.out.println(noTriples(new int[]{1, 1, 1, 2, 1}));
//        System.out.println(noTriples(new int[]{5,2,3}));
//    }

    public static boolean canBalance(int[] nums) {
        //return true if there is any place where we can split the array
        //each side of the array's sum is equal to each other
        int rightSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSum += nums[i];
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];
            if (leftSum == rightSum) return true;
        }
        return false;
    }

    //return true if there is no truples in the array
    public static boolean noTriples1(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i + 1] == nums[i] && nums[i + 2] == nums[i])
                return false;
        }
        return true;
    }

    public static boolean noTriples(int[] array) {
        int temp = array[0];
        boolean isDouble = false;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == temp) {
                if (isDouble) {
                    return false;
                }
                isDouble = true;
            } else {
                isDouble = false;
            }
            temp = array[i];
        }
        return true;
    }


//
//        //bitwise operation
//        int mask = 1;
//
//        Random rang = new Random();
//        int ranNum = rang.nextInt();
//
//        for(int i = 0; i < 32; i++){
//            System.out.println(ranNum & mask);
//            mask <<= 1;
//        }
//
//
//        System.out.println(middleOfThree(1, 2, 3));
//        System.out.println(middleOfThree(1, 3, 2));
//        System.out.println(middleOfThree(2, 1, 3));
//        System.out.println(middleOfThree(2, 3, 1));
//        System.out.println(middleOfThree(3, 1, 2));
//        System.out.println(middleOfThree(3, 2, 1));
//        System.out.println(macNum(3, 2, 1));
//
//        fizzBuzz();
//        fizzBuzz1();
//
//
//        //1-d Arrays:
//        int[] oneDim = new int[10];
//
//        //2-d arrays:
//        int[][] twoDim = new int[10][];
//        for (int i = 0; i < twoDim.length; i++) {
//            twoDim[i] = new int[10];
//        }
//        int[][] quick = {
//                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
//        };
//        int[][] quick2 = {
//                {11, 2, 3, 4, 5, 6, 7, 8, 9, 10},
//                {12, 2, 3, 4, 5, 6, 7, 8, 9, 10},
//                {1, 2, 3, 1234, 5, 6, 7, 8, 9, 10},
//                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
//                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
//                {11, 2, 3, 4, 5, 6, 7, 8, 9, 10},
//                {12, 2, 3, 4, 5, 6, 7, 8, 9, 10},
//                {1, 2, 3, 1234, 5, 6, 7, 8, 9, 10},
//                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
//                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
//        };
//
//        System.out.println(quick2[0][0]);
//        System.out.println(quick2[2][3]);
//
//        for (int row = 0; row < quick2.length; row++) {
//            for (int col = 0; col < quick2[row].length; col++) {
//                System.out.print(quick2[row][col] + " ");
//            }
//            System.out.println();
//        }
//
//        for(int i = 0; i < 100; i++){
//            int row = i / 10;//(10 is the width of the row);
//            int col = i % 10;
//            System.out.println(quick2[row][col]);
//        }
//    }
//    public static int computeIndex(int row, int col){
//        return 10 * row + col;
//    }

    public static int middleOfThree(int a, int b, int c) {
        if (a > b) {
            if (c > a) {
                return a;
            } else if (c > b) {
                return c;
            } else {
                return b;
            }
        } else {
            if (a > c) {
                return a;

            } else if (b > c) {
                return c;

            } else {
                return b;

            }
        }
    }

    public static int macNum(int a, int b, int c) {
        int maxNum = a;
        if (b > c) {
            maxNum = b;
        }
        if (c > maxNum) {
            maxNum = c;
        }
        return maxNum;
    }

    public static void fizzBuzz() {
        for (int i = 0; i < 100; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                System.out.print("i");
            }
            if (i % 3 == 0) {
                System.out.print("fizz");
            }
            if (i % 5 == 0) {
                System.out.print("buzz");
            }
            System.out.println();
        }
    }

    public static void fizzBuzz1() {
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("fizzbuzz");
            } else if (i % 3 == 0) {
                System.out.print("fizz");
            } else if (i % 5 == 0) {
                System.out.print("buzz");
            }
            System.out.println(i);
        }
    }

    //We'll say that a "mirror" section in an array is a group of contiguous elements
// such that somewhere in the array, the same group appears in reverse order.
// For example, the largest mirror section in {1, 2, 3, 8, 9, 3, 2, 1} is length 3
// (the {1, 2, 3} part). Return the size of the largest mirror section found in the given array.
//
//
//maxMirror([1, 2, 3, 8, 9, 3, 2, 1]) → 3
//maxMirror([1, 2, 1, 4]) → 3
//maxMirror([7, 1, 2, 9, 7, 2, 1]) → 2
    public int maxMirror1(int[] nums) {
        int totalLength = 0;
        for (int leftMatch = 0; leftMatch < nums.length; leftMatch++) {
            for (int rightMatch = nums.length - 1; rightMatch >= leftMatch; rightMatch--) {

                int lengthSm = 0;
                int leftIndex, rightIndex = 0;
                Boolean isMatch = false;

                if (nums[leftMatch] == nums[rightMatch]) {
                    isMatch = true;
                }
                while (isMatch) {
                    lengthSm++;
                    leftIndex = leftMatch + lengthSm;
                    rightIndex = rightMatch - lengthSm;

                    isMatch = (rightIndex >= 0) && (nums.length > leftIndex) &&
                            (nums[leftIndex] == nums[rightIndex]);
                }
                if (lengthSm > totalLength) {
                    totalLength = lengthSm;
                }
            }
        }
        return totalLength;
    }

    public int maxMirror(int[] nums) {
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) { //front loop
            for (int j = nums.length - 1; j >= 0; j--) {//back loop

                if (nums[i] == nums[j]) {
                    //we've found the match of at least length 1
                    //it could be the max, but we don't know

                    //another length variable to hold the least/small length inside the loop
                    int currentLength = 1;
                    for (int offset = 1;
                         i + offset < nums.length && j - offset >= 0;
                         offset++) {
                        if (nums[i + offset] == nums[j - offset]) {
                            currentLength++;
                        } else {
                            break;
                        }
                    }
                    if (currentLength > maxLength) {
                        maxLength = currentLength;
                    }
                }

            }

        }
        return maxLength;

    }
}