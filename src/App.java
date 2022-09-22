import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class App {
    private static final String MINHA_DATA = "2022-08-21";
    private static final String DATA_MAIOR = "10/10/2022";
    private static final String DATA_MENOR = "10/09/2022";
    private static final String DATA_IGUAL_MAIOR = "10/10/2022";

    public static void main(String[] args) throws Exception {
        DateHandler dateHandler = new DateHandler();

        System.out.println("Using Date: " + dateHandler.getDate());

        System.out.println("Using Calendar: " + dateHandler.getCalendar());

        System.out.println("Using Camunda: " + dateHandler.isoDateFormat());

        System.out.println("Using DB: " + dateHandler.isoDataBaseFormat());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataMaior = simpleDateFormat.parse(DATA_MAIOR);
        Date dataIgualMaior = simpleDateFormat.parse(DATA_MENOR);
        Date dataMenor = simpleDateFormat.parse(DATA_IGUAL_MAIOR);

        if (dataMaior.after(dataMenor)) {
            System.out.println("Exemplo date after");
        }

        if (dataMaior.equals(dataIgualMaior)) {
            System.out.println("Exemplo date equals");
        }

        if (dataMenor.before(dataMaior)) {
            System.out.println("Exemplo date before");
        }

        Calendar calendar = getCalendar();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        calendar.add(Calendar.DAY_OF_MONTH, 30);
        System.out.println("Soma 30 DIAS calendar(" + MINHA_DATA + ") "
                + dateFormat.format(calendar.getTime()));

        calendar = getCalendar();
        calendar.add(Calendar.MONTH, 1);
        System.out.println("Soma 1 MÊS calendar(" + MINHA_DATA + ") "
                + dateFormat.format(calendar.getTime()));

        calendar = getCalendar();
        calendar.add(Calendar.YEAR, 1);
        System.out.println("Soma 1 ANO calendar(" + MINHA_DATA + ") "
                + dateFormat.format(calendar.getTime()));

        Long dias = ChronoUnit.DAYS.between(LocalDate.parse(MINHA_DATA), LocalDate.now());
        System.out.println("Intervalo de " + MINHA_DATA + " até "
                + LocalDate.now() + " são de " + dias + " dias");

        Calendar dataCompra = getCalendar();
        HashMap<Integer, Date> dataParcelas = new HashMap<Integer, Date>();
        Date dataParcela = dataCompra.getTime();
        System.out.println("Data da compra: " + dateFormat.format(dataParcela));

        for (Integer parcela = 1; parcela <= 12; parcela++) {
            dataCompra.add(Calendar.MONTH, 1);
            dataParcela = dataCompra.getTime();
            dataParcelas.put(parcela, dataParcela);
            System.out.println(String.format("A paracela %s vence em %s", parcela, dateFormat.format(dataParcela)));
        }
    }

    public static Calendar getCalendar() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(MINHA_DATA));
        return calendar;
    }
}
