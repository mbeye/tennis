package tennis;

public class JeuxDeTennis {
    //score du joueur 1 initialisé à 0 au déut du jeu
    private int vScorePlayer1 = 0;
    //score du joueur 2 initialisé à 0 au déut du jeu
    private int vScorePlayer2 = 0;
    //Nom du joueur 1
    private final String vNomJoueur2;
    //Nom du joueur 2
    private final String vNomJoueur1;

    //Constructeur
    public JeuxDeTennis(String pNomJoueur1, String pNomJoueur2) {
        this.vNomJoueur1 = pNomJoueur1;
        this.vNomJoueur2 = pNomJoueur2;
    }

    //méthode pour récupérer le score
    public String getScore() {

        if (hasWinner()) {
            return getLeadPlayer() + " wins";
        }

        if (hasAdvantage()) {
            return "Advantage " + getLeadPlayer();
        }

        if (isDeuce()){
            return "Deuce";
        }

        if(vScorePlayer1 == vScorePlayer2) {
            return translateScore(vScorePlayer1) + " all";
        }

        return translateScore(vScorePlayer1) + "," + translateScore(vScorePlayer2);
    }

    //méthode permettant de savoir si on est en DEUCE
    private boolean isDeuce() {
        return vScorePlayer1 >= 3 && vScorePlayer2 == vScorePlayer1;
    }

    //méthode pour afficher le gagnant
    private String getLeadPlayer() {
        return (vScorePlayer1 > vScorePlayer2) ? vNomJoueur1 : vNomJoueur2;
    }

    //méthode pour savoir le gagnant
    private boolean hasWinner() {
        if(vScorePlayer2 >= 4 && vScorePlayer2 >= vScorePlayer1 + 2 )
            return true;
        return vScorePlayer1 >= 4 && vScorePlayer1 >= vScorePlayer2 + 2;
    }

    //méthode pour savoir qui a l'avantage
    private boolean hasAdvantage() {
        if (vScorePlayer2 >= 4 && vScorePlayer2 == vScorePlayer1 + 1)
            return true;
        return vScorePlayer1 >= 4 && vScorePlayer1 == vScorePlayer2 + 1;

    }

    //méthode pour récupérer le score du jouer 1
    public void scorePlayer1() {
        vScorePlayer1++;
    }

    //méthode pour récupérer le score du jouer 2
    public void scorePlayer2() {
        vScorePlayer2++;
    }

    //méthode pour affichant les points gagnés par chaque joueur
    private String translateScore(int score) {
        switch (score) {
            case 3:
                return "40";
            case 2:
                return "30";
            case 1:
                return "15";
            case 0:
                return "0";
        }
        throw new IllegalArgumentException("Mauvais score: " +  score);
    }
}
