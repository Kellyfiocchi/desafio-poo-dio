package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev{
    private String nome;
    private Set<Conteudo>conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo>conteudosConcluidos = new LinkedHashSet<>();

    public void increverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
      Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
      if(conteudo.isPresent()) {
          this.conteudosConcluidos.add(conteudo.get());
          this.conteudosInscritos.remove(conteudo.get());
      }else {
          System.err.println("Voce nao esta matriculado em nenhum conteudo!");
      }
    }

    public double calcularTotalXp() {
      return this.conteudosConcluidos
              .stream()
              .mapToDouble(conteudo -> conteudo.calcularXp())
              .sum();
    }

    public String getNome() {
        return nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }

    public void setNone(String camila) {
    }
}

