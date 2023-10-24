import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Drawing extends Canvas {
     static double time_passed = 0;
     static double delta_time = 0;

    public Object object = new Object();

    private Canvas canvas = null;

    public void OpenWindow() {
        JFrame frame = new JFrame("My Drawing");
        canvas = new Drawing();
        canvas.setSize(400, 400);
        frame.add(canvas);
        frame.pack();
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
        float deltaTime = 0.0f;
        while (true) {
            long start = System.currentTimeMillis();
            tick(deltaTime);
            canvas.repaint();
            frame.repaint();
            long end = System.currentTimeMillis() - start; // Delta time in ms
            float seconds = end / 1000.0f; // Delta time in s converted to float
            deltaTime = seconds;
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        object.Draw(g);
    }
    
    public void tick(float deltaTime) {
        object.Move();
        object.transform.position.x += 1;
        // canvas.repaint();
        // System.out.println("tixk");
    }
}