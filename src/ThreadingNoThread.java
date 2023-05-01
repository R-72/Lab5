import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ThreadingNoThread extends JFrame {

  public JButton colorBtn, calcBtn;
  public JTextField colorField, calcField;

  public ThreadingNoThread() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(400, 120);
    getRootPane().setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

    GridLayout layout = new GridLayout(2, 2);
    layout.setHgap(8);
    layout.setVgap(8);
    setLayout(layout);

    colorBtn = new JButton("Color");
    colorField = new JTextField();
    calcBtn = new JButton("Calculate");
    calcField = new JTextField();

    add(colorBtn);
    add(colorField);
    add(calcBtn);
    add(calcField);

    setVisible(true);
    addListeners();
    revalidate();
  }

  public void addListeners() {
    colorBtn.addActionListener(
      (ActionEvent e) -> {
          if (colorField.getBackground() == Color.GREEN) {
            colorField.setBackground(Color.ORANGE);
          } else {
            colorField.setBackground(Color.GREEN);
          }
      }
    );

    calcBtn.addActionListener(
      (ActionEvent e) -> {
          calculate();
      }
    );
  }

  private void calculate() {
    try {
      calcField.setText("Please Wait...");
      Thread.sleep(5 * 1000);
    } catch (InterruptedException e1) {}
    calcField.setText("Computation complete!");
  }

  public static void main(String[] args) {
    new ThreadingNoThread();
  }
}
