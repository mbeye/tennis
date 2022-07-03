package tennis;

import junit.framework.TestCase;
public class JeuxDeTennisTest extends TestCase {
    JeuxDeTennis game = new JeuxDeTennis("Player 1" , "Player 2");

    public void testNewGameShouldReturnZeroAll()
    {
        String score = game.getScore();
        assertEquals("0 all", score);
        System.out.println(score);
    }

    public void testPlayerOneWinsFirstBall()
    {
        game.scorePlayer1();
        String score = game.getScore();
        assertEquals("15,0", score);
        System.out.println(score);
    }

    public void testFifteenAll(){
        game.scorePlayer1();
        game.scorePlayer2();
        String score = game.getScore();
        assertEquals("15 all", score);
        System.out.println(score);
    }

    public void testPlayerTwoWinsFirstTwoBalls() {
        createScore(0, 2);
        String score = game.getScore();
        assertEquals("0,30", score);
        System.out.println(score);
    }


    public void testPlayerOneWinsFirstThreeBalls(){
        createScore(3, 0);
        String score = game.getScore();
        assertEquals("40,0", score);
        System.out.println(score);
    }

    public void testPlayersAreDeuce() {
        createScore(3, 3);
        String score = game.getScore();
        assertEquals("Deuce", score);
        System.out.println(score);
    }

    public void testPlayerOneWinsGame()
    {
        createScore(4, 0);
        String score = game.getScore();
        assertEquals("Player 1 wins", score);
        System.out.println(score);
    }

    public void testPlayerTwoWinsGame(){
        createScore(1,4);
        String score = game.getScore();
        assertEquals("Player 2 wins", score);
        System.out.println(score);
    }

    public void testPlayersAreDuce4() {
        createScore(4, 4);
        String score = game.getScore();
        assertEquals("Deuce", score);
        System.out.println(score);
    }

    public void testPlayerTwoAdvantage(){
        createScore(4, 5);
        String score = game.getScore();
        assertEquals("Advantage Player 2", score);
        System.out.println(score);
    }

    public void testPlayerOneAdvantage(){
        createScore(5, 4);
        String score = game.getScore();
        assertEquals("Advantage Player 1", score);
        System.out.println(score);
    }

    public void testPlayerTwoWins(){
        createScore(2, 4);
        String score = game.getScore();
        assertEquals("Player 2 wins", score);
        System.out.println(score);
    }


    public void testPlayerTwoWinsAfterAdvantage() {
        createScore(6, 8);
        String score = game.getScore();
        assertEquals("Player 2 wins", score);
        System.out.println(score);
    }



    public void testPlayerOneWinsAfterAdvantage() {
        createScore(8, 6);
        String score = game.getScore();
        assertEquals("Player 1 wins", score);
        System.out.println(score);
    }

    private void createScore(int pNombreBallesJoueurs1, int pNombreBallesJoueurs2 ) {
        for (int i = 0; i < pNombreBallesJoueurs1; i++) {
            game.scorePlayer1();
        }
        for (int i = 0; i < pNombreBallesJoueurs2; i++) {
            game.scorePlayer2();
        }
    }
}
