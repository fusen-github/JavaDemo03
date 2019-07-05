package packageTimer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TimerTest {

    public static void main(String[] args) {

        func01();
    }

    private static void func01()
    {
        ActionListener listener = new TimerPrinter();

        javax.swing.Timer timer = new javax.swing.Timer(3000, listener);

        timer.start();

        JOptionPane.showMessageDialog(null, "退出程序？");

        System.exit(0);
        System.out.println("end");
    }

}

class TimerPrinter implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("time is " + new Date());
        /// 发出一声玲响
        Toolkit.getDefaultToolkit().beep();
        System.out.println("来了");
    }
}
