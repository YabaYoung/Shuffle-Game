import java.util.*;

public class Shuffle {

        private static ArrayList<String> fruits = new ArrayList<>();
        private static ArrayList<String> flowers = new ArrayList<>();
        private static ArrayList<String> animals = new ArrayList<>();
        private static ArrayList<Character> words = new ArrayList<>();
        private static HashMap<String, String> answer = new HashMap<>();

        private static String shuffled = "";

        static boolean correct = false;

        public static void addFruits() {

            fruits.add("apple");
            fruits.add("banana");
            fruits.add("cherry");
            fruits.add("orange");
            fruits.add("kiwi");
            fruits.add("grapes");
            fruits.add("strawberry");
            fruits.add("avocado");
            fruits.add("melon");
            fruits.add("peach");
        }

        public static void addFlowers() {

            flowers.add("daisy");
            flowers.add("tulip");
            flowers.add("poppy");
            flowers.add("lotus");
            flowers.add("lily");
            flowers.add("dandelion");
            flowers.add("rose");
            flowers.add("peony");
            flowers.add("marigold");
            flowers.add("bluebell");
        }

        public static void addAnimals() {

            animals.add("cat");
            animals.add("dog");
            animals.add("fox");
            animals.add("lion");
            animals.add("monkey");
            animals.add("wolf");
            animals.add("zebra");
            animals.add("owl");
            animals.add("gorilla");
            animals.add("deer");
        }

        public static String shuffle(ArrayList List) {

            Random random = new Random();
            int index = random.nextInt(List.size());
            String word = (String) List.get(index);
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                words.add(c);
            }
            shuffled = "";
            Collections.shuffle(words);
            for (int i = 0; i < words.size(); i++) {

                shuffled+= words.get(i);
            }
            answer.put(shuffled, word);
            System.out.println(word);
            words.clear();

            return shuffled;
        }

        public static boolean guessWord (String word) {

            boolean correct;
            if (word.equals(answer.get(shuffled))) {
                System.out.println("Correct!");
                correct = true;
            } else {
                System.out.println("Incorrect... Please try again");
                correct = false;
            }
            return correct;
       }


        public static void main(String[] args) {

            boolean run = true;
            addFruits();

            Scanner input = new Scanner(System.in);
           // String categoryInput = input.next();
            System.out.println("Would you like to play a word guessing game?");
            String userResponse = input.next();
            while (run) {

                if (userResponse.equalsIgnoreCase("yes")) {
                    String result = shuffle(fruits);
                    System.out.println(result);
                    System.out.println("What is the original word?");

                    while (!correct) {
                        String guess = input.next();
                        correct = guessWord(guess);
                    }

                    if (correct) {
                        System.out.println("Would you like to play again?");
                        userResponse = input.next();
                        correct = false;
                    } else if (userResponse.equals("no")) {
                        run = false;
                    }

                }
            }
        }
}
