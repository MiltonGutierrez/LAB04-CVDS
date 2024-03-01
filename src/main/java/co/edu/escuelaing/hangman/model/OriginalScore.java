package co.edu.escuelaing.hangman.model;
import org.springframework.stereotype.Component;

@Component("originalScore")
public class OriginalScore implements GameScore {

    /**
     * Calcula el puntaje segun esquema de OriginalScore.
     * 
     * @pre incorrectCount >= 0, correctCount >= 0.
     * @post Puntaje devuelto >= 0, Puntaje devuelto <= 100
     * @param correctCount numero de letras correctas.
     * @param incorrectCount numero de letras incorrectas.
     * @return puntaje aplicando la penalizacion de 10 puntos por cada letra incorrecta.
     * @throws IllegalArgumentExcepton si se tienen parametros negativos.
     */
    public int calculateScore(int correctCount, int incorrectCount) {
        // Verifica que los parámetros sean válidos
        if (correctCount < 0 || incorrectCount < 0) {
            throw new IllegalArgumentException("Los parámetros no pueden ser negativos.");
        }

        // Calcula el puntaje
        int score = 100 - (incorrectCount * 10);
        // Si el puntaje es negativo, lo establece en cero
        return Math.max(0, score);
    }
    
}