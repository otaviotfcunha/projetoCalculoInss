import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class TelaPrjFinal extends JFrame implements ActionListener {
    protected Dimension dFrame, dLabel, dTextField, dButton, dTextArea;
    protected Label lblCodigo, lblNome, lblSetor, lblSalario, lblRecInss;
    protected Button btnSalvar, btnExcluir, btnCalcular, btnCarregar, btnSair;
    protected TextField txtCodigo, txtNome, txtSetor, txtSalario, txtRecInss;
    protected JTable tabela;
    protected JScrollPane barraRolagem;
    protected JPanel painelConteudo;
    GerenciarEmpregado gerencia = new GerenciarEmpregado();


    Object[][] dados = {};
    String[] colunas = {"Codigo","Nome","Setor","Salario","RecInss"};

    public TelaPrjFinal(){


        painelConteudo = new JPanel();
        painelConteudo.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(painelConteudo);
        painelConteudo.setLayout(null);

        dFrame = new Dimension(405,390);
        dLabel = new Dimension(100,20);
        dTextField = new Dimension(150,20);
        dButton = new Dimension(80,20);


        //Estrutura da tela
        setTitle("Gerenciamento de Funcionários");
        setResizable(false);
        setSize(dFrame);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //Campos da tela
        lblCodigo = new Label("Código: ",1);
        lblCodigo.setSize(dLabel);
        lblCodigo.setLocation(10,20);
        add(lblCodigo);

        txtCodigo = new TextField(null);
        txtCodigo.setSize(dTextField);
        txtCodigo.setLocation(130,20);
        add(txtCodigo);

        lblNome = new Label("Nome: ",1);
        lblNome.setSize(dLabel);
        lblNome.setLocation(10,50);
        add(lblNome);

        txtNome = new TextField(null);
        txtNome.setSize(dTextField);
        txtNome.setLocation(130,50);
        add(txtNome);


        lblSetor = new Label("Setor: ",1);
        lblSetor.setSize(dLabel);
        lblSetor.setLocation(10,80);
        add(lblSetor);

        txtSetor = new TextField(null);
        txtSetor.setSize(dTextField);
        txtSetor.setLocation(130,80);
        add(txtSetor);


        lblSalario = new Label("Salário: ",1);
        lblSalario.setSize(dLabel);
        lblSalario.setLocation(10,110);
        add(lblSalario);

        txtSalario = new TextField(null);
        txtSalario.setSize(dTextField);
        txtSalario.setLocation(130,110);
        add(txtSalario);


        btnSalvar = new Button("Salvar");
        btnSalvar.setSize(dButton);
        btnSalvar.setLocation(20,170);
        btnSalvar.addActionListener(this);
        add(btnSalvar);

        btnExcluir = new Button("Excluir");
        btnExcluir.setSize(dButton);
        btnExcluir.setLocation(110,170);
        btnExcluir.addActionListener(this);
        add(btnExcluir);

        btnSair = new Button("Sair");
        btnSair.setSize(dButton);
        btnSair.setLocation(290,170);
        btnSair.addActionListener(this);
        add(btnSair);

        tabela = new JTable(dados,colunas);
        DefaultTableModel model = new DefaultTableModel(dados, colunas);
        tabela.setModel(model);
        barraRolagem = new JScrollPane(tabela);
        barraRolagem.setBounds(10,220,370,120);
        painelConteudo.add(barraRolagem);

    }

    public void limparCampos(){
        txtCodigo.setText("");
        txtNome.setText("");
        txtSetor.setText("");
        txtSalario.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSair){
            JOptionPane.showMessageDialog(null,"O programa será finalizado!","FIM", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        if(e.getSource() == btnSalvar){

            try{
                DecimalFormat df = new DecimalFormat("#,###.00");
                double valInss = 0;
                valInss = ParametrosInss.calcularInss(Double.parseDouble(txtSalario.getText()));
                DefaultTableModel dtmEmpregados = (DefaultTableModel) tabela.getModel();
                Object[] dados = {txtCodigo.getText(),txtNome.getText(),txtSetor.getText(),"R$ "+ df.format(Double.parseDouble(txtSalario.getText())), "R$ " + df.format(valInss)};
                dtmEmpregados.addRow(dados);
                gerencia.adicionarEmpregado(Integer.parseInt(txtCodigo.getText()), txtNome.getText(), txtSetor.getText(), Double.parseDouble(txtSalario.getText()), valInss);
                gerencia.listarEmpregados();
                limparCampos();
                JOptionPane.showMessageDialog(null,"Dados salvos com sucesso, a contribuição do inss deste funcionário é: R$ " + df.format(valInss),"Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            }catch(NumberFormatException numErr) {
                JOptionPane.showMessageDialog(null,"Você deve preencher os campos corretamente para inserir um dado!","Erro!", JOptionPane.INFORMATION_MESSAGE);
            }catch (Exception err){
                JOptionPane.showMessageDialog(null,err.getMessage(),"Erro!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if(e.getSource() == btnExcluir){
            if(tabela.getSelectedRow() != -1){
                DefaultTableModel dtmProdutos = (DefaultTableModel) tabela.getModel();
                dtmProdutos.removeRow(tabela.getSelectedRow());
            }else{
                JOptionPane.showMessageDialog(null,"Selecione um empregado para Excluir");
            }
        }

    }
}
