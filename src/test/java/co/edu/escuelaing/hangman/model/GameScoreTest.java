package co.edu.escuelaing.hangman.model;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertEquals;


public class GameScoreTest {

    /*
    OriginalScore Test
    Clases de equivalencia:
    1. En el inicio del juego el puntaje debe iniciar en 100.
    2. No importa el numero de las letras correctas (mayor o igual a cero) no se otorga bonificacion.
    3. Por cada letra incorrecta se tiene una penalizacion de 10 puntos.
    4. El puntaje minimo es de 0.
    5. No puede haber un numero de palabras incorrectas (incorrectCount) o alabras correctas (correctCount) negativas.
     */
    @Test
    void originalScoreTestShouldStartAt100ScorePoints(){
        //Given
        OriginalScore originalScore = new OriginalScore();
        int correctCount = 0;
        int incorrectCount = 0;
        //When
        int score = originalScore.calculateScore(correctCount, incorrectCount);
        //Then
        assertEquals(100, score);
    }
    @Test
    void originalScoreTestShouldNotGiveBonificationWithAnyCorrectGuess(){
        //Given
        OriginalScore originalScore = new OriginalScore();
        int correctCount = 0;
        int incorrectCount = 0;
        int correctCount2 = 1;
        int correctCount3 = 10;
        int correctCount4 = 1000;
        //When
        int score = originalScore.calculateScore(correctCount, incorrectCount);
        int score2 = originalScore.calculateScore(correctCount2, incorrectCount);
        int score3 = originalScore.calculateScore(correctCount3, incorrectCount);
        int score4 = originalScore.calculateScore(correctCount4, incorrectCount);

        //Then
        assertEquals(100, score);
        assertEquals(100, score2);
        assertEquals(100, score3);
        assertEquals(100, score4);
    }

    @Test
    void originalScoreTestShouldGivePenalizationOfTenPointsForEachIncorrectGuess(){
        //Given
        OriginalScore originalScore = new OriginalScore();
        int correctCount = 0;
        int incorrectCount = 1;
        int incorrectCount2 = 2;
        int incorrectCount3 = 3;
        //When
        int score = originalScore.calculateScore(correctCount, incorrectCount);
        int score2 = originalScore.calculateScore(correctCount, incorrectCount2);
        int score3 = originalScore.calculateScore(correctCount, incorrectCount3);

        //Then
        assertEquals(90, score);
        assertEquals(70, score2);
        assertEquals(40, score3);
    }

    @Test
    void originalScoreTestShouldHaveAMinimumScoreOf0(){
        //Given
        OriginalScore originalScore = new OriginalScore();
        int correctCount = 0;
        int incorrectCount = 10;
        int incorrectCount2 = 2;
        int incorrectCount3 = 3;
        //When
        int score = originalScore.calculateScore(correctCount, incorrectCount);
        int score2 = originalScore.calculateScore(correctCount, incorrectCount2);
        int score3 = originalScore.calculateScore(correctCount, incorrectCount3);

        //Then
        assertEquals(0, score);
        assertEquals(0, score2);
        assertEquals(0, score3);
    }

    @Test
    void originalScoreTestShouldNotAllowANegativeNumberOfIncorrectCount(){
        //Given
        OriginalScore originalScore = new OriginalScore();
        int correctCount = -1;
        int incorrectCount = 0;
        
        int correctCount2 = 0;
        int incorrectCount2 = -1;

        int correctCount3 = -1;
        int incorrectCount3 = -1;
        //When y Assert
        assertThrows(IllegalArgumentException.class, () -> originalScore.calculateScore(correctCount, incorrectCount));
        assertThrows(IllegalArgumentException.class, () -> originalScore.calculateScore(correctCount2, incorrectCount2));
        assertThrows(IllegalArgumentException.class, () -> originalScore.calculateScore(correctCount3, incorrectCount3));
    }

    /*
    Bonus Score Test
    Clases de equivalencia:
    1. El puntaje inicial debe ser 0 puntos.
    2. Se bonifica por cada letra con 10 puntos.
    3. Cada letra incorrecta tiene una penalizacion de 5 puntos.
    4. El puntaje minimo es de 0 puntos
    5. No puede haber un numero de palabras incorrectas (incorrectCount) o alabras correctas (correctCount) negativas.
     */
    @Test
    void bonusScoreTestShouldStartAt0ScorePoints(){
        //Given
        BonusScore bonusScore = new BonusScore();
        int correctCount = 0;
        int incorrrectCount = 0;
        //When
        int score = bonusScore.calculateScore(correctCount, incorrrectCount);
        //Then  
        assertEquals(0, score);
    }

    @Test
    void bonusScoreTestShouldBonusAnyCorrectScorePoint(){
        //Given
        BonusScore bonusScore = new BonusScore();
        int correctCount = 1;
        int correctCount2 = 2;
        int correctCount3 = 3;
        int incorrrectCount = 0;
        //When
        int score = bonusScore.calculateScore(correctCount, incorrrectCount);
        int score2 = bonusScore.calculateScore(correctCount2, incorrrectCount);
        int score3 = bonusScore.calculateScore(correctCount3, incorrrectCount);
        //Then
        assertEquals(10, score);
        assertEquals(30, score);
        assertEquals(60, score);
    }

    @Test
    void bonusScoreTestShouldDiscountAnyIncorrectScorePoint(){
        //Given
        BonusScore bonusScore = new BonusScore();
        int incorrrectCount = 1;
        int incorrrectCount2 = 2;
        int incorrrectCount3 = 3;
        int correctCount = 3;
        //When
        int score = bonusScore.calculateScore(correctCount, incorrrectCount);
        int score2 = bonusScore.calculateScore(0, incorrrectCount2);
        int score3 = bonusScore.calculateScore(0, incorrrectCount3);
        //Then
        assertEquals(25, score);
        assertEquals(15, score);
        assertEquals(0, score);
    }

    @Test
    void bonusScoreTestShouldHaveAMinimumScoreOf0(){
        //Given
        BonusScore bonusScore = new BonusScore();
        int correctCount = 0;
        int incorrectCount = 10;
        int incorrectCount2 = 2;
        int incorrectCount3 = 3;
        //When
        int score = bonusScore.calculateScore(correctCount, incorrectCount);
        int score2 = bonusScore.calculateScore(correctCount, incorrectCount2);
        int score3 = bonusScore.calculateScore(correctCount, incorrectCount3);

        //Then
        assertEquals(0, score);
        assertEquals(0, score2);
        assertEquals(0, score3);
    }

    @Test
    void bonusScoreTestShouldNotAllowANegativeNumberOfIncorrectCount(){
        //Given
        BonusScore bonusScore = new BonusScore();
        int correctCount = -1;
        int incorrectCount = 0;
        
        int correctCount2 = 0;
        int incorrectCount2 = -1;

        int correctCount3 = -1;
        int incorrectCount3 = -1;
        //When y Assert
        assertThrows(IllegalArgumentException.class, () -> bonusScore.calculateScore(correctCount, incorrectCount));
        assertThrows(IllegalArgumentException.class, () -> bonusScore.calculateScore(correctCount2, incorrectCount2));
        assertThrows(IllegalArgumentException.class, () -> bonusScore.calculateScore(correctCount3, incorrectCount3));
    }

    /*
    PowerBonusScore 
    Clases de equivalencia:
    1. El puntaje inicial debe ser 0 puntos.
    2. Se bonifica por cada letra segun su posicion i otorgando 5^i puntos
    3. Cada letra incorrecta tiene una penalizacion de 8 puntos.
    4. El puntaje minimo es de 0 puntos
    5. El puntaje maximo es de 500 puntos.
    6. No puede haber un numero de palabras incorrectas (incorrectCount) o alabras correctas (correctCount) negativas.
     */
    @Test
    void powerBonusScoreTestShouldStartAt0ScorePoints(){
        //Given
        PowerBonusScore powerBonusScore = new PowerBonusScore();
        int correctCount = 0;
        int incorrrectCount = 0;
        //When
        int score = powerBonusScore.calculateScore(correctCount, incorrrectCount);
        //Then  
        assertEquals(0, score);
    }

    @Test
    void powerBonusScoreTestShouldDiscountAnyIncorrectScorePoint(){
        //Given
        PowerBonusScore powerBonusScore = new PowerBonusScore();
        int correctCount = 1;
        int incorrrectCount = 0;

        int correctCount2 = 2;
        int incorrrectCount2 = 1;

        int correctCount3 = 3;
        int incorrrectCount3 = 4;
        
        //When
        int score = powerBonusScore.calculateScore(correctCount, incorrrectCount);
        int score2 = powerBonusScore.calculateScore(correctCount2, incorrrectCount2);
        int score3 = powerBonusScore.calculateScore(correctCount3, incorrrectCount3);
        //Then
        assertEquals(5, score);
        assertEquals(22, score);
        assertEquals(115, score);
    }

    @Test
    void powerBonusScoreTestShouldBonusAnyCorrectScorePoint(){
        //Given
        PowerBonusScore powerBonusScore = new PowerBonusScore();
        int correctCount = 1;
        int correctCount2 = 2;
        int correctCount3 = 3;
        int incorrrectCount = 0;
        //When
        int score = powerBonusScore.calculateScore(correctCount, incorrrectCount);
        int score2 = powerBonusScore.calculateScore(correctCount2, incorrrectCount);
        int score3 = powerBonusScore.calculateScore(correctCount3, incorrrectCount);
        //Then
        assertEquals(5, score);
        assertEquals(30, score);
        assertEquals(155, score);
    }

    @Test
    void pwerBonusScoreTestShouldHaveAMinimumScoreOf0(){
        //Given
        PowerBonusScore powerBonusScore = new PowerBonusScore();
        int correctCount = 2;
        int incorrectCount = 3;
        int incorrectCount2 = 1;
        int incorrectCount3 = 1;
        //When
        int score = powerBonusScore.calculateScore(correctCount, incorrectCount);
        int score2 = powerBonusScore.calculateScore(0, incorrectCount2);
        int score3 = powerBonusScore.calculateScore(0, incorrectCount3);

        //Then
        assertEquals(22, score);
        assertEquals(0, score2);
        assertEquals(0, score3);
    }

    @Test
    void powerBonusScoreTestShouldHaveAMaximumScoreOf500(){
        //Given
        PowerBonusScore powerBonusScore = new PowerBonusScore();
        int incorrectCount = 0;
        int correctCount = 4; // Da una valor de 750 
        int correctCount2 = 1;
        int correctCount3 = 1;
        //When
        int score = powerBonusScore.calculateScore(correctCount, incorrectCount);
        int score2 = powerBonusScore.calculateScore(correctCount2, incorrectCount);
        int score3 = powerBonusScore.calculateScore(correctCount3, incorrectCount);

        //Then
        assertEquals(500, score);
        assertEquals(500, score2);
        assertEquals(500, score3);
    }

    @Test
    void powerBonusScoreTestShouldNotAllowANegativeNumberOfIncorrectCount(){
        //Given
        PowerBonusScore powerBonusScore = new PowerBonusScore();
        int correctCount = -1;
        int incorrectCount = 0;
        
        int correctCount2 = 0;
        int incorrectCount2 = -1;

        int correctCount3 = -1;
        int incorrectCount3 = -1;
        //When y Assert
        assertThrows(IllegalArgumentException.class, () -> powerBonusScore.calculateScore(correctCount, incorrectCount));
        assertThrows(IllegalArgumentException.class, () -> powerBonusScore.calculateScore(correctCount2, incorrectCount2));
        assertThrows(IllegalArgumentException.class, () -> powerBonusScore.calculateScore(correctCount3, incorrectCount3));
    }
}
