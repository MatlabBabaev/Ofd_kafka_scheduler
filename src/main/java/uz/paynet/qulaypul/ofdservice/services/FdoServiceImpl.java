package uz.paynet.qulaypul.ofdservice.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okio.ByteString;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import uz.paynet.qulaypul.ofdservice.domain.ProviderServicesFdo;
import uz.paynet.qulaypul.ofdservice.repository.ProviderServicesFdoRepository;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//@Service
@Component
@RequiredArgsConstructor
@Slf4j
public class FdoServiceImpl {
    //auth for http tax query
    @Value("${scheduler.user}")
    private String USER;

    @Value("${scheduler.password}")
    private String PASSWORD;

    //Run daily at 8:00:00
    private static final String SCHEDULER_LAUNCH = "0 0 8 * * *";

    private final ProviderServicesFdoRepository providerServicesFdoRepository;


    @Scheduled(cron = SCHEDULER_LAUNCH)
    public void getFdo() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String date = LocalDate.now().format(formatter);
        log.info("CACHE NOT HIT");

        ProviderServicesFdo fdo = new ProviderServicesFdo();

        List<ProviderServicesFdo> fdos = providerServicesFdoRepository.findAll();

        //sorted list of all service_ids
        List<Integer> service_ids = fdos.stream()
                .map(ProviderServicesFdo::getServiceId)
                .collect(Collectors.toList())
                .stream().sorted().collect(Collectors.toList());

        Map<Integer, ProviderServicesFdo> allByFdoService_id = providerServicesFdoRepository.findAllByServiceIdIn(service_ids).stream()
                .collect(Collectors.toMap(ProviderServicesFdo::getServiceId, Function.identity()));

        List <String> Inns = fdos.stream().distinct().map(ProviderServicesFdo::getInn).collect(Collectors.toList());

        try {

            fdos.forEach(c -> {

                        ProviderServicesFdo providerServicesFdo = allByFdoService_id.get(c.getServiceId());

                        //checking is the service nds registered (if yes isNds = 1 else 0)
                        boolean isNdsResponse = getNdsResponse("http://127.0.0.1/tax/v1" + providerServicesFdo.getInn() + "/" + date);

                        if (isNdsResponse) {
                            providerServicesFdo.setIsNds('1');
                        } else
                            providerServicesFdo.setIsNds('0');

                        log.info("Provider service updated, INN: " + providerServicesFdo.getInn() + ", isNDS: " + providerServicesFdo.getIsNds() + ", time: " + ZonedDateTime.now());
                        providerServicesFdoRepository.save(providerServicesFdo);

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            log.error(e.getStackTrace().toString());
                        }
                    }


            );

        } catch (Exception ex) {
            log.error(ex.getStackTrace().toString());
        }

    }

    private boolean getNdsResponse(String sUrl) {


        boolean result = false;

        HttpURLConnection conn;

        try {
            URL url = new URL(sUrl);

            conn = (HttpURLConnection) url.openConnection();
            String usernameAndPassword = USER + ":" + PASSWORD;
            byte[] bytes = usernameAndPassword.getBytes(StandardCharsets.ISO_8859_1);
            String encoded = ByteString.of(bytes).base64();

            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            conn.setRequestProperty("Authorization", "Basic " + encoded);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.connect();

            InputStreamReader iStream = new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8);
            BufferedReader inFor = new BufferedReader(iStream);

            String inputLineFor;
            String responsePage = "";
            while ((inputLineFor = inFor.readLine()) != null) {
                responsePage += inputLineFor;
            }
            inFor.close();

            JSONObject obj = new JSONObject(responsePage);

            if (obj.has("data") && obj.has("success") && obj.get("data")!=null  && obj.get("success")!=null) {

                JSONObject data = obj.getJSONObject("data");

                if (data.has("active") && data.has("suspended")) {

                    if (obj.get("success").equals(true)) {
                        if ((data.get("active").equals(true)) ||
                                (data.get("active").equals(false) && data.get("suspended").equals(true))) {
                            result = true;
                        } else {
                            result = false;
                        }
                    }
                } else{
                    log.error("TAX get isNDS QUERY JSON data uri {} not found. Please check URI or INN", sUrl);
                    return false;
                }

            } else {
                log.error("TAX get isNDS QUERY JSON data uri {} not found. Please check URI or INN", sUrl);
                return false;
            }

        } catch (JSONException ex) {
            log.error("TAX get isNDS QUERY JSON Exception :{}, url=>{}", ex.getStackTrace(), sUrl);
        } catch (ProtocolException e) {
            log.error("TAX get isNDS QUERY PROTOCOL Exception :{}, url=>{}", e.getStackTrace().toString(), sUrl);
        } catch (IOException e) {
            log.error("TAX get isNDS QUERY IO Exception :{}, url=>{}", e.getStackTrace().toString(), sUrl);
        } catch (Exception e) {
            log.error("TAX get isNDS QUERY Exception :{}, url=>{}", e.getStackTrace().toString(), sUrl);
        }
        return result;
    }
}
