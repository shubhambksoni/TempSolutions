public static int diagonalDifference(List<List<Integer>> list) {
    // Write your code here
        int sumA=0,sumB=0,difference;
        for(int i=0;i<list.size();i++){
            sumA+=list.get(i).get(i);
            sumB+=list.get(i).get(list.size()-i-1);
        }
        return Math.abs(sumA-sumB);
    }
