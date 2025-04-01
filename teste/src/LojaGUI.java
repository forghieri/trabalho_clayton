import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

class Produto {
    private String codigo;
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String codigo, String nome, double preco, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getQuantidade() { return quantidade; }
    public void setPreco(double preco) { this.preco = preco; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    @Override
    public String toString() {
        return "Codigo: " + codigo + ", Nome: " + nome + ", Preco: " + preco + ", Quantidade: " + quantidade;
    }
}

class Cliente {
    private String nome;
    private String cpf;
    private String telefone;

    public Cliente(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getTelefone() { return telefone; }

    @Override
    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf + ", Telefone: " + telefone;
    }
}

class Venda {
    private Cliente cliente;
    private Produto produto;
    private int quantidade;

    public Venda(Cliente cliente, Produto produto, int quantidade) {
        this.cliente = cliente;
        this.produto = produto;
        this.quantidade = quantidade;
        produto.setQuantidade(produto.getQuantidade() - quantidade);
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente.getNome() + ", Produto: " + produto.getNome() + ", Quantidade: " + quantidade;
    }
}

public class LojaGUI {
    private static List<Produto> produtos = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Venda> vendas = new ArrayList<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gerenciamento de Loja");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(8, 1));

        JButton btnProduto = new JButton("1. Cadastrar Produto");
        JButton btnCliente = new JButton("2. Cadastrar Cliente");
        JButton btnExcluirCliente = new JButton("3. Excluir Cliente");
        JButton btnVenda = new JButton("4. Registrar Venda");
        JButton btnListarProdutos = new JButton("5. Listar Produtos");
        JButton btnListarClientes = new JButton("6. Listar Clientes");
        JButton btnRelatorioVendas = new JButton("7. Relatório de Vendas");
        JButton btnSair = new JButton("8. Sair");

        btnProduto.addActionListener(e -> cadastrarProduto());
        btnCliente.addActionListener(e -> cadastrarCliente());
        btnExcluirCliente.addActionListener(e -> excluirCliente());
        btnVenda.addActionListener(e -> registrarVenda());
        btnListarProdutos.addActionListener(e -> listarProdutos());
        btnListarClientes.addActionListener(e -> listarClientes());
        btnRelatorioVendas.addActionListener(e -> listarVendas());
        btnSair.addActionListener(e -> System.exit(0));

        frame.add(btnProduto);
        frame.add(btnCliente);
        frame.add(btnExcluirCliente);
        frame.add(btnVenda);
        frame.add(btnListarProdutos);
        frame.add(btnListarClientes);
        frame.add(btnRelatorioVendas);
        frame.add(btnSair);

        frame.setVisible(true);
    }

    private static void cadastrarProduto() {
        String codigo = JOptionPane.showInputDialog("Código do produto:");
        String nome = JOptionPane.showInputDialog("Nome do produto:");
        double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço:"));
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade:"));
        produtos.add(new Produto(codigo, nome, preco, quantidade));
    }

    private static void cadastrarCliente() {
        String nome = JOptionPane.showInputDialog("Nome do cliente:");
        String cpf = JOptionPane.showInputDialog("CPF:");
        String telefone = JOptionPane.showInputDialog("Telefone:");
        clientes.add(new Cliente(nome, cpf, telefone));
    }

    private static void excluirCliente() {
        String cpf = JOptionPane.showInputDialog("Digite o CPF do cliente a ser excluído:");
        Cliente cliente = clientes.stream().filter(c -> c.getCpf().equals(cpf)).findFirst().orElse(null);
        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
            return;
        }
        clientes.remove(cliente);
        JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
    }

    private static void registrarVenda() {
        String cpf = JOptionPane.showInputDialog("CPF do cliente:");
        Cliente cliente = clientes.stream().filter(c -> c.getCpf().equals(cpf)).findFirst().orElse(null);
        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
            return;
        }
        String codigo = JOptionPane.showInputDialog("Código do produto:");
        Produto produto = produtos.stream().filter(p -> p.getCodigo().equals(codigo)).findFirst().orElse(null);
        if (produto == null || produto.getQuantidade() == 0) {
            JOptionPane.showMessageDialog(null, "Produto não disponível.");
            return;
        }
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade:"));
        if (quantidade > produto.getQuantidade()) {
            JOptionPane.showMessageDialog(null, "Quantidade insuficiente.");
            return;
        }
        vendas.add(new Venda(cliente, produto, quantidade));
        JOptionPane.showMessageDialog(null, "Venda registrada!");
    }

    private static void listarProdutos() {
        StringBuilder sb = new StringBuilder("Produtos:\n");
        produtos.forEach(p -> sb.append(p.toString()).append("\n"));
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void listarClientes() {
        StringBuilder sb = new StringBuilder("Clientes:\n");
        clientes.forEach(c -> sb.append(c.toString()).append("\n"));
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void listarVendas() {
        StringBuilder sb = new StringBuilder("Vendas:\n");
        vendas.forEach(v -> sb.append(v.toString()).append("\n"));
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
