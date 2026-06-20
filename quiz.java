import java.util.Scanner;
public class quiz{
    public static void main(String[] args){
        System.out.println("------------QUIZZZZZZZZZZZ---------------");
        Scanner sc=new Scanner(System.in);
        int score=0;

        String[] questions={
            "Que 1: What is capital of india? \n A. New Delhi\n B. Jaipur \n C.Chandigarh\n D.Haryana",
            "Que 2: What is capital of France? \n A. New Delhi\n B. Jaipur \n C.Paris\n D.Haryana",
            "Que 3: What is capital of Rajasthan? \n A. New Delhi\n B. Jaipur \n C.Chandigarh\n D.Haryana",
            "Que 4: What is capital of Haryana? \n A. New Delhi\n B. Jaipur \n C.Chandigarh\n D.Haryana",
            "Que 5: What is capital of Punjab? \n A. New Delhi\n B. Jaipur \n C.Chandigarh\n D.Haryana",
            "Que 6: What is capital of Uttar Pradesh? \n A. New Delhi\n B. Lucknow \n C.Chandigarh\n D.Haryana",
            "Que 7: What is capital of Bihar? \n A. New Delhi\n B. Jaipur \n C.Chandigarh\n D.Patna",
            "Que 8: What is capital of West Benagl? \n A. New Delhi\n B. Jaipur \n C.Kolkata\n D.Haryana",
            "Que 9: What is capital of Nepal? \n A. Katamandu\n B. Jaipur \n C.Chandigarh\n D.Haryana",
            "Que 10: What is capital of Himachal? \n A. New Delhi\n B. Jaipur \n C.Chandigarh\n D.Shimla"
        };
        String[] answers={"A","C","B","C","C","B","D","C","A","D"};

        for(int i=0;i<questions.length;i++){
            System.out.println(questions[i]);
            System.out.println("Enter your ansewer: ");
            String yourAnswer=sc.next();
            if(yourAnswer.equalsIgnoreCase(answers[i])){
                System.out.println("Correct!");
                score++;
            }
            else{
                System.out.println("WRONG!");
            }
        }
        int percentage=(score/100)*100;
        System.out.println("Final Score: "+score);
        System.out.println("Percentage you got: "+percentage);
    }
}