import biblioteca_matrizes.Vector3;

public class App {
    public static void main(String[] args) throws Exception {
        Transform test = new Transform();

        test.position = new Vector3(100, 12319, 1);
        test.rotation = new Vector3(90, 17, 75);

        Drawing drawing = new Drawing();
        drawing.OpenWindow();
    }
}
