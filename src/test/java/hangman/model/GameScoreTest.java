package hangman.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 * CLASES DE EQUIVALENCIA
 * + Que los score tengan puntaje minimo de 0
 * OriginalScore:
 * + Es el esquema actual, se inicia con 100 puntos
 * + No se bonifican las letras correctas
 * + Se penaliza con 10 puntos con cada letra incorrecta
 * BonusScore:
 * + El juego inicia en 0 puntos
 * + Se bonifica con 10 puntos cada letra correcta
 * + Se penaliza con 5 puntos cada letra incorrecta
 * PowerBonusScore:
 * + El juego inicia en 0 puntos
 * + La $i-ésima$ letra correcta se bonifica con $5^i$
 * + Se penaliza con 8 puntos cada letra incorrecta
 * + Si con las reglas anteriores sobrepasa 500 puntos, el puntaje es 500
 * 
 * Condiciones de Frontera:
 * + No deben existir puntajes negativos
 */
public class GameScoreTest {

    OriginalScore originalScore = new OriginalScore();
    BonusScore bonusScore = new BonusScore();
    PowerScore powerScore = new PowerScore();

    @Test
    public void originalScoreMinimalIsZero(){
        int result = originalScore.calculateScore(0,11);
        assertEquals(0,result);
    }

    @Test
    public void bonusScoreMinimalIsZero(){
        int result = bonusScore.calculateScore(0,1);
        assertEquals(0,result);
    }

    @Test
    public void powerScoreMinimalIsZero(){
        int result = powerScore.calculateScore(0,1);
        assertEquals(0,result);
    }

    @Test
    public void originalScoreStartWithOneHounderedPoints() {
        int result = originalScore.calculateScore(0, 0);
        assertEquals(100,result);
    }

    @Test
    public void originalScoreDoesntAddPointsByCorrectLetters() {
        int result = originalScore.calculateScore(1, 0);
        assertEquals(100,result);
    }

    @Test
    public void originalScoreCorrectPenalization() {
        int result = originalScore.calculateScore(0, 1);
        assertEquals(90,result);
    }

    @Test
    public void bonusScoreMinimalStartWithZero(){
        int result = bonusScore.calculateScore(0,0);
        assertEquals(0,result);
    }

    @Test
    public void bonusScoreCorrectBonus(){
        int result = bonusScore.calculateScore(1,0);
        assertEquals(10,result);
    }

    @Test
    public void bonusScoreCorrectPenalization(){
        int result = bonusScore.calculateScore(1,1);
        assertEquals(5,result);
    }

    @Test
    public void powerScoreStartsWithZero(){
        int result = powerScore.calculateScore(0,0);
        assertEquals(0,result);
    }

    @Test
    public void powerScoreMinimalCorrectBonus(){
        int result = powerScore.calculateScore(1,0);
        assertEquals(5,result);
    }

    @Test
    public void powerScoreCorrectPenalization(){
        int result = powerScore.calculateScore(2,1);
        assertEquals(17,result);
    }

    @Test
    public void powerScoreLimitScore(){
        int result = powerScore.calculateScore(4,1);
        assertEquals(500,result);
    }

} 
