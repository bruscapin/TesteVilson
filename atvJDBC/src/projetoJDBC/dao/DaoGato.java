package projetoJDBC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projetoJDBC.entidades.Gato;
import projetoJDBC.interfaces.ICrud;
import projetoJDBC.utilidades.Conexao;

public class DaoGato implements ICrud <Gato> {

	@Override
	public boolean salvar(Gato obj) {
		String sql ="insert into gato(nome, cor, sexo)values(?,?,?)";
		Connection con = Conexao.conectar();
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1,obj.getNome());
			stm.setString(2,obj.getCor());
			stm.setString(3,obj.getSexo());
			stm.execute();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		finally {
			Conexao.fechar());
		}
		return true;
		
	}

	@Override
	public boolean alterar(Gato obj) {
		
		String sql = "update gato set "+
                "nome = ?,"+
                "cor = ?,"+
                "sexo = ? "+
                "where id = ?";
        Connection con = Conexao.conectar();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, obj.getNome());
            stm.setString(2, obj.getCor());
            stm.setString(3, obj.getSexo());
            stm.setInt(4, obj.getId());
            stm.execute();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        finally {
            Conexao.fechar();
        }
        return true;
	}

	@Override
	public void excluir(int id) {
		
		String sql = "delete from gato where id = " + id;
        Connection con = Conexao.conectar();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            Conexao.fechar();
        }
	}

	@Override
	public Gato consultar(int id) {
		
		Gato gato = new Gato();
        String sql = "select * from gato where id= " + id;
        Connection con = Conexao.conectar();        
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                gato.setId(rs.getInt("id"));
                gato.setNome(rs.getString("nome"));
                gato.setCor(rs.getString("cor"));
                gato.setSexo(rs.getString("sexo"));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            Conexao.fechar();
        }
        return gato;
	}

	@Override
	public List<Gato> consultar() {
	
		List<Gato> gatos = new ArrayList<>();
        String sql = "select * from gato";
        
        Connection con = Conexao.conectar();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
                Gato gato = new Gato();
                gato.setId(rs.getInt("id"));
                gato.setNome(rs.getString("nome"));
                gato.setCor(rs.getString("cor"));
                gato.setSexo(rs.getString("sexo"));
                gatos.add(gato);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            Conexao.fechar();
        }
        return gatos;
	}

}
