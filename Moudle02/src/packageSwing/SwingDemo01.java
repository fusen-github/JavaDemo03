package packageSwing;

import javax.swing.*;
import javax.swing.plaf.TextUI;
import javax.swing.text.JTextComponent;
import java.awt.*;

public class SwingDemo01 {

    public static void main(String[] args) {

        func01();
    }

    private static void func01()
    {
        EventQueue.invokeLater(()->{

            SimpleFrame sf = new SimpleFrame();

            Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
            Dimension screenSize = defaultToolkit.getScreenSize();

            sf.setLocation(0, 0);
            sf.setSize(screenSize.width, screenSize.height - 200);

            /// 标题
            sf.setTitle("我的窗口");

            /// 设置窗口是否可以改变大小
            sf.setResizable(false);


//            FSComponent component = new FSComponent();
//            sf.add(component);

            JPanel panel = new JPanel();
//            panel.setBounds(10, 20, 100, 100);
            panel.setBackground(Color.red);
//            panel.setSize(50, 50);
            Dimension size = new Dimension();
            size.width = 100;
            size.height = 100;
            panel.setPreferredSize(size);
            sf.add(panel);


            sf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            sf.setVisible(true);


            /* 程序执行到这里，说明主线程已经执行完毕，但是子线程还没有销毁，所以主线程也不能销毁，
            * 因此程序并没有结束
            *
            * */
            System.out.println("end");
        });
    }

//    private static

}

class FSComponent extends JComponent
{
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawString("你好，世界", 20, 20);
    }
}

class SimpleFrame extends JFrame
{

}

