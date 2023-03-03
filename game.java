class Player {
    String name;
    int age;

    Player(String str, int x) {
        name = str;
        age = x;
    }

    public String getName() {
        return name;

    }

    public int getAge() {
        return age;
    }
}

class Snack {
    String description;
    double cost;
    String provider;

    Snack(String s, double c, String p) {
        description = s;
        cost = c;
        provider = p;
    }

    public String getDescription() {
        return description;

    }

    public double getCost() {
        return cost;

    }

    public String getProvider() {
        return provider;
    }
}

class BoardGame {
    static String title, owner;
    static int minimumAge, duration, minimumPlayers, maximumPlayers;
    static double rating;

    BoardGame(String t, String o, int mina, int max, int min, int d, double r) {
        title = t;
        owner = o;
        minimumAge = mina;
        duration = d;
        minimumPlayers = min;
        maximumPlayers = max;
        rating = r;

    }

    public String getTitle() {
        return title;

    }

    public String getOwner() {
        return owner;
    }

    public int getMinimumAge() {
        return minimumAge;

    }

    public int getMaximumPlayer() {

        return maximumPlayers;
    }

    public int getMinimumPlayer() {

        return minimumPlayers;
    }

    public double getRating() {
        return rating;
    }

    public static void setRating() {
        if (rating < 0 || rating > 100) {
            rating = 0;
            System.out.println("Rating percentage  not valid");
        }

    }
}

class GamingParty {

    String theme, boardGame, winner;
    int mp = BoardGame.maximumPlayers;
    int mnp = BoardGame.minimumPlayers;
    int ma = BoardGame.minimumAge;
    Player players[];
    Snack[] snacks;

    int j = 0;
    int k = 0;

    GamingParty(String t, String b) {
        theme = t;
        boardGame = b;
        winner = null;
        players = new Player[mp];
        snacks = new Snack[2 * mp];

    }

    public void addPlayer(String p, int a) {

        String n[] = new String[mp];

        for (int j = 0; j < players.length; j++) {
            if (players[j] != null)
                n[j] = players[j].getName();
        }

        if (j == mp) {
            System.out.println("The maximum no. of Players has reached for the game at this party");
            return;
        }

        if (a < ma) {
            System.out.println("The Player does not meet the age requirements for the board game at this party");
            return;
        }

        for (int j = 0; j < n.length; j++) {
            if (n[j] != null) {
                if (n[j].equals(p)) {
                    System.out.println("The Player is already playing the Game at the Party with the same name");
                    return;
                }

            }
        }

        players[j] = new Player(p, a);
        j++;
    }

    public void play() {
        if (j >= mnp) {
            System.out.println("Play");
        } else {
            System.out.println("You Need " + (mnp - j) + "more players");
        }

    }

    public void addSnack(String p, double c, String pr) {

        if (k == 2 * mp) {
            System.out.println("There are Enough Snacks");
        }

        snacks[k] = new Snack(p, c, pr);
        k++;

    }

    public double getPartyCost() {
        double s = 0;

        for (Snack snack : snacks) {
            if (snack != null)
                s = s + snack.cost;
        }

        return s;

    }

    public void getWinner() {
        System.out.println("Winner is : " + winner);
    }

    public void setWinner(String w) {
        if (winner != null) {
            System.out.println("The winner has already been decided !! It Was " + winner);
        }

        String n[] = new String[mp];
        for (int j = 0; j < players.length; j++) {
            if (players[j] != null)
                n[j] = players[j].getName();
        }

        for (int j = 0; j < n.length; j++) {
            if (n[j] != null) {
                if (n[j].equals(winner)) {
                    System.out.println("The Player didnt even win the game so cannot win!!");
                    return;
                }

            }
        }

        winner = w;
    }

    public void outputPartyDetails() {

        System.out.println("Theme : " + theme);
        System.out.println("Board Game : " + boardGame);
        System.out.println("Players : ");

        for (Player player : players) {
            if (player != null)
                System.out.println(player.getName());
        }

        System.out.println("Snacks : ");

        for (Snack snack : snacks) {
            if (snack != null)
                System.out.println(snack.getDescription() + " provided by " + snack.getProvider());
        }

        if (winner == null) {
            System.out.println("No Winners Yet");
        } else {
            System.out.println("The Winner is : " + winner);
        }

    }

    public void calculateRecommendedSnacks() {

        int gameDurationInHours = Math.round(BoardGame.duration / 60.0f);

        int maxSnacksAllowed = players.length * 2;

        // calculate the recommended number of snacks
        int recommendedSnacks = gameDurationInHours * players.length;

        if (recommendedSnacks > maxSnacksAllowed) {
            recommendedSnacks = maxSnacksAllowed;
        }

        recommendedSnacks = Math.min(recommendedSnacks, maxSnacksAllowed);

        System.out.println("A total of " + recommendedSnacks + " snack(s) are recommended for the game.");
    }

}

class game {
    public static void main(String[] args) {

        BoardGame obj1 = new BoardGame("Pictoionary", "Ravi", 18, 4, 2, 159, 75);

        System.out.println("//////////////////////////////////////////////////////////////////////////////");
        System.out.println("Title of BoardGame is : " + obj1.getTitle());
        System.out.println("Name of player who owns the BoardGame is : " + obj1.getOwner());
        System.out.println("Minimum Age of player is: " + obj1.getMinimumAge());
        System.out.println("Maximum no. of Player is : " + obj1.getMinimumPlayer());
        System.out.println("Minimum no. of player  is : " + obj1.getMaximumPlayer());
        System.out.println("Rating of GAme is : " + obj1.getRating());

        System.out.println("//////////////////////////////////////////////////////////////////////////////");
        GamingParty obj2 = new GamingParty("Friends Gathering", obj1.getTitle());

        obj2.addPlayer("deepak", 19);
        obj2.addPlayer("divyanshu", 21);
        obj2.addPlayer("manas", 22);

        obj2.play();

        obj2.addSnack("cream", 75, "deepu");
        obj2.addSnack("ice-cream", 75, "rakchit");
        obj2.addSnack("cake", 75, "ayush");

        System.out.println("Party cost is : " + obj2.getPartyCost());

        obj2.outputPartyDetails();

        obj2.calculateRecommendedSnacks();
    }
}