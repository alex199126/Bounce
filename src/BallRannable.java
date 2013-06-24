import java.awt.*;

public class BallRannable implements Runnable {

    public BallRannable(Ball aBall, Component aComponent){
        this.ball = aBall;
        this.component = aComponent;
    }

    public void run(){
        try{
            for(int i = 1; i<=STEPS; i++){
                ball.move(component.getBounds());
                component.repaint();
                Thread.sleep(DELAY);
            }
        } catch (InterruptedException e) {
        }

    }
    private static final int STEPS = 10000;
    private static final int DELAY = 3;
    private Ball ball;
    private Component component;
}
