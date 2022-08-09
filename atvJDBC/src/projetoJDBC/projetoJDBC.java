package projetoJDBC;

import projetoJDBC.dao.DaoGato;
import projetoJDBC.entidades.Gato;
import projetoJDBC.utilidades.Conexao;

public class projetoJDBC {
	public static void main (String[]args) {
	
	Gato g1 = new Gato("Tobias","Preto","Masculino");
	DaoGato dg = new DaoGato();
	if(dg.salvar(g1)) {
		System.out.println("Gato cadastrado com sucesso");
	}
	}
}



/*if(Conexao.conectar()!=null) {
System.out.println( "Conectado");
}
else {
System.out.println( "Erro ao conectar");}*/


