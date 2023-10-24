import biblioteca_matrizes.Matriz;

public class Camera {
    public float fov = 90;
    public float aspectRatio = 1f;
    public float far = 1000.0f;
    public float near = 0.0f;

    public Matriz GetPerspectiveMatrix() {
        Matriz perspective = new Matriz(4, 4);
        perspective.FillZero();

        float f = 1.0f / (float) Math.tan(fov / 2.0f);
        perspective.SetValue(0, 0, f / aspectRatio); 
        perspective.SetValue(1, 1, f);
        perspective.SetValue(2, 2, (far + near) / (near - far));
        perspective.SetValue(3, 2, (2 * far * near) / (near - far)); 
        perspective.SetValue(2, 3, -1);  
        perspective.SetValue(3, 3, 0);  
        return perspective;

    }
}
