package packageSwing;

import com.sun.javafx.fxml.builder.JavaFXSceneBuilder;
import oracle.jvm.hotspot.jfr.JFR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonFrameTest {

    public static void main(String[] args) {

        EventQueue.invokeLater(()->{

            ButtonFrame frame = new ButtonFrame();

            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension screenSize = toolkit.getScreenSize();

            JPanel panel = setupPanel();

            frame.add(panel);

            frame.setTitle("sen");
            frame.setBounds(0,0, screenSize.width, screenSize.height - 100);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setVisible(true);

        });
    }

    private static JPanel setupPanel()
    {
        JPanel panel = new JPanel();

        /// 添加红色按钮
        JButton redBtn = new JButton("红");
        ActionListener redAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.RED);
            }
        };
        redBtn.addActionListener(redAction);
        panel.add(redBtn);


        /// 添加绿色按钮
        JButton greenBtn = new JButton("绿");
//        ActionListener greenAction = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                panel.setBackground(Color.GREEN);
//            }
//        };
//        greenBtn.addActionListener(greenAction);


//        greenBtn.addActionListener((event) -> {
//            panel.setBackground(Color.GREEN);
//            System.out.println("f");
//        });

        greenBtn.addActionListener((event) ->
                panel.setBackground(Color.GREEN));

        panel.add(greenBtn);


        /// 添加蓝色按钮
        JButton blueBtn = new JButton("蓝");
        ActionListener blueAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.BLUE);
            }
        };
        blueBtn.addActionListener(blueAction);
        panel.add(blueBtn);

        return panel;
    }


}

class ButtonFrame extends JFrame
{
    private JPanel panel;

}
