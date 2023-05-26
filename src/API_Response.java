
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import static java.lang.System.out;

public class API_Response {
    public static void main(String[] args) {
        try{
            String api = "http://127.0.0.1:8000/stuinfo/";
            URL url = new URL(api);
            HttpURLConnection connect =(HttpURLConnection) url.openConnection();
            connect.setRequestMethod("GET");
            int responseCode = connect.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK){
                InputStream inpstr = connect.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(inpstr));
                String line;
                StringBuilder response = new StringBuilder();
                line = br.readLine();
                while (line != null){
                    response.append(line);
                    line = br.readLine();
                }
                out.println(response);
                br.close();
            }else {
                out.println("Response failure !");
            }

            connect.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
