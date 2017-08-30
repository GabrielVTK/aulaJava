    
    public class Objective extends Question {

        private String options[];
        private int correctAnswer;
        
        public Objective() {
            this.options = new String[5];
        }

        public String[] getOptions() {
            return options;
        }

        public void setOptions(String[] options) {
            this.options = options;
        }

        public int getCorrectAnswer() {
            return correctAnswer;
        }

        public void setCorrectAnswer(int correctAnswer) {
            
            if(correctAnswer >= 1 && correctAnswer <= 5) {
                this.correctAnswer = correctAnswer - 1;
            } else {
                throw new Error("Valor de reposta inválido!");
            }
            
        }

        @Override
        public String getQuestionDetails() {
            
            String details = this.getQuestion() + " (" + this.getWeight() + ")\n";
            
            char[] letters = {'a', 'b', 'c', 'd', 'e'};
            
            for(int i = 0; i < 5; i++) {
                details += letters[i] + ") " + this.getOptions()[i] + "\n";
            }
            
            details += "Reposta Correta: " + letters[this.getCorrectAnswer()] + "\n";
            
            details += "\n";
            
            return details;
        }

    }
