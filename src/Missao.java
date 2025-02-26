import java.util.ArrayList;
import java.util.List;

public class Missao {
    private String nome;
    private String objetivo;
    private String local;
    private List<Sobrevivente> listaDeSobreviventes;
    private List<Recurso> listaDeRecursosColetados;
    private String status;

    public Missao(String nome, String objetivo, String local, String status) {
        this.nome = nome;
        this.objetivo = objetivo;
        this.local = local;
        this.listaDeSobreviventes = new ArrayList<>();
        this.listaDeRecursosColetados = new ArrayList<>();
        setStatus(status);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public List<Sobrevivente> getListaDeSobreviventes() {
        return listaDeSobreviventes;
    }

    public void setListaDeSobreviventes(List<Sobrevivente> listaDeSobreviventes) {
        this.listaDeSobreviventes = listaDeSobreviventes;
    }

    public void adicionarSobrevivente(Sobrevivente sobrevivente) {
        this.listaDeSobreviventes.add(sobrevivente);
    }

    public List<Sobrevivente> getSobreviventes() {
        return listaDeSobreviventes;
    }

    public List<Recurso> getListaDeRecursosColetados() {
        return listaDeRecursosColetados;
    }

    public void setListaDeRecursosColetados(List<Recurso> listaDeRecursosColetados) {
        this.listaDeRecursosColetados = listaDeRecursosColetados;
    }

    public void adicionarRecurso(Recurso recurso) {
        this.listaDeRecursosColetados.add(recurso);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}