package GUI;

import CODE.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class MainFrame extends JFrame {

    public  MainFrame(){
        this.setVisible(true);
        // Set the JFrame title
        setTitle("Main Frame");

        // Set the size of the JFrame
        this.setPreferredSize(new Dimension(600, 700));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // center frame
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2- 300, dim.height/2- 300);

        this.setLayout(null);



        JButton loadDataBtn = new JButton("load data");
        loadDataBtn.setBounds(new Rectangle(30, 10 ,100 ,20));

        // select algorithms section
        JLabel DSlabel = new JLabel();
        DSlabel.setText("select data structure");
        DSlabel.setBounds(new Rectangle(30, 50 ,150 ,20));

        // select ds buttons
        JButton linerProbingLoadFactor50btnSSF = new JButton("<html>technique : linear probing & load factor : 50% , hash method SSF</html>");
        linerProbingLoadFactor50btnSSF.setBounds(new Rectangle(30, 80 ,150 ,60));

        JButton linerProbingLoadFactor50btnPAF = new JButton("<html>technique : linear probing & load factor : 50% , hash method PAF</html>");
        linerProbingLoadFactor50btnPAF.setBounds(new Rectangle(30, 150 ,150 ,60));

        JButton linerProbingLoadFactor80btnSSF = new JButton("<html>technique : linear probing & load factor : 80% , hash method SSF</html>");
        linerProbingLoadFactor80btnSSF.setBounds(new Rectangle(30, 220 ,150 ,60));

        JButton linerProbingLoadFactor80btnPAF = new JButton("<html>technique : linear probing & load factor : 80% , hash method PAF</html>");
        linerProbingLoadFactor80btnPAF.setBounds(new Rectangle(30, 290 ,150 ,60));



        JButton doubleHashingLoadFactor50btnSSF = new JButton("<html>technique : double hashing & load factor : 50% , hash method SSF</html>");
        doubleHashingLoadFactor50btnSSF.setBounds(new Rectangle(30, 360 ,150 ,60));

        JButton doubleHashingLoadFactor50btnPAF = new JButton("<html>technique : double hashing & load factor : 50% , hash method PAF</html>");
        doubleHashingLoadFactor50btnPAF.setBounds(new Rectangle(30, 430 ,150 ,60));

        JButton doubleHashingLoadFactor80btnSSF = new JButton("<html>technique : double hashing & load factor : 80% , hash method SSF</html>");
        doubleHashingLoadFactor80btnSSF.setBounds(new Rectangle(30, 500 ,150 ,60));

        JButton doubleHashingLoadFactor80btnPAF = new JButton("<html>technique : double hashing & load factor : 80% , hash method PAF</html>");
        doubleHashingLoadFactor80btnPAF.setBounds(new Rectangle(30, 570 ,150 ,60));



        // display selececd DS
        JLabel displayDSNamelabel = new JLabel();
        displayDSNamelabel.setText("select data structure : not selected ... ");
        displayDSNamelabel.setBounds(new Rectangle(100, 30 ,400 ,20));

        // display app state Label
        JLabel appStatelabel = new JLabel();
        appStatelabel.setText("app state : idle");
        appStatelabel.setBounds(new Rectangle(200, 0 ,400 ,20));


        linerProbingLoadFactor50btnSSF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SD.selectedHashTable = new HashTableLinearProbing(0.5f , SelectedHashFunction.SSF);
                displayDSNamelabel.setText("select data structure : linerProbingLoadFactor50btnSSF");
            }
        });
    // liner probing
        linerProbingLoadFactor80btnSSF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SD.selectedHashTable = new HashTableLinearProbing(0.8f , SelectedHashFunction.SSF);
                displayDSNamelabel.setText("select data structure : linerProbingLoadFactor80btnSSF");
            }
        });

        linerProbingLoadFactor50btnPAF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SD.selectedHashTable = new HashTableLinearProbing(0.5f , SelectedHashFunction.PAF);
                displayDSNamelabel.setText("select data structure : linerProbingLoadFactor50btnPAF");
            }
        });

        linerProbingLoadFactor80btnPAF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SD.selectedHashTable = new HashTableLinearProbing(0.8f , SelectedHashFunction.PAF);
                displayDSNamelabel.setText("select data structure : linerProbingLoadFactor80btnPAF");
            }
        });

        // double hashing

        doubleHashingLoadFactor50btnSSF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SD.selectedHashTable = new HashTableDobuleHashing(0.5f , SelectedHashFunction.SSF);
                displayDSNamelabel.setText("select data structure : doubleHashingLoadFactor50btnSSF");
            }
        });

        doubleHashingLoadFactor80btnSSF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SD.selectedHashTable = new HashTableDobuleHashing(0.8f , SelectedHashFunction.SSF);
                displayDSNamelabel.setText("select data structure : doubleHashingLoadFactor80btnSSF");
            }
        });

        doubleHashingLoadFactor50btnPAF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SD.selectedHashTable = new HashTableDobuleHashing(0.5f , SelectedHashFunction.PAF);
                displayDSNamelabel.setText("select data structure : doubleHashingLoadFactor50btnPAF");
            }
        });

        doubleHashingLoadFactor80btnPAF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SD.selectedHashTable = new HashTableDobuleHashing(0.8f , SelectedHashFunction.PAF);
                displayDSNamelabel.setText("select data structure : doubleHashingLoadFactor80btnPAF");
            }
        });

        // text area
        JTextArea textArea = new JTextArea();
        textArea.setText("Results ll be visualized in this area ...");
        textArea.setLineWrap(true); // Wrap lines if text exceeds the area
        textArea.setWrapStyleWord(true); // Wrap at word boundaries
        textArea.setEditable(true); // Allow the user to edit text
        textArea.setBounds(new Rectangle(200, 100 , 300 ,400));

        // Create a JScrollPane and add the JTextArea to it
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(200, 120, 380, 400);  // Set the bounds for the scroll pane
        this.add(scrollPane);


        // select data by id
        JTextField imbdIdField = createTextField("Enter imdbId");
        imbdIdField.setBounds(new Rectangle(300, 520 , 200 ,20));

        // select data by id
        JButton searchByimbdIdButton = new JButton("<html> search by imdbId</html>");
        searchByimbdIdButton.setBounds(new Rectangle(300, 540 , 200 ,20));

        searchByimbdIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String imdbID = imbdIdField.getText();
                HashTableEntry entry = SD.selectedHashTable.getValue(imdbID);
                if(entry != null){
                    textArea.setText(entry.Visualize());
                }else{
                    textArea.setText("no entry exist ... ");
                }
            }
        });


        // select data by Countyr code
        JTextField countyCodeField = createTextField("Enter County Code");
        countyCodeField.setBounds(new Rectangle(300, 570 , 200 ,20));

        JButton searchByimbdCountryCodeButton = new JButton("<html> search by country code</html>");
        searchByimbdCountryCodeButton.setBounds(new Rectangle(300, 590 , 200 ,20));

        searchByimbdCountryCodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String countryCode = countyCodeField.getText();
                if(SD.selectedHashTable == null){
                    appStatelabel.setText("app state : (error) select hash table and load data");
                }
                else if(SD.selectedHashTable.entryCount == 0){
                    appStatelabel.setText("app state : (error) hash table is not laoded with data");
                }
                else if(countryCode == null){
                    appStatelabel.setText("app state : (error) country code is null");
                }
                else{
                    appStatelabel.setText("app state : calculating");
                    new GetMediaViaCountry(appStatelabel, textArea ,countryCode).execute();
                }
            }
        });

        JButton benchMark1000Search =  new JButton("<html>benchmark 1000 search</html>");
        benchMark1000Search.setBounds(new Rectangle(200, 60, 100 ,40));


        benchMark1000Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(SD.selectedHashTable == null){
                    appStatelabel.setText("app state : (error) select hash table and load data");
                }
                else if(SD.selectedHashTable.entryCount == 0){
                    appStatelabel.setText("app state : (error) hash table is not laoded with data");
                }else{
                    appStatelabel.setText("app state : calculating");
                    new BenchMark1000SearchWorker(appStatelabel ,textArea).execute();
                }
            }
        });

        JButton getTop10 =  new JButton("<html>get top 10</html>");
        getTop10.setBounds(new Rectangle(325, 60, 100 ,40));

        getTop10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(SD.selectedHashTable == null){
                    appStatelabel.setText("app state : (error) select hash table and load data");
                }
                else if(SD.selectedHashTable.entryCount == 0){
                    appStatelabel.setText("app state : (error) hash table is not laoded with data");
                }else{
                    appStatelabel.setText("app state : calculating");
                    new FindTop10Record(appStatelabel, textArea).execute();
                }
            }
        });

        JButton meadiaItemsOn5platrofmsbtn =  new JButton("<html>media items that are streaming on 5 platforms</html>");
        meadiaItemsOn5platrofmsbtn.setBounds(new Rectangle(450, 30, 140 ,80));

        meadiaItemsOn5platrofmsbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(SD.selectedHashTable == null){
                    appStatelabel.setText("app state : (error) select hash table and load data");
                }
                else if(SD.selectedHashTable.entryCount == 0){
                    appStatelabel.setText("app state : (error) hash table is not laoded with data");
                }else{
                    appStatelabel.setText("app state : calculating");
                    new ListMediaItemOn5platform(appStatelabel, textArea).execute();
                }
            }
        });



        loadDataBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(SD.selectedHashTable == null){
                    appStatelabel.setText("app state : error (selected hash table is null)");
                }else{
                    appStatelabel.setText("app state : loading data");
                    new LoadDataWorker(appStatelabel ,textArea).execute();
                }

            }
        });

        // add gui elements to frame
        this.add(loadDataBtn);
        this.add(DSlabel);
        this.add(linerProbingLoadFactor50btnSSF);
        this.add(linerProbingLoadFactor50btnPAF);
        this.add(linerProbingLoadFactor80btnSSF);
        this.add(linerProbingLoadFactor80btnPAF);
        this.add(doubleHashingLoadFactor50btnSSF);
        this.add(doubleHashingLoadFactor50btnPAF);
        this.add(doubleHashingLoadFactor80btnSSF);
        this.add(doubleHashingLoadFactor80btnPAF);
        this.add(displayDSNamelabel);
        this.add(appStatelabel);
        this.add(imbdIdField);
        this.add(searchByimbdIdButton);
        this.add(benchMark1000Search);
        this.add(getTop10);
        this.add(meadiaItemsOn5platrofmsbtn);
        this.add(searchByimbdCountryCodeButton);
        this.add(countyCodeField);

        // Pack the frame to adjust size based on components
        this.pack();

        // Make the JFrame visible
        this.setVisible(true);
    }

    private JTextField createTextField(final String placeholder) {
        final JTextField textField = new JTextField(20);
        textField.setForeground(Color.GRAY);  // Set placeholder text color
        textField.setText(placeholder);

        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);  // Reset text color
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setForeground(Color.GRAY);
                    textField.setText(placeholder);
                }
            }
        });

        return textField;
    }
}
