package co.edu.escuelaing.hangman.model;
import org.springframework.stereotype.Component;

@Component("bonusScore")
public class BonusScore implements GameScore {
    
    private int totalScore;

    public BonusScore() {
        this.totalScore = 0;
    }

    /**
     * Calcula puntaje segun esquema de BonusScore.
     * 
     * @pre incorrectCount >= 0, correctCount >= 0.
     * @post Puntaje devuelto >= 0.
     * @param correctCount numero de letras correctas.
     * @param incorrectCount numero de letras incorrectas.
     * @return puntaje despues de la penalizacion (5 puntos por letra incorrecta) y bonificacion (10 puntos por letra correcta).
     * @throws IllegalArgumentException si se tienen parametros negativos.
     */

    public int calculateScore(int correctCount, int incorrectCount) {
        // Verifica que los parámetros sean válidos
        if (correctCount < 0 || incorrectCount < 0) throw new IllegalArgumentException("Los parámetros no pueden ser negativos.");
        // Calcula el puntaje
        int score = (correctCount * 10) - (incorrectCount * 5);
        // Si el puntaje es negativo, lo establece en cero
        return Math.max(0, score);
    }
    
}