package builders;

import algorithms.BubbleSort;
import algorithms.InsertionSort;
import algorithms.MergeSort;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AlgoChoosingBtn implements ActionListener {

    JButton bubbleSortBtn;
    JButton mergeSortBtn;
    JButton insertionSortBtn;
    JButton selectionSortBtn;
    JButton startBtn;
    String algo = "bubble";
    BarPanel barPanel;

    BubbleSort bubbleSort;
    MergeSort mergeSort;
    InsertionSort insertionSort;

    public AlgoChoosingBtn(JFrame appFrame, BarPanel barPanel){
        this.barPanel = barPanel;

        bubbleSortBtn = new JButton("Bubble Sort");
        bubbleSortBtn.setBounds(0, 600, 100, 30);
        bubbleSortBtn.setBackground(Color.RED);
        bubbleSortBtn.setFocusable(false);
        bubbleSortBtn.addActionListener(this);
        appFrame.add(bubbleSortBtn);

        mergeSortBtn = new JButton("Merge Sort");
        mergeSortBtn.setBounds(110, 600, 100, 30);
        mergeSortBtn.setBackground(Color.GRAY);
        mergeSortBtn.setFocusable(false);
        mergeSortBtn.addActionListener(this);
        mergeSortBtn.setEnabled(false);
        appFrame.add(mergeSortBtn);

        insertionSortBtn = new JButton("Insertion Sort");
        insertionSortBtn.setBounds(220, 600, 100, 30);
        insertionSortBtn.setBackground(Color.GRAY);
        insertionSortBtn.setFocusable(false);
        insertionSortBtn.addActionListener(this);
        appFrame.add(insertionSortBtn);

        selectionSortBtn = new JButton("Selection Sort");
        selectionSortBtn.setBounds(330, 600, 100, 30);
        selectionSortBtn.setBackground(Color.GRAY);
        selectionSortBtn.setFocusable(false);
        selectionSortBtn.addActionListener(this);
        appFrame.add(selectionSortBtn);

        startBtn = new JButton("Start");
        startBtn.setBounds(440, 600, 100, 30);
        startBtn.setBackground(Color.GRAY);
        startBtn.setFocusable(false);
        startBtn.addActionListener(this);
        appFrame.add(startBtn);

        bubbleSort = new BubbleSort(barPanel);
        mergeSort = new MergeSort(barPanel);
        insertionSort = new InsertionSort(barPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == bubbleSortBtn){
            setBtnGray();
            bubbleSortBtn.setBackground(Color.RED);
            algo = "bubble";
        }else if(e.getSource() == mergeSortBtn){
            setBtnGray();
            mergeSortBtn.setBackground(Color.RED);
            algo = "merge";
        }
        else if(e.getSource() == insertionSortBtn){
            setBtnGray();
            insertionSortBtn.setBackground(Color.RED);
            algo = "insertion";
        }else if(e.getSource() == selectionSortBtn){
            setBtnGray();
            selectionSortBtn.setBackground(Color.RED);
            algo = "selection";
        }
        else{
            switch (algo){
                case "bubble" -> bubbleSort.sort();
                case "merge" -> mergeSort.sort();
                case "insertion" -> insertionSort.sort();
            }
        }
    }

    private void setBtnGray(){
        bubbleSortBtn.setBackground(Color.GRAY);
        mergeSortBtn.setBackground(Color.GRAY);
        insertionSortBtn.setBackground(Color.GRAY);
        selectionSortBtn.setBackground(Color.GRAY);
    }
}
