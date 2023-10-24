import java.awt.Graphics;

import biblioteca_matrizes.*;

public class Object {
    public Transform transform;
    public Vector3[] points = new Vector3[] {
        new Vector3(-10, -10, -10),  // Ponto 0
        new Vector3(10, -10, -10),   // Ponto 1
        new Vector3(10, 10, -10),    // Ponto 2
        new Vector3(-10, 10, -10),   // Ponto 3

        // Back face
        new Vector3(-10, -10, 10),   // Ponto 4
        new Vector3(10, -10, 10),    // Ponto 5
        new Vector3(10, 10, 10),     // Ponto 6
        new Vector3(-10, 10, 10),    // Ponto 7

        // Conexões entre as faces
        new Vector3(-10, -10, -10),  // Ponto 8 (para conectar com Ponto 4)
        new Vector3(10, -10, -10),   // Ponto 9 (para conectar com Ponto 5)
        new Vector3(-10, 10, -10),   // Ponto 10 (para conectar com Ponto 7)
        new Vector3(10, 10, -10),    // Ponto 11 (para conectar com Ponto 6)
    };

    public Vector3[] GetTransformedPoints(Vector3[] points) {
        Vector3[] transformedPoints = new Vector3[points.length];
        for (int i = 0; i < points.length; i++) {
            Vector3 point = points[i];
            
            transformedPoints[i] = LinearAlgebra.Dot(transform.GetTransformationMatriz(),point);
        }

        return transformedPoints;
    }

    public Vector3[] GetReflectedPoints(Vector3[] points) {
        Vector3[] transformedPoints = new Vector3[points.length];
        for (int i = 0; i < points.length; i++) {
            Vector3 point = points[i];
            transformedPoints[i] = LinearAlgebra.Dot3(transform.GetReflectionMatrix(new Vector3(0, 0, 0)),point);
        }

        return transformedPoints;
    }

    public Vector3[] GetProjectedPoints(Vector3[] points, float d) {
        Vector3[] projectedPoints = new Vector3[points.length];
        for (int i = 0; i < points.length; i++) {
            Vector3 point = points[i];


            Vector3 projectedPoint = new Vector3(0, 0, 0);
            projectedPoint.x = (point.x * d) / point.z;
            projectedPoint.y = (point.y * d) / point.z;
            System.out.println(projectedPoint);
            projectedPoints[i] = projectedPoint;
        }

        return projectedPoints;
    }

    public Vector3[] GetPerspectivePoints(Vector3[] points, Camera camera) {
        Vector3[] perspectivePoints = new Vector3[points.length];
        for (int i = 0; i < points.length; i++) {
            Vector3 point = points[i];


            perspectivePoints[i] = LinearAlgebra.Dot(camera.GetPerspectiveMatrix(),point);
        }

        return perspectivePoints;
    }

    public Object() {
        transform = new Transform();
        transform.position = new Vector3(100, 100, 0);
        transform.rotation = new Vector3(0, 32, 0);
        transform.scale = new Vector3(0, 0, 0);

    }

    public void Move() {
        transform.position.x += 0.01f;
    }

    public void Draw(Graphics g) {
        Camera camera = new Camera();
        System.out.println("Drawing");
        // Vector3[] reflectedPoints = GetReflectedPoints(this.points);
        // Vector3[] projectedPoints = GetProjectedPoints(this.points, -20f);
        Vector3[] transformedPoints = GetTransformedPoints(this.points);
        Vector3[] perspectivedPoints = GetPerspectivePoints(transformedPoints, camera);
        
        Vector3[] pointsToDraw = perspectivedPoints;

        int[][] vertexOrder = {
            {0, 1, 2, 3, 0},  // Face frontal
            {4, 5, 6, 7, 4},  // Face traseira
            {0, 4},           // Conexões entre as faces
            {1, 5},
            {2, 6},
            {3, 7}
        };
    
        for (int[] face : vertexOrder) {
            for (int i = 0; i < face.length - 1; i++) {
                Vector3 from = pointsToDraw[face[i]];
                Vector3 to = pointsToDraw[face[i + 1]];
                g.drawLine((int) from.x, (int) from.y, (int) to.x, (int) to.y);
            }
        }
    }
}
