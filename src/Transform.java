import biblioteca_matrizes.*;
import javafx.scene.shape.Line;

public class Transform {
    private Matriz positionMatrix = new Matriz(4, 4);
    private Matriz rotationXMatrix;
    private Matriz rotationYMatrix;
    private Matriz rotationZMatrix;
    private Matriz projectionXMatriz;
    private Matriz projectionYMatriz;
    private Matriz projectionZMatriz;

    public Vector3 position;
    public Vector3 rotation;
    public Vector3 scale;
    public Vector3 projection;

    public Transform() {
        position = new Vector3(0, 0, 0);
        rotation = new Vector3(0, 0, 0);
        scale = new Vector3(0, 0, 0);
        projection = new Vector3(0, 0, 0);
    }

    public Matriz GetTranslationMatrix() {
        int linhas = 4;
        int colunas = 4;
        Matriz translationMatrix = new Matriz(linhas, colunas);
        
        // montando a identidade
        for (int i = 0; i < linhas; i++) {
            translationMatrix.SetValue(i, i, 1);
        }

        translationMatrix.SetValue(0, 3, position.x);
        translationMatrix.SetValue(1, 3, position.y);
        translationMatrix.SetValue(2, 3, position.z);

        return translationMatrix;
    }

    public Matriz Get_X_RotationMatrix() {
        int linhas = 4;
        int colunas = 4;
        Matriz rotationMatrix = new Matriz(linhas, colunas);

        // montando a matriz base
        rotationMatrix.SetValue(0, 0, 1);
        rotationMatrix.SetValue(3, 3, 1);

        double xRotation = Math.toRadians(rotation.x);
        rotationMatrix.SetValue(1, 1, Math.cos(xRotation));
        rotationMatrix.SetValue(1, 2, -Math.sin(xRotation));

        rotationMatrix.SetValue(2, 1, Math.sin(xRotation));
        rotationMatrix.SetValue(2, 2, Math.cos(xRotation));


        return rotationMatrix;
    }

    public Matriz Get_Y_RotationMatrix() {
        int linhas = 4;
        int colunas = 4;
        Matriz rotationMatrix = new Matriz(linhas, colunas);

        // montando a matriz base
        rotationMatrix.SetValue(1, 1, 1);
        rotationMatrix.SetValue(3, 3, 1);

        double yRotation = Math.toRadians(rotation.y);
        rotationMatrix.SetValue(0, 0, Math.cos(yRotation));
        rotationMatrix.SetValue(0, 2, Math.sin(yRotation));

        rotationMatrix.SetValue(2, 0, -Math.sin(yRotation));
        rotationMatrix.SetValue(2, 2, Math.cos(yRotation));


        return rotationMatrix;
    }

    public Matriz Get_Z_RotationMatrix() {
        int linhas = 4;
        int colunas = 4;
        Matriz rotationMatrix = new Matriz(linhas, colunas);

        // montando a matriz base
        rotationMatrix.SetValue(2,2,1);
        rotationMatrix.SetValue(3, 3, 1);

        double zRotation = Math.toRadians(rotation.z);
        rotationMatrix.SetValue(0, 0, Math.cos(zRotation));
        rotationMatrix.SetValue(0, 1, -Math.sin(zRotation));

        rotationMatrix.SetValue(1, 0, Math.sin(zRotation));
        rotationMatrix.SetValue(1, 1, Math.cos(zRotation));


        return rotationMatrix;
    }
    public Matriz Get_X_ProjectionMatrix() {
        int linhas = 4;
        int colunas = 4;
        Matriz projectionMatrix = new Matriz(linhas, colunas);

        // montando a matriz base
        projectionMatrix.SetValue(0, 0, 1);
        projectionMatrix.SetValue(3, 3, 1);

        double xProjection = Math.toRadians(projection.x);
        projectionMatrix.SetValue(1, 1, xProjection);
        projectionMatrix.SetValue(1, 2, 0);

        projectionMatrix.SetValue(2, 1, 0);
        projectionMatrix.SetValue(2, 2, 0);


        return projectionMatrix;
    }

    public Matriz Get_Y_ProjectionMatrix() {
        int linhas = 4;
        int colunas = 4;
        Matriz translationMatrix = new Matriz(linhas, colunas);

        // montando a matriz base
        translationMatrix.SetValue(1, 1, 1);
        translationMatrix.SetValue(3, 3, 1);

        double yProjection = Math.toRadians(projection.y);
        translationMatrix.SetValue(0, 0, 0);
        translationMatrix.SetValue(0,2,yProjection);

        translationMatrix.SetValue(2, 0, 0);
        translationMatrix.SetValue(2, 2, 0);


        return translationMatrix;
    }

    public Matriz Get_Z_ProjectionMatrix() {
        int linhas = 4;
        int colunas = 4;
        Matriz translationMatrix = new Matriz(linhas, colunas);

        // montando a matriz base
        translationMatrix.SetValue(2, 2, 1);
        translationMatrix.SetValue(3, 3, 1);

        double zProjection = Math.toRadians(projection.z);
        translationMatrix.SetValue(0, 0, 0);
        translationMatrix.SetValue(0, 1, 0);

        translationMatrix.SetValue(1, 0, 0);
        translationMatrix.SetValue(1, 1, 0);


        return translationMatrix;
    }

    /*public Vector3 shear(Vector3 vector, double kx, double ky) {
    double[][] shearMatrixData = {{1, kx, 0}, {ky, 1, 0}, {0, 0, 1}};
    Matriz shearMatrix = new Matriz(shearMatrixData);

    double[] homogeneousVectorData = {vector.x, vector.y, vector.z, 1};
    Matriz homogeneousVector = new Matriz(homogeneousVectorData, 4);

    Matriz shearedHomogeneousVector = LinearAlgebra.Dot(shearMatrix, homogeneousVector);

    return new Vector3(shearedHomogeneousVector.GetValue(0, 0), shearedHomogeneousVector.GetValue(1, 0), shearedHomogeneousVector.GetValue(2, 0));
    }
*/
    public Matriz GetTransformationMatriz() {
    Matriz transformationMatrix = GetTranslationMatrix();
        
    transformationMatrix = LinearAlgebra.Dot(transformationMatrix, GetTranslationMatrix());

    transformationMatrix = LinearAlgebra.Dot(transformationMatrix, Get_Z_RotationMatrix());
    transformationMatrix = LinearAlgebra.Dot(transformationMatrix, Get_Y_RotationMatrix());
    transformationMatrix = LinearAlgebra.Dot(transformationMatrix, Get_X_RotationMatrix());

    transformationMatrix = LinearAlgebra.Dot(transformationMatrix, Get_X_ProjectionMatrix());
    transformationMatrix = LinearAlgebra.Dot(transformationMatrix, Get_Y_ProjectionMatrix());
    transformationMatrix = LinearAlgebra.Dot(transformationMatrix, Get_Z_ProjectionMatrix());

    return transformationMatrix;
    }
}