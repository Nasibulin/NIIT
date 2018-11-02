package javalab5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new ClockFace());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class ClockFace extends JPanel {

        public ClockFace() {
            this.startClock();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(600, 600);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();

            LocalTime now = LocalTime.now();
            int seconds = now.getSecond();
            int minutes = now.getMinute();
            int hours = now.getHour();

            g2d.setColor(Color.BLACK);
            g2d.fillRect(0, 0, 600, 600);
            g2d.setColor(Color.WHITE);
            g2d.translate(300, 300);

            //Drawing the hour markers
            for (int i = 0; i < 12; i++) {

                g2d.drawLine(0, -260, 0, -300);
                g2d.rotate(Math.PI / 6);

            }

            g2d.rotate(seconds * Math.PI / 30);
            g2d.drawLine(0, 0, 0, -290);

            g2d.rotate(2 * Math.PI - seconds * Math.PI / 30);
            g2d.rotate(minutes * Math.PI / 30);
            g2d.setStroke(new BasicStroke(3));
            g2d.drawLine(0, 0, 0, -250);

            g2d.rotate(2 * Math.PI - minutes * Math.PI / 30);
            g2d.rotate(hours * Math.PI / 6);
            g2d.setStroke(new BasicStroke(6));
            g2d.drawLine(0, 0, 0, -200);

            g2d.dispose();
        }

        public void startClock() {
            Timer timer = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    repaint();
                }
            });
            timer.start();
        }

    }

}
