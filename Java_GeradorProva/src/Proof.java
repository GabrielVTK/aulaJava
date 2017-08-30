
import java.util.ArrayList;


    public class Proof {

        private String discipline;
        private int weight;
        private String place;
        private String date;
        private ArrayList<Question> questions;

        public Proof(String discipline, int weight, String place, String date) {
            this.discipline = discipline;
            this.weight = weight;
            this.place = place;
            this.date = date;
            this.questions = new ArrayList();
        }

        public String getDetails() {

            String details = "";

            details += "Disciplina: " + this.discipline + "\n";
            details += "Peso: " + this.weight + "\n";
            details += "Local: " + this.place + "\n";
            details += "Data: " + this.date + "\n";
            
            int numberQuestion = 1;
            
            /**/
            for(Question question : this.getQuestions()) {

                details += numberQuestion + ". " + question.getQuestionDetails();

                numberQuestion++;
                
            }
            /**/
            
            return details;
        }

        public String getDiscipline() {
            return discipline;
        }

        public void setDiscipline(String discipline) {
            this.discipline = discipline;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getPlace() {
            return place;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public ArrayList<Question> getQuestions() {
            return questions;
        }

        public void addQuestion(Question question) {
            this.questions.add(question);
        }
        
    }
