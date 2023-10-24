package biblioteca_matrizes;
public class LinearAlgebra {
    public static Matriz Tranposta(Matriz matriz) {
        int linhas = matriz.GetLinhas();
        int colunas = matriz.GetColunas();

        Matriz transposta = new Matriz(colunas, linhas);

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                transposta.SetValue(j, i, matriz.GetValue(i, j));
            }
        }

        return transposta;
    }

    public static Matriz Times(Matriz matriz, double quantidade) {
        Matriz transposta = new Matriz(matriz);

        int linhas = transposta.GetLinhas();
        int colunas = transposta.GetColunas();

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                transposta.SetValue(i, j, matriz.GetValue(i, j) * quantidade);
            }
        }

        return transposta;
    }

    public static Vector Times(Vector vetor, double quantidade) {
        Matriz transposta = new Matriz(vetor);

        return new Vector(Times(transposta, quantidade));
    }

    public static Matriz Subtracao(Matriz matriz1, Matriz matriz2) {

        int linhas1 = matriz1.GetLinhas();
        int colunas1 = matriz1.GetColunas();
        int linhas2 = matriz2.GetLinhas();
        int colunas2 = matriz2.GetColunas();

        Matriz soma = new Matriz(linhas2, colunas2);

        for (int i = 0; i < linhas1; i++) {
            for (int j = 0; j < colunas1; j++) {
                soma.SetValue(i, j, matriz1.GetValue(i, j) - matriz2.GetValue(i, j));
            }
        }

        return soma;
    }

    public static Matriz Soma(Matriz matriz1, Matriz matriz2) {

        int linhas1 = matriz1.GetLinhas();
        int colunas1 = matriz1.GetColunas();
        int linhas2 = matriz2.GetLinhas();
        int colunas2 = matriz2.GetColunas();

        Matriz soma = new Matriz(linhas2, colunas2);

        for (int i = 0; i < linhas1; i++) {
            for (int j = 0; j < colunas1; j++) {
                soma.SetValue(i, j, matriz1.GetValue(i, j) + matriz2.GetValue(i, j));
            }
        }

        return soma;
    }

    public static Vector Soma(Vector vetor1, Vector vetor2) {

        Matriz matriz1 = new Matriz(vetor1);
        Matriz matriz2 = new Matriz(vetor2);

        return new Vector(Soma(matriz1, matriz2));
    }

    public static Matriz Multiplicacao(Matriz matriz1, Matriz matriz2) {
        int linhas1 = matriz1.GetLinhas();
        int colunas1 = matriz1.GetColunas();
        int linhas2 = matriz2.GetLinhas();
        int colunas2 = matriz2.GetColunas();

        if (linhas1 != linhas2 || colunas1 != colunas2) {
            throw new IllegalArgumentException("As matrizes devem ter o mesmo número de linhas e colunas.");
        }

        Matriz resultado = new Matriz(linhas1, colunas1);

        for (int i = 0; i < linhas1; i++) {
            for (int j = 0; j < colunas1; j++) {
                double valor = matriz1.GetValue(i, j) * matriz2.GetValue(i, j);
                resultado.SetValue(i, j, valor);
            }
        }

        return resultado;
    }

    public static Vector Multiplicacao(Vector vetor1, Vector vetor2) {
        Matriz matriz1 = new Matriz(vetor1);
        Matriz matriz2 = new Matriz(vetor2);

        return new Vector(Multiplicacao(matriz1, matriz2));
    }

    public static Vector3 Dot3(Matriz matriz1, Vector3 vector3 ) {
        Matriz matriz2 = new Matriz(3, 1);
        matriz2.SetValue(0, 0, vector3.x);
        matriz2.SetValue(1, 0, vector3.y);
        matriz2.SetValue(2, 0, vector3.z);


        int linhas1 = matriz1.GetLinhas();
        int colunas1 = matriz1.GetColunas();
        int linhas2 = matriz2.GetLinhas();
        int colunas2 = matriz2.GetColunas();
    
        if (colunas1 != linhas2) {
            throw new IllegalArgumentException("O número de colunas da matriz1 deve ser igual ao número de linhas da matriz2 para multiplicação.");
        }
    
        Matriz dot = new Matriz(linhas1, colunas2);
    
        for (int i = 0; i < linhas1; i++) {
            for (int j = 0; j < colunas2; j++) {
                double valor = 0.0;
                for (int k = 0; k < colunas1; k++) {
                    valor += matriz1.GetValue(i, k) * matriz2.GetValue(k, j);
                }
                dot.SetValue(i, j, valor);
            }
        }
        return new Vector3((int)dot.GetValue(0, 0), (int)dot.GetValue(1, 0), (int)dot.GetValue(2, 0));
    }

    public static Vector3 Dot(Matriz matriz1, Vector3 vector3 ) {
        Matriz matriz2 = new Matriz(4, 1);
        matriz2.SetValue(0, 0, vector3.x);
        matriz2.SetValue(1, 0, vector3.y);
        matriz2.SetValue(2, 0, vector3.z);
        matriz2.SetValue(3, 0, 1);


        int linhas1 = matriz1.GetLinhas();
        int colunas1 = matriz1.GetColunas();
        int linhas2 = matriz2.GetLinhas();
        int colunas2 = matriz2.GetColunas();
    
        if (colunas1 != linhas2) {
            throw new IllegalArgumentException("O número de colunas da matriz1 deve ser igual ao número de linhas da matriz2 para multiplicação.");
        }
    
        Matriz dot = new Matriz(linhas1, colunas2);
    
        for (int i = 0; i < linhas1; i++) {
            for (int j = 0; j < colunas2; j++) {
                double valor = 0.0;
                for (int k = 0; k < colunas1; k++) {
                    valor += matriz1.GetValue(i, k) * matriz2.GetValue(k, j);
                }
                dot.SetValue(i, j, valor);
            }
        }
        return new Vector3((int)dot.GetValue(0, 0), (int)dot.GetValue(1, 0), (int)dot.GetValue(2, 0));
    }

    public static Matriz Dot(Matriz matriz1, Matriz matriz2) {
        int linhas1 = matriz1.GetLinhas();
        int colunas1 = matriz1.GetColunas();
        int linhas2 = matriz2.GetLinhas();
        int colunas2 = matriz2.GetColunas();
    
        if (colunas1 != linhas2) {
            throw new IllegalArgumentException("O número de colunas da matriz1 deve ser igual ao número de linhas da matriz2 para multiplicação.");
        }
    
        Matriz dot = new Matriz(linhas1, colunas2);
    
        for (int i = 0; i < linhas1; i++) {
            for (int j = 0; j < colunas2; j++) {
                double valor = 0.0;
                for (int k = 0; k < colunas1; k++) {
                    valor += matriz1.GetValue(i, k) * matriz2.GetValue(k, j);
                }
                dot.SetValue(i, j, valor);
            }
        }
        return dot;

        
    }

    public static Vector Dot(Vector vetor1, Vector vetor2) {
        Matriz matriz1 = new Matriz(vetor1);
        Matriz matriz2 = new Matriz(vetor2);

        return new Vector(Dot(matriz1, matriz2));
    }


    public static Matriz Gauss(Matriz matriz) {
        Matriz solucao = new Matriz(matriz.GetLinhas(), 1);

        int n = matriz.GetLinhas();

        // Fase de Eliminação
        for (int k = 0; k < n - 1; k++) {
            for (int i = k + 1; i < n; i++) {
                double fator = matriz.GetValue(i, k) / matriz.GetValue(k, k);
                for (int j = k; j < n + 1; j++) {
                    matriz.SetValue(i, j, matriz.GetValue(i, j) - fator * matriz.GetValue(k, j));
                }
            }
        }

        // Fase de Solucao
        solucao.SetValue(n - 1, 0, matriz.GetValue(n-1, n) / matriz.GetValue(n-1, n-1));
        for (int i = n - 2; i >= 0; i--) {
            double soma = 0.0;
            for (int j = i + 1; j < n; j++) {
                soma += matriz.GetValue(i, j) * solucao.GetValue(j, 0);
            }
            solucao.SetValue(i, 0, (matriz.GetValue(i, n) - soma) / matriz.GetValue(i, i));
        }

        return solucao;
    }
}
