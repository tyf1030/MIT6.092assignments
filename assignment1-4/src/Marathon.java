class Marathon {
    public static void main (String[] arguments) {
        String[] names = {
            "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
            "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda",
            "Aaron", "Kate"
        };

        int[] times = {
            341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299,
            343, 317, 265
        };

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + ": " + times[i]);
        }
        System.out.println("the best: " + names[theBest(times)] + ":" + times[theBest(times)]);
        System.out.println("the second best: " + names[theSecondBest(times)] + ":" + times[theSecondBest(times)]);
    }

    public static int theBest (int[] times){
        int i;
        int index = 0;
        for (i = 1; i < times.length; i++){
            if (times[i] < times[index]){
                index = i;
            }
        }
        return index;
    }

    public static int theSecondBest (int[] times){
        int theBest = times[theBest(times)];
        int index = 0;
        int i;
        for (i = 1; i< times.length; i++){
            if (times[i] < times[index] && times[i] > theBest){
                index = i;
            }
        }
        return index;
    }
} 