import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizGUI extends JFrame implements ActionListener {

    String playerName = "";
    int currentQuestion = 0;
    int score = 0;

    String[] questions = {
            "What is the capital of India?",
            "What is the capital of France?",
            "What is the capital of Rajasthan?",
            "What is the capital of Haryana?",
            "What is the capital of Punjab?",
            "What is the capital of Uttar Pradesh?",
            "What is the capital of Bihar?",
            "What is the capital of West Bengal?",
            "What is the capital of Nepal?",
            "What is the capital of Himachal Pradesh?"
    };

    String[][] options = {
            {"New Delhi", "Jaipur", "Chandigarh", "Haryana"},
            {"New Delhi", "Jaipur", "Paris", "Haryana"},
            {"New Delhi", "Jaipur", "Chandigarh", "Haryana"},
            {"New Delhi", "Jaipur", "Chandigarh", "Haryana"},
            {"New Delhi", "Jaipur", "Chandigarh", "Haryana"},
            {"New Delhi", "Lucknow", "Chandigarh", "Haryana"},
            {"New Delhi", "Jaipur", "Chandigarh", "Patna"},
            {"New Delhi", "Jaipur", "Kolkata", "Haryana"},
            {"Kathmandu", "Jaipur", "Chandigarh", "Haryana"},
            {"New Delhi", "Jaipur", "Chandigarh", "Shimla"}
    };

    String[] answers = {
            "New Delhi",
            "Paris",
            "Jaipur",
            "Chandigarh",
            "Chandigarh",
            "Lucknow",
            "Patna",
            "Kolkata",
            "Kathmandu",
            "Shimla"
    };

    JPanel startPanel;
    JPanel quizPanel;

    JTextField nameField;
    JButton startBtn;
    JButton nextBtn;

    JLabel titleLabel;
    JLabel questionLabel;

    JRadioButton optionA;
    JRadioButton optionB;
    JRadioButton optionC;
    JRadioButton optionD;

    ButtonGroup group;

    public QuizGUI() {

        setTitle("Quiz Challenge");
        setSize(700, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createStartScreen();

        setVisible(true);
    }

    void createStartScreen() {

        startPanel = new JPanel();
        startPanel.setLayout(null);
        startPanel.setBackground(new Color(245, 230, 238));

        JLabel smallTitle = new JLabel("Quiz Challenge");
        smallTitle.setBounds(260, 60, 200, 30);
        smallTitle.setFont(new Font("Arial", Font.BOLD, 24));

        titleLabel = new JLabel("ARE YOU A QUIZ MASTER?");
        titleLabel.setBounds(80, 140, 600, 50);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));

        JLabel intro = new JLabel("Test your knowledge and score high!");
        intro.setBounds(180, 220, 350, 30);
        intro.setFont(new Font("Arial", Font.PLAIN, 18));

        JLabel nameLabel = new JLabel("Enter Your Name");
        nameLabel.setBounds(250, 320, 200, 30);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 22));

        nameField = new JTextField();
        nameField.setBounds(150, 370, 380, 40);

        startBtn = new JButton("Start Quiz");
        startBtn.setBounds(240, 470, 200, 50);
        startBtn.setFont(new Font("Arial", Font.BOLD, 22));
        startBtn.addActionListener(this);

        startPanel.add(smallTitle);
        startPanel.add(titleLabel);
        startPanel.add(intro);
        startPanel.add(nameLabel);
        startPanel.add(nameField);
        startPanel.add(startBtn);

        add(startPanel);
    }

    void createQuizScreen() {

        remove(startPanel);

        quizPanel = new JPanel();
        quizPanel.setLayout(null);
        quizPanel.setBackground(Color.WHITE);

        questionLabel = new JLabel();
        questionLabel.setBounds(50, 60, 600, 50);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 22));

        optionA = new JRadioButton();
        optionB = new JRadioButton();
        optionC = new JRadioButton();
        optionD = new JRadioButton();

        optionA.setBounds(80, 160, 500, 30);
        optionB.setBounds(80, 220, 500, 30);
        optionC.setBounds(80, 280, 500, 30);
        optionD.setBounds(80, 340, 500, 30);

        optionA.setFont(new Font("Arial", Font.PLAIN, 18));
        optionB.setFont(new Font("Arial", Font.PLAIN, 18));
        optionC.setFont(new Font("Arial", Font.PLAIN, 18));
        optionD.setFont(new Font("Arial", Font.PLAIN, 18));

        group = new ButtonGroup();
        group.add(optionA);
        group.add(optionB);
        group.add(optionC);
        group.add(optionD);

        nextBtn = new JButton("Next");
        nextBtn.setBounds(260, 470, 150, 50);
        nextBtn.setFont(new Font("Arial", Font.BOLD, 20));
        nextBtn.addActionListener(this);

        quizPanel.add(questionLabel);
        quizPanel.add(optionA);
        quizPanel.add(optionB);
        quizPanel.add(optionC);
        quizPanel.add(optionD);
        quizPanel.add(nextBtn);

        add(quizPanel);

        loadQuestion();

        revalidate();
        repaint();
    }

    void loadQuestion() {

        questionLabel.setText(
                "Q" + (currentQuestion + 1) + ". " +
                        questions[currentQuestion]);

        optionA.setText(options[currentQuestion][0]);
        optionB.setText(options[currentQuestion][1]);
        optionC.setText(options[currentQuestion][2]);
        optionD.setText(options[currentQuestion][3]);

        group.clearSelection();
    }

    void checkAnswer() {

        String selected = "";

        if (optionA.isSelected())
            selected = optionA.getText();

        else if (optionB.isSelected())
            selected = optionB.getText();

        else if (optionC.isSelected())
            selected = optionC.getText();

        else if (optionD.isSelected())
            selected = optionD.getText();

        if (selected.equals(answers[currentQuestion])) {
            score++;
        }
    }

    void showResult() {

        int percentage = (score * 100) / questions.length;

        JOptionPane.showMessageDialog(
                this,
                "Name : " + playerName +
                        "\nScore : " + score + "/" + questions.length +
                        "\nPercentage : " + percentage + "%",
                "Quiz Result",
                JOptionPane.INFORMATION_MESSAGE
        );

        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == startBtn) {

            playerName = nameField.getText();

            if (playerName.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Please enter your name."
                );
                return;
            }

            createQuizScreen();
        }

        if (e.getSource() == nextBtn) {

            checkAnswer();

            currentQuestion++;

            if (currentQuestion < questions.length) {
                loadQuestion();
            } else {
                showResult();
            }
        }
    }

    public static void main(String[] args) {

        new QuizGUI();
    }
}