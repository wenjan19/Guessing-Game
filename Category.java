class Category {
    private final String[] words;

    public Category(String[] words) {
        this.words = words;
    }

    public String chooseWord() {
        java.util.Random rand = new java.util.Random();
        int randIndex = rand.nextInt(words.length);
        return words[randIndex];
    }
}

class Animals extends Category {
    public Animals() {
        super(new String[]{"kangaroo", "orca", "orangutan"});
    }
}


class Food extends Category {
    public Food() {
        super(new String[]{"banana", "hot dog", "salad"});
    }
}


class Gadgets extends Category {
    public Gadgets() {
        super(new String[]{"smartwatch", "camera", "phone"});
    }
}


class OOP extends Category {
    public OOP() {
        super(new String[]{"abstraction", "polymorphism", "constructor"});
    }
}
