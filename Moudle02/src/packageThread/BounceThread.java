package packageThread;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.*;
import java.util.List;

public class BounceThread {

    public static void main(String[] args) {

        EventQueue.invokeLater(()->{

            JFrame frame = new BaseFrame();

            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension screenSize = toolkit.getScreenSize();

            frame.setBounds(0,0, screenSize.width, screenSize.height - 50);

            frame.setTitle("多线程演练");

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setVisible(true);

        });
    }

    private static void func01()
    {
//        ArrayList

//        HashMap

//        TreeMap

//        List

//        Stack

//        LinkedHashMap

    }


}


class BaseFrame extends JFrame implements BottomPanelInterface
{
    private BallPanel ballPanel;
//    private BottomPanel bottomPanel;

    public BaseFrame()
    {
        init();
    }

    private void init()
    {
        // 小球窗格
        BallPanel ballPanel = new BallPanel();

        this.ballPanel = ballPanel;

        this.add(ballPanel, BorderLayout.CENTER);


        /// 添加底部窗格
        BottomPanel bottomPanel = new BottomPanel();

        bottomPanel.parentFrame = this;

        this.add(bottomPanel, BorderLayout.SOUTH);
    }


    @Override
    public void addBall() {

        Ball ball = new Ball();

        this.ballPanel.addBall(ball);

        Runnable runFunc = ()-> {

            for (int i = 0; i < 10000000; i++) {

                ball.move(this.ballPanel.getBounds());

//                this.ballPanel.paint(this.ballPanel.getGraphics());

                this.ballPanel.repaint();

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(runFunc);

        thread.start();
    }


}



/**
 * 小球窗格
 * */
class BallPanel extends JPanel
{
    private ArrayList<Ball> ballArrayList = new ArrayList<>();

    public BallPanel()
    {
        this.setBackground(Color.RED);
    }

    public void addBall(Ball ball)
    {
        ballArrayList.add(ball);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D graphics2D = (Graphics2D)g;

        for (Ball ball : ballArrayList) {

//            System.out.println("重绘");

            graphics2D.fill(ball.getShap());
        }
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(400, 400);
    }
}


interface BottomPanelInterface
{
    void addBall();
}

/**
 * 底部窗格
 */
class BottomPanel extends JPanel
{
    BottomPanelInterface parentFrame;

    public BottomPanel()
    {
        this.setBackground(Color.GREEN);
        this.init();
    }

    private void init()
    {
        JButton startBtn = new JButton("发射");
        startBtn.addActionListener(e -> addBallToFrame());
        this.add(startBtn);

        JButton cancelBtn = new JButton("结束");
        cancelBtn.addActionListener(e -> System.exit(0));
        this.add(cancelBtn);
    }

    private void addBallToFrame()
    {
        if (parentFrame instanceof BottomPanelInterface)
        {
            parentFrame.addBall();
        }
    }
}



class Ball
{
    private static final int WIDTH = 15;
    private static final int HEIGHT = 15;
    private double x = 100;
    private double y = 100;

    private Random random;

    public Ball()
    {
        this.random = new Random(21);
    }

    public void move(Rectangle2D rect)
    {
        double dx = this.random.nextInt() - 10;
        double dy = this.random.nextInt() - 10;

        x += dx;
        y += dy;

        System.out.println("x = " + x + ", y = " + y);

        if (x < rect.getMinX())
        {
            x = rect.getMinX();
        }

        if (x + WIDTH > rect.getMaxX())
        {
            x = rect.getMaxX() - WIDTH;
        }

        if (y < rect.getMinY())
        {
            y = rect.getMinY();
        }

        if (y + HEIGHT > rect.getMaxY())
        {
            y = rect.getMaxY() - HEIGHT;
        }
    }

    public Ellipse2D getShap()
    {
        Ellipse2D obj = new Ellipse2D.Double(x, y, WIDTH, HEIGHT);

        return obj;
    }

}
