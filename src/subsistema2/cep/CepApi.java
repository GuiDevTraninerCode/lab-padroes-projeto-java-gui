package subsistema2.cep;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CepApi {

	private static CepApi instancia = new CepApi();

	private CepApi() {
		super();
	}

	public static CepApi getInstancia() {
		return instancia;
	}
	
	public String recuperarCidade(String cep) {


		String[] json = getDadosCEP(cep)
			.replace("{", "")
			.replace("}", "").split(",");
		
			String[] campoCidade = json[5].split(":");
        	String cidade = (campoCidade[1].replace("\"", ""));

		return cidade;
	}
	
	public String recuperarEstado(String cep) {

			String[] json = getDadosCEP(cep)
			.replace("{", "")
			.replace("}", "").split(",");
		
			String[] campoEstado = json[7].split(":");
        	String estado = campoEstado[1].replace("\"", "");
		
			return estado;
	}

	private String getDadosCEP(String cep){

		String retorno="";
		
		try {
            // 1. Define a URL
            URL url = new URL("https://viacep.com.br/ws/"+cep+"/json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // 2. Configura o método e headers
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            // 3. Verifica o código de status (200 = OK)
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                
                // 4. Lê a resposta usando um Buffer
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Recebe o resultado
				retorno = response.toString();
            } else {
                System.out.println("Erro na requisição. Código: " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

		return retorno;

	}
}
