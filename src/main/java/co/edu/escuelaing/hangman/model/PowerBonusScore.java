package co.edu.escuelaing.hangman.model;
import org.springframework.stereotype.Component;

@Component("powerBonusScore")
public class PowerBonusScore implements GameScore {

    /**
     * Calcula puntaje segun esquema de PowerBonusScore
     * 
     * @pre incorrectCount >= 0, correctCount >= 0.
     * @post Puntaje devuelto >= 0, Puntaje devuelto <= 500
     * @param correctCount numero de letras correctas.
     * @param incorrectCount numero de letras incorrectas.
     * @return puntaje despues de la penalizacion (8 puntos por letra incorreta) y bonificacion (5^i puntos por letra correcta).
     * @throws IllegalArgumentExcepton si se tienen parametros negativos.
     */
    public int calculateScore(int correctCount, int incorrectCount) {
        // Verifica que los parámetros sean válidos
        if (correctCount < 0 || incorrectCount < 0) throw new IllegalArgumentException("Los parámetros no pueden ser negativos.");
        int score = 0;
        for (int i = 1 ; i <= correctCount; i++){
            score += Math.pow(5, i);
        }
        score -= 8 * incorrectCount;
        if (score <= 0 ) return 0;
        else if (score >= 500) return  500;
        return score;
        
    }
    
}
