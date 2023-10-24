package biblioteca_matrizes;
import java.util.Scanner;
public class Matriz {
    private double[][] dados;
    private int linhas;
    private int colunas;

    public Matriz(int _linhas, int _colunas) {
        linhas = _linhas;
        colunas = _colunas;
        dados = new double[linhas][colunas];
        FillZero();
    }

    public Matriz(Vector vetor) {
        linhas = vetor.getDimensao();
        colunas = 1;
        dados = new double[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                dados[i][j] = vetor.GetValue(i);
            }
        }
    }

    public Matriz(Matriz matriz) {
        linhas = matriz.GetLinhas();
        colunas = matriz.GetColunas();
        dados = new double[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                dados[i][j] = matriz.GetValue(i, j);
            }
        }
    }

    public int GetLinhas() {
        return linhas;
    }

    public int GetColunas() {
        return colunas;
    }

    public double GetValue(int linha, int coluna) {
        return dados[linha][coluna];
    }

    public void SetValue(int linha, int coluna, double dado) {
        dados[linha][coluna] = dado;
    }

    public void FillRandom(float escala) {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                dados[i][j] = (Math.random() - 0.5) * escala;
            }
        }
    }

    public void FillInput(Scanner sc) {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.println(String.format("Digite o valor(%d, %d): ", i, j));
                dados[i][j] = sc.nextFloat();
            }
        }
    }

    public void FillZero() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                dados[i][j] = 0;
            }
        }
    }

    public void FillIdentidade() {
        if (linhas != colunas) {
            return;
        }

        for (int i = 0; i < linhas; i++) {
            dados[i][i] = 1;
        }
    }

    public String toString() {
        String matriz_string = "";

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz_string += dados[i][j];
                matriz_string += " | ";
            }
            matriz_string += "\n";
        }

        return matriz_string;
    }
}
