package tennis;

public class JeuxDeTennis {
    private int vScorePlayer1 = 0;
    private int vScorePlayer2 = 0;
    private final String vNomJoueur2;
    private final String vNomJoueur1;

    public JeuxDeTennis(String pNomJoueur1, String pNomJoueur2) {
        this.vNomJoueur1 = pNomJoueur1;
        this.vNomJoueur2 = pNomJoueur2;
    }

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

    private boolean isDeuce() {
        return vScorePlayer1 >= 3 && vScorePlayer2 == vScorePlayer1;
    }

    private String getLeadPlayer() {
        return (vScorePlayer1 > vScorePlayer2) ? vNomJoueur1 : vNomJoueur2;
    }

    private boolean hasWinner() {
        if(vScorePlayer2 >= 4 && vScorePlayer2 >= vScorePlayer1 + 2 )
            return true;
        return vScorePlayer1 >= 4 && vScorePlayer1 >= vScorePlayer2 + 2;
    }

    private boolean hasAdvantage() {
        if (vScorePlayer2 >= 4 && vScorePlayer2 == vScorePlayer1 + 1)
            return true;
        return vScorePlayer1 >= 4 && vScorePlayer1 == vScorePlayer2 + 1;

    }

    public void scorePlayer1() {
        vScorePlayer1++;
    }

    public void scorePlayer2() {
        vScorePlayer2++;
    }

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
