package Lesson_8;

import javax.management.StringValueExp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterApp extends JFrame {
    private int value;

    public CounterApp(int initialValue) {
        value = initialValue;

        setBounds(500, 500, 700, 120);
        setTitle("Simple Counter");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new GridLayout(1,8));

        Font font = new Font("Arial", Font.BOLD, 32);

        JButton decrementButton_10 = new JButton("-10");
        decrementButton_10.setFont(font);
        add(decrementButton_10);

        JButton decrementButton_5 = new JButton("-5");
        decrementButton_5.setFont(font);
        add(decrementButton_5);

        JButton decrementButton_1 = new JButton("-1");
        decrementButton_1.setFont(font);
        add(decrementButton_1);

        JLabel counterValueView = new JLabel();
        counterValueView.setFont(font);
        counterValueView.setHorizontalAlignment(SwingConstants.CENTER);
        add(counterValueView);

        JLabel evenView = new JLabel();
        evenView.setFont(font);
        evenView.setText("");
        add(evenView);

        counterValueView.setText(String.valueOf(value));

        JButton incrementButton_1 = new JButton("+1");
        incrementButton_1.setFont(font);
        add(incrementButton_1);

        JButton incrementButton_5 = new JButton("+5");
        incrementButton_5.setFont(font);
        add(incrementButton_5);

        JButton incrementButton_10 = new JButton("+10");
        incrementButton_10.setFont(font);
        add(incrementButton_10);


        decrementButton_10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                value -=10;
                counterValueView.setText(String.valueOf(value));
                evenView.setText(isEven(value));
            }
        });

        decrementButton_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                value -= 5;
                counterValueView.setText(String.valueOf(value));
                evenView.setText(isEven(value));
            }
        });

        decrementButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                value--;
                counterValueView.setText(String.valueOf(value));
                evenView.setText(isEven(value));
            }
        });

        incrementButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                value++;
                counterValueView.setText(String.valueOf(value));
                evenView.setText(isEven(value));
            }
        });

        incrementButton_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                value += 5;
                counterValueView.setText(String.valueOf(value));
                evenView.setText(isEven(value));
            }
        });

        incrementButton_10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                value += 10;
                counterValueView.setText(String.valueOf(value));
                evenView.setText(isEven(value));
            }
        });

        setVisible(true);
    }

    public String isEven(int value){
        if(value % 2 == 0){
            return "even";
        }else{
           return "odd";
        }
    }

    public static void main(String[] args) {
        new CounterApp(0);
    }
}
