public class ParametrosInss {
    public static final double [] faixa = new double[]{7.5, 9, 12, 14};
    public static final double [] limiteFaixa = new double[]{1100, 2203.48, 3305.22, 6433.57};


    public static void mostrarVetor() {
        for(double itens : faixa){
            System.out.println(itens);
        }

        for(double item : limiteFaixa){
            System.out.println(item);
        }
    }


    public static double calcularInss(double salarioBruto){
        double calculaRecInss = 0;
        double resto = 0;
        double somaContr = 0;
        double testaValor = 0;
        resto = salarioBruto - resto;

        for(int i = 0; i < limiteFaixa.length; i++){

            testaValor = resto - limiteFaixa[i];
            if(testaValor <= 0 || i == 3){
                somaContr += resto * faixa[i] / 100;
                break;
            }else{
                resto = testaValor;
                somaContr += limiteFaixa[i] * faixa[i] / 100;
            }

        }
        calculaRecInss = somaContr;
         return calculaRecInss;
    }



}
