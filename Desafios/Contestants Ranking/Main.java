import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    // Coded By
    // Breno Silva

    private static final int MAXIMO = (int) 1e9;

    static class Participante {
        String nome;
        List<Participante> conexoes = new ArrayList<>();
        int pontuacao = MAXIMO;

        Participante(String nome) {
            this.nome = nome;
        }

        void adicionarConexao(Participante participante) {
            if (!conexoes.contains(participante)) {
                conexoes.add(participante);
            }
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int casosDeTeste = entrada.nextInt();

        Map<String, Participante> mapeamento = new HashMap<>();

        while (casosDeTeste-- > 0) {
            int quantidadeConsultas = entrada.nextInt();
            mapeamento.clear();

            entrada.nextLine();
            for (int q = 0; q < quantidadeConsultas; q++) {
                String[] nomes = { entrada.next(), entrada.next(), entrada.next() };

                for (String nome : nomes) {
                    mapeamento.putIfAbsent(nome, new Participante(nome));
                }

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (i != j) {
                            mapeamento.get(nomes[i]).adicionarConexao(mapeamento.get(nomes[j]));
                        }
                    }
                }
            }

            if (mapeamento.containsKey("Ahmad")) {
                bfs(mapeamento.get("Ahmad"));
            }

            List<Participante> participantes = new ArrayList<>(mapeamento.values());
            participantes.sort(Comparator.comparingInt((Participante p) -> p.pontuacao).thenComparing(p -> p.nome));

            System.out.println(participantes.size());
            for (Participante participante : participantes) {
                System.out.print(participante.nome + " ");
                if (participante.pontuacao == MAXIMO) {
                    System.out.println("undefined");
                } else {
                    System.out.println(participante.pontuacao);
                }
            }
        }

        entrada.close();
    }

    private static void bfs(Participante inicio) {
        Queue<Participante> fila = new LinkedList<>();
        inicio.pontuacao = 0;
        fila.add(inicio);

        while (!fila.isEmpty()) {
            Participante atual = fila.poll();
            for (Participante vizinho : atual.conexoes) {
                if (vizinho.pontuacao == MAXIMO) {
                    vizinho.pontuacao = atual.pontuacao + 1;
                    fila.add(vizinho);
                }
            }
        }
    }
}
