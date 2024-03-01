
package co.edu.escuelaing.hangman.model;
import org.springframework.stereotype.Component;

@Component("bonusScore")
public class BonusScore implements GameScore {
    /**
     * Calcula puntaje segun esquema de BonusScore.
     * 
     * @pre incorrectCount >= 0, correctCount >= 0..
     * @post Puntaje devuelto >= 0.
     * @param correctCount numero de letras correctas.
     * @param incorrectCount numero de letras incorrectas.
     * @return puntaje despues de la penalizacion (5 puntos por letra incorreta) y bonificacion (10 puntos por letra correcta).
     * @throws IllegalArgumentExcepton si se tienen parametros negativos.
     */
    public int calculateScore(int correctCount, int incorrectCount) {
        return 0;
    }
    
}
