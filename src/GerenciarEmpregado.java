import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciarEmpregado {
    private static List<Empregado> listaEmpregados = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public static List<Empregado> getListaEmpregados() {
        return listaEmpregados;
    }

    public void setListaEmpregados(List<Empregado> listaEmpregados) {
        this.listaEmpregados = listaEmpregados;
    }

    public static void adicionarEmpregado(int codigo,String nome, String setor, double salarioBruto, double recInss){

        Empregado emp = new Empregado();
        emp.setCodigoEmpregado(codigo);
        emp.setNomeEmpregado(nome);
        emp.setSetor(setor);
        emp.setSalarioBruto(salarioBruto);
        emp.setRecInss(recInss);
        getListaEmpregados().add(emp);
    }

    public void removerEmpregado(Empregado e){
        //utilizar .remove

    }

    public void listarEmpregados(){
        //listar empregados utilizando List<Empregado>
        System.out.println("Lista de empregados:");

        for(Empregado empregado : listaEmpregados){
            System.out.println("codigo: " + empregado.getCodigoEmpregado());
            System.out.println("nome: " + empregado.getNomeEmpregado());
            System.out.println("Setor: " + empregado.getSetor());
            System.out.println("Salário bruto: " + empregado.getSalarioBruto());
            System.out.println("Rec Inss: " + empregado.getRecInss());

        }

    }
    private boolean verificarExistencia(Empregado e){
        boolean temNaLista;
        for(Empregado emp : listaEmpregados){

            if(listaEmpregados.contains(e.getCodigoEmpregado())){
                return temNaLista = true;
            }
        }
        return temNaLista = false;
    }

}
