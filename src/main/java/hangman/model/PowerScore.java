package hangman.model;


public class PowerScore implements GameScore{
    /**
     * @pre Entra el numero de aciertos y el numero de letras incorrectas
     * @pos Devuelve el puntaje final teniendo en cuenta las condiciones
     * 
     * @param correctCount int Numero de letras correctas
     * @param incorrectCount int Numero de letras incorrectas
     * 
     */
    public int calculateScore(int correctCount,int incorrectCount){
        int score = 0;
        for (int i = 1; i<= correctCount;i++){
            score  += Math.pow(5, i);
        }
        score -= incorrectCount*8;
		
        if (score < (double)0){
            score = 0;
        }
		
		if (score > (double)500){
            score = 500;
        }
        return score;
    }

}