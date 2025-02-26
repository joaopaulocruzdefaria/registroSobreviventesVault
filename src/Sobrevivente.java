public class Sobrevivente extends Pessoa {
    private String[] habilidades;
    private int quantidadeHabilidades;
    private String Status;


    public Sobrevivente(String nome, int idade, String identificador, String status, String[] habilidades) {
        super(nome, idade, identificador);
        this.habilidades = new String[3];
        this.quantidadeHabilidades = 0;
        this.Status = status;
        for (String habilidade : habilidades) {
            if (habilidade != null) {
                this.habilidades[this.quantidadeHabilidades++] = habilidade;
            }
        }
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public boolean adicionarHabilidade(String habilidade) {
        if (quantidadeHabilidades < 3 ) {
            habilidades[quantidadeHabilidades] = habilidade;
            quantidadeHabilidades++;
            return true;
        }
        return false;
    }

    public boolean removerHabilidade(String habilidade) {
        for (int i = 0; i < quantidadeHabilidades; i++) {
            if (habilidades[i].equals(habilidade)) {
                habilidades[i] = habilidades[quantidadeHabilidades - 1];
                habilidades[quantidadeHabilidades - 1] = null;
                quantidadeHabilidades--;
                return true;
            }
        }
        return false;
    }

    public void incrementarQuantidadeHabilidades() {
        quantidadeHabilidades++;
    }

    public String[] getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String[] habilidades) {
        this.habilidades = habilidades;
    }

    public int getQuantidadeHabilidades() {
        return quantidadeHabilidades;
    }

    public void setQuantidadeHabilidades(int quantidadeHabilidades) {
        this.quantidadeHabilidades = quantidadeHabilidades;
    }
}
