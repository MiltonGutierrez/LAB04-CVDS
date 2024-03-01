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
        return 0;
    }
    
}
