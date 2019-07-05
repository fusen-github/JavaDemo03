package packageSwing;

import javax.swing.*;
import java.awt.*;

public class SwingTest {

    public static void main(String[] args) {

        func01();
    }

    private static void func01()
    {
        EventQueue.invokeLater(() -> {

            SimpleFrame sf = new SimpleFrame();

            sf.setLocation(300, 100);

            sf.setSize(400, 500);

//            sf.setUndecorated(true);

            sf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            sf.setVisible(true);
        });
    }



}

class SimpleFrame extends JFrame
{
    private static final int kWidth = 300;

    private static final int kHeight = 200;

//    public SimpleFrame()
//    {
//    }
}
