import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;

import javax.swing.JOptionPane;

public class DateAndTimeTest {

	public static void main(String[] args) {
		
		//data e hora corrente
		LocalDateTime ldt = LocalDateTime.now();
		showMessage("LocalDateTime",ldt);
		
		// usando o construtor com valores
		LocalDate ld = LocalDate.of(2012, Month.DECEMBER, 12); 
		showMessage("LocalDate",ld);
		
		// 365 dias após 1970-1-1
		ld = LocalDate.ofEpochDay(365);  
		showMessage("ofEpochDay(365)",ld);
		
		// hora que termina essa apresentação 
		LocalTime lt = LocalTime.of(19, 30); 
		showMessage("LocalTime",lt);
		
		// usando uma String como parâmetro
		lt = LocalTime.parse("10:15:30");
		showMessage("LocalTime",lt);
		
		//conversãode LocalDateTime para LocalDate 
		LocalDate theDate = ldt.toLocalDate();
		showMessage("toLocalDate()",theDate);
		
		//nome do mês
		Month month = ldt.getMonth();
		showMessage("getMonth()",month);
		
		//dia do mês
		int day = ldt.getDayOfMonth();
		showMessage("getDayOfMonth()", day);
		
		//segundos
		int second = ldt.getSecond();
		showMessage("getSecond()", second);
		
		// Atribui valores e retorna um novo objeto
		LocalDateTime thePast = ldt.withDayOfMonth(10).withYear(2010);
		showMessage(thePast);
		
		// Métodos de manipulação direta ou um par de valores indicando o campo
		LocalDateTime yetAnother = thePast.plusWeeks(3).plus(3, ChronoUnit.WEEKS);
		showMessage("plusWeeks(3).plus(3, ChronoUnit.WEEKS)", yetAnother);
		
		// O último dia do mês
		LocalDateTime lastDayOfMonth = ldt.with(TemporalAdjusters.lastDayOfMonth());
		showMessage("lastDayOfMonth()", lastDayOfMonth);
		
		// mesma data em junho
		LocalDateTime june = ldt.with(Month.JUNE);
		showMessage("Alteração de mês", june);
		
		// Usando valor de classes com métodos de ajuste
		LocalDateTime now = ldt.with(LocalTime.now());
		showMessage("now()", now);
		
		// truncando os minutos
		LocalTime truncatedTime = lt.truncatedTo(ChronoUnit.MINUTES);
		showMessage(String.format("lt = %s, truncatedTime = %s", lt,truncatedTime));
		
		Instant inicio = Instant.now();
		rodarAlgoritmo();
		Instant fim = Instant.now();
		 
		Duration duracao = Duration.between(inicio, fim);
		showMessage("Duration", duracao);
		
		long duracaoEmNanoSegundos = duracao.toNanos();
		showMessage("duracaoEmNanoSegundos", duracaoEmNanoSegundos);
		
	}

	static void rodarAlgoritmo() {
		for (int i = 0; i < 100000; i++) {
			System.out.print(i);
		}
	}

	private static void showMessage(String title, Object obj) {
		if (JOptionPane.showConfirmDialog(null, obj, title,  JOptionPane.OK_CANCEL_OPTION) >0)
			System.exit(0);
	}
	private static void showMessage(Object obj) {
		 showMessage(DateAndTimeTest.class.getName(), obj);
	}

}
