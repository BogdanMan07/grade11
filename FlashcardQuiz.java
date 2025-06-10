import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FlashCardQuiz {
    public static void main(String[] args) {
        new FlashcardApp();
    }
}

class Flashcard {
    private String question;
    private String answer;

    public Flashcard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

class FlashcardManager {
    private ArrayList<Flashcard> cards;

    public FlashcardManager() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Flashcard card) {
        cards.add(card);
    }

    public void deleteCard(int index) {
        if (index >= 0 && index < cards.size()) {
            cards.remove(index);
        }
    }

    public void updateCard(int index, Flashcard card) {
        if (index >= 0 && index < cards.size()) {
            cards.set(index, card);
        }
    }

    public ArrayList<Flashcard> getAllCards() {
        return cards;
    }
}

class FlashcardApp extends JFrame {
    private CardLayout layout;
    private JPanel mainPanel;
    private FlashcardManager manager;

    public FlashcardApp() {
        manager = new FlashcardManager();
        layout = new CardLayout();
        mainPanel = new JPanel(layout);

        mainPanel.add(new MainMenuPanel(this), "MainMenu");
        mainPanel.add(new CreatePanel(manager, this), "Create");
        mainPanel.add(new QuizPanel(manager, this), "Quiz");

        add(mainPanel);
        setTitle("Flashcard Quiz App");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void switchTo(String name) {
        if (name.equals("Quiz")) {
            mainPanel.remove(2);
            mainPanel.add(new QuizPanel(manager, this), "Quiz");
        }
        layout.show(mainPanel, name);
    }
}

class MainMenuPanel extends JPanel {
    public MainMenuPanel(FlashcardApp app) {

        setLayout(new GridLayout(4, 1, 10, 10));
        setBackground(new Color(240, 248, 255));
        setBorder(BorderFactory.createEmptyBorder(40, 100, 40, 100));

        JLabel imageLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images (1).png"));
        Image scaledImage = imageIcon.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledImage));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton createBtn = new JButton("Create Flashcards");
        JButton quizBtn = new JButton("Start Quiz");
        JButton exitBtn = new JButton("Exit");

        createBtn.setBackground(new Color(12, 238, 144));
        quizBtn.setBackground(new Color(17, 216, 230));
        exitBtn.setBackground(new Color(255, 100, 122));

        createBtn.addActionListener(e -> app.switchTo("Create"));
        quizBtn.addActionListener(e -> app.switchTo("Quiz"));
        exitBtn.addActionListener(e -> System.exit(0));

        add(imageLabel);
        add(createBtn);
        add(quizBtn);
        add(exitBtn);
    }
}

class CreatePanel extends JPanel {
    private FlashcardManager manager;
    private DefaultListModel<String> listModel;
    private JList<String> flashcardList;
    private JTextField questionField;
    private JTextField answerField;

    public CreatePanel(FlashcardManager manager, FlashcardApp app) {
        this.manager = manager;
        setLayout(new BorderLayout());
        setBackground(new Color(250, 250, 240));

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        inputPanel.setBackground(new Color(250, 250, 240));
        questionField = new JTextField();
        answerField = new JTextField();
        inputPanel.add(new JLabel("Question:"));
        inputPanel.add(questionField);
        inputPanel.add(new JLabel("Answer:"));
        inputPanel.add(answerField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.setBackground(new Color(250, 250, 240));
        JButton addButton = new JButton("Add Card");
        JButton updateButton = new JButton("Update Selected");
        JButton deleteButton = new JButton("Delete Selected");
        JButton backButton = new JButton("Back to Menu");

        addButton.setBackground(new Color(12, 238, 144));
        updateButton.setBackground(new Color(17, 216, 230));
        deleteButton.setBackground(new Color(255, 100, 122));
        backButton.setBackground(new Color(211, 211, 211));

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(backButton);

        listModel = new DefaultListModel<>();
        flashcardList = new JList<>(listModel);
        JScrollPane listScrollPane = new JScrollPane(flashcardList);
        listScrollPane.setBorder(BorderFactory.createTitledBorder("Flashcards"));
        refreshCardList();

        flashcardList.addListSelectionListener(e -> {
            int selected = flashcardList.getSelectedIndex();
            if (selected >= 0) {
                Flashcard card = manager.getAllCards().get(selected);
                questionField.setText(card.getQuestion());
                answerField.setText(card.getAnswer());
            }
        });

        addButton.addActionListener(e -> {
            String q = questionField.getText().trim();
            String a = answerField.getText().trim();
            if (!q.isEmpty() && !a.isEmpty()) {
                manager.addCard(new Flashcard(q, a));
                refreshCardList();
                questionField.setText("");
                answerField.setText("");
                JOptionPane.showMessageDialog(this, "Flashcard added!");
            }
        });

        deleteButton.addActionListener(e -> {
            int selected = flashcardList.getSelectedIndex();
            if (selected >= 0) {
                manager.deleteCard(selected);
                refreshCardList();
                questionField.setText("");
                answerField.setText("");
                JOptionPane.showMessageDialog(this, "Flashcard deleted!");
            }
        });

        updateButton.addActionListener(e -> {
            int selected = flashcardList.getSelectedIndex();
            String q = questionField.getText().trim();
            String a = answerField.getText().trim();
            if (selected >= 0 && !q.isEmpty() && !a.isEmpty()) {
                manager.updateCard(selected, new Flashcard(q, a));
                refreshCardList();
                questionField.setText("");
                answerField.setText("");
                JOptionPane.showMessageDialog(this, "Flashcard updated!");
            }
        });

        backButton.addActionListener(e -> app.switchTo("MainMenu"));

        add(inputPanel, BorderLayout.NORTH);
        add(listScrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void refreshCardList() {
        listModel.clear();
        for (Flashcard card : manager.getAllCards()) {
            listModel.addElement(card.getQuestion() + " - " + card.getAnswer());
        }
    }
}

class QuizPanel extends JPanel {
    private int currentIndex = 0;
    private int score = 0;
    private JLabel questionLabel;
    private JTextField answerField;
    private JButton submitBtn;
    private FlashcardManager manager;
    private FlashcardApp app;

    public QuizPanel(FlashcardManager manager, FlashcardApp app) {
        this.manager = manager;
        this.app = app;
        setLayout(new BorderLayout());
        setBackground(new Color(245, 245, 245));

        questionLabel = new JLabel("Question will appear here", JLabel.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        answerField = new JTextField();
        submitBtn = new JButton("Submit Answer");
        JButton backButton = new JButton("Back to Menu");

        submitBtn.setBackground(new Color(12, 238, 144));
        backButton.setBackground(new Color(211, 211, 211));

        submitBtn.addActionListener(e -> {
            try {
                if (currentIndex < manager.getAllCards().size()) {
                    Flashcard current = manager.getAllCards().get(currentIndex);
                    String userAnswer = answerField.getText().trim();
                    if (userAnswer.equalsIgnoreCase(current.getAnswer().trim())) {
                        score++;
                    }
                    currentIndex++;
                    answerField.setText("");
                    loadNextQuestion();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error during quiz: " + ex.getMessage());
            }
        });

        backButton.addActionListener(e -> {
            currentIndex = 0;
            score = 0;
            answerField.setText("");
            app.switchTo("MainMenu");
        });

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(245, 245, 245));
        topPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        topPanel.add(questionLabel, BorderLayout.CENTER);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(new Color(245, 245, 245));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        centerPanel.add(answerField, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        bottomPanel.setBackground(new Color(245, 245, 245));
        bottomPanel.add(submitBtn);
        bottomPanel.add(backButton);

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        loadNextQuestion();
    }

    private void loadNextQuestion() {
        if (currentIndex < manager.getAllCards().size()) {
            Flashcard card = manager.getAllCards().get(currentIndex);
            questionLabel.setText("Q" + (currentIndex + 1) + ": " + card.getQuestion());
        } else {
            JOptionPane.showMessageDialog(this,
                    "Quiz Finished!\nScore: " + score + "/" + manager.getAllCards().size(),
                    "Quiz Completed",
                    JOptionPane.INFORMATION_MESSAGE);
            currentIndex = 0;
            score = 0;
            app.switchTo("MainMenu");
        }
    }
}
