package com.sd3.dao;

import com.sd3.model.OrdensServico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdemServicoDAO {

    public boolean inserir(OrdensServico os) {
        String sql = "INSERT INTO ordens_servico (cliente_id, servico, valor, status) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, os.getClienteId());
            stmt.setString(2, os.getDescricaoServico());
            stmt.setDouble(3, os.getValor());
            stmt.setString(4, os.getStatus());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Erro ao inserir O.S.: " + e.getMessage());
            return false;
        }
    }

    public List<OrdensServico> listarTodas() {
        List<OrdensServico> lista = new ArrayList<>();
        String sql = "SELECT os.id, os.cliente_id, c.nome AS nome_cliente, os.servico, os.valor, os.status " +
                     "FROM ordens_servico os " +
                     "INNER JOIN clientes c ON os.cliente_id = c.id " +
                     "ORDER BY os.id ASC";

        try (Connection conn = ConexaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                OrdensServico os = new OrdensServico();
                os.setId(rs.getInt("id"));
                os.setClienteId(rs.getInt("cliente_id"));
                os.setNomeCliente(rs.getString("nome_cliente"));
                os.setDescricaoServico(rs.getString("servico"));
                os.setValor(rs.getDouble("valor"));
                os.setStatus(rs.getString("status"));
                lista.add(os);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar O.S.: " + e.getMessage());
        }
        return lista;
    }

    public boolean atualizar(OrdensServico os) {
        String sql = "UPDATE ordens_servico SET servico = ?, valor = ?, status = ? WHERE id = ?";

        try (Connection conn = ConexaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, os.getDescricaoServico());
            stmt.setDouble(2, os.getValor());
            stmt.setString(3, os.getStatus());
            stmt.setInt(4, os.getId());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar O.S.: " + e.getMessage());
            return false;
        }
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM ordens_servico WHERE id = ?";

        try (Connection conn = ConexaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Erro ao excluir O.S.: " + e.getMessage());
            return false;
        }
    }
    // Contar total de clientes cadastrados
    public int contarClientes() {
        String sql = "SELECT COUNT(*) FROM clientes";
        try (Connection conn = ConexaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            System.err.println("Erro ao contar clientes: " + e.getMessage());
        }
        return 0;
    }

    // Contar Ordens de Serviço com status 'Aberta'
    public int contarOSAbertas() {
        String sql = "SELECT COUNT(*) FROM ordens_servico WHERE status = 'Aberta'";
        try (Connection conn = ConexaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            System.err.println("Erro ao contar O.S. abertas: " + e.getMessage());
        }
        return 0;
    }

    // Somar o valor das Ordens de Serviço com status 'Concluída'
    public double calcularFaturamentoConcluido() {
        String sql = "SELECT COALESCE(SUM(valor), 0) FROM ordens_servico WHERE status = 'Concluída'";
        try (Connection conn = ConexaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) return rs.getDouble(1);
        } catch (SQLException e) {
            System.err.println("Erro ao calcular faturamento: " + e.getMessage());
        }
        return 0.0;
    }
}