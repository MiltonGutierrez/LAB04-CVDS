package co.edu.escuelaing.hangman.model;

/**
 * Interfaz para el puntaje del Juego
 */
public interface GameScore {
    int calculateScore(int correctCount, int incorrectCount);
}
