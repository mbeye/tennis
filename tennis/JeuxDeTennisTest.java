package tennis;

import junit.framework.TestCase;
public class JeuxDeTennisTest extends TestCase {
    JeuxDeTennis game = new JeuxDeTennis("Player 1" , "Player 2");

    //début du jeu chacun a 0 point
    public void testNewGameShouldReturnZeroAll()
    {
        String score = game.getScore();
        assertEquals("0 all", score);
        System.out.println(score);
    }

    //joueur 1 a gagné 1 point
    public void testPlayerOneWinsFirstBall()
    {
        game.scorePlayer1();
        String score = game.getScore();
        assertEquals("15,0", score);
        System.out.println(score);
    }

    //joueur 2 a gagné 1 point
    public void testFifteenAll(){
        game.scorePlayer1();
        game.scorePlayer2();
        String score = game.getScore();
        assertEquals("15 all", score);
        System.out.println(score);
    }

    //joueur 2 a gagné 2 point
    public void testPlayerTwoWinsFirstTwoBalls() {
        createScore(0, 2);
        String score = game.getScore();
        assertEquals("0,30", score);
        System.out.println(score);
    }

    //joueur 1 a gagné 3 point
    public void testPlayerOneWinsFirstThreeBalls(){
        createScore(3, 0);
        String score = game.getScore();
        assertEquals("40,0", score);
        System.out.println(score);
    }

    //Egalité des points
    public void testPlayersAreDeuce() {
        createScore(3, 3);
        String score = game.getScore();
        assertEquals("Deuce", score);
        System.out.println(score);
    }

    //joueur 1 a gagné le jeu
    public void testPlayerOneWinsGame()
    {
        createScore(4, 0);
        String score = game.getScore();
        assertEquals("Player 1 wins", score);
        System.out.println(score);
    }

    //joueur 2 a gagné le jeu
    public void testPlayerTwoWinsGame(){
        createScore(1,4);
        String score = game.getScore();
        assertEquals("Player 2 wins", score);
        System.out.println(score);
    }

    //Egalité des points
    public void testPlayersAreDuce4() {
        createScore(4, 4);
        String score = game.getScore();
        assertEquals("Deuce", score);
        System.out.println(score);
    }

    //joueur 2 a l'avantage
    public void testPlayerTwoAdvantage(){
        createScore(4, 5);
        String score = game.getScore();
        assertEquals("Advantage Player 2", score);
        System.out.println(score);
    }

    //joueur 1 a l'avantage
    public void testPlayerOneAdvantage(){
        createScore(5, 4);
        String score = game.getScore();
        assertEquals("Advantage Player 1", score);
        System.out.println(score);
    }

    //joueur 2 a gagné le jeu
    public void testPlayerTwoWins(){
        createScore(2, 4);
        String score = game.getScore();
        assertEquals("Player 2 wins", score);
        System.out.println(score);
    }

    //joueur 2 a gagné le jeu
    public void testPlayerTwoWinsAfterAdvantage() {
        createScore(6, 8);
        String score = game.getScore();
        assertEquals("Player 2 wins", score);
        System.out.println(score);
    }


    //joueur 1 a gagné le jeu
    public void testPlayerOneWinsAfterAdvantage() {
        createScore(8, 6);
        String score = game.getScore();
        assertEquals("Player 1 wins", score);
        System.out.println(score);
    }

    //permet d'afficher les différents points
    private void createScore(int pNombreBallesJoueurs1, int pNombreBallesJoueurs2 ) {
        for (int i = 0; i < pNombreBallesJoueurs1; i++) {
            game.scorePlayer1();
        }
        for (int i = 0; i < pNombreBallesJoueurs2; i++) {
            game.scorePlayer2();
        }
    }
}
