	package dao;
	
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ArrayList;
	import java.util.List;
	
	import connection.ConnectionMySQL;
	import modelos.Contato;
	
	public class ContatoDAO {
	
	    // create
	    public void create(Contato contato) {
	        System.out.println("*** CREATE ***");
	
	        String sql = "INSERT INTO Contato (ID_Contato, Mensagem, Email, Nome) values (?,?,?,?)";
	
	        Connection conn = null;
	        PreparedStatement pstm = null;
	
	        try {
	            conn = ConnectionMySQL.createConnectionMySQL();
	
	            pstm = conn.prepareStatement(sql);
	
	            pstm.setInt(1, contato.getID_Contato());
	            pstm.setString(2, contato.getMensagem());
	            pstm.setString(3, contato.getEmail());
	            pstm.setString(4, contato.getNome());
	
	            pstm.execute();
	
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (pstm != null) {
	                    pstm.close();
	                }
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }
	
	    // read
	    public List<Contato> read() {
	        List<Contato> contatos = new ArrayList<Contato>();
	
	        System.out.println("*** READ ***");
	
	        String sql = "SELECT * FROM Contato";
	
	        Connection conn = null;
	        PreparedStatement pstm = null;
	        ResultSet rset = null;
	
	        try {
	            conn = ConnectionMySQL.createConnectionMySQL();
	
	            pstm = conn.prepareStatement(sql);
	
	            rset = pstm.executeQuery();
	
	            while (rset.next()) {
	                Contato contato = new Contato();
	
	                contato.setID_Contato(rset.getInt("ID_Contato"));
	                contato.setMensagem(rset.getString("Mensagem"));
	                contato.setEmail(rset.getString("Email"));
	                contato.setNome(rset.getString("Nome"));
	
	                contatos.add(contato);
	            }
	
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (rset != null) {
	                    rset.close();
	                }
	                if (pstm != null) {
	                    pstm.close();
	                }
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	
	        return contatos;
	    }
	
	    // update
	    public void update(Contato contato) {
	        System.out.println("*** UPDATE ***");
	
	        String sql = "UPDATE Contato SET Mensagem=?, Email=?, Nome=? WHERE ID_Contato=?";
	
	        Connection conn = null;
	        PreparedStatement pstm = null;
	
	        try {
	            conn = ConnectionMySQL.createConnectionMySQL();
	
	            pstm = conn.prepareStatement(sql);
	
	            pstm.setString(1, contato.getMensagem());
	            pstm.setString(2, contato.getEmail());
	            pstm.setString(3, contato.getNome());
	            pstm.setInt(4, contato.getID_Contato());
	
	            pstm.execute();
	
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (pstm != null) {
	                    pstm.close();
	                }
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }
	
	    // delete
	    public void delete(int id) {
	        System.out.println("*** DELETE ***");
	
	        String sql = "DELETE FROM Contato WHERE ID_Contato=?";
	
	        Connection conn = null;
	        PreparedStatement pstm = null;
	
	        try {
	            conn = ConnectionMySQL.createConnectionMySQL();
	
	            pstm = conn.prepareStatement(sql);
	
	            pstm.setInt(1, id);
	
	            pstm.execute();
	
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (pstm != null) {
	                    pstm.close();
	                }
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }
	
	    // readById
	    public Contato readById(int id) {
	        System.out.println("*** READ BY ID ***");
	
	        String sql = "SELECT * FROM Contato WHERE ID_Contato=?";
	
	        Connection conn = null;
	        PreparedStatement pstm = null;
	        ResultSet rset = null;
	        Contato contato = new Contato();
	
	        try {
	            conn = ConnectionMySQL.createConnectionMySQL();
	
	            pstm = conn.prepareStatement(sql);
	
	            pstm.setInt(1, id);
	
	            rset = pstm.executeQuery();
	
	            while (rset.next()) {
	                contato.setID_Contato(rset.getInt("ID_Contato"));
	                contato.setMensagem(rset.getString("Mensagem"));
	                contato.setEmail(rset.getString("Email"));
	                contato.setNome(rset.getString("Nome"));
	            }
	
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (rset != null) {
	                    rset.close();
	                }
	                if (pstm != null) {
	                    pstm.close();
	                }
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	
	        return contato;
	    }
	}
