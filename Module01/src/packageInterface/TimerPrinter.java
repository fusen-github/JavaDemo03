package packageInterface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerPrinter implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("来了");
    }
}
