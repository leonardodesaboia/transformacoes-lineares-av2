package biblioteca_matrizes;
public class Vector3 {
    public float x = 0;
    public float y = 0;
    public float z = 0;

    public Vector3(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String toString() {
        return String.format("X: %f, Y: %f, Z: %f", x, y, z);
    }

    public Matriz GetMatrix() {
        Matriz m = new Matriz(3, 1);
        m.SetValue(0, 0, x);
        m.SetValue(1, 0, y);
        m.SetValue(2, 0, z);

        return m;

    }
}
