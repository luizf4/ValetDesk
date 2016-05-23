package br.metodista.ead.ads3.model;

import java.util.Date;

/**
 *
 * @author Luiz Fernando de Souza 
 * Matricula: 225272 
 * ADS - EAD - Polo Sorocaba
 */
public class Valet {

    private Long id;
    private String modelo;
    private String placa;
    private Date entrada;
    private Date saida;
    private Double valor;

    public Valet() {

    }
    
    public Valet(Long id, String modelo, String placa, Date entrada) {
        this.id = id;
        this.modelo = modelo;
        this.placa = placa;
        this.entrada = entrada;

    }

    public Valet(String modelo, String placa, Date entrada) {

        this.modelo = modelo;
        this.placa = placa;
        this.entrada = entrada;

    }

    public Valet(Long id, String modelo, String placa, Date entrada, Date saida, Double valor) {
        this.id = id;
        this.modelo = modelo;
        this.placa = placa;
        this.entrada = entrada;
        this.saida = saida;
        this.valor = valor;
    }    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getSaida() {
        return saida;
    }

    public void setSaida(Date saida) {
        this.saida = saida;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "id=" + id + "\nmodelo=" + modelo + "\nplaca=" 
                + placa + "\nentrada=" + entrada + "\nsaida=" + saida 
                + "\nvalor=" + valor + "\n__________________________\n";
    }

    
    
}
