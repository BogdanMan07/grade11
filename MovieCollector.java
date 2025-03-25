import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Movie {
    private String title;
    private String genre;

    public Movie(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }
}

class TitleComparator implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {
        return m1.getTitle().compareTo(m2.getTitle());
    }
}

class GenreComparator implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {
        return m1.getGenre().compareTo(m2.getGenre());
    }
}

public class MovieCollector {
    private JFrame frame;
    private JTextField titleField;
    private JTextField searchField;
    private JComboBox<String> genreBox;
    private DefaultTableModel tableModel;
    private JTable table;
    private JLabel countLabel;
    private ArrayList<Movie> movies;
    private String[] genres;

    public MovieCollector() {
        movies = new ArrayList<Movie>();
        genres = new String[]{"Action", "Comedy", "Horror", "Drama"};
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("Movie Collection Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 450);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        inputPanel.setBackground(new Color(230, 230, 250));

        titleField = new JTextField(15);
        genreBox = new JComboBox<>(genres);
        JButton addButton = new JButton("Add Movie");
        styleButton(addButton);

        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Genre:"));
        inputPanel.add(genreBox);
        inputPanel.add(addButton);

        tableModel = new DefaultTableModel(new String[]{"Title", "Genre"}, 0);
        table = new JTable(tableModel);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.setGridColor(Color.LIGHT_GRAY);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setLayout(new GridLayout(1, 3, 10, 10));

        JButton sortTitleButton = new JButton("Sort by Title");
        JButton sortGenreButton = new JButton("Sort by Genre");
        JButton searchButton = new JButton("Search");

        styleButton(sortTitleButton);
        styleButton(sortGenreButton);
        styleButton(searchButton);

        buttonPanel.add(sortTitleButton);
        buttonPanel.add(sortGenreButton);
        buttonPanel.add(searchButton);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        controlPanel.setBackground(new Color(240, 248, 255));

        searchField = new JTextField(12);
        countLabel = new JLabel("Total Movies: 0");

        controlPanel.add(new JLabel("Search Title:"));
        controlPanel.add(searchField);
        controlPanel.add(buttonPanel);
        controlPanel.add(countLabel);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.setVisible(true);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addMovie();
            }
        });

        sortTitleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sortMoviesByTitle();
            }
        });

        sortGenreButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sortMoviesByGenre();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchMovie();
            }
        });
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(30, 144, 255)); // Dodger Blue
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(150, 35));

    }

    private void addMovie() {
        String title = titleField.getText().trim();
        String genre = (String) genreBox.getSelectedItem();
        if (!title.isEmpty()) {
            movies.add(new Movie(title, genre));
            updateTable();
            titleField.setText("");
        }
    }

    private void updateTable() {
        tableModel.setRowCount(0);
        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            tableModel.addRow(new Object[]{movie.getTitle(), movie.getGenre()});
        }
        countLabel.setText("Total Movies: " + movies.size());
    }

    private void sortMoviesByTitle() {
        Collections.sort(movies, new TitleComparator());
        updateTable();
    }

    private void sortMoviesByGenre() {
        Collections.sort(movies, new GenreComparator());
        updateTable();
    }

    private void searchMovie() {
        String find = searchField.getText().trim().toLowerCase();
        for (int i = 0; i < table.getRowCount(); i++) {
            String movieTitle = table.getValueAt(i, 0).toString().toLowerCase();
            if (movieTitle.contains(find)) {
                table.setRowSelectionInterval(i, i);
                return;
            }
        }
    }

    public static void main(String[] args) {
        new MovieCollector();
    }
}
