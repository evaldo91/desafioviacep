package br.com.evaldo.desafioviacep.entradas;

public class Endereco {
    private int cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;



    public Endereco(int numero) {
        this.cep = numero;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }

    public Endereco(JsonCep meuCep) {
        this.cep = Integer.valueOf(meuCep.cep().replace("-", ""));
        this.logradouro = meuCep.logradouro();
        this.bairro = meuCep.bairro();
        this.localidade = meuCep.localidade();
        this.uf = meuCep.uf();
    }

    @Override
    public String toString() {
        return "Seu cep = " + this.cep + "\n" +
                "Logradouro = " + this.logradouro +  "\n" +
                "Bairro = " + this.bairro + "\n" +
                "Localidade = " + this.localidade + "\n" +
                "Estado = " + this.uf
                ;
    }
}
