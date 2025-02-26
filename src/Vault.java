import java.util.ArrayList;
import java.util.List;

public class Vault {
    private List<Sobrevivente> sobreviventes;
    private List<Recurso> recursos;
    private List<Missao> missoes;

    // Construtor
    public Vault() {
        this.sobreviventes = new ArrayList<>();
        this.recursos = new ArrayList<>();
        this.missoes = new ArrayList<>();
    }

    // Getters e Setters
    public List<Sobrevivente> getSobreviventes() {
        return sobreviventes;
    }

    public void setSobreviventes(List<Sobrevivente> sobreviventes) {
        this.sobreviventes = sobreviventes;
    }

    public void adicionarSobrevivente(Sobrevivente sobrevivente) {
        this.sobreviventes.add(sobrevivente);
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<Recurso> recursos) {
        this.recursos = recursos;
    }

    public void adicionarRecurso(Recurso recurso) {
        for (Recurso r : recursos) {
            if (r.getNome().equals(recurso.getNome())) {
                r.setQuantidade(r.getQuantidade() + recurso.getQuantidade());
                return;
            }
        }
        this.recursos.add(recurso);
    }

    public List<Missao> getMissoes() {
        return missoes;
    }

    public void setMissoes(List<Missao> missoes) {
        this.missoes = missoes;
    }

    public void adicionarMissao(Missao missao) {
        this.missoes.add(missao);
    }

    public boolean consumirRecurso(String nomeRecurso, int quantidade) {
        for (Recurso recurso : recursos) {
            if (recurso.getNome().equals(nomeRecurso)) {
                if (recurso.getQuantidade() >= quantidade) {
                    recurso.setQuantidade(recurso.getQuantidade() - quantidade);
                    if (recurso.getQuantidade() == 0) {
                        recursos.remove(recurso);
                    }
                    return true;
                } else {
                    return false; // Quantidade insuficiente
                }
            }
        }
        return false; // Recurso não encontrado
    }
}