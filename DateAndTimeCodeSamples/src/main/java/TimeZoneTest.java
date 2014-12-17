import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;

import javax.swing.JOptionPane;

public class TimeZoneTest {

	public static void main(String[] args) {

		ZonedDateTime zonedSid = ZonedDateTime.now();
		showMessage("ZonedSid",zonedSid);
		showMessage("ZonedSid",zonedSid.plus(3,ChronoUnit.MONTHS));
		
		
		// Você pode especificar o ZoneId quando cria um dateTime 'Zoneado'
		ZoneId id = ZoneId.of("Europe/Paris");
		ZonedDateTime zoned = ZonedDateTime.now(id);
		showMessage("ZonedDateTime",zoned);
		
		
		
		//showMessage("Paris",zoned.toOffsetDateTime().toOffsetTime().withOffsetSameInstant(zoned.getOffset()));
		
		ZoneId zi = ZoneId.from(zoned);
		showMessage("ZoneId",zi );
		showMessage("OffsetTime",zoned.getOffset());

		// uso de offsets
		ZoneOffset offset = ZoneOffset.of("-3");
		showMessage("ZoneOffset", offset);

		// criando um DateTime Zoneado
		ZonedDateTime zdt = ZonedDateTime
				.parse("2007-12-03T10:15:30+01:00[Europe/Paris]");
		showMessage("ZonedDateTime.parse()", zdt);

		// pega o offset corrente
		OffsetTime ost = OffsetTime.now();
		showMessage("OffsetTime.now()",ost.getOffset());

		// mantendo o mesmo ponto na linha do tempo
		OffsetTime sameTimeDifferentOffset = ost.withOffsetSameInstant(offset);
		showMessage("withOffsetSameInstant", sameTimeDifferentOffset);

		// Muda o deslocamento, e atualiza o ponto na linha do tempo
		OffsetTime changeTimeWithNewOffset = ost.withOffsetSameLocal(offset);
		showMessage("withOffsetSameLocal", changeTimeWithNewOffset);

		// Também pode criar novo objeto com campos alterados como antes
		OffsetTime ot = changeTimeWithNewOffset.withHour(3).plusSeconds(2);		
		showMessage("withHour(3).plusSeconds(2)", ot);

		// 3 years, 2 months, 1 day
		Period period = Period.of(3, 2, 1);
		showMessage("3 years, 2 months, 1 day", period);
		
		// Você pode modificar os valores das datas usando períodos
		LocalDate newDate = LocalDate.now().plus(period);
		showMessage("LocalDate.now().plus(period)", newDate);
		LocalDateTime newDateTime = LocalDateTime.now().minus(period);
		showMessage("LocalDateTime.now().minus(period)", newDateTime);
		
		// Componentes de um período são representados por valores ChronoUnit
		long days = period.get(ChronoUnit.DAYS); 
		showMessage("period.get(ChronoUnit.DAYS)", days);
		
		// uma duracao de 3 segundos e 5 nanoseconds
		Duration duration = Duration.ofSeconds(3, 5);
		showMessage("Duration.ofSeconds(3, 5)", duration);
		
		// Uma duração de 5 minutos
		duration = Duration.ofSeconds(300);
		showMessage("Duration.ofSeconds(300)",  duration);
		
	}
	private static void showMessage(String title, Object obj) {
		if (JOptionPane.showConfirmDialog(null, obj, title,  JOptionPane.OK_CANCEL_OPTION) >0)
			System.exit(0);
	}
	private static void showMessage(Object obj) {
		 showMessage(TimeZoneTest.class.getName(), obj);
	}
}
