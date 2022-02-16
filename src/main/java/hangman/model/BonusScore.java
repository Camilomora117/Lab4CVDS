package hangman.model;

public class BonusScore implements GameScore{

    /**
     * @pre Entra el numero de aciertos y el numero de letras incorrectas
     * @pos Devuelve el puntaje final teniendo en cuenta las condiciones dadas
     * 
     * @param correctCount int Numero de letras correctas
     * @param incorrectCount int Numero de letras incorrectas
     * 
     */
	@Override
    public int calculateScore(int correctCount,int incorrectCount){
		int score = 0;
        int correct = 10 * correctCount;
        int penalty = 5 * incorrectCount;
        score += correct;
        score -= penalty;
        if (score < 0){
            score = 0;
        }
        return score;
    }
	
}