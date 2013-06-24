import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BounceFrame extends JFrame{
    public BounceFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setTitle("Bounce");

        panel = new BallPanel();
        add(panel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start",
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent event)
                    {
                        addBall();
                    }
                });

        addButton(buttonPanel, "Close",
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent event)
                    {
                        System.exit(0);
                    }
                });
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void addButton(Container c, String title, ActionListener listener)
    {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    public void addBall()
    {
            Ball ball = new Ball();
            panel.add(ball);
            Runnable r = new BallRannable(ball, panel);
            Thread t = new Thread(r);
            t.start();
    }

    private BallPanel panel;
    public static final int DEFAULT_WIDTH = 450;
    public static final int DEFAULT_HEIGHT = 350;
    public static final int STEPS = 10000;
    public static final int DELAY = 3;
}
