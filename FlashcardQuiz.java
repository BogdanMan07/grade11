import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
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
        setLayout(new GridLayout(3, 1, 10, 10));

        JButton createBtn = new JButton("Create Flashcards");
        JButton quizBtn = new JButton("Start Quiz");
        JButton exitBtn = new JButton("Exit");

        createBtn.addActionListener(e -> app.switchTo("Create"));
        quizBtn.addActionListener(e -> app.switchTo("Quiz"));
        exitBtn.addActionListener(e -> System.exit(0));

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

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        questionField = new JTextField();
        answerField = new JTextField();
        inputPanel.add(new JLabel("Question:"));
        inputPanel.add(questionField);
        inputPanel.add(new JLabel("Answer:"));
        inputPanel.add(answerField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add Card");
        JButton updateButton = new JButton("Update Selected");
        JButton deleteButton = new JButton("Delete Selected");
        JButton backButton = new JButton("Back to Menu");

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(backButton);

        listModel = new DefaultListModel<>();
        flashcardList = new JList<>(listModel);
        JScrollPane listScrollPane = new JScrollPane(flashcardList);
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
