
import javax.swing.JOptionPane;

    public class GeradorProva {

        public static void main(String args[]) {

            JOptionPane.showMessageDialog(null, "Gerador de provas");
            
            Proof p1 = new Proof(
                    JOptionPane.showInputDialog(null, "Digite o nome da disciplina"),
                    Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o peso da prova")),
                    JOptionPane.showInputDialog(null, "Digite o local da prova"),
                    JOptionPane.showInputDialog(null, "Digite a data da prova")
            );
            
            Object[] options = {"Questão Discursiva", "Questão Objetiva", "Sair"};
            String questionOptions[] = null;
            
            while(true) {
                
                int opcao = JOptionPane.showOptionDialog(
                        null, "Selecione uma opção", "Opções", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE, null, options, options[2]);
                
                // Discursiva
                if(opcao == 0) {
                    Discursive question = new Discursive();
                    
                    question.setQuestion(JOptionPane.showInputDialog(null, "Digite a pergunta"));
                    question.setWeight(Float.parseFloat(JOptionPane.showInputDialog(null, "Digite o peso da questão")));
                    question.setCriteria(JOptionPane.showInputDialog(null, "Digite o critério de avaliação"));
                    
                    p1.addQuestion(question);
                    
                // Objetiva
                } else if(opcao == 1) {

                    Objective question = new Objective();
                    
                    question.setQuestion(JOptionPane.showInputDialog(null, "Digite a pergunta"));
                    question.setWeight(Float.parseFloat(JOptionPane.showInputDialog(null, "Digite o peso da questão")));
                    
                    questionOptions = new String[5];
                    
                    for(int i = 0; i < 5; i++) {
                        questionOptions[i] = JOptionPane.showInputDialog(null, "Digite a " + (i + 1) + "ª opção");
                    }
                    
                    question.setOptions(questionOptions);
                    
                    p1.addQuestion(question);
                    
                //Sair
                } else {
                    break;
                }
                
            }
            
            System.out.println(p1.getDetails());

        }

    }