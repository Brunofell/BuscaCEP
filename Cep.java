public class Cep {
    double cep;
    String logradouro;
    String bairro;
    String localidade;
    String uf;

    public Cep(double cep, String logradouro, String bairro, String localidade, String uf) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }

    public double getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setCep(double cep) {
        this.cep = cep;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "ConsultaCEP{" + "cep=" + cep + ", logradouro='" + logradouro + '\'' + ", bairro='" + bairro + '\'' + ", localidade='" + localidade + '\'' + ", uf='" + uf + '\'' + '}';
    }
}
