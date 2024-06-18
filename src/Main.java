import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = criarCurso("curso java", "descrição curso java", 8);
        Curso curso2 = criarCurso("curso js", "descrição curso js", 4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().addAll(Arrays.asList(curso1, curso2, mentoria));

        inscreverEProgredirDev("Camila", bootcamp, 2);
        System.out.println("-");
        inscreverEProgredirDev("Joao", bootcamp, 3);
    }

    private static Curso criarCurso(String titulo, String descricao, int cargaHoraria) {
        Curso curso = new Curso();
        curso.setTitulo(titulo);
        curso.setDescricao(descricao);
        curso.setCargaHoraria(cargaHoraria);
        return curso;
    }

    private static void inscreverEProgredirDev(String nome, Bootcamp bootcamp, int progresso) {
        Dev dev = new Dev();
        dev.setNome(nome);
        dev.inscreverBootcamp(bootcamp);

        System.out.println("Conteúdos Inscritos " + nome + ": " + dev.getConteudosInscritos());

        for (int i = 0; i < progresso; i++) {
            dev.progredir();
        }

        System.out.println("Conteúdos Concluídos " + nome + ": " + dev.getConteudosConcluidos());
        System.out.println("XP " + nome + ": " + dev.calcularTotalXp());
    }
}
