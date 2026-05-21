package apoio;

import java.sql.Connection;
import java.sql.Statement;
import apoio.ConexaoBD;

public class TablesInsertionDB {
    
    static Connection conexao = null;
    
    private static final String _createCliente = "CREATE TABLE IF NOT EXISTS cliente (" +
                                            "	id serial4 NOT NULL," +
                                            "	nome varchar(150) NOT NULL," +
                                            "	email varchar(45) NOT NULL," +
                                            "	cpf varchar(45) NOT NULL," +
                                            "	telefone varchar(45) NULL," +
                                            "	last_modification timestamp NOT NULL DEFAULT NOW()," +
                                            "	CONSTRAINT cliente_pk PRIMARY KEY (id)," +
                                            "	CONSTRAINT cliente_email_un UNIQUE (email)," +
                                            "	CONSTRAINT cliente_cpf_un UNIQUE (cpf));";

    private static final String _createEndereco = "CREATE TABLE IF NOT EXISTS endereco (" +
                                                 "	id serial4 NOT NULL," +
                                                 "	descricao varchar(45) NOT NULL," +
                                                 "	cep varchar(10) NOT NULL," +
                                                 "	last_modification timestamp NOT NULL DEFAULT NOW()," +
                                                 "	CONSTRAINT endereco_pk PRIMARY KEY (id));";

    private static final String _createFornecedor = "CREATE TABLE IF NOT EXISTS fornecedor (" +
                                                   "	id serial4 NOT NULL," +
                                                   "	nome varchar(150) NOT NULL," +
                                                   "	email varchar(45) NOT NULL," +
                                                   "	telefone varchar(45) NULL," +
                                                   "	cnpj varchar(45) NOT NULL," +
                                                   "	last_modification timestamp NOT NULL DEFAULT NOW()," +
                                                   "	CONSTRAINT fornecedor_pk PRIMARY KEY (id)," +
                                                   "	CONSTRAINT fornecedor_email_un UNIQUE (email)," +
                                                   "	CONSTRAINT fornecedor_cnpj_un UNIQUE (cnpj));";

    private static final String _createProduto = "CREATE TABLE IF NOT EXISTS produto (" +
                                                "	id serial4 NOT NULL," +
                                                "	descricao varchar(150) NOT NULL," +
                                                "	valor_unitario decimal(10,2) NOT NULL," +
                                                "	qtde_estoque int4 NOT NULL," +
                                                "	last_modification timestamp NOT NULL DEFAULT NOW()," +
                                                "	CONSTRAINT produto_pk PRIMARY KEY (id));";

    private static final String _createClienteEndereco = "CREATE TABLE IF NOT EXISTS cliente_endereco (" +
                                                         "	id serial4 NOT NULL," +
                                                         "	cliente_id int4 NOT NULL," +
                                                         "	endereco_id int4 NOT NULL," +
                                                         "	last_modification timestamp NOT NULL DEFAULT NOW()," +
                                                         "	CONSTRAINT cliente_endereco_pk PRIMARY KEY (id)," +
                                                         "	CONSTRAINT fk_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id)," +
                                                         "	CONSTRAINT fk_endereco FOREIGN KEY (endereco_id) REFERENCES endereco(id));";

    private static final String _createCompra = "CREATE TABLE IF NOT EXISTS compra (" +
                                               "	id serial4 NOT NULL," +
                                               "	data varchar(45) NOT NULL," +
                                               "	fornecedor_id int4 NOT NULL," +
                                               "	last_modification timestamp NOT NULL DEFAULT NOW()," +
                                               "	CONSTRAINT compra_pk PRIMARY KEY (id)," +
                                               "	CONSTRAINT fk_fornecedor FOREIGN KEY (fornecedor_id) REFERENCES fornecedor(id));";

    private static final String _createPedido = "CREATE TABLE IF NOT EXISTS pedido (" +
                                               "	id serial4 NOT NULL," +
                                               "	data varchar(45) NOT NULL," +
                                               "	endereco_entrega varchar(45) NOT NULL," +
                                               "	observacao varchar(500) NULL," +
                                               "	cliente_id int4 NOT NULL," +
                                               "	last_modification timestamp NOT NULL DEFAULT NOW()," +
                                               "	CONSTRAINT pedido_pk PRIMARY KEY (id)," +
                                               "	CONSTRAINT fk_cliente_pedido FOREIGN KEY (cliente_id) REFERENCES cliente(id));";

    private static final String _createItemCompra = "CREATE TABLE IF NOT EXISTS item_compra (" +
                                                    "	id serial4 NOT NULL," +
                                                    "	compra_id int4 NOT NULL," +
                                                    "	produto_id int4 NOT NULL," +
                                                    "	qtde double precision NOT NULL," +
                                                    "	valor decimal(10,2) NOT NULL," +
                                                    "	last_modification timestamp NOT NULL DEFAULT NOW()," +
                                                    "	CONSTRAINT item_compra_pk PRIMARY KEY (id)," +
                                                    "	CONSTRAINT fk_compra FOREIGN KEY (compra_id) REFERENCES compra(id)," +
                                                    "	CONSTRAINT fk_produto_compra FOREIGN KEY (produto_id) REFERENCES produto(id));";

    private static final String _createItemPedido = "CREATE TABLE IF NOT EXISTS item_pedido (" +
                                                    "	id serial4 NOT NULL," +
                                                    "	produto_id int4 NOT NULL," +
                                                    "	pedido_id int4 NOT NULL," +
                                                    "	qtde double precision NOT NULL," +
                                                    "	valor_item decimal(10,2) NOT NULL," +
                                                    "	last_modification timestamp NOT NULL DEFAULT NOW()," +
                                                    "	CONSTRAINT item_pedido_pk PRIMARY KEY (id)," +
                                                    "	CONSTRAINT fk_produto_pedido FOREIGN KEY (produto_id) REFERENCES produto(id)," +
                                                    "	CONSTRAINT fk_pedido FOREIGN KEY (pedido_id) REFERENCES pedido(id));";
    
    public static boolean CreateTables() throws Exception {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            st.executeUpdate(_createCliente);
            st.executeUpdate(_createEndereco);
            st.executeUpdate(_createFornecedor);
            st.executeUpdate(_createProduto);
            st.executeUpdate(_createClienteEndereco);
            st.executeUpdate(_createCompra);
            st.executeUpdate(_createPedido);
            st.executeUpdate(_createItemCompra);
            st.executeUpdate(_createItemPedido);
            
            return true;

        } catch (Exception e) {
            System.err.println("Erro ao tentar criar tabelas: " + e);
            throw e;
        }
    }
}
