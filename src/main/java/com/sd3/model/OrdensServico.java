package com.sd3.model;

/**
 *
 * @author Ismael
 * @version 1.0
 */
public class OrdensServico {
    private int id;
    private String dataAbertura;
    private String status;
    private Cliente cliente; // Associação O.O. com o Objeto Cliente
    private Servico servico; // Associação O.O. com o Objeto Serviço

    // Atributos auxiliares para integração direta com a tabela ordens_servico do MySQL
    private int clienteId;
    private String nomeCliente;
    private String descricaoServico;
    private double valor;

    public OrdensServico() {}

    public OrdensServico(int id, String dataAbertura, String status, Cliente cliente, Servico servico) {
        this.id = id;
        this.dataAbertura = dataAbertura;
        this.status = status;
        this.cliente = cliente;
        this.servico = servico;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getDataAbertura() { return dataAbertura; }
    public void setDataAbertura(String dataAbertura) { this.dataAbertura = dataAbertura; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Servico getServico() { return servico; }
    public void setServico(Servico servico) { this.servico = servico; }

    // Getters e Setters para o DAO/Banco
    public int getClienteId() { return clienteId; }
    public void setClienteId(int clienteId) { this.clienteId = clienteId; }

    public String getNomeCliente() { return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }

    public String getDescricaoServico() { return descricaoServico; }
    public void setDescricaoServico(String descricaoServico) { this.descricaoServico = descricaoServico; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }
}
