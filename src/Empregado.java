import java.util.Objects;

public class Empregado {
    private int codigoEmpregado;
    private String nomeEmpregado;
    private String setor;
    private double salarioBruto;
    private double recInss;

    public int getCodigoEmpregado() {
        return codigoEmpregado;
    }

    public void setCodigoEmpregado(int codigoEmpregado) {
        this.codigoEmpregado = codigoEmpregado;
    }

    public String getNomeEmpregado() {
        return nomeEmpregado;
    }

    public void setNomeEmpregado(String nomeEmpregado) {
        this.nomeEmpregado = nomeEmpregado;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public double getRecInss() {
        return recInss;
    }

    public void setRecInss(double recInss) {
        this.recInss = recInss;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empregado empregado = (Empregado) o;
        return codigoEmpregado == empregado.codigoEmpregado && Double.compare(empregado.salarioBruto, salarioBruto) == 0 && Double.compare(empregado.recInss, recInss) == 0 && nomeEmpregado.equals(empregado.nomeEmpregado) && setor.equals(empregado.setor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoEmpregado, nomeEmpregado, setor, salarioBruto, recInss);
    }

}
