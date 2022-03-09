package handler;

import com.gorzdrav.telegram.bot.Bot;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DoctorHandler {
    private final RestTemplate restTemplate = new RestTemplate();
    private Bot bot;
    public DoctorHandler(Bot bot) {
        this.bot = bot;
    }
    @Scheduled (fixedDelay = 1000)
    public void scheduleFixedDelayTask() {
                final String uri = "https://gorzdrav.spb.ru/_api/api/v2/schedule/lpu/466/speciality/7242/doctors"
               String result = restTemplate.getForObject(uri, String.class);
              bot.setMessage("123",result);
    }
}
