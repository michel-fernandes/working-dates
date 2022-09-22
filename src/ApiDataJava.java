import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class ApiDataJava {
    
    public static void main(String[] args) throws Exception {

        System.out.println("----------------- API TIME JAVA --------------");
        LocalDate localDate = LocalDate.now();
        System.out.println("Data atual: " + localDate);
        
        LocalTime localTime = LocalTime.now();
        System.out.println("Hora atual: " + localTime);
        
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Data hora atual: " + localDateTime);

        System.out.println("Data hora atual: " + localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        System.out.println("Data hora atual: " + localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        System.out.println("Dia da semana name: " + localDate.getDayOfWeek().name());

        System.out.println("Dia da semana value: " + localDate.getDayOfWeek().getValue());

        System.out.println("Dia do mês: " + localDate.getDayOfMonth());

        System.out.println("Dia do ano: " + localDate.getDayOfYear());

        System.out.println("Mês do ano: " + localDate.getMonthValue());

        System.out.println("Ano gregoriano: " + localDate.getYear());

        System.out.println("Cronologia: " + localDate.getChronology());

        duracaoProcessamento();
        periodo();
        adicionandoPeriodo();
        parcelamentoMensal();
    }

    public static void duracaoProcessamento() throws InterruptedException{
        System.out.println("----------------- TEMPO DE PROCESSAMENTO --------------");
        Instant startInclusive = Instant.now();
        Thread.sleep(10);
        Instant endExclusive = Instant.now();
        Duration duration = Duration.between(startInclusive, endExclusive);   

        System.out.println("Duração do processamento simulado:  " + duration.toMillis() + " ms");        
    }

    public static void periodo(){
        System.out.println("----------------- PERIODO ENTRE DATAS --------------");
        LocalDate startDateInclusive = LocalDate.of(1982, 2, 9);
        LocalDate endDateExclusive = LocalDate.now();

        System.out.println("Data birthday: " + startDateInclusive);
        System.out.println("Data birthday é maior que a data de hoje: " + startDateInclusive.isAfter(endDateExclusive));
        System.out.println("Data birthday é menor que a data de hoje: " + startDateInclusive.isBefore(endDateExclusive));
        System.out.println("Data birthday é igual a data de hoje: " + startDateInclusive.isEqual(endDateExclusive));
        
        Period period = Period.between(startDateInclusive, endDateExclusive);

        System.out.println("Quantos dias entre as datas do mês: " + period.getDays());
        System.out.println("Quantos meses entre as datas do ano: " + period.getMonths());
        System.out.println("Quantos anos entre as datas: " + period.getYears());
        System.out.println(String.format("%s anos, %s meses e %s dias", period.getYears(), period.getMonths(), period.getDays()));
    }

    public static void adicionandoPeriodo(){
        System.out.println("----------------- ADD E SUB PERIODOS --------------");
        LocalDate baseDate = LocalDate.parse("2022-09-22");
        
        System.out.println("Data base: " + baseDate);
        System.out.println("Data base + 5 dias: " + (baseDate = baseDate.plusDays(5)));
        System.out.println("Data base + 5 semanas: " + (baseDate = baseDate.plusWeeks(5)));
        System.out.println("Data base + 5 meses: " + (baseDate = baseDate.plusMonths(5)));
        System.out.println("Data base + 5 anos: " + (baseDate = baseDate.plusYears(5)));
        System.out.println("Data base - 5 anos: " + (baseDate = baseDate.minusYears(5)));
        System.out.println("Data base - 5 meses: " + (baseDate = baseDate.minusMonths(5)));
        System.out.println("Data base - 5 semanas: " + (baseDate = baseDate.minusWeeks(5)));
        System.out.println("Data base - 5 dias: " + (baseDate = baseDate.minusDays(5)));
    }

    public static void parcelamentoMensal(){
        System.out.println("----------------- PARCELAMENTO --------------");
        LocalDate baseDate = LocalDate.parse("2022-09-22");
        
        System.out.println("Data base: " + baseDate);
        
        for(int parcela=1; parcela<=12; parcela++){
            System.out.println(String.format("Parcela %s vence em: %s", parcela, baseDate.plusMonths(parcela)));
        }
    }
}
