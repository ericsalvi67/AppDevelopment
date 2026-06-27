package apoio;

import java.sql.Connection;
import java.sql.Statement;
import apoio.ConexaoBD;

public class TablesInsertionDB {

        static Connection conexao = null;
        
        private static final String _createUsuario = 
            "CREATE TABLE IF NOT EXISTS usuario (" +
            "	id serial4 NOT NULL," +
            "	email varchar(45) NOT NULL," +
            "	senha varchar(255) NOT NULL," +
            "	situacao varchar(1) NULL," +
            "	last_modification timestamp NOT NULL DEFAULT NOW()," +
            "	CONSTRAINT usuario_pk PRIMARY KEY (id)," +
            "	CONSTRAINT usuario_email_un UNIQUE (email));";

        private static final String _createCliente = 
            "CREATE TABLE IF NOT EXISTS cliente (" +
            "	id serial4 NOT NULL," +
            "	nome varchar(150) NOT NULL," +
            "	email varchar(45) NOT NULL," +
            "	cpf varchar(45) NOT NULL," +
            "	telefone varchar(45) NULL," +
            "	last_modification timestamp NOT NULL DEFAULT NOW()," +
            "	CONSTRAINT cliente_pk PRIMARY KEY (id)," +
            "	CONSTRAINT cliente_email_un UNIQUE (email)," +
            "	CONSTRAINT cliente_cpf_un UNIQUE (cpf));";

        private static final String _createEndereco = 
            "CREATE TABLE IF NOT EXISTS endereco (" +
            "	id serial4 NOT NULL," +
            "	descricao varchar(45) NOT NULL," +
            "	cep varchar(10) NOT NULL," +
            "	last_modification timestamp NOT NULL DEFAULT NOW()," +
            "	CONSTRAINT endereco_pk PRIMARY KEY (id));";

        private static final String _createFornecedor = 
            "CREATE TABLE IF NOT EXISTS fornecedor (" +
            "	id serial4 NOT NULL," +
            "	nome varchar(150) NOT NULL," +
            "	email varchar(45) NOT NULL," +
            "	telefone varchar(45) NULL," +
            "	cnpj varchar(45) NOT NULL," +
            "	last_modification timestamp NOT NULL DEFAULT NOW()," +
            "	CONSTRAINT fornecedor_pk PRIMARY KEY (id)," +
            "	CONSTRAINT fornecedor_email_un UNIQUE (email)," +
            "	CONSTRAINT fornecedor_cnpj_un UNIQUE (cnpj));";

        private static final String _createProduto = 
            "CREATE TABLE IF NOT EXISTS produto (" +
            "	id serial4 NOT NULL," +
            "	descricao varchar(150) NOT NULL," +
            "	valor_unitario decimal(10,2) NOT NULL," +
            "	qtde_estoque int4 NOT NULL," +
            "	last_modification timestamp NOT NULL DEFAULT NOW()," +
            "	CONSTRAINT produto_pk PRIMARY KEY (id));";

        private static final String _createClienteEndereco = 
            "CREATE TABLE IF NOT EXISTS cliente_endereco (" +
            "	id serial4 NOT NULL," +
            "	cliente_id int4 NOT NULL," +
            "	endereco_id int4 NOT NULL," +
            "	last_modification timestamp NOT NULL DEFAULT NOW()," +
            "	CONSTRAINT cliente_endereco_pk PRIMARY KEY (id)," +
            "	CONSTRAINT fk_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id)," +
            "	CONSTRAINT fk_endereco FOREIGN KEY (endereco_id) REFERENCES endereco(id));";

        private static final String _createCompra = 
            "CREATE TABLE IF NOT EXISTS compra (" +
            "	id serial4 NOT NULL," +
            "	data varchar(45) NOT NULL," +
            "	fornecedor_id int4 NOT NULL," +
            "	last_modification timestamp NOT NULL DEFAULT NOW()," +
            "	CONSTRAINT compra_pk PRIMARY KEY (id)," +
            "	CONSTRAINT fk_fornecedor FOREIGN KEY (fornecedor_id) REFERENCES fornecedor(id));";

        private static final String _createPedido = 
            "CREATE TABLE IF NOT EXISTS pedido (" +
            "	id serial4 NOT NULL," +
            "	data varchar(45) NOT NULL," +
            "	endereco_entrega varchar(45) NOT NULL," +
            "	observacao varchar(500) NULL," +
            "	cliente_id int4 NOT NULL," +
            "	last_modification timestamp NOT NULL DEFAULT NOW()," +
            "	CONSTRAINT pedido_pk PRIMARY KEY (id)," +
            "	CONSTRAINT fk_cliente_pedido FOREIGN KEY (cliente_id) REFERENCES cliente(id));";

        private static final String _createItemCompra = 
            "CREATE TABLE IF NOT EXISTS item_compra (" +
            "	id serial4 NOT NULL," +
            "	compra_id int4 NOT NULL," +
            "	produto_id int4 NOT NULL," +
            "	qtde double precision NOT NULL," +
            "	valor decimal(10,2) NOT NULL," +
            "	last_modification timestamp NOT NULL DEFAULT NOW()," +
            "	CONSTRAINT item_compra_pk PRIMARY KEY (id)," +
            "	CONSTRAINT fk_compra FOREIGN KEY (compra_id) REFERENCES compra(id)," +
            "	CONSTRAINT fk_produto_compra FOREIGN KEY (produto_id) REFERENCES produto(id));";

        private static final String _createItemPedido = 
            "CREATE TABLE IF NOT EXISTS item_pedido (" +
            "	id serial4 NOT NULL," +
            "	produto_id int4 NOT NULL," +
            "	pedido_id int4 NOT NULL," +
            "	qtde double precision NOT NULL," +
            "	valor_item decimal(10,2) NOT NULL," +
            "	last_modification timestamp NOT NULL DEFAULT NOW()," +
            "	CONSTRAINT item_pedido_pk PRIMARY KEY (id)," +
            "	CONSTRAINT fk_produto_pedido FOREIGN KEY (produto_id) REFERENCES produto(id)," +
            "	CONSTRAINT fk_pedido FOREIGN KEY (pedido_id) REFERENCES pedido(id));";
        
        private static final String INSERT_CLIENTE=
            "INSERT INTO cliente (nome,email,telefone,cpf) VALUES"
            + "('Beatriz Almeida','beatriz.almeida@email.com','(82) 6 4153-7902','519.912.345-05'),"
            + "('Camila Santos','camila.santos@email.com','(50) 2 7419-6385','519.912.345-03'),"
            + "('Eduardo Nunes','eduardo.nunes@email.com','(78) 4 1203-6958','519.912.345-10'),"
            + "('Gabriel Ferreira','gabriel.ferreira@email.com','(74) 1 2589-6310','519.912.345-02'),"
            + "('Henrique Martins','henrique.m@email.com','(64) 7 2819-5300','519.912.345-06'),"
            + "('Isabela Rocha','isabela.rocha@email.com','(31) 0 9478-5622','519.912.345-07'),"
            + "('Mariana Oliveira','mariana.oliveira@email.com','(32) 8 4519-7010','519.912.345-01'),"
            + "('Rafael Costa','rafael.costa@email.com','(19) 3 8475-6210','519.912.345-04'),"
            + "('Vinicius Lopes','vinicius.lopes@email.com','(90) 5 1726-3841','519.912.345-08'),"
            + "('Larissa Duarte','larissa.duarte@email.com','(43) 8 1205-9763','519.912.345-09')";


        private static final String INSERT_ENDERECO=
            "INSERT INTO endereco (descricao,cep) VALUES "
            +"('Rua das Araucárias, 125 - Centro','95.185-000'),"
            +"('Av. Independência, 890','95.010-010'),"
            +"('Rua Bento Gonçalves, 44','95.700-020'),"
            +"('Rua Flores da Cunha, 77','95.020-030'),"
            +"('Av. Rio Branco, 1540','90.010-000'),"
            +"('Rua Tiradentes, 230','95.750-010'),"
            +"('Rua Dom Pedro II, 412','95.050-040'),"
            +"('Av. Brasil, 998','95.600-000'),"
            +"('Rua São José, 58','95.170-000'),"
            +"('Rua Itália, 150','95.185-090');";

        private static final String INSERT_FORNECEDOR=
            "INSERT INTO fornecedor (nome,email,telefone,cnpj) VALUES"
            +"	 ('Sul Mix','financeiro@sulmix.com','(54) 3 3811-009 ','12.845.001/0001-09')," 
            +"	 ('Alimentos Horizonte','vendas@horizonte.com','(51) 3 0221-102 ','12.845.001/0001-02'),"
            +"	 ('Bom Sabor Atacado','atendimento@bomsabor.com','(54) 3 3811-004 ','12.845.001/0001-04')," 
            +"	 ('Casa do Atacado','vendas@casaatacado.com','(54) 3 3811-008 ','12.845.001/0001-08')," 
            +"	 ('Comercial Estrela','contato@estrela.com','(54) 3 3811-010 ','12.845.001/0001-10')," 
            +"	 ('Distribuidora Serra Sul','contato@serrasul.com','(54) 3 3811-001 ','12.845.001/0001-01')," 
            +"	 ('Mercantil Gaúcha','comercial@gaucha.com','(54) 3 3811-003 ','12.845.001/0001-03')," 
            +"	 ('Norte Comercial','vendas@norte.com','(54) 3 3811-006 ','12.845.001/0001-06')," 
            +"	 ('Premium Foods','contato@premium.com','(54) 3 3811-007 ','12.845.001/0001-07')," 
            +"	 ('Vale Distribuição','contato@vale.com','(54) 3 3811-005 ','12.845.001/0001-05')";

        private static final String INSERT_PRODUTO=
            "INSERT INTO produto (descricao,valor_unitario,qtde_estoque) VALUES "
            +"('Arroz Branco Tipo 1 5kg',36.90,120),"
            + "('Feijão Preto 1kg',9.40,180),"
            + "('Macarrão Espaguete 500g',7.50,210),"
            + "('Café Torrado 500g',21.90,90),"
            + "('Açúcar Cristal 5kg',23.90,110),"
            + "('Leite Integral 1L',5.99,350),"
            + "('Óleo de Soja 900ml',8.29,170),"
            + "('Farinha de Trigo 5kg',18.50,95),"
            + "('Refrigerante Cola 2L',10.99,130),"
            + "('Biscoito Recheado Chocolate',4.79,260);";

        private static final String INSERT_CLIENTE_ENDERECO=
            "INSERT INTO cliente_endereco (cliente_id,endereco_id) VALUES "
            + "(1,1),"
            + "(2,2),"
            + "(3,3),"
            + "(4,4),"
            + "(5,5),"
            + "(6,6),"
            + "(7,7),"
            + "(8,8),"
            + "(9,9),"
            + "(10,10);";
        
        private static final String INSERT_COMPRA=
            "INSERT INTO compra (data,fornecedor_id) VALUES "
            + "('01/06/2026',1),"
            + "('03/06/2026',2),"
            + "('05/06/2026',3),"
            + "('07/06/2026',4),"
            + "('09/06/2026',5),"
            + "('11/06/2026',6),"
            + "('13/06/2026',7),"
            + "('15/06/2026',8),"
            + "('17/06/2026',9),"
            + "('19/06/2026',10);";
        
        private static final String INSERT_PEDIDO=
            "INSERT INTO pedido (data,endereco_entrega,observacao,cliente_id) VALUES "
            +"('02/06/2026','Rua das Araucárias, 125','Entregar pela manhã',1),"
            +"('04/06/2026','Av. Independência, 890','',2),"
            +"('06/06/2026','Rua Bento Gonçalves, 44','Interfone 12',3),"
            +"('08/06/2026','Rua Flores da Cunha, 77','',4),"
            +"('10/06/2026','Av. Rio Branco, 1540','Deixar na portaria',5),"
            +"('12/06/2026','Rua Tiradentes, 230','',6),"
            +"('14/06/2026','Rua Dom Pedro II, 412','',7),"
            +"('16/06/2026','Av. Brasil, 998','Casa azul',8),"
            +"('18/06/2026','Rua São José, 58','',9),"
            +"('20/06/2026','Rua Itália, 150','Fundos',10);";
        
        private static final String INSERT_ITEM_COMPRA=
            "INSERT INTO item_compra (compra_id,produto_id,qtde,valor) VALUES "
            + "(1,1,20,36.90),"
            + "(1,4,15,21.90),"
            + "(2,2,30,9.40),"
            + "(2,6,50,5.99),"
            + "(3,3,40,7.50),"
            + "(3,7,25,8.29),"
            + "(4,5,18,23.90),"
            + "(4,8,20,18.50),"
            + "(5,9,35,10.99),("
            + "5,10,60,4.79),"
            + "(6,1,15,36.90),"
            + "(7,2,25,9.40),"
            + "(8,3,20,7.50),"
            + "(9,4,12,21.90),"
            + "(10,5,14,23.90);";
        
        private static final String INSERT_ITEM_PEDIDO=
            "INSERT INTO item_pedido (produto_id,pedido_id,qtde,valor_item) VALUES "
            + "(1,1,2,73.80),"
            + "(4,1,1,21.90),"
            + "(2,2,3,28.20),"
            + "(6,2,12,71.88),"
            + "(3,3,4,30.00),"
            + "(9,3,2,21.98),"
            + "(5,4,1,23.90),"
            + "(8,4,1,18.50),"
            + "(10,5,5,23.95),"
            + "(7,5,3,24.87),"
            + "(1,6,1,36.90),"
            + "(2,7,2,18.80),"
            + "(3,8,2,15.00),"
            + "(4,9,1,21.90),"
            + "(5,10,2,47.80);";

        public static boolean CreateTables() throws Exception {
            try {
                    Statement st = ConexaoBD.getInstance().getConnection().createStatement();

                    st.executeUpdate(_createUsuario);
                    st.executeUpdate(_createCliente);
                    st.executeUpdate(_createEndereco);
                    st.executeUpdate(_createFornecedor);
                    st.executeUpdate(_createProduto);
                    st.executeUpdate(_createClienteEndereco);
                    st.executeUpdate(_createCompra);
                    st.executeUpdate(_createPedido);
                    st.executeUpdate(_createItemCompra);
                    st.executeUpdate(_createItemPedido);
                    
//                    st.executeUpdate(INSERT_CLIENTE);
//                    st.executeUpdate(INSERT_ENDERECO);
//                    st.executeUpdate(INSERT_FORNECEDOR);
//                    st.executeUpdate(INSERT_PRODUTO);
//                    st.executeUpdate(INSERT_CLIENTE_ENDERECO);
//                    st.executeUpdate(INSERT_COMPRA);
//                    st.executeUpdate(INSERT_PEDIDO);
//                    st.executeUpdate(INSERT_ITEM_COMPRA);
//                    st.executeUpdate(INSERT_ITEM_PEDIDO);

                    return true;

            } catch (Exception e) {
                    System.err.println("Erro ao tentar criar tabelas: " + e);
                    throw e;
            }
        }
}
