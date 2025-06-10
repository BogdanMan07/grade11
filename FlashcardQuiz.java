import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlashCardQuiz{
    public static void main(String[] args){
    }
}
class Flashcard {
    public String question;
    public String answer;

    public Flashcard(String q, String a) {
        question = q;
        answer = a;
    }
}

class FlashcardManager {
    public ArrayList<Flashcard> cards = new ArrayList<>();

    public void add(Flashcard f) { cards.add(f); }
    public ArrayList<Flashcard> getAll() { return cards; }
    public void delete(int index) { cards.remove(index); }
    public void update(int index, Flashcard f) { cards.set(index, f); }
}

public class FlashcardApp extends JFrame {
    CardLayout layout;
    JPanel flashcard;

    public FlashcardApp() {
        layout = new CardLayout();
        flashcard = new JPanel(layout);

        flashcard.add(new MainMenuPanel(this), "MainMenu");
        flashcard.add(new CreatePanel(), "Create");
        flashcard.add(new QuizPanel(), "Quiz");

        add(flashcard);
        setTitle("Flashcard Quiz App");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void switchTo(String name) {
        layout.show(flashcard, name);
    }

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
