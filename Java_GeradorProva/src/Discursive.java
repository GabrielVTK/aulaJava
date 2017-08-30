

    public class Discursive extends Question {

        private String criteria;

        public String getCriteria() {
            return criteria;
        }

        public void setCriteria(String criteria) {
            this.criteria = criteria;
        }

        @Override
        public String getQuestionDetails() {
           
            String details = this.getQuestion() + " (" + this.getWeight() + ")\n";
            
            details += "Critérios de Avaliação: " + this.getCriteria() + "\n";
            
            details += "\n";
            
            return details;
        }

    }